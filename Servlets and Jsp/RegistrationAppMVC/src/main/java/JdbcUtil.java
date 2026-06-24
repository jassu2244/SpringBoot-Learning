import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil 
{
	private static final Properties DOT_ENV = loadDotEnv();

	static
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		System.out.println("Driver is registered");
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		return DriverManager.getConnection(requireConfig("DB_URL"), requireConfig("DB_USER"), requireConfig("DB_PASSWORD"));
	}
	
	public static void closeResource(Connection connect, Statement stmt) throws SQLException
	{
		if(connect!=null)
			connect.close();
		if(stmt!=null)
			stmt.close();
	}

	private static String requireConfig(String name)
	{
		String value = System.getenv(name);
		if(value == null || value.isBlank())
		{
			value = DOT_ENV.getProperty(name);
		}
		if(value == null || value.isBlank())
		{
			throw new IllegalStateException("Missing required database setting: " + name);
		}
		return value.trim();
	}

	private static Properties loadDotEnv()
	{
		Properties properties = new Properties();
		Path current = Path.of(System.getProperty("user.dir"));

		while(current != null)
		{
			Path envFile = current.resolve(".env");
			if(Files.isRegularFile(envFile))
			{
				try (InputStream input = Files.newInputStream(envFile))
				{
					properties.load(input);
				}
				catch (IOException e)
				{
					throw new IllegalStateException("Unable to read " + envFile, e);
				}
			}
			current = current.getParent();
		}

		return properties;
	}

}

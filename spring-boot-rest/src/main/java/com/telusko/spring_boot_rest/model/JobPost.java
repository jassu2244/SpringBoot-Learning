package com.telusko.spring_boot_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//the above 3 annotation are from lombok that helps with getters and setters so we do not need to create them manually
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //this is to make this spring component
public class JobPost {
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;
}

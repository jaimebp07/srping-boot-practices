package com.mycompany.project_reactor_features.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {

    private String comment;
    private Integer score;

}

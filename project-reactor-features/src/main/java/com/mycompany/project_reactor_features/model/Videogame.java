package com.mycompany.project_reactor_features.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Videogame {
    private String name;
    private Double price;
    private Console console;
    private List<Review> reviews;
    private String officialWebsite;
    private Boolean isDiscount;
    private Integer totalSold;

}

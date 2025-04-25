package com.jaime.practices.practices1.autowire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateAreaService {

    @Autowired
    private List<Figure> figures;

    public double calculateAreas(){
        double area = 0;
        for(Figure figure: figures){
            area += figure.calculateArea();
        }
        return area;
    }

}

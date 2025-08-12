package com.mycompany.project_reactor_features.pipelines;

import com.mycompany.project_reactor_features.dataBase.DataBase;
import com.mycompany.project_reactor_features.model.Videogame;

import reactor.core.publisher.Mono;

public class PipelineSumAllPricesInDiscount {

    /*
    Sum all prices of each videogame in discount
    */
    public static Mono<Double> getSumAlIPricesInDiscount() {
        return DataBase.getVideogamesFlux()
               .filter(videoGame -> videoGame.getIsDiscount())
               .map(Videogame::getPrice)
               .reduce(0.0, (acc, price) -> acc + price);
    }
}

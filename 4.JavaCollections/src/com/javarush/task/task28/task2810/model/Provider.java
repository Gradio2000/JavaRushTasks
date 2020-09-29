package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public List<Vacancy> getJavaVacancies(String searchString){
        if (searchString == null) return new ArrayList<>();
        return strategy.getVacancies(searchString);
    }

}

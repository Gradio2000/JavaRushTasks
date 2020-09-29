package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;


import java.util.ArrayList;
import java.util.List;

public class Model {
    View view;
    Provider[] providers;

    public Model(View view, Provider ... providers) {
        if (view == null || providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }
    public void selectCity(String city){
        List<Vacancy> list = new ArrayList<>();
        for (int i = 0; i < providers.length; i++) {
            list.addAll(providers[i].getJavaVacancies(city));
        }
        view.update(list);
    }


}

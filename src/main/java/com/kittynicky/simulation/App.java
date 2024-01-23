package com.kittynicky.simulation;

import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.services.RenderService;
import com.kittynicky.simulation.services.impl.RenderServiceImpl;

public class App {
    public static void main(String[] args) {
        Map map = new Map(10, 30);
        RenderService renderService = new RenderServiceImpl(map);
        Simulation simulation = new Simulation(map, renderService);

        simulation.start();
    }
}
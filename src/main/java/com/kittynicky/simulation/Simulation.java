package com.kittynicky.simulation;

import com.kittynicky.simulation.actions.*;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.services.RenderService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Thread {
    private Map map;
    private int moveCounter;
    private boolean isSimulationRunning;
    private RenderService renderService;
    private List<Action> initActions;
    private List<Action> turnActions;
    private static Logger logger = Logger.getLogger(Simulation.class);


    public Simulation(Map map, RenderService renderService) {
        this.map = map;
        this.renderService = renderService;
        this.isSimulationRunning = false;
        this.moveCounter = 0;
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();

    }

    @Override
    public void run() {
        startSimulation();
        renderService.render();
        while (isSimulationRunning) {
            nextTurn();
            renderService.render();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextTurn() {
        logger.info("Move № " + (++moveCounter));
        turnActions.forEach(Action::perform);
    }

    public void startSimulation() {
        System.out.println("The simulation has started");
        addActions();
        initActions.forEach(Action::perform);
        isSimulationRunning = true;
    }

    public void stopSimulation() {
        isSimulationRunning = false;
    }

    private void addActions() {
        initActions.add(new GrassSpawnAction(map));
        initActions.add(new RockSpawnAction(map));
        initActions.add(new TreeSpawnAction(map));
        initActions.add(new HerbivoreSpawnAction(map));
        initActions.add(new PredatorSpawnAction(map));

        turnActions.add(new GrassSpawnAction(map));
        turnActions.add(new MoveAction(map));
        turnActions.add(new HerbivoreSpawnAction(map));
    }
}

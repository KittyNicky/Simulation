package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.services.BreadthFirstSearchService;
import org.apache.log4j.Logger;

import java.util.ArrayDeque;

public class Herbivore extends Creature {
    private final static Logger logger = Logger.getLogger(Herbivore.class);

    public Herbivore(Cell cell, String sign, int hp, int speed, Map map, BreadthFirstSearchService breadthFirstSearchService) {
        super(cell, sign, hp, speed, map, breadthFirstSearchService);
        this.path = new ArrayDeque<>();
        logger.info(String.format("Spawn %s", this));
    }

    @Override
    public void makeMove() {
        logger.info(this + " started moving");

        for (int i = 0; i < speed; i++) {

            Cell grassCell = breadthFirstSearchService.getTargetNear(cell, Grass.class);

            if (grassCell != null) {
                logger.info(this + " eat grass " + map.getEntity(grassCell));
                map.removeEntity(grassCell);
                hp += 1;
                break;
            }

            Cell toCell = path.pollFirst();
            if (toCell == null) {
                path.addAll(breadthFirstSearchService.findPathToTarget(cell, Grass.class));
                toCell = path.pollFirst();
            }

            map.moveEntity(cell, toCell);

            logger.info(this);
        }
        logger.info(this + " finished moving");
    }
}

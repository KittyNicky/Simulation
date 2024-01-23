package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.services.BreadthFirstSearchService;
import org.apache.log4j.Logger;

import java.util.ArrayDeque;

public class Predator extends Creature {
    private int damage;
    private static Logger logger = Logger.getLogger(Predator.class);

    public Predator(Cell cell, String sign, int hp, int speed, int damage, Map map, BreadthFirstSearchService breadthFirstSearchService) {
        super(cell, sign, hp, speed, map, breadthFirstSearchService);
        this.path = new ArrayDeque<>();
        this.damage = damage;
        logger.info(String.format("Spawn %s", this));
    }

    @Override
    public void makeMove() {
        logger.info(this + " started moving");

        for (int i = 0; i < speed; i++) {

            Cell targetCell = breadthFirstSearchService.getTargetNear(cell, Herbivore.class);

            if (targetCell != null) {
                Herbivore herbivore = (Herbivore) map.getEntity(targetCell);
                herbivore.hp -= damage;

                logger.info(this + " inflicted " + damage + " damage to " + herbivore);

                if (!herbivore.isAlive()) {
                    logger.info(this + " killed " + herbivore);
                    map.removeEntity(targetCell);
                }
                break;
            }

            Cell toCell = path.pollFirst();
            if (toCell == null) {
                path.addAll(breadthFirstSearchService.findPathToTarget(cell, Herbivore.class));
                toCell = path.pollFirst();
            }

            map.moveEntity(cell, toCell);

            logger.info(this);
        }
        logger.info(this + " finished moving");
    }
}

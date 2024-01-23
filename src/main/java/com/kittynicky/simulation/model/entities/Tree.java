package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;
import org.apache.log4j.Logger;

public class Tree extends Entity {
    private Logger logger = Logger.getLogger(Tree.class);

    public Tree(Cell cell, String sign) {
        super(cell, sign);
        logger.info(String.format("Spawn %s", this));
    }
}

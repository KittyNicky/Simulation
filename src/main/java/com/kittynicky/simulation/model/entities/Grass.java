package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;
import org.apache.log4j.Logger;

public class Grass extends Entity {
    private Logger logger = Logger.getLogger(Grass.class);

    public Grass(Cell cell, String sign) {
        super(cell, sign);
        logger.info(String.format("Spawn %s", this));
    }
}

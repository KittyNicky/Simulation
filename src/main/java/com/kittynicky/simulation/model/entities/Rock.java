package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;
import org.apache.log4j.Logger;

public class Rock extends Entity {
    private Logger logger = Logger.getLogger(Rock.class);

    public Rock(Cell cell, String sign) {
        super(cell, sign);
        logger.info(String.format("Spawn %s", this));
    }
}

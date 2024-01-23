package com.kittynicky.simulation.services.impl;

import com.kittynicky.simulation.config.EntityConfig;
import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Entity;
import com.kittynicky.simulation.services.RenderService;
import org.apache.log4j.Logger;

public class RenderServiceImpl implements RenderService {
    private Map cells;
    private static Logger logger = Logger.getLogger(RenderServiceImpl.class);

    public RenderServiceImpl(Map cells) {
        this.cells = cells;
    }

    @Override
    public void render() {
        logger.info(cells);

        for (int row = 0; row < cells.getHeight(); row++) {
            for (int col = 0; col < cells.getWidth(); col++) {
                Cell cell = new Cell(row, col);
                Entity entity = cells.getEntity(cell);
                System.out.print(entity == null ? EntityConfig.GROUND_SIGN : entity.getSign());
            }
            System.out.println();
        }
        System.out.println();
    }
}

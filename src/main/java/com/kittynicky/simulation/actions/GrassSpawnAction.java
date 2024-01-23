package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.config.EntityConfig;
import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Grass;

public class GrassSpawnAction extends SpawnAction<Grass> {

    public GrassSpawnAction(Map map) {
        super(map);
        this.rate = (int) (map.size() * 0.05);
    }

    @Override
    public Grass spawnEntity(Cell cell) {
        return new Grass(cell, EntityConfig.GRASS_SIGN);
    }

    @Override
    public int getCurrentRate() {
        return map.getEntitiesByType(Grass.class).size();
    }
}

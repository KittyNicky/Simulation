package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.config.EntityConfig;
import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Rock;

public class RockSpawnAction extends SpawnAction<Rock> {
    public RockSpawnAction(Map map) {
        super(map);
        this.rate = (int) (map.size() * 0.02);
    }

    @Override
    public Rock spawnEntity(Cell cell) {
        return new Rock(cell, EntityConfig.ROCK_SIGN);
    }

    @Override
    public int getCurrentRate() {
        return map.getEntitiesByType(Rock.class).size();
    }
}

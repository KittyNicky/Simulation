package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Entity;

public abstract class SpawnAction<T extends Entity> extends Action {
    protected int rate;

    public SpawnAction(Map map) {
        super(map);
    }

    public void perform() {
        int curRate = getCurrentRate();

        while (curRate < rate) {
            Cell cell = map.getEmptyRandomCell();
            map.putEntity(cell, spawnEntity(cell));
            curRate++;
        }
    }

    public abstract int getCurrentRate();

    public abstract T spawnEntity(Cell cell);
}

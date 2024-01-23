package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Creature;

public class MoveAction extends Action {
    public MoveAction(Map map) {
        super(map);
    }

    @Override
    public void perform() {
        map.getEntitiesByType(Creature.class).forEach(Creature::makeMove);
    }
}

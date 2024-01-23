package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.config.EntityConfig;
import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Tree;

public class TreeSpawnAction extends SpawnAction<Tree> {
    public TreeSpawnAction(Map map) {
        super(map);
        this.rate = (int) (map.size() * 0.02);
    }

    @Override
    public Tree spawnEntity(Cell cell) {
        return new Tree(cell, EntityConfig.TREE_SIGN);
    }

    @Override
    public int getCurrentRate() {
        return map.getEntitiesByType(Tree.class).size();
    }
}

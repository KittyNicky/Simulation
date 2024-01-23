package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.config.EntityConfig;
import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Herbivore;
import com.kittynicky.simulation.services.BreadthFirstSearchService;
import com.kittynicky.simulation.services.impl.BreadthFirstSearchServiceImpl;

import java.util.Random;

public class HerbivoreSpawnAction extends SpawnAction<Herbivore> {

    public HerbivoreSpawnAction(Map map) {
        super(map);
        this.rate = (int) (map.size() * 0.05);
    }

    @Override
    public int getCurrentRate() {
        return map.getEntitiesByType(Herbivore.class).size();
    }

    @Override
    public Herbivore spawnEntity(Cell cell) {
        Random random = new Random();
        int hp = random.nextInt(EntityConfig.HERBIVORE_HP_MAX - EntityConfig.HERBIVORE_HP_MIN + 1)
                + EntityConfig.HERBIVORE_HP_MIN;
        int speed = random.nextInt(EntityConfig.HERBIVORE_SPEED_MAX - EntityConfig.HERBIVORE_SPEED_MIN + 1)
                + EntityConfig.HERBIVORE_SPEED_MIN;
        BreadthFirstSearchService breadthFirstSearchService = new BreadthFirstSearchServiceImpl(map);

        return new Herbivore(cell, EntityConfig.HERBIVORE_SIGN, hp, 1, map, breadthFirstSearchService);
    }
}

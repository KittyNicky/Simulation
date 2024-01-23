package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.config.EntityConfig;
import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.model.entities.Predator;
import com.kittynicky.simulation.services.BreadthFirstSearchService;
import com.kittynicky.simulation.services.impl.BreadthFirstSearchServiceImpl;

import java.util.Random;

public class PredatorSpawnAction extends SpawnAction<Predator> {
    public PredatorSpawnAction(Map map) {
        super(map);
        this.rate = (int) (map.size() * 0.01);
    }

    @Override
    public Predator spawnEntity(Cell cell) {
        Random random = new Random();
        int hp = random.nextInt(EntityConfig.PREDATOR_HP_MAX - EntityConfig.PREDATOR_HP_MIN + 1)
                + EntityConfig.PREDATOR_HP_MIN;
        int speed = random.nextInt(EntityConfig.PREDATOR_SPEED_MAX - EntityConfig.PREDATOR_SPEED_MIN + 1)
                + EntityConfig.PREDATOR_SPEED_MIN;
        int damage = random.nextInt(EntityConfig.PREDATOR_DAMAGE_MAX - EntityConfig.PREDATOR_DAMAGE_MIN + 1)
                + EntityConfig.PREDATOR_DAMAGE_MIN;
        BreadthFirstSearchService breadthFirstSearchService = new BreadthFirstSearchServiceImpl(map);

        return new Predator(cell, EntityConfig.PREDATOR_SIGN, hp, speed, damage, map, breadthFirstSearchService);
    }

    @Override
    public int getCurrentRate() {
        return map.getEntitiesByType(Predator.class).size();
    }
}

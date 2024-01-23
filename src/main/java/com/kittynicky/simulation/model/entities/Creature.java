package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.services.BreadthFirstSearchService;

import java.util.Deque;
import java.util.Locale;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected BreadthFirstSearchService breadthFirstSearchService;
    protected Map map;
    protected Deque<Cell> path;

    public Creature(Cell cell, String sign, int hp, int speed, Map map, BreadthFirstSearchService breadthFirstSearchService) {
        super(cell, sign);
        this.hp = hp;
        this.speed = speed;
        this.map = map;
        this.breadthFirstSearchService = breadthFirstSearchService;
    }

    public abstract void makeMove();

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return '{' + getClass().getSimpleName().toLowerCase(Locale.ROOT) + " " + sign +
                ", entityId=" + entityId +
                ", cell=" + cell +
                ", speed=" + speed +
                ", hp=" + hp +
                '}';
    }
}

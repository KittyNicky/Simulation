package com.kittynicky.simulation.model;

import com.kittynicky.simulation.model.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Map {
    private int height;
    private int width;
    private HashMap<Cell, Entity> cells;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new HashMap<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Entity getEntity(Cell cell) {
        return cells.get(cell);
    }

    public void putEntity(Cell cell, Entity entity) {
        entity.setCell(cell);
        cells.put(cell, entity);
    }

    public boolean containsCell(Cell cell) {
        return cells.containsKey(cell);
    }

    public void removeEntity(Cell cell) {
        cells.remove(cell);
    }

    public void moveEntity(Cell fromCell, Cell toCell) {
        Entity entity = cells.get(fromCell);
        if (entity == null || cells.get(toCell) != null) return;

        putEntity(toCell, entity);
        removeEntity(fromCell);
    }

    public List<Cell> getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<>();
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                Cell cell = new Cell(row, col);
                if (!cells.containsKey(cell)) {
                    emptyCells.add(cell);
                }
            }
        }
        return emptyCells;
    }

    public Cell getEmptyRandomCell() {
        Random random = new Random();
        List<Cell> emptyCells = getEmptyCells();
        int index = random.nextInt(emptyCells.size());
        return emptyCells.get(index);
    }

    public <T extends Entity> List<T> getEntitiesByType(Class<T> cls) {
        List<T> entities = new ArrayList<>();
        for (Entity value : cells.values()) {
            try {
                if (value != null) {
                    Class<?> valueClass = value.getClass();
                    if (valueClass.equals(valueClass.asSubclass(cls))) {
                        entities.add((T) value);
                    }
                }
            } catch (ClassCastException ignored) {
            }
        }
        return entities;
    }

    public int size() {
        return getHeight() * getWidth();
    }

    @Override
    public String toString() {
        HashMap<String, Integer> map = new HashMap<>();
        cells.values().forEach(entity -> {
            if (!map.containsKey(entity.getSign())) {
                map.put(entity.getSign(), 1);
            } else {
                map.put(entity.getSign(), map.get(entity.getSign()) + 1);
            }
        });
        return map.toString();
    }
}

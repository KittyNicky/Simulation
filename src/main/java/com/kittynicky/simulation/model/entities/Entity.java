package com.kittynicky.simulation.model.entities;

import com.kittynicky.simulation.model.Cell;

import java.util.Locale;

public class Entity {
    protected String sign;
    protected Cell cell;
    protected int entityId;
    private static int identity = 0;

    public Entity(Cell cell, String sign) {
        this.cell = cell;
        this.sign = sign;
        this.entityId = ++identity;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return '{' + getClass().getSimpleName().toLowerCase(Locale.ROOT) + " " + sign +
                ", entityId=" + entityId +
                ", cell=" + cell +
                '}';
    }
}

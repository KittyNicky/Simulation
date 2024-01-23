package com.kittynicky.simulation.actions;

import com.kittynicky.simulation.model.Map;

public abstract class Action {
    protected Map map;

    public Action(Map map) {
        this.map = map;
    }

    public abstract void perform();
}

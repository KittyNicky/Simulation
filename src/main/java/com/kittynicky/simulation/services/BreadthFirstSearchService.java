package com.kittynicky.simulation.services;

import com.kittynicky.simulation.model.Cell;

import java.util.Deque;
import java.util.List;

public interface BreadthFirstSearchService {

    Cell getTargetNear(Cell cell, Class<?> cls);

    List<Cell> getEmptyCellsNear(Cell cell);

    Deque<Cell> findPathToTarget(Cell cell, Class<?> cls);

}

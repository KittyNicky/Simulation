package com.kittynicky.simulation.services.impl;

import com.kittynicky.simulation.model.Cell;
import com.kittynicky.simulation.model.Map;
import com.kittynicky.simulation.services.BreadthFirstSearchService;

import java.util.*;

public class BreadthFirstSearchServiceImpl implements BreadthFirstSearchService {
    private Map cells;

    public BreadthFirstSearchServiceImpl(Map cells) {
        this.cells = cells;
    }

    private Set<Cell> getCellsToCheck(Cell cell) {
        Set<Cell> set = new HashSet<>();
        int fromHeight = Math.max(cell.getX() - 1, 0);
        int toHeight = Math.min(cell.getX() + 1, cells.getHeight() - 1);
        int fromWidth = Math.max(cell.getY() - 1, 0);
        int toWidth = Math.min(cell.getY() + 1, cells.getWidth() - 1);

        for (int i = fromHeight; i <= toHeight; i++) {
            for (int j = fromWidth; j <= toWidth; j++) {
                if (i == cell.getX() && j == cell.getY()) {
                    continue;
                }
                set.add(new Cell(i, j));
            }
        }
        return set;
    }

    @Override
    public Cell getTargetNear(Cell cell, Class<?> cls) {
        return getCellsToCheck(cell)
                .stream()
                .filter(c -> cells.getEntity(c) != null
                        && cells.getEntity(c).getClass().equals(cls))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cell> getEmptyCellsNear(Cell cell) {
        return getCellsToCheck(cell)
                .stream()
                .filter(c -> !cells.containsCell(c))
                .toList();
    }

    @Override
    public Deque<Cell> findPathToTarget(Cell cell, Class<?> cls) {
        Deque<Cell> path = new ArrayDeque<>();
        Deque<Cell> toVisitCells = new ArrayDeque<>(getEmptyCellsNear(cell));

        while (!toVisitCells.isEmpty()) {
            Cell toMoveCell = toVisitCells.pollFirst();
            path.add(toMoveCell);

            if (getTargetNear(toMoveCell, cls) != null) break;

            toVisitCells.addAll(getEmptyCellsNear(toMoveCell)
                    .stream()
                    .filter(c -> !path.contains(c))
                    .toList());
        }
        return path;
    }
}

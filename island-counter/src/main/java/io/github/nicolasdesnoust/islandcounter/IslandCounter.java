package io.github.nicolasdesnoust.islandcounter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IslandCounter {

    public static final int NO_ISLANDS = 0;
    public static final int ISLAND_PART = 1;

    public int countNumberOfIslandsIn(int[][] matrix) {

        if (matrix == null) {
            return NO_ISLANDS;
        }

        int numberOfIslands = NO_ISLANDS;
        int matrixHeight = matrix.length;
        int matrixWidth = matrix.length == 0 ? 0 : matrix[0].length;
        boolean[][] visitedCells = new boolean[matrixHeight][matrixWidth];

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (visitedCells[y][x]) {
                    continue;
                }
                visitedCells[y][x] = true;

                if (matrix[y][x] == ISLAND_PART) {
                    numberOfIslands++;
                    Coordinates firstIslandPart = new Coordinates(x, y);
                    visitWholeIslandSurface(firstIslandPart, matrix, visitedCells);
                }
            }
        }

        return numberOfIslands;
    }

    private void visitWholeIslandSurface(Coordinates firstIslandPart, int[][] matrix, boolean[][] visitedCells) {
        Deque<Coordinates> islandPartsToVisit = new ArrayDeque<>();
        islandPartsToVisit.add(firstIslandPart);

        while (!islandPartsToVisit.isEmpty()) {
            Coordinates currentIslandPart = islandPartsToVisit.pop();
            List<Coordinates> surroundingIslandParts = getUnvisitedSurroundingIslandParts(
                    currentIslandPart,
                    matrix,
                    visitedCells
            );
            islandPartsToVisit.addAll(surroundingIslandParts);
            visitedCells[currentIslandPart.getY()][currentIslandPart.getX()] = true;
        }
    }

    private List<Coordinates> getUnvisitedSurroundingIslandParts(
            Coordinates coordinates,
            int[][] matrix,
            boolean[][] visitedCells
    ) {
        return coordinates.getAllSurroundingCoordinates()
                .stream()
                .filter(isNotOutOfBounds(matrix))
                .filter(isAnIslandPart(matrix))
                .filter(hasNeverBeenVisited(visitedCells))
                .collect(Collectors.toList());
    }

    private Predicate<Coordinates> hasNeverBeenVisited(boolean[][] visitedCells) {
        return coordinates -> !visitedCells[coordinates.getY()][coordinates.getX()];
    }

    private Predicate<Coordinates> isAnIslandPart(int[][] matrix) {
        return coordinates -> matrix[coordinates.getY()][coordinates.getX()] == ISLAND_PART;
    }

    private Predicate<Coordinates> isNotOutOfBounds(int[][] matrix) {
        return coordinates -> coordinates.getY() >= 0
                && coordinates.getY() < matrix.length
                && coordinates.getX() >= 0
                && coordinates.getX() < matrix[coordinates.getY()].length;
    }

}

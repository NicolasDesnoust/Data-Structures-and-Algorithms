package io.github.nicolasdesnoust.islandcounter;

public class ExplorationTracker {

    private final boolean[][] exploredCoordinates;

    private ExplorationTracker(boolean[][] exploredCoordinates) {
        this.exploredCoordinates = exploredCoordinates;
    }

    public static ExplorationTracker createTrackerFor(ExplorableArea explorableArea) {
        boolean[][] exploredCoordinates
                = new boolean[explorableArea.getHeight()][explorableArea.getWidth()];

        return new ExplorationTracker(exploredCoordinates);
    }

    public void markAsExplored(Coordinates coordinates) {
        this.exploredCoordinates[coordinates.getY()][coordinates.getX()] = true;
    }

    public boolean hasCoordinatesBeenExplored(Coordinates coordinates) {
        return this.exploredCoordinates[coordinates.getY()][coordinates.getX()];
    }
}

package io.github.nicolasdesnoust.islandcounter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class IslandCounter {

    public static final int NO_ISLANDS = 0;

    public int countNumberOfIslandsIn(int[][] area) {

        if (area == null) {
            return NO_ISLANDS;
        }

        int numberOfIslands = NO_ISLANDS;
        var explorableArea = new ExplorableArea(area);
        var tracker = ExplorationTracker.createTrackerFor(explorableArea);

        for (int y = 0; y < explorableArea.getHeight(); y++) {
            for (int x = 0; x < explorableArea.getWidth(); x++) {
                Coordinates currentCellCoordinates = new Coordinates(x, y);

                if (tracker.hasCoordinatesBeenExplored(currentCellCoordinates)) {
                    continue;
                }
                tracker.markAsExplored(currentCellCoordinates);

                if (explorableArea.isThereLandAt(currentCellCoordinates)) {
                    numberOfIslands++;
                    exploreWholeIslandSurface(currentCellCoordinates, explorableArea, tracker);
                }
            }
        }

        return numberOfIslands;
    }

    private void exploreWholeIslandSurface(
            Coordinates firstIslandPart,
            ExplorableArea area,
            ExplorationTracker tracker
    ) {
        Deque<Coordinates> islandPartsToExplore = new ArrayDeque<>();
        islandPartsToExplore.add(firstIslandPart);

        while (!islandPartsToExplore.isEmpty()) {
            Coordinates currentIslandPart = islandPartsToExplore.pop();
            List<Coordinates> unexploredSurroundingIslandParts = getUnexploredSurroundingIslandParts(
                    currentIslandPart,
                    area,
                    tracker
            );
            islandPartsToExplore.addAll(unexploredSurroundingIslandParts);
            tracker.markAsExplored(currentIslandPart);
        }
    }

    private List<Coordinates> getUnexploredSurroundingIslandParts(
            Coordinates startingCoordinates,
            ExplorableArea area,
            ExplorationTracker tracker
    ) {
        return startingCoordinates.getAllSurroundingCoordinates()
                .stream()
                .filter(area::contains)
                .filter(area::isThereLandAt)
                .filter(tracker::hasCoordinatesBeenExplored)
                .collect(Collectors.toList());
    }

}

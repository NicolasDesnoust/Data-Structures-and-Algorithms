package io.github.nicolasdesnoust.islandcounter;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Coordinates> getAllSurroundingCoordinates() {
        List<Coordinates> surroundingCoordinates = new ArrayList<>();

        surroundingCoordinates.add(getCoordinatesAtTop());
        surroundingCoordinates.add(getCoordinatesAtBottom());
        surroundingCoordinates.add(getCoordinatesAtLeft());
        surroundingCoordinates.add(getCoordinatesAtRight());
        surroundingCoordinates.add(getCoordinatesAtBottomLeft());
        surroundingCoordinates.add(getCoordinatesAtBottomRight());
        surroundingCoordinates.add(getCoordinatesAtTopLeft());
        surroundingCoordinates.add(getCoordinatesAtTopRight());

        return surroundingCoordinates;
    }

    public Coordinates getCoordinatesAtRight() {
        return new Coordinates(x - 1, y);
    }

    public Coordinates getCoordinatesAtLeft() {
        return new Coordinates(x + 1, y);
    }

    public Coordinates getCoordinatesAtBottom() {
        return new Coordinates(x, y + 1);
    }

    public Coordinates getCoordinatesAtTop() {
        return new Coordinates(x, y - 1);
    }

    public Coordinates getCoordinatesAtTopRight() {
        return new Coordinates(x + 1, y - 1);
    }

    public Coordinates getCoordinatesAtTopLeft() {
        return new Coordinates(x - 1, y - 1);
    }

    public Coordinates getCoordinatesAtBottomRight() {
        return new Coordinates(x + 1, y + 1);
    }

    public Coordinates getCoordinatesAtBottomLeft() {
        return new Coordinates(x - 1, y + 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

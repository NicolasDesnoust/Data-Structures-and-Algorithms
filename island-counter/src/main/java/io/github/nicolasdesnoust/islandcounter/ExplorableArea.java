package io.github.nicolasdesnoust.islandcounter;

public class ExplorableArea {

    private static final int LAND = 1;

    private final int[][] area;

    public ExplorableArea(int[][] area) {
        this.area = area;
    }

    public boolean isThereLandAt(Coordinates coordinates) {
        return area[coordinates.getY()][coordinates.getX()] == LAND;
    }

    public boolean contains(Coordinates coordinates) {
        return coordinates.getY() >= 0
                && coordinates.getY() < getHeight()
                && coordinates.getX() >= 0
                && coordinates.getX() < getWidth();
    }

    public int getHeight() {
        return area.length;
    }

    public int getWidth() {
        return area.length == 0 ? 0 : area[0].length;
    }

}

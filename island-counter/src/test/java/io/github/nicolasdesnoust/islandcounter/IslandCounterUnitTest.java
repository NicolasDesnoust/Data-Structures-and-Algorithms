package io.github.nicolasdesnoust.islandcounter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandCounterUnitTest {

    IslandCounter islandCounter = new IslandCounter();

    @Test
    void givenNoIslands_whenCountNumberOfIslands_thenReturnZero() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0}
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isZero();
    }

    @Test
    void givenNullMatrix_whenCountNumberOfIslands_thenReturnZero() {
        int numberOfIslands = islandCounter.countNumberOfIslandsIn(null);

        Assertions.assertThat(numberOfIslands).isZero();
    }

    @Test
    void givenEmptyMatrix_whenCountNumberOfIslands_thenReturnZero() {
        int[][] matrix = { {} };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isZero();
    }

    @Test
    void givenOneCellIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] matrix = {
                {1, 0, 0},
                {0, 0, 1}
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenVerticalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] matrix = {
                {1, 0, 1},
                {1, 0, 1}
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenHorizontalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenHorizontalAndVerticalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] matrix = {
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 1}
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenDiagonalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] matrix = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0}
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenComplexIsland_whenCountNumberOfIslands_thenSuccess() {
        int[][] matrix = {
                {1, 0, 1, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        int numberOfIslands = islandCounter.countNumberOfIslandsIn(matrix);

        Assertions.assertThat(numberOfIslands).isEqualTo(1);
    }
}

package io.github.nicolasdesnoust.islandcounter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandCounterTest {

    IslandCounter underTest = new IslandCounter();

    @Test
    void givenNoIslands_whenCountNumberOfIslands_thenReturnZero() {
        int[][] area = {
                {0, 0, 0},
                {0, 0, 0}
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isZero();
    }

    @Test
    void givenNullArea_whenCountNumberOfIslands_thenReturnZero() {
        int numberOfIslands = underTest.countNumberOfIslandsIn(null);

        Assertions.assertThat(numberOfIslands).isZero();
    }

    @Test
    void givenEmptyArea_whenCountNumberOfIslands_thenReturnZero() {
        int[][] area = { {} };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isZero();
    }

    @Test
    void givenOneCellIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] area = {
                {1, 0, 0},
                {0, 0, 1}
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenVerticalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] area = {
                {1, 0, 1},
                {1, 0, 1}
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenHorizontalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] area = {
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenHorizontalAndVerticalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] area = {
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 1}
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenDiagonalIslands_whenCountNumberOfIslands_thenSuccess() {
        int[][] area = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0}
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isEqualTo(2);
    }

    @Test
    void givenComplexIsland_whenCountNumberOfIslands_thenSuccess() {
        int[][] area = {
                {1, 0, 1, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        int numberOfIslands = underTest.countNumberOfIslandsIn(area);

        Assertions.assertThat(numberOfIslands).isEqualTo(1);
    }
}

# Island Counter Problem

## Problem statement
- Given an explorable area (2D integer matrix), find the number of islands.

## Language based on the Domain Model
- An **explorable area** is divided in **cells**.
- These cells have **coordinates**, and can be either **land** or **sea**.
- An **Island** is a group of **connected land cells**.
- The land cells that form an island can be connected **horizontally**, **vertically** or **diagonally**.

## Implemented algorithm
The algorithm first tries to explore the explorable area cell by cell. If it stops on a land cell, then it must explore the island starting from this land cell before checking another unrelated cell. To prevent the algorithm for exploring multiple times the same cells, it keeps track of previously explored cells.

## Test out the algorithm
The entry point of the algorithm is the class `IslandCounter`. 
You can test it out by running the test cases that are in `src\test\java\io\github\nicolasdesnoust`.
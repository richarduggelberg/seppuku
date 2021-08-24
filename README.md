# Seppuku

A mediocre sudoku solver.

It is currently able to solve simpler N x N sudoku puzzles where some squares have only one possible value.

Created as part of my thesis project where the goal is to synthesize property-based tests from an existing test suite.
This repository serves as a possible basis for such experiments.


## Test metrics

### Cobertura

##### Overall
* Line Coverage: 84%
* Branch Coverage: 81%

##### Board.java
* Line Coverage: 79%
* Branch Coverage: 71%

##### Solver.java
* Line Coverage: 90%
* Branch Coverage: 88%

### Pitest

##### Overall
* Line Coverage: 86%
* Mutation Score: 63%
* Test Strength: 71%

##### Board.java
* Line Coverage: 80%
* Mutation Score: 72%
* Test Strength: 88%

##### Solver.java
* Line Coverage: 91%
* Mutation Score: 56%
* Test Strength: 61%
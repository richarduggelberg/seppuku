# Seppuku

A mediocre sudoku solver.

It is currently able to solve simpler N x N sudoku puzzles where some squares have only one possible value.

Created as part of my thesis project where the goal is to synthesize property-based tests from an existing test suite.
This repository serves as a possible basis for such experiments.


## Test metrics

### Cobertura

##### Overall
* Line Coverage: 88%
* Branch Coverage: 86%

##### Board.java
* Line Coverage: 86%
* Branch Coverage: 83%

##### Solver.java
* Line Coverage: 91%
* Branch Coverage: 89%

### Pitest

##### Overall
* Line Coverage: 90%
* Mutation Score: 79%
* Test Strength: 88%

##### Board.java
* Line Coverage: 87%
* Mutation Score: 76%
* Test Strength: 87%

##### Solver.java
* Line Coverage: 92%
* Mutation Score: 81%
* Test Strength: 88%
# Seppuku

A mediocre sudoku solver.

It is currently able to solve simpler N x N sudoku puzzles where some squares have only one possible value.

Created as part of my thesis project where the goal is to synthesize property-based tests from an existing test suite.
This repository serves as a possible basis for such experiments.


## Test metrics

### Cobertura

##### Overall
* Line Coverage: 87%
* Branch Coverage: 84%

##### Board.java
* Line Coverage: 84%
* Branch Coverage: 78%

##### Solver.java
* Line Coverage: 90%
* Branch Coverage: 88%

### Pitest

##### Overall
* Line Coverage: 88%
* Mutation Score: 65%
* Test Strength: 73%

##### Board.java
* Line Coverage: 85%
* Mutation Score: 73%
* Test Strength: 86%

##### Solver.java
* Line Coverage: 91%
* Mutation Score: 59%
* Test Strength: 64%
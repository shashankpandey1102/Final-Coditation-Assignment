package com.coditation.cell;
/*
 * Author = Shashank Pandey
 */

public class Grid {
	// Function for printing next generation
	void nextGeneration(Cell grid[][], int M, int N) {
		int[][] futureGeneration = new int[M][N];

		// Traversing through each cell
		for (int p = 1; p < M - 1; p++) {
			for (int q = 1; q < N - 1; q++) {
				// Finding Living neighbors
				int liveNeighbors = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						liveNeighbors += grid[p + i][q + j].getStatus();

				liveNeighbors -= grid[p][q].getStatus();

				// Implementation Logic

				// Cell dies due to loneliness
				if ((grid[p][q].getStatus() == 1) && (liveNeighbors < 2))
					futureGeneration[p][q] = 0;

				// Cell dies due to overcrowding
				else if ((grid[p][q].getStatus() == 1) && (liveNeighbors > 3))
					futureGeneration[p][q] = 0;

				// A new cell comes to life
				else if ((grid[p][q].getStatus() == 0) && (liveNeighbors == 3))
					futureGeneration[p][q] = 1;

				// unchanged
				else
					futureGeneration[p][q] = grid[p][q].getStatus();
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j].setStatus(futureGeneration[i][j]);
			}
		}

		// Printing Next Generation
		System.out.println("Next Generation");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j].getStatus() == 0)
					System.out.print(" Dead ");
				else
					System.out.print(" Live ");
			}
			System.out.println();
		}

	}
}

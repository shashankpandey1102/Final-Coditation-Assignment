package com.coditation.cell;
/*
 * Author = Shashank Pandey
 */

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Grid g = new Grid(); // Object Declaration of Grid

		int M = 10, N = 10;
		int id = 1;
		int row = 0, col = 0;
		Scanner sc = new Scanner(System.in);

		Cell[][] grid = new Cell[10][10];

		System.out.println("Enter the number of poition you want to change the status to alive : ");
		int noOfcell = sc.nextInt();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = new Cell(id++, 0);
			}
		}

		for (int i = 0; i < noOfcell; i++) {
			System.out.println("Enter the position of Cell you want alive : ");
			int pos = sc.nextInt();
			if (pos > 0 & pos <= 100) {
				if (pos % 10 != 0) {
					row = (pos / 10);
					col = pos % 10 - 1;
				} else if (pos % 10 == 0) {
					row = pos / 10 - 1;
					col = 9;
				}
			} else {
				System.out.println("Invalid Position");
				continue;
			}
			grid[row][col].setStatus(1);
		}

		// Displaying the Present Generation
		System.out.println("Present Generation");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j].getStatus() == 0)
					System.out.print(" Dead ");
				else
					System.out.print(" Live ");
			}
			System.out.println();
		}
		System.out.println();

		g.nextGeneration(grid, M, N); // Calling nextGeneration function of Grid class

		System.out.println("*******************************************************************");
		System.out.println("Please enter the cell Number whose status you want :--> ");
		int Cpos = sc.nextInt();
		if (Cpos > 0 & Cpos <= 100) {
			if (Cpos % 10 != 0) {
				row = (Cpos / 10);
				col = Cpos % 10 - 1;
			} else if (Cpos % 10 == 0) {
				row = Cpos / 10 - 1;
				col = 9;
			}
		} else {
			System.out.println("Invalid Position");
		}

		System.out.println("If Status = 0 then Cell is Dead");
		System.out.println("If Status = 1 then Cell is Alive");

		System.out.println("The status for " + grid[row][col].getId() + " Is :--> " + grid[row][col].getStatus());
	}

}

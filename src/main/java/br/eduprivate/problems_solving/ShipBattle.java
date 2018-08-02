package br.eduprivate.problems_solving;

import java.util.StringTokenizer;

public class ShipBattle {
	public String solution(int N, String S, String T) {
		
		StringTokenizer ship = new StringTokenizer(S, ",");
		
		int countShipSunk = 0;
		int countShipHit = 0;
		while (ship.hasMoreTokens()) {
			String shipCoords = ship.nextToken();
			boolean isShipSunk = isShipSunk(N, shipCoords, T);
			if (isShipSunk) {
				countShipSunk++;
			} else {
				if (isShipHit(N, shipCoords, T)) {
					countShipHit++;
				}
			}
		}
		
		return countShipSunk+","+countShipHit;
	}

	public boolean isShipSunk(int n, String S, String T) {
		int[][] board = new int[n][n];

		StringTokenizer tokensShip = new StringTokenizer(S);
		String position = tokensShip.nextToken();
		int rowX = Integer.parseInt(position.substring(0, position.length() - 1)) -1;
		char charColumnX = position.charAt(position.length() - 1);
		int columnX = getColumn(Character.toString(charColumnX));
		position = tokensShip.nextToken();
		int rowY = Integer.parseInt(position.substring(0, position.length() - 1)) -1;
		char charColumnY = position.charAt(position.length() - 1);
		int columnY = getColumn(Character.toString(charColumnY));
		
		
		for (int i = rowX; i <= rowY; i++) {
			for (int j = columnX; j <= columnY; j++) {
				board[i][j] = 1;				
			}
		}
		StringTokenizer tokensHit = new StringTokenizer(T);

		while (tokensHit.hasMoreTokens()) {
			String positionHit = tokensHit.nextToken();
			int row = Integer.parseInt(positionHit.substring(0, positionHit.length() - 1)) - 1;
			char charColumn = positionHit.charAt(positionHit.length() - 1);
			int column = getColumn(Character.toString(charColumn));
			
			board[row][column] = 2;
		}
		
		boolean isShipSunk = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					isShipSunk = false;
				}
			}
		}

		return isShipSunk;
	}
	
	public boolean isShipHit(int n, String S, String T) {
		int[][] board = new int[n][n];

		StringTokenizer tokensShip = new StringTokenizer(S);
		String position = tokensShip.nextToken();
		int rowX = Integer.parseInt(position.substring(0, position.length() - 1)) -1;
		char charColumnX = position.charAt(position.length() - 1);
		int columnX = getColumn(Character.toString(charColumnX));
		position = tokensShip.nextToken();
		int rowY = Integer.parseInt(position.substring(0, position.length() - 1)) -1;
		char charColumnY = position.charAt(position.length() - 1);
		int columnY = getColumn(Character.toString(charColumnY));
		
		
		for (int i = rowX; i <= rowY; i++) {
			for (int j = columnX; j <= columnY; j++) {
				board[i][j] = 1;				
			}
		}
		
		StringTokenizer tokensHit = new StringTokenizer(T);

		while (tokensHit.hasMoreTokens()) {
			String positionHit = tokensHit.nextToken();
			int row = Integer.parseInt(positionHit.substring(0, positionHit.length() - 1)) -1;
			char charColumn = positionHit.charAt(positionHit.length() - 1);
			int column = getColumn(Character.toString(charColumn));
			board[row][column] = 2;
		}
		
		boolean isShipSunk = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					isShipSunk = false;
				}
			}
		}
		
		if (isShipSunk) {
			return false;
		}
		
		boolean isShipHit = false;
		StringTokenizer tokensRemainShip = new StringTokenizer(S);
		String positionRemains = tokensRemainShip.nextToken();
		int rowRemainsX = Integer.parseInt(positionRemains.substring(0, positionRemains.length() - 1)) -1;
		char charReaminsColumnX = positionRemains.charAt(positionRemains.length() - 1);
		int columnRemainsnsX = getColumn(Character.toString(charReaminsColumnX));
		positionRemains = tokensRemainShip.nextToken();
		int rowRemainsY = Integer.parseInt(positionRemains.substring(0, positionRemains.length() - 1)) -1;
		char charRemainsColumnY = positionRemains.charAt(positionRemains.length() - 1);
		int columnRaminsY = getColumn(Character.toString(charRemainsColumnY));
		
		for (int i = rowRemainsX; i <= rowRemainsY; i++) {
			for (int j = columnRemainsnsX; j <= columnRaminsY; j++) {
				if (board[i][j] == 2)
					isShipHit = true;				
			}
		}

		return isShipHit;
	}
	
	public void printBoard(int n, int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("|"+board[i][j]);
			}
				System.out.println();
			}
	}

	public int getColumn(String C) {
		String COLUMNS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return COLUMNS.indexOf(C);
	}
	
	public static void main(String[] args) {
		ShipBattle solution = new ShipBattle();
		int n = 4;
		String S = "1B 2C,2D 4D";
		String T = "2B 2D 3D 4D 4A";
		System.out.println(solution.solution(n, S, T));
	}
}

package BaekOJ.ssafy.date1006;

import java.io.*;
import java.util.*;

public class BaekOJ2239_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int SIZE = 9;
	static final int NUMBER = 10;
	static int map[][] = new int[SIZE][SIZE];
	static boolean checkCol[][] = new boolean[SIZE][NUMBER];
	static boolean checkRow[][] = new boolean[SIZE][NUMBER];
	static boolean checkSqr[][] = new boolean[SIZE][NUMBER];

	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i = 0; i < 9; i++) {
			String input = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j)-'0';
				if(map[i][j] != 0) {
					checkCol[i][map[i][j]] = true;
					checkRow[j][map[i][j]] = true;
					checkSqr[(i/3)*3+(j/3)][map[i][j]] = true;
				}
			}
		}
		playSudoku(0);
	}
	
	public static void playSudoku(int idx) {
		if(idx == SIZE*SIZE) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) sb.append(map[i][j]);
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int i = idx / 9;
		int j = idx % 9;
		int sqr = (i/3)*3+(j/3);
		if(map[i][j] == 0) {
			for(int num = 1; num <= 9; num++) {
				if(!((checkCol[i][num]) || checkRow[j][num] || checkSqr[sqr][num])) {
					checkCol[i][num] = true;
					checkRow[j][num] = true;
					checkSqr[sqr][num] = true;
					map[i][j] = num;
					
					playSudoku(idx+1);
					
					checkCol[i][num] = false;
					checkRow[j][num] = false;
					checkSqr[sqr][num] = false;
					map[i][j] = 0;
				}
			}
		}
		else playSudoku(idx+1);
	}
}

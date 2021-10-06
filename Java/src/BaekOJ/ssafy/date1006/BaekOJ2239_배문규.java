package BaekOJ.ssafy.date1006;

import java.io.*;
import java.util.*;

public class BaekOJ2239_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	/*
	 * row, col, x, y 표현은 헷갈려서  i, j로 통일하였음.
	 * 스도쿠를 완성시키기위해서는 행, 열, 작은 사각형에 중복되는 숫자가 존재하면 안된다.
	 * 그래서  i, j, sqr 별로 숫자체크를 해줘야 함.
	 */
	static final int I = 0, J = 1, SQUARE = 2;
	static final int SIZE = 9, NUMBER = 10;
	static int map[][] = new int[SIZE][SIZE];
	static boolean check[][][] = new boolean[3][SIZE][NUMBER];

	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i = 0; i < 9; i++) {
			String input = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j));
				if(map[i][j] != 0) {
					// 0이 아니면 해당  i, j, sqr에 해당 숫자 체크
					check[I][i][map[i][j]] = true;
					check[J][j][map[i][j]] = true;
					check[SQUARE][(i/3)*3+(j/3)][map[i][j]] = true;
				}
			}
		}
		playSudoku(0);
	}
	
	public static void playSudoku(int idx) {
		// 스도쿠가 완성되면 출력 형식에 맞춰서 출력하고 프로그램 종료
		if(idx == SIZE * SIZE) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) sb.append(map[i][j]);
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		// 선형탐색을 원활하게 하기 위해  idx변수 1개만 사용해서 연산을 통해 i, j, sqr를 구해 줌
		int i = idx / 9;
		int j = idx % 9;
		int sqr = (i/3)*3+(j/3);
		
		// 0이면 조건에 맞춰서 채워줌
		if(map[i][j] == 0) {
			// 스도쿠 숫자범위인 1부터 9까지
			for(int num = 1; num <= 9; num++) {
				// 해당 num이 행, 열, 사각형에 모두 포함되지 않았다면
				if(!(check[I][i][num]) && !check[J][j][num] && !check[SQUARE][sqr][num]) {
					// 체크하고  dfs 
					check[I][i][num] = true;
					check[J][j][num] = true;
					check[SQUARE][sqr][num] = true;
					map[i][j] = num;
					
					playSudoku(idx+1);
					
					// 스도쿠가 완성되지 못하고  dfs를 빠져나오면 해당 숫자 체크를 해제하고 다음 수를 체크함
					check[I][i][num] = false;
					check[J][j][num] = false;
					check[SQUARE][sqr][num] = false;
					map[i][j] = 0;
				}
			}
		}
		// 0이 아니면 그냥 0을 찾아 넘어감
		else playSudoku(idx+1);
	}
}

package ssafy0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1233_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[][] tree = new String[N+1][];
			int result = 1;
			for(int i = 1; i <= N; i++) {
				tree[i] = br.readLine().split(" ");
				switch(tree[i].length) {
				case 2:{ // 리프노드 였을 때
					if(isChar(tree[i][1])) result = 0; // 연산자이면 fail
					break;
					}
				case 3:{ // 자식은 무조건 2개
					result = 0; // fail
					break;
					}
				case 4:{ // 자식이 있을 때
					if(!isChar(tree[i][1])) result = 0; // 숫자이면 fail
					break;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}

	}
	
	public static boolean isChar(String str) {
		if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) return true;
		else return false;
	}
}
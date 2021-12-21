package BaekOJ.study.date1214;

import java.io.*;
import java.util.*;

/*
 * 백준 13013 접미사 배열 2
 * 
 * 메모리 	시간
 * 
 */
public class BaekOJ13013_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	static final int ORIGIN = 0, NEW = 1;
	static int N, result, order[];
	static String suffix[][], S[][];
	public static void main(String[] args) throws Exception {
		N = result = Integer.parseInt(br.readLine());
		order = new int[N];
		suffix = new String[2][N];
		S = new String[2][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			S[ORIGIN][order[i]] = S[NEW][order[i]] = ((char)(i+97))+"";
		}

		for(int i = 0; i < N-1; i++) {
			S[NEW][order[i+1]] = S[NEW][order[i]];
			
			for(int j = 0; j < N; j++) 
				suffix[ORIGIN][j] = suffix[NEW][j] = String.join("", S[NEW]).substring(j);
			Arrays.sort(suffix[NEW]);
			
			sb.setLength(0);
			for(int j = 0; j < N; j++) 
				sb.append(Arrays.asList(suffix[ORIGIN]).indexOf(suffix[NEW][j]));
			
			if(Arrays.toString(order).replaceAll("[^0-9]","").equals(sb.toString())){
				S[ORIGIN] = S[NEW].clone();
				result--;
			}
			else S[NEW] = S[ORIGIN].clone();
		}

		System.out.println(result);
	}
}

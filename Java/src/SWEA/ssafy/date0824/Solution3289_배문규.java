package SWEA.ssafy.date0824;

import java.io.*;
import java.util.*;

public class Solution3289_배문규 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, N, M, set[], c, a, b;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			set = new int[N+1];
			for(int i = 1; i <= N; i++) set[i] = i;
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				// 0 이면 합집합
				if(c == 0) union(set, a, b);
				// 1 이면 같은 집합인지 확인
				else {
					// 같은 집합이면 1, 아니면 0
					if(findCap(set, a) == findCap(set, b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 집합 대표 찾아가기
	public static int findCap(int[] set, int e) { 
		// 대표를 찾음
		if(e == set[e]) return e; 
		else return set[e] = findCap(set, set[e]);  // 못찾으면 대표를 찾으러 올라감
	} 
	
	// 합집합
	public static void union(int[] set, int a, int b) {
		// 우선 각 대표를 찾음
		a = findCap(set, a); 
		b = findCap(set, b); 
		// 대표를 비교하고 a가 크면 a의 대표는 b, b가 크면 b의 대표는 a로 인수합병
		if(a > b) set[a] = b; 
		else set[b] = a; 
	}
}

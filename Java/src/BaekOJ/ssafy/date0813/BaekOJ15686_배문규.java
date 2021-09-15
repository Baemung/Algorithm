package BaekOJ.ssafy.date0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekOJ15686_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st = null;
	static int N, M;
	static int _min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵을 입력받고, 치킨 집 개수를 구함
		int[][] map = new int[N][N];
		int chickenCnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chickenCnt++;
			}
		}
		
		// 치킨 집 개수를 통해 치킨집인덱스 배열을 만들고, 치킨집 인덱스 찾아 넣기
		int[][] chickenIdx = new int[chickenCnt][2];
		int idx = -1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					chickenIdx[++idx][0] = i;
					chickenIdx[idx][1] = j;
				}
			}
		}
		
		// 치킨집 조합을 만들기 위한 배열
		int[] chickenComb = new int[chickenCnt];
		for(int i = chickenCnt-1; i > chickenCnt-1-M ; i--) chickenComb[i] = 9;
		
		
		// 치킨집 조합을 통해 도시의 최단 치킨 거리 구함
		do {
			// 도시 치킨 거리
			int chickenDist = 0;
			
			// 치킨집 조합 인덱스를 담을 배열 생성
			int cidx = 0;
			int[] chicken = new int[M];
			for(int i = 0; i < chickenCnt; i++) {
				if(chickenComb[i] == 9) chicken[cidx++] = i;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 집에서
					if(map[i][j] == 1) {
						int min_c = Integer.MAX_VALUE;
						// 조합된 치킨집마다 각 거리를 각각 구함
						for(int c : chicken) {
							int ci = chickenIdx[c][0];
							int cj = chickenIdx[c][1];
							int dist = Math.abs(i-ci) +  Math.abs(j-cj);
							// 해당 집에서 최단 거리의 치킨집구함
							min_c = Math.min(dist, min_c);
						}
						// 제일 가까운 치킨집 거리를 도시 치킨 거리에 추가
						chickenDist += min_c;
					}
				}
			}
			// 현재까지 조합에서 도시의 최단 치킨 거리 구함 
			_min = Math.min(_min, chickenDist);
			
		}while(np(chickenComb));
		
		System.out.println(_min);
	}
	
	public static boolean np(int[] arr) {
		int N = arr.length;
		int i = N-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

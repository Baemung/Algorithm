package BaekOJ.ssafy.date0924;

import java.io.*;
import java.util.*;

public class BaekOJ7576_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, M, map[][], result;
	static int delta[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static Queue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		queue = new ArrayDeque<int[]>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) queue.offer(new int[] {i, j});
			}
		}
		
		System.out.println(solution());
	}
	
	public static int solution() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] dt = queue.poll();
				search(dt[0], dt[1]);
			}
			result++;
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j <N; j++) {
				if(map[i][j] == 0) return -1;
			}
		}
		
		return result-1;
	}
	
	public static void search(int i, int j) {
		for(int d = 0; d < 4; d++) {
			int di = i + delta[d][0];
			int dj = j + delta[d][1];
			if(!isOOB(di, dj) && map[di][dj] == 0) {
				map[di][dj] = 1;
				queue.offer(new int[] {di, dj});
			}
		}
	}
	
	public static boolean isOOB(int i, int j) {
		if (i>=M || i<0 || j>=N || j<0) return true;
		else return false;
	}
}
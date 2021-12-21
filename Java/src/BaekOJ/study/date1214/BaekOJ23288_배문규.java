package BaekOJ.study.date1214;

import java.io.*;
import java.util.*;

/*
 * 백준 23288 주사위굴리기2
 * 
 * 정말 삼성코테에서 푼 그대로 다시 풀었음
 * 효율성은 별로 안보는듯...?
 * 
 * 4*3 배열을 주사위로 관리하며
 * 요구조건대로 구현하였음.
 * 
 * 메모리 	시간
 * 18288	292
 */

public class BaekOJ23288_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, M, K, map[][], result, dir;
	static boolean check[][];
	static int ni = 0, nj = 0;
	static int delta[][] = {{0,1}, {-1,0}, {0,-1}, {1,0}};
	static int dice[][] = {
			{0,2,0},
			{4,1,3},
			{0,5,0},
			{0,6,0}
	};
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int m = 0; m < K; m++) {
			move();
			getScore();
			setDir();
		}
		
		System.out.println(result);
	}
	
	public static void move() {
		// 범위 밖이면 반대로 튕겨나옴
		int di = ni + delta[dir][0];
		int dj = nj + delta[dir][1];
		if(isOOB(di, dj)) dir = (dir+2)%4;
		ni += delta[dir][0];
		nj += delta[dir][1];
		
		// 주사위 이동
		int temp;
		switch (dir) {
		case 0:
			temp = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 1:
			temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 2:
			temp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 3:
			temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
			break;
		default:
			break;
		}
	}
	
	public static void getScore() {
		int score = map[ni][nj], cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) check[i][j] = false;
		}
		queue.clear();
		
		// bfs로 같은 점수 찾기
		queue.offer(ni);
		queue.offer(nj);
		check[ni][nj] = true;
		cnt++;
		while(!queue.isEmpty()) {
			int i = queue.poll();
			int j = queue.poll();
			for(int d = 0; d < 4; d++) {
				int di = i + delta[d][0];
				int dj = j + delta[d][1];
				if(!isOOB(di, dj) && !check[di][dj] && map[di][dj] == score) {
					queue.offer(di);
					queue.offer(dj);
					check[di][dj] = true;
					cnt++;
				}
 			}
		}
		result += score * cnt;
	}
	
	// 방향 설정
	public static void setDir() { 
		if(map[ni][nj] < dice[3][1]) dir = (dir+3)%4;
		else if(map[ni][nj] > dice[3][1]) dir = (dir+1)%4;
	}
	
	public static boolean isOOB(int i, int j) {
		return i > N - 1 || i < 0 || j > M - 1 || j < 0;
	}
}

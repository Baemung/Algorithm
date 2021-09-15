package BaekOJ.ssafy.date0915;

import java.io.*;
import java.util.*;

class Monkey{
	int i;
	int j;
	int K;
	
	public Monkey(int i, int j, int K) {
		this.i = i;
		this.j = j;
		this.K = K;
	}
}

public class BaekOJ1600_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int K, W, H, map[][], cnt[][][];
	static int hDelta[][] = {{1, 2}, {2, 1},
							{1, -2}, {2, -1},
							{-1, 2}, {-2, 1},
							{-1, -2}, {-2, -1}};
	static int mDelta[][] = {{1, 0}, {0, 1},
							{-1, 0}, {0, -1}};
	static Queue<Monkey> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		cnt = new int[201][201][31];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solve());
	}
	public static int solve() {
		Monkey monkey = new Monkey(0, 0, K);
		queue = new ArrayDeque<Monkey>();
		queue.offer(monkey);
		while(!queue.isEmpty()) {
			Monkey knight = queue.poll();
			if(isArrived(knight.i, knight.j)) return cnt[knight.i][knight.j][knight.K];

			int currI = knight.i;
			int currJ = knight.j;
			int currK = knight.K;
			
			for(int i = 0; i < 4; i++) {
				int di = currI + mDelta[i][0];
				int dj = currJ + mDelta[i][1];
				if(!isOOB(di, dj) && !isBoundary(di, dj) && cnt[di][dj][currK] == 0) {
					cnt[di][dj][currK] = cnt[currI][currJ][currK]+1;
					queue.offer(new Monkey(di, dj, currK));
				}
			}
			
			if(currK > 0) {
				for(int i = 0; i < 8; i++) {
					int di = currI + hDelta[i][0];
					int dj = currJ + hDelta[i][1];
					if(!isOOB(di, dj) && !isBoundary(di, dj) && cnt[di][dj][currK-1] == 0) {
						cnt[di][dj][currK-1] = cnt[currI][currJ][currK]+1;
						queue.offer(new Monkey(di, dj, currK-1));
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean isOOB(int i, int j) {
		if(i < 0 || i >= H || j < 0 || j >= W) return true;
		else return false;
	}
	
	public static boolean isBoundary(int i, int j) {
		if(map[i][j] == 1) return true;
		else return false;
	}
	
	public static boolean isArrived(int i, int j) {
		if(i == H-1 && j == W-1) return true;
		else return false;
	}
}

package BaekOJ.study.date1214;

import java.io.*;
import java.util.*;

/*
 * 백준 21609 상어중학교
 * 
 * 
 * 
 * 메모리 	시간
 * 18732	176
 */

class Block implements Comparable<Block> {
	int i, j, color;
	public Block(int i, int j, int color) {
		this.i = i;
		this.j = j;
		this.color = color;
	}
	
	@Override
	public int compareTo(Block other) {
		if(this.color == other.color) {
			if(this.i == other.i)
				return this.j - other.j;
			return this.i - other.i;
		}
		return other.color - this.color;
	}
}	

public class BaekOJ21609_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int EMPTY = -2;
	static final int RAINBOW = 0;
	static int N, M, score, map[][], sSize, srSize;
	static boolean[][] check;
	static int delta[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}}; 
	static List<Block> selectedGroup;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		check = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		while(true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!check[i][j] && map[i][j] > 0) {
						selectGroup( bfs(i, j) );
					}
				}
			}
			if(selectedGroup == null) break; 
			removeBlockGroup();
			gravity();
			rotate();
			gravity();
		}
		System.out.println(score);
	}

	public static List<Block> bfs(int i, int j) {
		int color = map[i][j];
		List<Block> group = new ArrayList<>();
		Queue<Block> queue = new LinkedList<>();
		
		check[i][j] = true;
		group.add(new Block(i, j, map[i][j]));
		queue.offer(new Block(i, j, map[i][j]));
		
		while( !queue.isEmpty() ) {
			Block block = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nj = block.j + delta[d][0];
				int ni = block.i + delta[d][1];
				if(!(0 <= ni && ni < N && 0 <= nj && nj < N) ) continue;
				if(check[ni][nj] || !(map[ni][nj] == RAINBOW || map[ni][nj] == color)) continue;
				check[ni][nj] = true;
				group.add(new Block(ni, nj, map[ni][nj]));
				queue.offer(new Block(ni, nj, map[ni][nj]));
			}
		}
		return group;
	}
	
	public static void selectGroup(List<Block> group) {
		int size = group.size(), rSize = 0;
		if(size == 1) return;
		for (Block block : group) {
			if( block.color == RAINBOW ) {
				check[block.i][block.j] = false;
				rSize++;
			}
		}
		Collections.sort(group);
		if(selectedGroup != null) {
			if(selectedGroup.size() > group.size()) return;
			else if(selectedGroup.size() == group.size()) {
				if(srSize > rSize) return;
				else if(srSize == rSize) {
					Block sBlock = selectedGroup.get(0), block = group.get(0);	
					if(sBlock.i > block.i) return;
					else if(sBlock.i == block.i) {
						if(sBlock.j > block.j) return;
					}
				}
			}
		}
		
		sSize = size; 
		srSize = rSize;
		selectedGroup = group;
	}

	public static void removeBlockGroup() {
		for(Block block : selectedGroup) map[block.i][block.j] = EMPTY;
		score += sSize * sSize;
		selectedGroup = null;
		sSize = srSize = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) check[i][j] = false;
		}
	}
	
	public static void gravity() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] < 0) continue;
				int g = 1;
				while(i + g < N && map[i + g][j] == EMPTY) g++;
				if(i + g - 1 != i) {
					map[i + g - 1][j] = map[i][j];
					map[i][j] = EMPTY;
				}
			}
		}
	}

	public static void rotate() {
		int[][] temp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) temp[N-1-j][i] = map[i][j];
		}
		map = temp;
	}
}
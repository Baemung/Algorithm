package BaekOJ.ssafy.date0929;

import java.io.*;
import java.util.*;

public class BaekOJ1194_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;

	static int N, M;
	static int delta[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static char map[][];
	static boolean check[][][];
	static Queue<int[]> queue = new ArrayDeque<int[]>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N+2][M+2];
		check = new boolean[N+2][M+2][64];
		for(int i = 0; i < N+2; i++) Arrays.fill(map[i], '#');

		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1);
				if(map[i][j] == '0') {
					queue.offer(new int[] {i, j, 0, 0});
					map[i][j] = '.';
					check[i][j][0] = true;
				}
			}
		}
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int msI, msJ, move, key, nkey, dI, dJ, shift, minsick[];
		
		while(!queue.isEmpty()) {
			minsick = queue.poll();
			msI = minsick[0];
			msJ = minsick[1];
			key = minsick[2];
			move = minsick[3];
			
			for(int[] d : delta) {
				dI = msI + d[0];
				dJ = msJ + d[1];
				
				// 벽이 아니거나, 동일한 열쇠구성으로 방문하지 않은 곳이라면
				if(map[dI][dJ] != '#' && !check[dI][dJ][key]) {
					// 도착지라면
					if(map[dI][dJ] == '1') return move+1;
					// 갈 수 있다면
					if(map[dI][dJ] == '.') {
						check[dI][dJ][key] = true;
						queue.offer(new int[] {dI, dJ, key, move+1});
					}
					
					else {
						shift = map[dI][dJ]-'0' <= 22 ? map[dI][dJ]-'0'-17 : map[dI][dJ]-'0' - 49;
						// 문일 때
						if(17 <= map[dI][dJ]-'0' && map[dI][dJ]-'0' <= 22) {
							// 열쇠가 있다면
							nkey = key & (1 << shift);
							if(nkey == (1 << shift)) {
								check[dI][dJ][key] = true;
								queue.offer(new int[] {dI, dJ, key, move+1});
							}
						}
						// 열쇠일 때
						else {
							// 열쇠를 가지고, 해당 열쇠 구성으로 아직 방문하지 않았다면
							nkey = key | (1 << shift);
							if(!check[dI][dJ][nkey]) {
								check[dI][dJ][nkey] = true;
								queue.offer(new int[] {dI, dJ, nkey, move+1});
							}
						}
					}
				}
			}
		}
		return -1;
	}
}

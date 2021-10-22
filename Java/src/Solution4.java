import java.io.*;
import java.util.*;

class Solution4
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int T, N, n, check[][], result;
	static int delta[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			
			check = new int[N][N];
			
			Queue<int[]> queue = new ArrayDeque<int[]>();
			Queue<int[][]> queueMap = new ArrayDeque<int[][]>();

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						map[i][j] = 0;
						queue.offer(new int[] {i, j, 0});
					}
				}
			}
			
			result = 0;
			queueMap.offer(map);
			while(!queue.isEmpty()) {
				int[] po = queue.poll();
				int[][] qMap = queueMap.poll();
				
				int pi = po[0];
				int pj = po[1];
				int move = po[2];
				if(move == 3) break;
				
				for(int d = 0; d < 4; d++) {
					int di = pi + delta[d][0];
					int dj = pj + delta[d][1];
					boolean canGo = false;
					
					while(true) {
						if(isOOB(di, dj)) break;
						
						if(!canGo && qMap[di][dj] == 1) {
							canGo = true;
							di += delta[d][0];
							dj += delta[d][1];
							continue;
						}
						
						if(canGo){
							if(qMap[di][dj] == 1) {
								if(check[di][dj] == 0) check[di][dj] = move+1;
								queue.offer(new int[] {di, dj, move+1});
								queueMap.offer(copy(qMap, di, dj));
								break;
							}
							else {
								queue.offer(new int[] {di, dj, move+1});
								queueMap.offer(qMap);
							}
						}
						di += delta[d][0];
						dj += delta[d][1];
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(check[i][j] != 0) result++;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	public static boolean isOOB(int i, int j) {
		return i > N - 1 || i < 0 || j > N - 1 || j < 0;
	}
	
	public static int[][] copy(int[][] arr, int pi, int pj){
		int[][] copy = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) copy[i][j] = arr[i][j];
		}
		copy[pi][pj] = 0;
		
		return copy;
	}
}

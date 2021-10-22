import java.io.*;
import java.util.*;

public class Solution1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int MAN = 1, ESCAPE = 2;
	static int T, N, map[][], wait[][], human[], result;
	static boolean check[][][];
	static int delta[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	static Map<Integer, Queue<int[]>> escapeQueue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			wait = new int[N][N];
			queue.clear();

			escapeQueue = new HashMap<Integer, Queue<int[]>>();
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == MAN) queue.offer(new int[] {i, j, 0, cnt++});
					else if(map[i][j] == ESCAPE) escapeQueue.put(i*j, new ArrayDeque<int[]>());
				}
			}
			
			result = 0;
			human = new int[cnt];
			Arrays.fill(human, Integer.MAX_VALUE);
			check = new boolean[N][N][cnt];
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					int[] man = queue.poll();
					int mI = man[0];
					int mJ = man[1];
					int time = man[2];
					int id = man[3];
					
					for(int[] d : delta) {
						int dI = mI + d[0];
						int dJ = mJ + d[1];
						if(isOOB(dI, dJ) || check[dI][dJ][id]) continue;
						
						check[dI][dJ][id] = true;
						if(map[dI][dJ] == ESCAPE) escapeQueue.get(dI*dJ).offer(new int[] {id, time});
						
						queue.offer(new int[] {dI, dJ, time+1, id});
					}
				}
			}
			
			System.out.println();
		}
	}
	
	public static boolean isOOB(int i, int j) {
		return i > N - 1 || i < 0 || j > N - 1 || j < 0;
	}
}

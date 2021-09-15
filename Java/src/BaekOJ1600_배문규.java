import java.io.*;
import java.util.*;

// 원숭이 말 클래스
class Monkey{
	int i;
	int j;
	int K;
	static int H;
	static int W;
	
	public Monkey(int i, int j, int K) {
		this.i = i;
		this.j = j;
		this.K = K;
	}
	
	// 목적지 도착 체크
	public boolean isArrived() {
		return H == this.i+1 && W == this.j+1 ? true : false ;
	}
}

public class BaekOJ1600_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int K, W, H, map[][], cnt[][][];
	// 말, 원숭이 델타
	static int hDelta[][] = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
	static int mDelta[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	// BFS 큐
	static Queue<Monkey> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 맵 입력
		map = new int[H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 도착좌표 + K를 몇번 사용하고 도착했는지 체크, value로는 카운트값이 들어옴
		cnt = new int[H+1][W+1][K+1];
		System.out.println(solve());
	}
	public static int solve() {
		// Monkey의 스태틱 변수 세팅
		Monkey.W = W;
		Monkey.H = H;
		Monkey monkey = new Monkey(0, 0, K);
		
		queue = new ArrayDeque<Monkey>();
		queue.offer(monkey);
		while(!queue.isEmpty()) {
			Monkey knight = queue.poll();
			// 도착 체크
			if(knight.isArrived()) return cnt[knight.i][knight.j][knight.K];

			int currI = knight.i;
			int currJ = knight.j;
			int currK = knight.K;
			
			// 원숭이 무브
			for(int i = 0; i < 4; i++) {
				int di = currI + mDelta[i][0];
				int dj = currJ + mDelta[i][1];
				if(!isOOB(di, dj) && !isBlock(di, dj) && cnt[di][dj][currK] == 0) {
					cnt[di][dj][currK] = cnt[currI][currJ][currK]+1;
					queue.offer(new Monkey(di, dj, currK));
				}
			}
			
			// 말 무브
			if(currK > 0) {
				for(int i = 0; i < 8; i++) {
					int di = currI + hDelta[i][0];
					int dj = currJ + hDelta[i][1];
					// 말일 땐 움직일 위치를 K-1하여 방문 체크 
					if(!isOOB(di, dj) && !isBlock(di, dj) && cnt[di][dj][currK-1] == 0) {
						// 말로 움직인 횟수 마이너스 카운트
						cnt[di][dj][currK-1] = cnt[currI][currJ][currK]+1; 
						queue.offer(new Monkey(di, dj, currK-1));
					}
				}
			}
		}
		
		return -1;
	}
	
	// 배열 범위 체크
	public static boolean isOOB(int i, int j) {
		if(i < 0 || i >= H || j < 0 || j >= W) return true;
		else return false;
	}
	
	// 장애물 체크
	public static boolean isBlock(int i, int j) {
		if(map[i][j] == 1) return true;
		else return false;
	}
}

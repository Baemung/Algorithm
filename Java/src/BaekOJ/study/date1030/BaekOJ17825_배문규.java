package BaekOJ.study.date1030;

import java.io.*;
import java.util.*;

/*
 * 백준 19238 스타트 택시
 * 
 * 손님을 도착지로 데려다주면 연료 충전
 * 연료가 바닥나면 업무 종료
 * M명의 승객을 태우는 것이 목표
 * 
 * 1. 현재 위치에서 (1.거리 -> 2.가장 위 -> 3.가장 왼쪽) 선택
 * 2. 승객을 목적지로 이동시키면 이동한 동안 소모한 연료 양의 2배를 충전함
 * 
 * 주의사항 
 * 1. 초기 연료의 양을 넘어서까지 충전될 수 있다.
 * 2. 이동 도중에 연료가 바닥나서 다음 출발지나 목적지로 이동할 수 없으면 -1을 출력한다. 모든 손님을 이동시킬 수 없는 경우에도 -1을 출력한다.
 * 
 * 시행착오 
 * 1. 도착지가 출발지인 경우
 * 2. 도착지로 갈 수 없는 경우
 * 
 * 메모리 	시간
 * 19460	216
 */

class Passenger implements Comparable<Passenger>{
	int originI;
	int originJ;
	int destinationI;
	int destinationJ;
	int dist;
	
	public Passenger(int originI, int originJ, int destinationI, int destinationJ) {
		super();
		this.originI = originI;
		this.originJ = originJ;
		this.destinationI = destinationI;
		this.destinationJ = destinationJ;
	}

	// 거리 - 행 - 열 순
	@Override
	public int compareTo(Passenger o) {
		return this.dist != o.dist ? this.dist - o.dist : this.originI != o.originI ? this.originI - o.originI : this.originJ - o.originJ;
	}
}

public class BaekOJ17825_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, M, fuel, map[][];
	static int[][] delta = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static boolean check[][];
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	static HashMap<Integer, Passenger> passengers;
	static PriorityQueue<Passenger> next = new PriorityQueue<Passenger>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		// 패딩
		map = new int[N+2][N+2];
		check = new boolean[N+2][N+2];
		for(int i = 0; i < N+2; i++) Arrays.fill(map[i], 1);
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int driverI = Integer.parseInt(st.nextToken());
		int driverJ = Integer.parseInt(st.nextToken());
		int dist = 0;
		
		// 맵으로 승객관리 and map에 -i로 승객 표시
		passengers = new HashMap<Integer, Passenger>();
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int oi = Integer.parseInt(st.nextToken());
			int oj = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			int dj = Integer.parseInt(st.nextToken());
			passengers.put(-i, new Passenger(oi, oj, di, dj));
			map[oi][oj] = -i;
		}
		
		int cnt = 0;
		while(cnt++ < M) {
			// bfs 탐색 세팅 초기화
			queue.clear();
			for(int i = 0; i < N+2; i++) Arrays.fill(check[i], false);
			
			// 도착지가 출발지인 경우
			if(map[driverI][driverJ] < 0) {
				passengers.get(map[driverI][driverJ]).dist = 0;
				next.offer(passengers.get(map[driverI][driverJ]));
			}
			
			queue.offer(new int[] {driverI, driverJ, dist});
			// 1. 손님 태우기
			while(!queue.isEmpty()) {
				int[] driver = queue.poll();
				driverI = driver[0];
				driverJ = driver[1];
				dist = driver[2];
				
				// 승객을 태웠으면
				if(map[driverI][driverJ] < 0) {
					dist = next.peek().dist;
					if(fuel < dist) {
						System.out.println(-1);
						System.exit(0);
					}
					else fuel -= dist;
					break;
				}
				
				for(int[] d: delta) {
					int di = driverI + d[0];
					int dj = driverJ + d[1];
					if(map[di][dj] == 1 || check[di][dj]) continue;
					
					queue.offer(new int[] {di, dj, dist+1});
					check[di][dj] = true;
					// 승객이 있으면 태움
					if(map[di][dj] < 0) {
						passengers.get(map[di][dj]).dist = dist+1;
						next.offer(passengers.get(map[di][dj]));
					}
				}
			}
			
			// 승객을 태우지 못했다면
			if(next.size() == 0) {
				System.out.println(-1);
				System.exit(0);
			}
			
			// bfs 탐색 세팅 초기화
			queue.clear();
			for(int i = 0; i < N+2; i++) Arrays.fill(check[i], false);
			
			// 2. 목적지 데려다주기
			Passenger nextPassenger = next.poll();
			next.clear();
			int orgnI = nextPassenger.originI;
			int orgnJ = nextPassenger.originJ;
			int destI = nextPassenger.destinationI;
			int destJ = nextPassenger.destinationJ;
			map[orgnI][orgnJ] = 0;
			queue.offer(new int[] {orgnI, orgnJ, 0});
			boolean flag = false; // 도착지에 도착했는지 체크
			while(!queue.isEmpty()) {
				int[] driver = queue.poll();
				driverI = driver[0];
				driverJ = driver[1];
				dist = driver[2];
				
				// 도착지에 도착했다면
				if(driverI == destI && driverJ == destJ) {
					if(fuel < dist) {
						System.out.println(-1);
						System.exit(0);
					}
					else fuel += dist;
					flag = true;
					break;
				}
				
				for(int[] d: delta) {
					int di = driverI + d[0];
					int dj = driverJ + d[1];
					if(map[di][dj] == 1 || check[di][dj]) continue;
					
					queue.offer(new int[] {di, dj, dist+1});
					check[di][dj] = true;
				}
			}
			
			// 도착지에 도착하지 못했다면
			if(!flag) {
				System.out.println(-1);
				System.exit(0);
			}
			
			// 도착지를 출발지로 세팅하고 거리 초기화
			driverI = destI;
			driverJ = destJ;
			dist = 0;
		}
		
		System.out.println(fuel);
	}
}












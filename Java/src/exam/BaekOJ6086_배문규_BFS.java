package exam;

import java.io.*;
import java.util.*;

/*
 *  메모리 	시간
 *  14208	136
 */


public class BaekOJ6086_배문규_BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int MAX_SIZE = 52;
	static int N, maxFlow, S, T = 25, aPath[], capacity[][], flow[][];
	static Queue<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		capacity = new int[MAX_SIZE][MAX_SIZE];
		flow = new int[MAX_SIZE][MAX_SIZE];
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = charToInt(st.nextToken().charAt(0));
			int end = charToInt(st.nextToken().charAt(0));
			int weight = Integer.parseInt(st.nextToken());
			// 여기서는 그냥 연결이기 때문에 무향 그래프라서 양방향으로 웨이트를 둘 다 더해줌
			capacity[start][end] += weight; 
			capacity[end][start] += weight;
		}
		
		queue = new ArrayDeque<Integer>();
		aPath = new int[MAX_SIZE];
		// 더 이상 증가경로가 없을 때 까지 반복
		while(true) {
			// 큐, 증가경로 초기화
			queue.clear();
			Arrays.fill(aPath, -1);
			aPath[S] = S;
			queue.add(S);
			
			// BFS로 최단거리 증가경로 찾기
			while(!queue.isEmpty() && aPath[T] == -1) {
				int from = queue.poll();
				for(int to = 0; to < MAX_SIZE; to++) {
					// 유량이 흐를 수 있으면서, 아직 방문하지 않았다면
					if(capacity[from][to] > flow[from][to] && aPath[to] == -1) {
						queue.offer(to);
						aPath[to] = from;
					}
				}
			}
			
			// 경로가 없으면 종료
			if(aPath[T] == -1) break;
			
			// 찾은 증가 경로의 r(u,v)의 최솟값 (최소 잔여 용량)을 찾음 
			int flowAmount = Integer.MAX_VALUE;
			for(int i = T; i != S; i = aPath[i]) flowAmount = Math.min(capacity[aPath[i]][i] - flow[aPath[i]][i], flowAmount);

			for(int i = T; i != S; i = aPath[i]) {
				flow[aPath[i]][i] += flowAmount; // 경로들에 유량 흘러줌
				flow[i][aPath[i]] -= flowAmount; // 유량의 대칭성으로 반대 경로에 - 유량 흘림
			}
			
			maxFlow += flowAmount;
		}
		
		System.out.println(maxFlow);
	}
	
	// 문자를 인덱스로 매핑하기 위해 변환
	public static int charToInt(char c) {
		if('a' <= c && c <= 'z') c -= 6;
		return c - 65;
	}
}

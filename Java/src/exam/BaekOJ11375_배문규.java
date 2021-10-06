package exam;

import java.io.*;
import java.util.*;

/*
 * 회사에 N명의 직원과, M가지 작업이 있을 때,
 * 해당 회사가 할 수 있는 최대 일의 개수를 구하시오.
 * 
 * 1. 각 직원은 1개의 일을 할 수 있다.
 * 2. 각 작업을 담당하는 사람은 1명이다. 즉, 1 : 1 매칭
 * 3. 각 직원이 할 수 있는 일의 목록이 주어진다.
 * 
 * 직원(집단 A)과 작업(집단 B)을 최대한 매칭시키는 베이직한 이분 매칭 문제.
 * 
 * 메모리 	시간
 * 78212	964
 */

public class BaekOJ11375_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int MAX_SIZE = 1001;
	static int N, M, worker[][], b[];
	static boolean check[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		worker = new int[N+1][];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			worker[i] = new int[cnt];
			for(int j = 0; j < cnt; j++) worker[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bMatch());
	}
	
	public static int bMatch() {
		b = new int[MAX_SIZE]; // b배열의 인덱스 : 작업 인덱스, b배열의 값 : 직원 인덱스 
		check = new boolean[MAX_SIZE]; // 이미 확인한 직원인지 체크 배열
		int result = 0; // 매칭된 작업 수

		for(int i = 1; i <= N; i++) {
			Arrays.fill(check, false); // 매번 매칭을 시도할 때마다 이미 매칭된 사람도 
									   // 다른 작업으로 매칭이 바뀔 수 있으므로 방문 체크를 초기화 해야함 
			if(dfs(i)) result++; // i번 째 직원이 일과 매칭이 되면 카운트
		}
		
		return result;
	}
	
	public static boolean dfs(int workerIdx) {
		if(check[workerIdx]) return false;  // 이미 확인한 사람은 다시 확인할 필요 없음
		check[workerIdx] = true;
		
		// 해당 직원이 수행할 수 있는 작업들 
		for(int job : worker[workerIdx]) {
			
			// 매칭이 가능한 경우는 2가지가 있다.
			// 1. 아직 해당 작업이 아무런 직원과 매칭이 되어 있지 않았을 때 
			// 2. 이미 해당 작업에 매칭된 직원이 다른 작업도 매칭할 수 있을 때
			if(b[job] == 0 || dfs(b[job])) {
				b[job] = workerIdx; // 직원 <--> 작업 매칭하고 true 리턴
				return true;
			}
		}
		
		return false;
	}
}

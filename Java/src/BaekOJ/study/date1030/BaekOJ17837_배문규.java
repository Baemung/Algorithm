package BaekOJ.study.date1030;

import java.io.*;
import java.util.*;

/*
 * 백준 17837 주사위 윷놀이
 * 
 * 얻을 수 있는 점수의 최댓값을 구하기
 * 1. 주사위는 5면체
 * 2. 예상 이동(도착지 제외)지점에  다른 말이 있다면 그 말은 선택할 수 없음 == 말 업는 개념이 없음
 * 3. 이동을 마칠 때 마다 칸에 적혀있는 수가 점수에 추가됨
 * 
 * 시행착오 1 : 처음에 경로를 4개를 구분하고 넥퍼로 나이브하게 접근했더니 어떻게 해야 할지 모르겠어서 분류보니까 백트래킹인 걸 보고 dfs로 백트래킹 함...그냥 칸 하나하나를 인덱스와 포인트로 매칭시켜서 관리함
 * 시행착오 2 :도착칸에 도착했을 때 인덱스가 튀어나가지 않도록, 도착 직전인 40점짜리 말에서 끝 인덱스인 32로 보내고, 끝 인덱스 32에서도 다시  32로 수렴시킴
 * 
 * 메모리 	시간
 * 18624	220
 * 
 */
public class BaekOJ17837_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int dice[], max;
	static int points[] = {
			0, 2, 4, 6, 8, 10, 
			12, 14, 16, 18, 20, 
			22, 24, 26, 28, 30, 
			32, 34, 36, 38, 40,
			13, 16, 19, 25, 22, 
			24, 28, 27, 26, 30, 35, 0};
	static int map[][] = {
			{1},{2},{3},{4},{5},{6,21},
			{7},{8},{9},{10},{11,25},
			{12},{13},{14},{15},{16,27},
			{17},{18},{19},{20},{32},
			{22},{23},{24},{30},{26},
			{24},{28},{29},{24},{31},{20},{32}};

	public static void main(String[] args) throws Exception {
		dice = new int[10];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());
		
		List<Integer> knights = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++) knights.add(0);
		dfs(knights, 0, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(List<Integer> knights, int idx, int result) {
		// 기저조건
		if(idx == 10) {
			 max = Math.max(max, result);
			 return;
		}
		
		for(int k = 0; k < 4; k++) {
			// k번째 말 선택, 첫번째 말을 우선 선택함
			int knight = knights.get(k);
			
			// 지름길에 있으면 경로 변경
			if(map[knight].length == 2) knight = map[knight][1];
			else knight = map[knight][0];
			
			// 해당말을 dice[idx]칸 만큼 이동
			for(int d = 1; d < dice[idx]; d++) knight = map[knight][0];

			// 주사위가 도착했거나, 아니면 이동할 위치에 말이 없으면 이동하고 dfs 
			if((knight < 32 && !knights.contains(knight)) || knight == 32){
				int temp = knights.get(k);
				knights.set(k, knight); // 이동
				dfs(knights, idx+1, result+points[knight]); // dfs
				knights.set(k, temp); // 원상복구
			}
		}
	}
}

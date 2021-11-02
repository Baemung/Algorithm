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
 * 메모리 	시간
 * 
 */

public class BaekOJ17825_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, M, fuel;
	static int[][] delta = {{}, {}, {}, {}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
	}
}

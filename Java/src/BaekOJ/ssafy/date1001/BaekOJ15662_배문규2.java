package BaekOJ.ssafy.date1001;

import java.io.*;
import java.util.*;

public class BaekOJ15662_배문규2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int T, K, gearNum, dir, result;
	static char pole;
	static String str;
	static boolean gear[][], check[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		gear = new boolean[5][8];
		for(int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				if(str.charAt(j)-'0' == 1) gear[i][j] = true;
				else gear[i][j] = false;
			}
		}
		
		K = Integer.parseInt(br.readLine());
		check = new boolean[5];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			gearNum = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			
			Arrays.fill(check, false);
			rotate(gearNum, dir);
		}
		
		result = 0;
		for(int i = 1; i <= 4; i++) {
			if(gear[i][0]) result += 1<<(i-1);
		}
		System.out.println(result);
	}
	
	public static void rotate(int gearNum, int dir) {
		if(gearNum < 1 || gearNum > 4) return; // 기저조건
		// 회전하고 체크
		shift(gearNum, dir);
		check[gearNum] = true;
		
		// 왼쪽 끝 톱니 -> 우 이동
		if(gearNum == 1) {
			if(!check[gearNum+1] && gear[gearNum][2+dir] != gear[gearNum+1][6]) rotate(gearNum+1, -dir);
		}
		// 오른쪽 끝 톱니 -> 좌 이동
		else if(gearNum == 4) {
			if(!check[gearNum-1] && gear[gearNum][6+dir] != gear[gearNum-1][2]) rotate(gearNum-1, -dir);
		}
		// 중간 톱니 -> 좌우 이동
		else {
			if(!check[gearNum+1] && gear[gearNum][2+dir] != gear[gearNum+1][6]) rotate(gearNum+1, -dir);
			if(!check[gearNum-1] && gear[gearNum][6+dir] != gear[gearNum-1][2]) rotate(gearNum-1, -dir);
		}
	}
	
	public static void shift(int gearNum, int dir) {
		int idx;
		boolean temp;
		
		// 시계 회전
		if(dir == 1) {
			idx = 8;
			temp = gear[gearNum][7];
			while(--idx > 0) gear[gearNum][idx] = gear[gearNum][idx-1];
			gear[gearNum][0] = temp;
		}
		// 반시계 회전
		else {
			idx = -1;
			temp = gear[gearNum][0];
			while(++idx < 7) gear[gearNum][idx] = gear[gearNum][idx+1];
			gear[gearNum][7] = temp;
		}
	}
}

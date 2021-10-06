package BaekOJ.ssafy.date1001;

import java.io.*;
import java.util.*;

public class BaekOJ15662_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int T, K, gearNum, dir, result;
	static char pole;
	static String str;
	static boolean gear[][], check[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		gear = new boolean[T+1][8];
		for(int i = 1; i <= T; i++) {
			str = br.readLine();
			for(int j = 0; j < 8; j++) {
				if(str.charAt(j) == '1') gear[i][j] = true;
				else gear[i][j] = false;
			}
		}
		
		K = Integer.parseInt(br.readLine());
		check = new boolean[T+1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			gearNum = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			
			Arrays.fill(check, false);
			rotate(gearNum, dir);
		}
		
		
		for(int i = 1; i <= T; i++) {
			if(gear[i][0]) result++;
		}
		
		System.out.println(result);
	}
	
	public static void rotate(int gearNum, int dir) {
		if(gearNum < 1 || gearNum > T) return;
		
		shift(gearNum, dir);
		check[gearNum] = true;

		if(gearNum == 1) {
			if(!check[gearNum+1] && gear[gearNum][2+dir] != gear[gearNum+1][6]) rotate(gearNum+1, -dir);
		}
		else if(gearNum == T) {
			if(!check[gearNum-1] && gear[gearNum][6+dir] != gear[gearNum-1][2]) rotate(gearNum-1, -dir);
		}
		else {
			if(!check[gearNum+1] && gear[gearNum][2+dir] != gear[gearNum+1][6]) rotate(gearNum+1, -dir);
			if(!check[gearNum-1] && gear[gearNum][6+dir] != gear[gearNum-1][2]) rotate(gearNum-1, -dir);
		}
	}
	
	public static void shift(int gearNum, int dir) {
		int idx;
		boolean temp;
		
		if(dir == 1) {
			idx = 8;
			temp = gear[gearNum][7];
			while(--idx > 0) gear[gearNum][idx] = gear[gearNum][idx-1];
			gear[gearNum][0] = temp;
		}
		else {
			idx = -1;
			temp = gear[gearNum][0];
			while(++idx < 7) gear[gearNum][idx] = gear[gearNum][idx+1];
			gear[gearNum][7] = temp;
		}
	}
}

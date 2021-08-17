package SWEA.ssafy0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6808_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int _win, _lose, friend[], me[], perm[];
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			boolean[] check = new boolean[19];
			me = new int[9];
			for(int i = 0; i < 9; i++) {
				me[i] = Integer.parseInt(st.nextToken());
				check[me[i]] = true;
			}
			
			int idx = 0;
			friend = new int[9];
			for(int i = 1; i < 19; i++) {
				if(!check[i]) friend[idx++] = i;
			}
			
			_win = 0; _lose = 0;
			perm = new int[9];
			permutation(0, 0);
			sb.append("#").append(tc).append(" ").append(_win).append(" ").append(_lose).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void permutation(int cnt, int flag) {
		if(cnt == 9) {
			int score = 0;
			for(int i = 0; i < 9 ; i++) 
				score += perm[i] > friend[i] ? perm[i] + friend[i] : -(perm[i] + friend[i]);
			
			if(score > 0) _win++;
			else if(score < 0) _lose++;
			
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if((flag & 1<<i) != 0) continue;
			
			perm[cnt] = me[i];
			permutation(cnt+1, flag | 1<<i); 
		}
	}

}

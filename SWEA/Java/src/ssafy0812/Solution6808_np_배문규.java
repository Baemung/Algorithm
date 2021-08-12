package ssafy0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808_np_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int _win, _lose;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			boolean[] check = new boolean[19];
			int[] me = new int[9];
			for(int i = 0; i < 9; i++) {
				me[i] = Integer.parseInt(st.nextToken());
				check[me[i]] = true;
			}
			
			int idx = 0;
			int[] friend = new int[9];
			for(int i = 1; i < 19; i++) {
				if(!check[i]) friend[idx++] = i;
			}
			
			_win = 0; _lose = 0;
			Arrays.sort(me);
			do {			
				int score = 0;
				for(int i = 0; i < 9 ; i++) score += me[i] > friend[i] ? me[i] + friend[i] : -(me[i] + friend[i]);
				if(score > 0) _win++;
				else _lose++;
			}while(np(me));
			sb.append("#").append(tc).append(" ").append(_win).append(" ").append(_lose).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static boolean np(int[] arr) {	
		int N = arr.length;
	
		int i = N-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
			
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr, i-1, j);

		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

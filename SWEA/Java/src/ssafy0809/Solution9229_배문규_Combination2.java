package ssafy0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9229_배문규_Combination2 {
	
	static int N, M;
	static int _max = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[] snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) snack[i] = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[N];
			comb(snack, check, 0, 2);
			
			sb.append("#").append(tc).append(" ").append(_max).append("\n");
			_max = -1;
		}
		
		System.out.println(sb.toString());
	}
	
	static void comb(int[] arr, boolean[] check, int depth, int r) {
		if(r == 0) {
			int w = getMax(arr, check);
			if(w <= M) _max = Math.max(_max, w);
			return;
		}
		if (depth == N) return;

		check[depth] = true;
		comb(arr, check, depth+1, r-1);
		check[depth] = false;
		comb(arr, check, depth+1, r);
	}
	
	static int getMax(int[] arr, boolean[] visited) {
		int num = 0;
		for(int i = 0; i < N; i++) {
			if(visited[i]) num += arr[i];
		}
		return num;
	}

}

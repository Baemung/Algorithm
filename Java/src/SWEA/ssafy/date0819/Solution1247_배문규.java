package SWEA.ssafy.date0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1247_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, N, company[], home[], customer[][], customerPerm[], check[][], _min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			company = new int[2];
			home = new int[2];
			customer = new int[N][2];
			customerPerm = new int[N];
			
			st = new StringTokenizer(br.readLine());
			// 회사
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			// 집
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			// 고객
			for(int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
				customerPerm[i] = i;
			}
			
			_min = Integer.MAX_VALUE;

			do {
				int dist = Math.abs(customer[customerPerm[0]][0] - company[0]) + Math.abs(customer[customerPerm[0]][1] - company[1]);
				for(int i = 1; i < N; i++) {
					dist += Math.abs(customer[customerPerm[i]][0] - customer[customerPerm[i-1]][0]) + Math.abs(customer[customerPerm[i]][1] - customer[customerPerm[i-1]][1]);
					if(_min <= dist) continue;
				}
				dist += Math.abs(customer[customerPerm[N-1]][0] - home[0]) + Math.abs(customer[customerPerm[N-1]][1] - home[1]);
				_min = Math.min(_min, dist);
			}while(np(customerPerm));
			
			sb.append("#").append(tc).append(" ").append(_min).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean np(int arr[]) {
		int len = arr.length;
		
		int i = len-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = len-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr, i-1, j);
		
		int k = len-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

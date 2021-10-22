import java.io.*;
import java.util.*;

class Solution3
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int SELECT = 9;
	static int T, N, n, station[], combi[], idx[], result;
	static int[] resultArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		idx = new int[4];
		resultArr = new int[4];
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			station = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) station[i] = Integer.parseInt(st.nextToken());

			//  N개의 역중에 4개 선택  
			combi = new int[N];
			Arrays.fill(combi, 0);
			for(int i = N-1; i >= N-4; i--) combi[i] = SELECT;
			
			
			result = 0;
 next_combi:do {
	 			n = 0;
	 			Arrays.fill(idx, 0);
	 			
	 			if(combi[0] == SELECT && combi[N-1] == SELECT) continue next_combi;
				for(int i = 0; i < N-1; i++) {
					if(combi[i] == SELECT && combi[i+1] == SELECT) continue next_combi;
					if(combi[i] == SELECT) idx[n++] = i;
				}
				if(combi[N-1] == SELECT) idx[n] = N-1;
				
				result = Math.max(result, (int)Math.pow(station[idx[0]] + station[idx[1]], 2) + (int)Math.pow(station[idx[2]] + station[idx[3]], 2));
				result = Math.max(result, (int)Math.pow(station[idx[0]] + station[idx[3]], 2) + (int)Math.pow(station[idx[1]] + station[idx[2]], 2));
				
			}while(np(combi));
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	// 조합을 생성하기 위한 넥스트 퍼뮤테이션
	static boolean np(int[] arr) {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			j--;
		swap(arr, i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(arr, i++, k--);

		return true;
	}

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

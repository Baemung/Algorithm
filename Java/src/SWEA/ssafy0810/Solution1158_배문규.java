package SWEA.ssafy0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1158_배문규 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Integer> table = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) table.add(i);
		
		int idx = 0;
		sb.append("<");
		while(true) {
			idx = ((idx + K)-1)%table.size();
			if(table.size() == 1) {
				sb.append(table.get(idx)).append(">");
				break;
			}
			sb.append(table.get(idx)).append(", ");
			table.remove(table.get(idx));
		}
		
		System.out.println(sb);
	}

}
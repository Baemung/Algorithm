package SWEA.ssafy.date0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] sArr = new String[N];
		for(int i = 0; i < N; i++) sArr[i] = br.readLine();
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			if(sArr[i].charAt(0) != '0') cnt++;
			for(int j = 1; j < sArr[i].length(); j++) {
				if(sArr[i].charAt(j-1) != sArr[i].charAt(j)) cnt++;
			}
			
			System.out.println("#"+(i+1)+" "+cnt);
		}
	}
}

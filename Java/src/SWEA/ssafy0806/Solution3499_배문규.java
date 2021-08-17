package SWEA.ssafy0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3499_배문규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] word = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < (N+1)/2; i++) {
				// 입력 단어가 홀수개면, 정중앙 단어 1개를 마지막으로 더해줌
				if(N%2 == 1 && i == (N+1)/2-1) sb.append(word[i]);
				// 중간인덱스를 기준으로 단어를 좌우로 나눠서 좌우 단어들을 순서대로 더해줌
				else sb.append(word[i]+" "+word[i+(N+1)/2]+" ");
			}
			System.out.println("#"+tc+" "+sb.toString());
		}
	}

}

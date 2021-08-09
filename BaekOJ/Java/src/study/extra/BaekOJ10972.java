package study.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekOJ10972 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] result = new int[10000];

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) result[i] = Integer.parseInt(st.nextToken());
		

	}

}

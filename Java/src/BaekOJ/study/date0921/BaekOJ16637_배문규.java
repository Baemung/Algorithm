package BaekOJ.study.date0921;

import java.io.*;
import java.util.*;

public class BaekOJ16637_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int N, num[], result = Integer.MIN_VALUE;
	static char op[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		num = new int[N/2+1];
		op = new char[N/2];
		
		String input = br.readLine();
		for(int i = 0; i < N; i++) {
			if(i%2 == 0) num[i/2] = Character.getNumericValue(input.charAt(i));
			else op[i/2] = input.charAt(i);
		}
		
		dfs(0, num[0]);
		System.out.println(result);
	}
	
	public static void dfs(int idx, int total) {
		if(idx == op.length) {
			result = result < total ? total : result;
			return;
		}
		
		int left = calc(total, op[idx], num[idx+1]);
		dfs(idx+1, left);
		
		if(idx + 1 < op.length) {
			int right = calc(num[idx+1], op[idx+1], num[idx+2]);
			right = calc(total, op[idx], right);
			dfs(idx+2, right);
		}
	}
	
	public static int calc(int left, char operator, int right) {
		switch (operator) {
		case '+': return left+right;
		case '-': return left-right;
		case '*': return left*right;
		default : return 0;
		}
	}
}
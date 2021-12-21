package BaekOJ.study.date1214;

import java.io.*;

/*
 * 백준 2023 신기한 소수
 * 
 * 
 * 
 * 메모리 	시간
 * 14036	124
 */

public class BaekOJ2023_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    
	static int N;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for(int i : new int[] {2,3,5,7})
			getResult(i);
		System.out.println(sb);
	}
	
	public static void getResult(int num) {
		if(Integer.toString(num).length() == N) sb.append(num).append("\n");
	    else {
	        for(int i = 0; i < 10; i++) {
	            int temp = num * 10 + i;
	            if(isPrime(temp)) getResult(temp);
	        }
	    }
	}

	public static boolean isPrime(int num) {
	    for(int i = 2; i < Math.sqrt(num)+1; i++) {
	        if(num % i == 0) return false;
	    }
	    return true;
	}
}

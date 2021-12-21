package BaekOJ.study.date1214;

import java.io.*;
import java.util.*;

/*
 * 백준 5052 전화번호 목록
 * 
 * 파이썬에 startsWith이라는 내장함수가 있는데 자바도 있었음
 * 자바 String객체의 startsWith 내장함수를 이용해서 간편하게 결과도출
 * 
 * 메모리 	시간
 * 34944	660
 *  
 */
public class BaekOJ5052_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int T, N;
	static String book[];
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			book = new String[N];
			for(int i = 0; i < N; i++) book[i] = br.readLine();
			
			Arrays.sort(book);
			
			System.out.println(getResult(book));
		}
	}
	
	public static String getResult(String[] arr) {
		for(int i = 1; i < N; i++) {
			if(arr[i].startsWith(arr[i-1])) return "NO";
		}
		return "YES";
	}
}

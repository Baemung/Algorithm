package study.date0730;

import java.util.*;

public class BaekOJ2751 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] list = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		for(int a:list) {
			System.out.println(a);
		}
	}

}

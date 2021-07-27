package study.date0730;

import java.util.Scanner;

public class BaekOJ11047 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		
		//sc.nextLine();
		
		int[] money = new int[N];
		for(int i = N-1; i >= 0; i--) {
			money[i] = sc.nextInt();
		}
				
		for(int m:money) {
			cnt += K/m;
			K %= m;
			if(K == 0) break;
		}
		
		System.out.println(cnt);
	}

}

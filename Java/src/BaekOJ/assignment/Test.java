package BaekOJ.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, R, Scnt, Pcnt, PPcnt, Ccnt, input[];
	static boolean check[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		check = new boolean[N];
		input = new int[N];
		for(int i = 0; i < N; i++) input[i] = i+1;
		
		// 부분집합
		powerSet(0);
		System.out.println(Scnt);
		
		// nPn
		do {
			Pcnt++;
			for(int i = 0; i < N; i++) System.out.print(input[i]+" ");
			System.out.println();
		}while(np(input));
		System.out.println(Pcnt);
		
		// nCr
		for(int i = 0; i < N; i++) input[i] = i+1;
		int[] comb = new int[N];
		for(int i = N-1; i > N-1-R; i--) comb[i] = 9;
		do {
			Ccnt++;
			for(int i = 0; i < N; i++) {
				if(comb[i] == 9) System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np(comb));
		System.out.println(Ccnt);
		
		// nPr
		for(int i = 0; i < N; i++) input[i] = i+1;
		int[] perm = new int[N];
		for(int i = N-1; i > N-1-R; i--) perm[i] = 9;
		
		do {
			int[] nPr = new int[R];
			int idx = 0;
			for(int i = 0; i < N; i++) {
				if(perm[i] == 9) nPr[idx++] = input[i];
			}
			
			do {
				PPcnt++;
				for(int i = 0; i < R; i++) System.out.print(nPr[i]+" ");
				System.out.println();
			}while(np(nPr));
		}while(np(perm));
		
		System.out.println(PPcnt);
	}
	
	public static void powerSet(int num) {
		if(num == N) {
			Scnt++;
			for(int i = 0; i < N; i++) System.out.print((check[i] ? input[i] : "X")+" ");
			System.out.println();
			return;
		}
		
		check[num] = true;
		powerSet(num+1);
		check[num] = false;
		powerSet(num+1);
	}
	
	public static boolean np(int[] arr) {
		int N = arr.length;
		
		int i = N-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}





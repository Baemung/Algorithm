package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10972_배문규 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		if(np(arr)) for(int i:arr) System.out.print(i+" ");
		else System.out.println(-1);

	}
	
	public static boolean np(int[] numbers) {
		
		int N = numbers.length;
	
		// 꼭대기 (i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N-1;
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
			
		if(i == 0) return false;
		
		// i-1 위치값과 교환할 큰 값 찾기
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		
		// i-1 위치값과 j 위치값 교환
		swap(numbers, i-1, j);

		// 꼭대기 (i)부터 맨뒤 까지 내림차순 형태의 순열을 오름차순으로 정리
		int k = N-1;
		while(i < k) swap(numbers, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}

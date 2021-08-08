package study.date0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekOJ2805 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] tree;
	static int _max = Integer.MIN_VALUE;
	
//	 이 문제는 0807때 문제였던 1654번 랜선자르기와 동일한 문제 (https://www.acmicpc.net/problem/1654) 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());

	    tree = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	tree[i] = Integer.parseInt(st.nextToken());
	    	if(tree[i] > _max) _max = tree[i];
	    }
	    
//	    int[]			메모리 119140	시간 544
//		Integer[]		메모리 134956	시간 716
//	    List<Integer>	메모리 145320	시간 824
	    
//		당연하겠지만 primitive type이 성능이 좋다. (https://siyoon210.tistory.com/139)
//	        엄청나게 큰 숫자를 사용해서 차라리 참조값을 넘기는 경우가 아니라면.
	    System.out.println(p_search(0, _max));
	}
	
//	 파라메트릭 서치로 최적값을 찾아감
	public static int p_search(int left, int right) {
//		 최적값 수렴
		if(left > right) return right;
		
//		remain이 int형일 때 오버플로우
//		오버플로우 테케
//		5 2000000000
//		900000000 900000000 900000000 900000000 900000000
		int pivot = (left + right)/2;
		long remain = 0;
		for(int i : tree) {
			if(i - pivot >= 0) remain += i-pivot;
		}
		
		if(remain >= M) return p_search(pivot+1, right);
		else return p_search(left, pivot-1);
	}
}
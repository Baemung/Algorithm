package exam;

import java.io.*;
import java.util.*;
/*
  4 5
  2 3
  3 4
  4 5
  5 6
  
  ==>   7 [2,3]
 */
/**
 * 
 * @author THKim
 *
 */
// 가치의 최대값 및 최대값을 구성하는 부분집합요소 구하기
public class KnapsackTest2_DP_SubSet {
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];

		int[][] D = new int[N+1][W+1];
		boolean[][] keeps = new boolean[N+1][W+1];
		
		// i=0은 0으로 그대로 둠.
		for (int i = 1; i <=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				
				if(weights[i] <= w && profits[i]+D[i-1][w-weights[i]]>D[i-1][w]){
					D[i][w]  = profits[i]+D[i-1][w-weights[i]];
					keeps[i][w] = true;

				}else{
					D[i][w] = D[i-1][w];
				}
			}
		}
		
		System.out.println(D[N][W]);
		
		int tempN = N, tempW = W;
		Stack<Integer> stack = new Stack<Integer>();
		do{
			if(keeps[tempN][tempW]){
				stack.push(weights[tempN]);
				tempW = tempW - weights[tempN];
			}
		}while(--tempN>0);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
		sc.close();
	}

}

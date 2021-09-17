package exam;

import java.io.*;
import java.util.*;

// 음의가중치의 간선 가능
public class FolydTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] D = new int[N][N];
		final int INF = 99999;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				D[i][j] = sc.nextInt();
				// 자기자신으로가 아니고 못가면  max로 놓고 시작
				if(i!=j && D[i][j]==0) D[i][j] =  INF;
			}
		}
		
		// 플로이드 워샬 알고리즘 적용
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue; // 출발지 = 경유지상황 : 경유효과 없음.
				for (int j = 0; j < N; j++) {
					if(i==j) continue; // 출발지 = 도착지비용은 항상 0이라고 가정한다면 
					if(D[i][k] != INF && D[k][j] != INF && D[i][j]>D[i][k]+D[k][j]) D[i][j] = D[i][k]+D[k][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(D[i]));
		}
	}

}

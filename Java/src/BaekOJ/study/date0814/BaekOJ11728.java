package BaekOJ.study.date0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 처음엔 && || 논리 연산자의 특징을 이용해서 최소한으로 연산을 줄이려고함
 그러다가 문제에서 입력값의 최대가 10^9인것을 확인하고 배열을 N+1, M+1로 만들어
 마지막 인덱스에 MAX_INT값을 넣고 while문 내에서 단 한번의 비교로 분기를  만들어 냄
 그러나 놀랍게도 시간이나 메모리 측면에서 최적이 아니었음.
*/

public class BaekOJ11728 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//	메모리	시간
		//	312444	1632
		
		// A와 B모두 이미 소팅이 되어있음 -> merge
		// MAX값을 넣어줄 마지막 인덱스자리 추가
		int[] A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int[] B = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
		
		// 값의 범위가 최대 10억이니까 A와 B 마지막인덱스에 Integer.MAX_VALUE 입력
		// 둘 중 한쪽이 마지막 인덱스에 도달해도 나머지 배열의 어떤 값보다 크기 때문에 if문을 통과하지 않아 런타임 에러가 발생하지 않음
		A[N] = Integer.MAX_VALUE;
		B[M] = Integer.MAX_VALUE;
		int aIdx = 0, bIdx = 0;
		// A와 B모두 마지막 인덱스만 남았을 때, break
		while(aIdx+bIdx != N+M) {
			// A가 B보다 작거나 같으면  A 추가
			if(A[aIdx] <= B[bIdx]) sb.append(A[aIdx++]).append(" ");
			else sb.append(B[bIdx++]).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}


//		split -> parsing (parsing을 (N+M)*2)
//		split메소드는 정규표현식(regex)을 사용하기 때문에 st보다 속도가 느리다.
/*		메모리	시간
 * 		438712	1720
 *  	String[] A = br.readLine().split(" ");
		String[] B = br.readLine().split(" ");
		
		int aIdx = 0, bIdx = 0;
		while(aIdx+bIdx != N+M) {
			if(bIdx == M  ||  (aIdx != N && Integer.parseInt(A[aIdx]) <= Integer.parseInt(B[bIdx]))) {
				sb.append(A[aIdx]).append(" ");
				aIdx++;
			}
			else if(aIdx == N || (bIdx != M && Integer.parseInt(A[aIdx]) >= Integer.parseInt(B[bIdx]))){
				sb.append(B[bIdx]).append(" ");
				bIdx++;
			}
		}
		
		
		String arr = "a, b, , c";
		
		st = new StringTokenizer(arr, ",");
		st => a,b,c
		st.countTokens() = 남아있는 토큰 수 (int)
		st.hasMoreTokens() = 토큰이 남았는지 여부 (bool)
		
		arr.split(",");
		split => a,b,(공백),c
		

		nextToken -> parsing (parsing N+M)
		메모리	시간
		310784	1436
		int[] A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		int[] B = new int[M+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());

		int aIdx = 0, bIdx = 0;
		while(aIdx+bIdx != N+M) {
            if(bIdx == M || (aIdx != N && A[aIdx] <= B[bIdx])) {
				sb.append(A[aIdx]).append(" ");
				aIdx++;
			}
			else if(aIdx == N || (bIdx != M && (A[aIdx] >= B[bIdx]))){
				sb.append(B[bIdx]).append(" ");
				bIdx++;
			}
		}
*/
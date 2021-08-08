package study.date0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekOJ9019 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, A, B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < N; tc++) {
			Queue<Integer> queue = new LinkedList<>();
			// 입력의 범위가 0~9999 경우라서 크기가 10000인 배열을 선언하여 해당 값을 인덱스로 해서 배열에 매핑하면 되겠다 생각함
			String[] result = new String[10000];

			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
            queue.offer(A);
			while(result[B] == null && !queue.isEmpty()) {
				int front = queue.poll();
				
				// dequeue한 값으로 DSLR 값들을 모두 구함
				int D = (front*2)%10000;
				int S = (front+9999)%10000;
				int L = (front/1000)+(front%1000)*10;
				int R = (front/10)+(front%10)*1000;
				
				// D -> S -> L -> R 순으로 enqueue하여 BFS
				if(result[D] == null) {
					queue.offer(D);
					result[D] = result[front]+"D";
				}
				if(result[S] == null) {
					queue.offer(S);
					result[S] = result[front]+"S";
				}
				if(result[L] == null) {
					queue.offer(L);
					result[L] = result[front]+"L";
				}
				if(result[R] == null) {
					queue.offer(R);
					result[R] = result[front]+"R";
				}
			}
			
			sb.append(result[B]+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
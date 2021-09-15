package BaekOJ.ssafy.date0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekOJ2630_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st = null;
	static boolean[][] paper;
	static int N, W, B;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		paper = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(st.nextToken().equals("1")) paper[i][j] = true;
			}
		}
		cut(0, N, 0, N);
		System.out.println(W+"\n"+B);
	}
	
	public static void cut(int left, int right, int up, int down) {
		
		int tempW = 0;
		int tempB = 0;
		for(int i = up; i < down; i++) {
			for(int j = left; j < right; j++) {
				if(paper[i][j]) tempB += 1;
				else tempW += 1;
			}
		}
		
		int area = (right-left)*(down-up);
		if(tempB == area) {
			B++;
			return;
		}
		if(tempW == area) {
			W++;
			return;
		}
		
		cut(left, (left+right)/2, up, (up+down)/2);
		cut(left, (left+right)/2, (up+down)/2, down);
		cut((left+right)/2, right, up, (up+down)/2);
		cut((left+right)/2, right, (up+down)/2, down);
		
	}
}
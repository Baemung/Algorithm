package BaekOJ.study.date0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekOJ14889_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, N, map[][], R[], C[], total, _min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		_min = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		R = new int[N];
		C = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int ability = Integer.parseInt(st.nextToken());
				total += ability;
				R[i] += ability;
				C[j] += ability;
			}
		}
		
		makeTeam(1, 1, total-R[0]-C[0]);
		System.out.println(_min);
	}
	
	public static void makeTeam(int idx, int cnt, int gap) {
		if(cnt == N/2) {
			_min = Math.min(_min, Math.abs(gap));
			return;
		}
		if(idx == N) return;
		
		makeTeam(idx+1, cnt+1, gap-R[idx]-C[idx]);
		makeTeam(idx+1, cnt, gap);
	}
}
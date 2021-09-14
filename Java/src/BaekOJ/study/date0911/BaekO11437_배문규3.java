package BaekOJ.study.date0911;

import java.io.*;
import java.util.*;

public class BaekO11437_배문규3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, M, log, depth[], parent[][];
	static List<Integer> tree[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		log = (int)(Math.ceil(Math.log(N) / Math.log(2)));

		tree = new List[N+1];
		for(int i = 1; i <= N; i++) tree[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		depth = new int[N+1];
		parent = new int[log+1][N+1];
		
		setDepth(1, 1);
		for(int i = 1; i <= log; i++) {
			for(int j = 1; j <= N; j++) {
				parent[i][j] = parent[i][parent[i-1][j-1]];
			}
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			sb.append(LCA(n1, n2)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void setDepth(int p, int d) {
		depth[p] = d;
		for(int c : tree[p]) {
			if(depth[c] != 0) continue;
			parent[0][c] = p;
			setDepth(c, d+1);
		}
	}
	
	public static int LCA(int n1, int n2) {
		if(depth[n1] > depth[n2]) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		for(int i = log; i >= 0; i--) {
			if(depth[n2]-depth[n1] >= Math.pow(2,i)) n2 = parent[i][n2];
		}
		
		if(n1 == n2) return n1;
		
		for(int i = log; i >= 0; i--) {
			if(parent[i][n1] != parent[i][n2]) {
				n1 = parent[i][n1];
				n2 = parent[i][n2];
			}
		}
		
		return parent[0][n1];
	}
}

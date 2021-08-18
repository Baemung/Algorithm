package SWEA.ssafy0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class BC1{
	int x;
	int y;
	int d;
	int charge;
	int serial;
	
	BC1(int x, int y, int d, int charge, int serial){
		this.x = x;
		this.y = y;
		this.d = d;
		this.charge = charge;
		this.serial = serial;
	}
}

public class Solution5644_배문규2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int M, N, result, A[], Aidx[], B[], Bidx[];
	static Integer[] Alist, Blist;
	static BC1[] bc;
	static int[][] delta = new int[][] {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			result = 0;

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			A = new int[M+1];
			Aidx = new int[]{0, 0};
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) A[i] = Integer.parseInt(st.nextToken());
			
			B = new int[M+1];
			Bidx = new int[]{9, 9};
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) B[i] = Integer.parseInt(st.nextToken());
			
			bc = new BC1[N]; 
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new BC1(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			
			for(int i = 0; i <= M; i++) {
				move(i);
				setBC(); 
				getResult();
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	public static void move(int i) {
		Aidx[0] += delta[A[i]][0];
		Aidx[1] += delta[A[i]][1];
		Bidx[0] += delta[B[i]][0];
		Bidx[1] += delta[B[i]][1];
	}
	
	public static void setBC() {
		Alist = new Integer[8];
		Blist = new Integer[8];
		
		for(int i = 0; i < 8; i++) {
			Alist[i] = 0;
			Blist[i] = 0;
		}
		
		for(BC1 b : bc) {
			Integer charge = new Integer(b.charge);
			if(Math.abs(Aidx[0]-b.y) + Math.abs(Aidx[1]-b.x) <= b.d) Alist[b.serial] = charge;
			if(Math.abs(Bidx[0]-b.y) + Math.abs(Bidx[1]-b.x) <= b.d) Blist[b.serial] = charge;
		}
		
		Arrays.sort(Alist, Collections.reverseOrder());
		Arrays.sort(Blist, Collections.reverseOrder());
	}
	
	public static void getResult() {
		if(Alist[0] == Blist[0]) {
			if(Alist[1] == 0 && Alist[1].equals(Blist[1])) result += Alist[0];
			else{
				result += Alist[0];
				result += Alist[1] <= Blist[1] ? Blist[1] : Alist[1];
			}
		}
		else result += Alist[0] + Blist[0];
	}
}

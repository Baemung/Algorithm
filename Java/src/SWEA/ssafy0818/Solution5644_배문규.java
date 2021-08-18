package SWEA.ssafy0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// BC 정보 관리 클래스
class BC implements Comparable<BC>{
	int x;
	int y;
	int d;
	int charge;
	int serial;
	
	BC(int x, int y, int d, int charge, int serial){
		this.x = x;
		this.y = y;
		this.d = d;
		this.charge = charge;
		this.serial = serial;
	}
	
	// Comparable 인터페이스를 상속받아서 객체 정렬은 charge기준으로 내림차순
	@Override
	public int compareTo(BC o) {
		return o.charge - this.charge;
	}
}

public class Solution5644_배문규 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int M, N, result, A[], Aidx[], B[], Bidx[];
	static BC[] bc;
	static List<BC> Alist, Blist;
	static int[][] delta = new int[][] {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			result = 0;

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			// 사용자 A 정보 입력
			A = new int[M+1];
			Aidx = new int[]{0, 0};
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) A[i] = Integer.parseInt(st.nextToken());
			// 사용자 B 정보 입력
			B = new int[M+1];
			Bidx = new int[]{9, 9};
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) B[i] = Integer.parseInt(st.nextToken());
			// BC 정보 입력
			bc = new BC[N]; 
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new BC(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			
			// 매 시간마다 이동하고 충전소를 체크하고 충전량 산출
			for(int i = 0; i <= M; i++) {
				move(i);
				checkBC(); 
				getResult();
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	// 사용자 A, B 이동
	public static void move(int i) {
		Aidx[0] += delta[A[i]][0];
		Aidx[1] += delta[A[i]][1];
		Bidx[0] += delta[B[i]][0];
		Bidx[1] += delta[B[i]][1];
	}

	// 사용자가 BC에서 충전할 수 있는지 체크
	public static void checkBC() {
		// 해당 시간의 충전소 등록 리스트
		Alist = new ArrayList<BC>();
		Blist = new ArrayList<BC>();

		// 해당 시간에 충전소 범위안에 있으면 해당 충전소를 등록
		for(BC b : bc) {
			if(Math.abs(Aidx[0]-b.y) + Math.abs(Aidx[1]-b.x) <= b.d) Alist.add(b);
			if(Math.abs(Bidx[0]-b.y) + Math.abs(Bidx[1]-b.x) <= b.d) Blist.add(b);
		}
		// charge를 기준으로 내림차순 정렬
		Collections.sort(Alist);
		Collections.sort(Blist);
	}

	// 각 시간마다 충전 총합량을 산출함
	public static void getResult() {
		// 최대 충전량이 같은 충전소 객체가 서로 같다면
		if(Alist.size() > 0 && Blist.size() > 0 && Alist.get(0) == Blist.get(0)) {
			// 둘다 다른 충전소에 걸쳐져 있지 않으면
			if(Alist.size() == 1 && Blist.size() == 1) result += Alist.get(0).charge;
			else{// 다른 충전소에도 걸쳐져 있다면
				if(Alist.size() > 1 && Blist.size() == 1) // A만 2개걸침 때
					result += Alist.get(1).charge + Blist.get(0).charge;
				else if(Alist.size() == 1 && Blist.size() > 1) // B만 2개걸칠 때
					result += Alist.get(0).charge + Blist.get(1).charge;
				else if(Alist.size() > 1 && Blist.size() > 1) { // 둘 다 2개걸칠 때
					if(Alist.get(1).charge <= Blist.get(1).charge) // 2번째가 B가 더 큼
						result += Alist.get(0).charge + Blist.get(1).charge;
					else result += Alist.get(1).charge + Blist.get(0).charge; // 2번째가 A가 더 큼
				}
			}
		}
		// 최대 충전량이 서로 다른 충전소면
		else if(Alist.size() > 0 && Blist.size() > 0 && Alist.get(0) != Blist.get(0)) // 서로 다른 충전소
			result += Alist.get(0).charge + Blist.get(0).charge;
		else if(Alist.size() > 0 && Blist.size() == 0) // A만 충전
			result += Alist.get(0).charge;
		else if(Alist.size() == 0 && Blist.size() > 0) // B만 충전
			result += Blist.get(0).charge;
	}
}

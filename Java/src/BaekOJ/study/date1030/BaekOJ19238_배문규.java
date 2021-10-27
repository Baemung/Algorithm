package BaekOJ.study.date1030;

import java.io.*;
import java.util.*;

/*
 * 백준 19238 새로운 게임 2
 * 
 * 말이 1번부터 K번까지 번호가 매겨져 있으며 초기에 미리 좌표값과 방향이 정해져 있다.
 * 방향은 4방 중 하나이고, 턴 한 번은 1번 말부터 K번 말까지 순서대로 이동시키는 것이다.
 * 말을 다른 말 위로 올릴 수 있으며, 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.
 * 
 * 이동하려는 칸의 색상에 따라 규칙이 다름
 * 흰색(1) : 이동하고 기존 위치에 말이 있다면 올라탐 A B C -> D E = D E A B C
 * 빨간색(2) : 이동하고 이동한 말안에서 말의 순서를 반대로 바꾼다. A B C -> D E = D E C B A
 * 파란색(3) or 체스판을 벗어남 : 이동 방향을 반대로 하고 한 칸 이동. 방향을 반대로 바꾸고 이동하려는 칸이 파란색이면 가만히 있음. 
 * 
 * 시행착오 : 말을 옮기고 난 뒤에 기존에 위한 곳의 리스트의 사이즈가 줄어들어서 인덱스 접근하면 자꾸 범위를 벗어났음..
 * 순차적으로 삭제하기 때문에 처음에 찾은 인덱스를 고정시켜주면 알아서 땡겨지면서 삭제가 됨
 *  
 * 메모리 	시간
 * 14396	148
 * 
 */
public class BaekOJ19238_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static final int RED = 1, BLUE = 2;
	static int N, K, map[][], knight[][], result = -1;
	static List<Integer>[][] knightMap;
	static List<Integer> tempList = new ArrayList<Integer>();
	static int delta[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 맵을 입력받으면서 맵마다 리스트 객체 생성
		map = new int[N][N];
		knightMap = new List[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				knightMap[i][j] = new ArrayList<Integer>();
			}
		}
		
		// 기사 입력받고 맵에 위치 시킴
		knight = new int[K][3];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken())-1;
			
			knight[k][0] = i;
			knight[k][1] = j;
			knight[k][2] = dir;
			knightMap[i][j].add(k);
		}
		
	game:for(int turn = 1; turn <= 1000; turn++) {
			 for(int num = 0; num < K; num++) {
				 tempList.clear();
				 int moveDir = knight[num][2];
				 // 기존 위치
				 int kI = knight[num][0];
				 int kJ = knight[num][1];
				 // 옮길 위치
				 int dI = kI + delta[moveDir][0];
				 int dJ = kJ + delta[moveDir][1];
				 
				// 0,1,2,3
				// 짝수  = +1, 홀수 = -1 하여 방향 전환
				 if(isOOB(dI, dJ) || map[dI][dJ] == BLUE) {
					 int changeDir = 0;
					 if(moveDir % 2 == 0) changeDir = 1;
					 else changeDir = -1;
					 
					 knight[num][2] += changeDir;
					 moveDir = knight[num][2];
					 
					 dI = kI + delta[moveDir][0];
					 dJ = kJ + delta[moveDir][1];
					 if(isOOB(dI, dJ) || map[dI][dJ] == BLUE) continue;
				 }
				 
				 // 해당 말이 몇번째 위치하는지 확인
				 int idx = knightMap[kI][kJ].indexOf(num);
				 int size = knightMap[kI][kJ].size();
				 // 삭제할 때 마다 사이즈가 줄어드므로 삭제할 인덱스는 고정임 
				 for(int move = idx; move < size; move++) {
					 // 말 하나씩 옮기기
					 int knightToMove = knightMap[kI][kJ].get(idx);
					 knight[knightToMove][0] += delta[moveDir][0];
					 knight[knightToMove][1] += delta[moveDir][1];
					 
					 // 맵에 반영
					 // 빨간색인 경우 순서를 바꾸기 위해 임시 리스트에 따로 추가
					 if(map[dI][dJ] == RED) tempList.add(knightToMove);
					 else knightMap[knight[knightToMove][0]][knight[knightToMove][1]].add(knightToMove);
					 
					 knightMap[kI][kJ].remove(knightMap[kI][kJ].indexOf(knightToMove));
				 }
				 
				 // 빨간색인 경우 순서 바꾸고 반영
				 if(map[dI][dJ] == RED) {
					 Collections.reverse(tempList);
					 for(Integer n : tempList) knightMap[dI][dJ].add(n);
				 }
				 
				 // 게임 종료 조건
				 if(knightMap[dI][dJ].size() >= 4) {
					 result = turn;
					 break game;
				 }
			 }
		}
		
		System.out.println(result);
	}
	
	public static boolean isOOB(int i, int j) {
		return i > N - 1 || i < 0 || j > N - 1 || j < 0;
	}
}

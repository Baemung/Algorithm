package BaekOJ.study.date0911;

import java.io.*;
import java.util.*;

/*
 * 시행착오:
 * 	각 함수 인덱스마다 반복되기 전까지의 인덱스 흐름을 기록함. 
 * 	그리고 반복되지 않는 부분을 구해서
 * 	n이 인덱스 흐름보다 클 때, 반복되지 않는 부분만큼 빼고 모드연산을 실시하여 값을 도출함
 *  ==> M이 200,000이라, 함수들을 인덱스 흐름의 찾을 때 워스트케이스 O(M^2)까지 가능
 *  ==> M log M이상 이면 시간초과
 */
public class BaekOJ17435_배문규2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int M, Q, func[], nonRepeat[];
	static List<Integer> result[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		M = Integer.parseInt(br.readLine());
		func = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) func[i] = Integer.parseInt(st.nextToken());
		
		result = new List[M+1];
		nonRepeat = new int[M+1];
		
		for(int i = 1; i <= M; i++) {
			result[i] = new ArrayList<Integer>();
			
			int idx = i;
			while(true) {
				result[i].add(idx);
				idx = func[idx];
				int check = result[i].indexOf(idx);
				if(check != -1) {
					nonRepeat[i] = check;
					break;
				}
			}
		}
		
		Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			sb.append(func[result[x].get(n <= result[x].size() ? n-1 : (n-nonRepeat[i])%result[x].size())]).append("\n");
		}
		
		System.out.println(sb);
	}
}

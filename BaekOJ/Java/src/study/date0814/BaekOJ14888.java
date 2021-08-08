package study.date0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekOJ14888 {
	
	// 변경없이 사용만 하는 경우에는  static이 참 편하다.
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] num;
	
	static int _max = Integer.MIN_VALUE;
	static int _min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	    br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    // 숫자들 입력받음
	    num = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
	    
	    // 연산자들 개수 입력받음
	    int[] operator = new int[4];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
	    
	    // [ 0 : add ][ 1 : sub ][ 2 : mul ][ 3 : div ]
	    solve(1, num[0], operator[0], operator[1], operator[2], operator[3]);
	    System.out.println(_max+"\n"+_min);
	}
	
	public static void solve(int i, int result, int add, int sub, int mul, int div) {
		if (i == N) {
			_max = Math.max(_max, result);
			_min = Math.min(_min, result);
		}
		
		// add -> sub -> mul -> div 순으로 파고들어서 DFS 
		if (add > 0) solve(i+1, result+num[i], add-1, sub, mul, div);
		if (sub > 0) solve(i+1, result-num[i], add, sub-1, mul, div);
		if (mul > 0) solve(i+1, result*num[i], add, sub, mul-1, div);
		if (div > 0) solve(i+1, result/num[i], add, sub, mul, div-1);
	}
	
}
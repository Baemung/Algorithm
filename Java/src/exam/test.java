package exam;

import java.io.*;
import java.util.*;

public class test {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, N, M1, M2, result, _min, _max;
	static PriorityQueue<Integer> block;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M1 = Integer.parseInt(st.nextToken());
			M2 = Integer.parseInt(st.nextToken());
			
			block = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) block.offer(Integer.parseInt(st.nextToken()));
			
			result = 0;
			_min = M1 < M2 ? M1 : M2;
			_max = M1 > M2 ? M1 : M2;
			
			for(int i = 1; i <= _min; i++) {
				result += block.poll()*i;
				result += block.poll()*i;
			}
			
			for(int i = _min+1; i <= _max; i++) {
				result += block.poll()*i;
			}
			
			System.out.println(result);
		}
	}
	
}

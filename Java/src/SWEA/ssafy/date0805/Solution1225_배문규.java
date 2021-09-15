package SWEA.ssafy.date0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1225_배문규 {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			Queue<Integer> queue = new LinkedList<Integer>();
			for(String str : br.readLine().split(" ")) queue.add(Integer.parseInt(str));
			
			int i = 0;
			while(true) {
				if(++i == 6) i = 1;
				if(queue.peek() - i <= 0) {
					queue.poll();
					queue.add(0);
					break;
				}
				else queue.add(queue.poll()-i);
			}
			
			sb.append("#"+tc);
			for(int e : queue) sb.append(" "+e);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

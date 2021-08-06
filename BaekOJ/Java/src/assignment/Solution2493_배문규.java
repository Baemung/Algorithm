package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2493_배문규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] tower = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			tower[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[N];
		
		for(int i = N-1; i >= 0; i--) {
			while(stack.size() != 0 && tower[stack.peek()] < tower[i])
		            result[stack.pop()] = i+1;
			stack.push(i);
		}
		
		for(int i : result)sb.append(i+" ");
		System.out.print(sb.toString());
	}

}
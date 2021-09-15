package SWEA.ssafy.date0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1218_배문규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine());
			char[] problem = br.readLine().toCharArray();
			System.out.println("#"+tc+" "+solve(num, problem));
		}

	}
	
	public static int solve(int num, char[] problem) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < num; i++) {
			if(problem[i] == '(' || problem[i] == '{' || problem[i] == '[' || problem[i] == '<') 
				stack.push(problem[i]);
			else if(problem[i] == ')') {
				if(stack.pop() != '(') return 0;
			}
			else if(problem[i] == '}') {
				if(stack.pop() != '{') return 0;
			}
			else if(problem[i] == ']') {
				if(stack.pop() != '[') return 0;
			}
			else if(problem[i] == '>') {
				if(stack.pop() != '<') return 0;
			}
		}
		if(stack.isEmpty()) return 1;
		else return 0;
	}

}
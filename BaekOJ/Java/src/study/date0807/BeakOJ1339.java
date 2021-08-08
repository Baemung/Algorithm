package study.date0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Perm {
    int n;
    List<List<List<Integer>>> result; 
    int _max = Integer.MIN_VALUE;

    public Perm(List<List<List<Integer>>> result) {
        this.n = result.size();
        this.result = result;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void perm(int[] arr, int depth) {
        if (depth == n) {
            int sum = 0;
            int idx = 0;
            for(List<List<Integer>> j : result) {
            	for(List<Integer> k : j) {
            		sum += arr[idx] * k.get(1) * Math.pow(10, k.get(0));
            	}
            	idx++;
            }
            _max = Math.max(_max, sum);

            return;
        }
        
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
    
}

public class BeakOJ1339 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<String> sArr = new ArrayList<String>();
		for(int i = 0; i < N; i++) 
			sArr.add(br.readLine());
		
		int[][] alpha = new int[26][8];
		for(String str : sArr) {
			for(int i = 0; i < str.length(); i++) 
				alpha[(int)str.charAt(i)-65][str.length()-i-1]++;
		}
		
		List<List<List<Integer>>> result = new ArrayList<List<List<Integer>>>();
		for(int i = 0; i < alpha.length; i++) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			for(int j = 0; j < alpha[0].length; j++) {
				if(alpha[i][j] == 0) continue;
				
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(j); 
				temp.add(alpha[i][j]);
				res.add(temp);
			}
			if(res.size() != 0) result.add(res);
		}
		
		System.out.println(result.toString());
		
        Perm perm = new Perm(result);
        perm.perm(Arrays.copyOfRange(arr, 0, result.size()), 0);
        System.out.println(perm._max);
    }
}

/*
반례 || A:8, B:9 (1790) > A:9, B:8(1780) 

10
ABB
BB
BB
BB
BB
BB
BB
BB
BB
BB
 
 public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<String> sArr = new ArrayList<String>();
		for(int i = 0; i < N; i++) sArr.add(br.readLine());
		
		int[][] alpha = new int[26][8];
		for(String str : sArr) {
			for(int i = 0; i < str.length(); i++) {
				alpha[(int)str.charAt(i)-65][8 - (str.length()-i)]++;
			}
		}
		
		Integer[] result = new Integer[26];
		for(int i = 0; i < alpha.length; i++) {
			sb.setLength(0);
			for(int j = 0; j < alpha[0].length; j++) sb.append(alpha[i][j]);

			if(sb.toString().equals("0")) continue;
			result[i] = Integer.parseInt(sb.toString());
		}
		
		Arrays.sort(result, Collections.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i < result.length; i++) sum += result[i]*(9-i);
		
		System.out.println(sum);
	}
}
*/
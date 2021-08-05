package stepbystep.array_1d;

import java.util.Scanner;

public class MinMax_10818 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int _min = Integer.MAX_VALUE, _max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			if(temp >= _max) _max = temp;
			if(temp <= _min) _min = temp;
		}
		
		System.out.println(_min+" "+_max);
	}

}

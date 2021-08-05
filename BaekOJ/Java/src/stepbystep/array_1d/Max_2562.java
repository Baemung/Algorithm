package stepbystep.array_1d;

import java.util.Scanner;

public class Max_2562 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int idx = 0, _max = Integer.MIN_VALUE;
		
		for(int i = 1; i < 10; i++) {
			int temp = sc.nextInt();
			if(temp >= _max) {
				_max = temp;
				idx = i;
			}
		}
		
		System.out.println(_max+"\n"+idx);
	}

}

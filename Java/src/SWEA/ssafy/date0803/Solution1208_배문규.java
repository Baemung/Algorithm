package SWEA.ssafy.date0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1208_배문규 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int T = 1; T <= 10; T++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			List<Integer> box = new ArrayList<Integer>();
			for(int i = 0; i < 100; i++) box.add(Integer.parseInt(st.nextToken()));
			
			flatten(T, box, dump);
		}

	}
	
	static void flatten(int t, List<Integer> box, int dump) {
		int _max = Collections.max(box);
		int _min = Collections.min(box);
		int gap = _max-_min;
		
		if(gap <= 1 || dump == 0) {
			System.out.println("#"+t+" "+gap);
			return;
		}
		
		box.set(box.indexOf(_max), _max-1);
		box.set(box.indexOf(_min), _min+1);
		
		flatten(t, box, dump-1);
	}

}

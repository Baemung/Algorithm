import java.io.*;
import java.util.*;

class Work{
	int time;
	int beforeTime = 0;
	List<Integer> before = new ArrayList<Integer>();
	List<Integer> after = new ArrayList<Integer>();
}

public class Solution2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int T, N, min, result;
	static Work works[];
	static Work copyWorks[];
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
 next_T:for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			works = new Work[N+1];
			copyWorks = new Work[N+1];
			
			for(int i = 1; i <= N; i++) works[i] = new Work();
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				works[i].time = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				for(int n = 0; n < cnt; n++) {
					int w = Integer.parseInt(st.nextToken());
					if(works[i].before.indexOf(w) == -1) works[i].before.add(w); // i보다 먼저 수행해야 할 작업들
					if(works[w].after.indexOf(i) == -1) works[w].after.add(i); // w가 끝나야 i를 수행할 수 있음
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++) {
				queue.clear();
				for(int j = 1; j <= N; j++) {
					copyWorks[j] = new Work();
					copyWorks[j].time = works[j].time;
					copyWorks[j].beforeTime = works[j].beforeTime;
					for(int n = 0; n < works[j].before.size(); n++) copyWorks[j].before.add(works[j].before.get(n));
					for(int n = 0; n < works[j].after.size(); n++) copyWorks[j].after.add(works[j].after.get(n));
					if(copyWorks[j].before.size() == 0) queue.offer(j);
				}
				
				copyWorks[i].time /= 2;
				
				result = 0;
				while(!queue.isEmpty()){
					int q = queue.poll();
					
					for(int w : copyWorks[q].after) {
						copyWorks[w].before.remove(copyWorks[w].before.indexOf(q));
						copyWorks[w].beforeTime = Math.max(copyWorks[w].beforeTime, copyWorks[q].time);
						
						if(copyWorks[w].before.size() == 0) {
							copyWorks[w].time += copyWorks[w].beforeTime;
							copyWorks[w].beforeTime = 0;
							queue.offer(w);
						}
					}
				}
				
				for(int idx = 1; idx <= N; idx++) {
					if(copyWorks[idx].before.size() != 0) {
						System.out.println("#" + test_case + " " + -1);
						continue next_T;
					}
					result = Math.max(result, copyWorks[idx].time);
				}
				
				min = Math.min(min, result);
			}
			System.out.println("#" + test_case + " " + min);
		}
	}
}

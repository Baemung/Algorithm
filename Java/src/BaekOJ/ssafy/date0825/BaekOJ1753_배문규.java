package BaekOJ.ssafy.date0825;

import java.io.*;
import java.util.*;

// 그래프의  Vertex 클래스 
class Vertex implements Comparable<Vertex>{
	int no, distance;
	Vertex(int no, int distance){
		this.no = no;
		this.distance = distance;
	}
	// 거리가 작으면 우선순위
	@Override
	public int compareTo(Vertex o) {
		return this.distance-o.distance;
	}
}

public class BaekOJ1753_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int V, E, start, dist[];
	static List<Vertex> graph[];
	static boolean check[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Vertex개수, Edge개수, 시작점 입력
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		// 그래프, 거리배열, 방문체크배열 생성하고 거리배열 INF로 초기화
		graph = new ArrayList[V+1];
		dist = new int[V+1];
		check = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 그래프 정보 입력 u -> v, distance
		for(int i = 1; i <= V; i++) graph[i] = new ArrayList<Vertex>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())].add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 최적화용 PQ, 시작지점을 PQ에 넣고 거리 초기화
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
	    pq.add(new Vertex(start, 0));
	    dist[start] = 0;
	    while(!pq.isEmpty()){
	    	// 최단거리 Vertex 꺼내고 방문 체크
	    	Vertex curVertex = pq.poll();
	    	int cur = curVertex.no;
	    	if(check[cur] == true) continue; // 방문했으면 컨티뉴
	        check[cur] = true;

	        // 현재 Vertex cur 에서 갈 수 있는 다른 Vertex v들
	        for(Vertex v : graph[cur]){
	        	// 시작점에서  cur를 경유해서 v까지 거리가 더 기존 경로보다 더 가까우면 갱신하고 pq에 add  
	            if(dist[v.no] > dist[cur] + v.distance){
	                dist[v.no] = dist[cur] + v.distance;
	                pq.add(new Vertex(v.no, dist[v.no]));
	            }
	        }
	    }
	    
	    // 경로가 존재하면 해당 경로까지 거리, 존재하지 않으면 INF
	    for(int i = 1; i <= V; i++) {
	    	if(dist[i] != Integer.MAX_VALUE) sb.append(dist[i]).append("\n");
	    	else sb.append("INF\n");
	    }
	    System.out.println(sb);
	}
}

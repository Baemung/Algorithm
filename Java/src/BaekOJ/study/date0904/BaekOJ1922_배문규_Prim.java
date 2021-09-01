package BaekOJ.study.date0904;

import java.io.*;
import java.util.*;

/*
 * 메모리 	시간
 * 46176	412
 */
public class BaekOJ1922_배문규_Prim {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int V, E, map[][], minWeight[];
	static boolean check[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		map = new int[V][V];
		check = new boolean[V];
		minWeight = new int[V];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from =  Integer.parseInt(st.nextToken())-1;
			int to =  Integer.parseInt(st.nextToken())-1;
			int weight =  Integer.parseInt(st.nextToken());
			map[from][to] = weight;
			map[to][from] = weight;
		}
		
		System.out.println(getResult());
	}
	
	public static int getResult(){
		int _min = 0;
		minWeight[0] = 0;
		
		for (int i = 0; i < V; i++) {
			int temp = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j < V; j++) {
				if(!check[j] && temp > minWeight[j]) {
					temp = minWeight[j];
					minVertex = j;
				}
			}
			 
			check[minVertex] = true;
			_min += temp;
			for (int j = 0; j < V; j++) 
				if(!check[j] && map[minVertex][j] != 0 && minWeight[j] > map[minVertex][j]) 
					minWeight[j] = map[minVertex][j];
		}
		
		return _min;
	}
}

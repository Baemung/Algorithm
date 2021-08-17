package SWEA.ssafy0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1210_배문규 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) 
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
             
            int x = 0, y = 99;
            int direct = 0;

            // 사다리를 올라갈 지점 찾기
            for(int j = 0; j < 100; j++) 
                if(map[99][j] == 2) {
                    x = j;
                    break;
                }
             
            while(true) {
                // 사다리 오르면서 샛길찾기
                for(int i = y-1; i >= 0; i--) {
                    // 오른쪽 길 발견
                    if(direct == 0 && x-1 >= 0 && map[i][x-1] == 1) 
                    {
                        y = i;
                        direct = 2;
                        break;
                    }
                    // 왼쪽 길 발견
                    else if(direct == 0 && x+1 < 100 && map[i][x+1] == 1)
                    {
                        y = i;
                        direct = 1;
                        break;
                    }
                }
                // 샛길이 없으면 종료
                if(direct == 0) break;
                // 오른쪽 길 이동
                else if(direct == 1) {
                    for(int i = x+1; i < 100; i++) {
                        if(map[y-1][i] == 1) {
                            x = i;
                            direct = 0;
                            break;
                        }
                    }
                }
                // 왼쪽 길 이동
                else if(direct == 2){
                    for(int i = x-1; i >= 0; i--) {
                        if(map[y-1][i] == 1) {
                            x = i;
                            direct = 0;
                            break;
                        }
                    }
                }
            }
            
            System.out.println("#"+T+" "+x);
        }
    }
}

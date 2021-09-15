package SWEA.ssafy.date0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution2805_배문규 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            // 맵의 센터 인덱스
            int center = N/2;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                String line= br.readLine();
                for(int j = 0; j < N; j++) {
                    // 맨하탄 디스턴스가 센터 인덱스보다 같거나 작으면 합산
                    if(Math.abs(center - i) + Math.abs(center - j) <= center) 
                        sum += Character.getNumericValue(line.charAt(j));
                }
            }
            System.out.println("#"+t+" "+sum);
        }
 
    }
 
}

package SWEA.ssafy0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution1873_배문규 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
             
             // 인덱스 0 ~ 3 : 유저의 방향 캐릭터 and 4 : 현 상태 저장
            List<Character> user = new ArrayList<Character>();
            user.add('>');
            user.add('<');
            user.add('^');
            user.add('v');
            user.add('4');
             
             // 맵에서 유저의 위치 인덱스
            int[] idx = new int[2];
            char[][] map = new char[H][W];
             
             // 맵을 형성하고, 맵에서 유저를 찾아서 현 위치와 상태를 저장
            for(int h = 0; h < H; h++) {
                map[h] = br.readLine().toCharArray();
                for(int w = 0; w < W; w++) {
                    if(user.contains(map[h][w])) {
                        idx[0] = h;
                        idx[1] = w;
                        user.set(4, Character.forDigit(user.indexOf(map[h][w]), 10));
                    }
                }
            }
             
            br.readLine();
            char[] console = br.readLine().toCharArray();
             
            for(char c : console) {
                // 이동
                if(c == 'R') {
                    // 상태 변경
                    map[idx[0]][idx[1]] = user.get(0);
                    // 유저에 현 상태 저장
                    user.set(4, Character.forDigit(user.indexOf(map[idx[0]][idx[1]]), 10));
                    // 위치 이동
                    if(idx[1]+1 < W && map[idx[0]][idx[1]+1] == '.') {
                        map[idx[0]][idx[1]+1] = user.get(0);
                        map[idx[0]][idx[1]] = '.';
                        idx[1]++;
                    } 
                }
                else if(c == 'L') {
                    map[idx[0]][idx[1]] = user.get(1);
                    user.set(4, Character.forDigit(user.indexOf(map[idx[0]][idx[1]]), 10));
                    if(idx[1]-1 >= 0 && map[idx[0]][idx[1]-1] == '.') {
                        map[idx[0]][idx[1]-1] = user.get(1);
                        map[idx[0]][idx[1]] = '.';
                        idx[1]--;
                    } 
                }
                else if(c == 'U') {
                    map[idx[0]][idx[1]] = user.get(2);
                    user.set(4, Character.forDigit(user.indexOf(map[idx[0]][idx[1]]), 10));
                    if(idx[0]-1 >= 0 && map[idx[0]-1][idx[1]] == '.') {
                        map[idx[0]-1][idx[1]] = user.get(2);
                        map[idx[0]][idx[1]] = '.';
                        idx[0]--;
                    } 
                }
                else if(c == 'D') {
                    map[idx[0]][idx[1]] = user.get(3);
                    user.set(4, Character.forDigit(user.indexOf(map[idx[0]][idx[1]]), 10));
                    if(idx[0]+1 < H && map[idx[0]+1][idx[1]] == '.') {
                        map[idx[0]+1][idx[1]] = user.get(3);
                        map[idx[0]][idx[1]] = '.';
                        idx[0]++;
                    } 
                }
                // 슛
                else if(c == 'S') {
                    // 유저가 어디를 바라보는지 콜
                    char usr =  user.get(4);
                    // 0 ~ 3 사방에서 슛이 *(돌벽)을 맞으면 벽을 1개 부숨, #(철벽)을 만나면 그냥 사라짐
                    if(usr == '0') {
                        for(int w = idx[1]; w < W; w++) {
                            if(map[idx[0]][w] == '*') {
                                map[idx[0]][w] = '.';
                                break;
                            } else if(map[idx[0]][w] == '#') break;
                        }
                    }
                    else if(usr == '1') {
                        for(int w = idx[1]; w >= 0; w--) {
                            if(map[idx[0]][w] == '*') {
                                map[idx[0]][w] = '.';
                                break;
                            } else if(map[idx[0]][w] == '#') break;
                        }
                    }
                    else if(usr == '2') {
                        for(int h = idx[0]; h >= 0; h--) {
                            if(map[h][idx[1]] == '*') {
                                map[h][idx[1]] = '.';
                                break;
                            } else if(map[h][idx[1]] == '#') break;
                        }
                    }
                    else if(usr == '3') {
                        for(int h = idx[0]; h < H; h++) {
                            if(map[h][idx[1]] == '*') {
                                map[h][idx[1]] = '.';
                                break;
                            } else if(map[h][idx[1]] == '#') break;
                        }
                    }
                     
                }
            }
             
            System.out.print("#"+t+" ");
            for(int h = 0; h < H; h++) {
                for(int w = 0; w < W; w++) {
                    System.out.print(map[h][w]);
                }
                System.out.println();
            }
        }
    }
 
}

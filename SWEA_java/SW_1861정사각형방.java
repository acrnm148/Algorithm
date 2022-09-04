package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DFS
 * 
 * */
public class SW_1861정사각형방 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int N;
    static int nx, ny;
    static int start, minStart, maxCnt;
     
    public static void dfs(int x, int y, int cnt) {
        for (int k = 0; k < 4; k++) {
            nx = x + dx[k];
            ny = y + dy[k];
 
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(map[x][y] + 1 == map[nx][ny]) {
                    if(cnt == 1)
                        start = map[x][y];
                    cnt++;
                    dfs(nx, ny, cnt);
                }
            }
            if(cnt > maxCnt) {
                maxCnt = cnt;
                minStart = start;
            }
            if(cnt == maxCnt)
                minStart = Math.min(start, minStart);
        }
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());  // 테스트 케이스 수
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
             
            maxCnt = 0;
            minStart = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }   
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(i, j, 1);
                }
            }
            sb.append("#").append(tc).append(" ").append(minStart).append(" ").append(maxCnt).append("\n");
        }
        System.out.println(sb);
    }
}
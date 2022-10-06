import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
 
public class Solution{
    
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        PriorityQueue<data> pq = new PriorityQueue<>(); 
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int [][] map = new int [N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j)-'0';
                }
            }
             
            boolean [][] visited = new boolean [N][N];
            int [][] total = new int [N][N]; 
            for (int i = 0; i < N; i++) {
                Arrays.fill(total[i], Integer.MAX_VALUE);
            }
             
            pq.clear();
            pq.offer(new data(0, 0, 0)); 
            total[0][0] = 0;
             
            while (!pq.isEmpty()) {
                data q = pq.poll();
                int row = q.r;
                int col = q.c;
                int cost = q.cost;
                visited[row][col] = true;
                 
                if(cost > total[N-1][N-1]) continue;
                for (int i = 0; i < 4; i++) {
                    int r = row + dx[i];
                    int c = col + dy[i];
                    if(r >= N || r < 0 || c >= N || c < 0) continue;
                    if(visited[r][c]) continue;
                    if(cost + map[r][c] > total[r][c]) continue;
                    total[r][c] = cost+map[r][c];
                    pq.offer(new data(r, c, total[r][c]));
                }
            }
             
            System.out.println("#" + tc + " " + total[N-1][N-1]);
             
        }
 
        System.out.println(sb);
         
    }
    static public class data implements Comparable<data>{
        int r;
        int c;
        int cost;
         
        data(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
     
      @Override
        public int compareTo(data o) {
            return this.cost - o.cost;
        }
    }
}

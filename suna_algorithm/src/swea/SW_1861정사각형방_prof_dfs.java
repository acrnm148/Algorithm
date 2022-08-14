package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class SW_1861정사각형방_prof_dfs {

	static int[][] map;
	static int T, N, NO, COUNT;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//초기화
			NO = 0;
			COUNT = 1; //출발하는 방 번호도 count에 추가
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//dfs
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N ; j++) {
					//모든 방에서 출발해봐야 한다
					dfs(i, j, map[i][j], 1);
				}
			}
			
			System.out.println("#" + t + " " + NO + " " + COUNT);
		}

	}
	
	//delta
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void dfs(int y, int x, int no, int cnt) { //visited가 필요없다. 자기자신보다 +1인 아이만 가면 되기 때문
		if (cnt > COUNT) {
				COUNT = cnt;
				NO = no;
			} else if (cnt == COUNT) {
				NO = no < NO? no : NO;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= N ||  map[ny][nx] != map[y][x] + 1) continue;
				dfs(ny, nx, no, cnt+1);
				break; // 더 돌 필요가 없다. 조건에 맞는 다음 방 번호는 한 개이므로 더이상 delta를 따져볼 필요가 없다
			}
	}
}
	










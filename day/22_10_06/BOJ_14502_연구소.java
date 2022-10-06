package a22_10_06;

import java.io.*;
import java.util.*;

public class BOJ_14502_연구소 {

	static int N, M, max;
	static int[][] map;
	static List<int[]> virus = new ArrayList<> ();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 2) virus.add(new int[] {i, j});
			}
		}
		
		dfs(0);
		System.out.println(max);
	}

	static void dfs(int wallCnt) {
		if (wallCnt == 3) { //벽 3개 다 세웠을 경우
			int cnt = spread();
			max = Math.max(max, cnt);
			return;
		}
		
		//이렇게 하면 안좋은 점 : 안그래도 많이 도는 dfs 매 번 이중for문으로 처음부터 돈다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs( wallCnt+1 );
					map[i][j] = 0;
				}
			}
		}
	}
	
	static int spread() { //bfs
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		Queue<int[]> queue = new ArrayDeque<> ();
		boolean[][] visited = new boolean[N][M];
		
		for (int[] v : virus) {
			
			if (visited[v[0]][v[1]]) continue;
			
			queue.offer(new int[] {v[0], v[1]});
			visited[v[0]][v[1]] = true;
			
			while (!queue.isEmpty()) {
				int[] node = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = node[0]+dy[d];
					int nx = node[1]+dx[d];
					if ( ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] ) continue;
					if (copyMap[ny][nx] == 0) {
						copyMap[ny][nx] = 2;
						queue.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class SW_1861정사각형방_prof_bfs {

	static int[][] map;
	static int T, N, NO, COUNT;
	static Queue<Node> queue = new ArrayDeque<>();
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
			
			//bfs
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N ; j++) {
					//모든 방에서 출발해봐야 한다
					queue.add(new Node(i, j, map[i][j], 1));
					bfs();
				}
			}
			
			System.out.println("#" + t + " " + NO);
		}

	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static void bfs() { //visited가 필요없다. 자기자신보다 +1인 아이만 가면 되기 때문
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.cnt > COUNT) {
				COUNT = node.cnt;
				NO = node.no;
			} else if (node.cnt == COUNT) {
				NO = node.no < NO? node.no : NO;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= N ||  map[ny][nx] != map[node.y][node.x] + 1) continue;
				queue.offer(new Node(ny, nx, node.no, node.cnt+1));
				break; // 더 돌 필요가 없다. 조건에 맞는 다음 방 번호는 한 개이므로 더이상 delta를 따져볼 필요가 없다
			}
		}
	}
	
	static class Node {
		int y;
		int x;
		int no; //시작 방 번호 (계속 따라다녀야 한다)
		int cnt; //방문 횟수 (방문할 때마다 계속 증가)
		
		public Node(int y, int x, int no, int cnt) {
			this.y = y;
			this.x = x;
			this.no = no;
			this.cnt = cnt;
		}
	}
}







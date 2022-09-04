package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* 시간초과난 코드
 * bfs
 * 시간: 2.9874ms => 2.7689ms(예제5) 별차이 없는디..?
 * 		(시간초과)
 * -----
 * 시간초과
 * 문제점: 1. 모든 지점의 bfs가 끝난 후에 인구이동
 * 		 2. 인구이동할 지점을 map에 표시 => 인구이동할 때 NxN 모두 탐색
 * 해결방법:1. 각 지점의 bfs가 끝난 후에 인구이동
 * 		 2. 인구이동할 지점의 좌표만 ArrayList에 저장 => 인구이동할 때 ArrayList.size()만큼만 탐색
 * */
public class BOJ_16234인구이동 {

	static boolean part_s, move_s; //part_s:구역시작상태, move_s:전체 인구이동 유무 상태
	static Queue<Node> queue = new ArrayDeque<>();
	static int[][] map_part, map;
	static boolean[][] visited;
	static int N, min, max, day, part; //day:인구이동 발생 일수, part:인구이동할 구역
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map_part = new int[N][N]; 
		
		while (true) { //더이상 인구이동이 없을 때까지
			visited = new boolean[N][N]; 
			move_s = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])
						part_s = false;
						bfs(i, j);
				}
			}
			
			if (!move_s) break; //move_s: 한번이라도 인구이동이 일어났으면 true
			move(); //인구이동
			day++;
		}
		System.out.println(day);
	}
	
	static void bfs(int y, int x) {
		queue.offer(new Node(y, x));
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
				//인접 나라와의 인구 차이가 min 이상 max 이하일 때
				if (Math.abs(map[ny][nx] - map[node.y][node.x]) >= min && Math.abs(map[ny][nx] - map[node.y][node.x]) <= max) {
					if (!part_s) part++; //part_s==false일 때 위 조건을 만나면 part+1, part_s=true(구역 시작한다는 의미)
					queue.offer(new Node(ny, nx));
					visited[ny][nx] = true;
					map_part[ny][nx] = part; 			//국경 열림
					map_part[node.y][node.x] = part; 	//국경 열림
					part_s = true;
					move_s = true;	//한번이라도 이동이 일어났으면 true
				}
			}
		}
	}
	
	static void move() {
		for (int p = 1; p <= part; p++) {
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map_part[i][j] == p) {
						sum += map[i][j];
						cnt++;
					}
				}
			}
			if (cnt != 0) {
				int num = sum/cnt;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map_part[i][j] == p) {
							map[i][j] = num;
						}
					}
				}
			}
		}
	}
	
	
	static class Node {
		int y, x;
		public Node (int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs
 * 시간:2.7689ms(예제5) => 별 차이없음..
 * -----
 * 
 * */
public class BOJ_16234인구이동2 {

	static boolean move_s; //move_s:전체 인구이동 유무 상태
	static Queue<Node> queue = new ArrayDeque<>();
	static int[][] map_part, map;
	static boolean[][] visited;
	static int N, min, max, day, part; //day:인구이동 발생 일수, part:인구이동할 구역
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static List<Node> union = new ArrayList<>(); //add => 인구이동할 지점 x,y 좌표 따로 저장
	
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
		
		while (true) { //더이상 인구이동이 없을 때까지
			visited = new boolean[N][N]; 
			move_s = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])
						bfs(i, j);
				}
			}
			
			if (!move_s) break; //move_s: 한번이라도 인구이동이 일어났으면 true
			day++;
		}
		System.out.println(day);
	}
	
	static void bfs(int y, int x) {
		queue.offer(new Node(y, x));
		visited[y][x] = true;
		union.add(new Node(y,x));
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
				//인접 나라와의 인구 차이가 min 이상 max 이하일 때
				if (Math.abs(map[ny][nx] - map[node.y][node.x]) >= min && Math.abs(map[ny][nx] - map[node.y][node.x]) <= max) {
					queue.offer(new Node(ny, nx));
					visited[ny][nx] = true;
					union.add(new Node(ny, nx));
					move_s = true;	//한번이라도 이동이 일어났으면 true
				}
			}
		}
		
		move();
		
	}
	
	static void move() {
		int sum = 0;
		for (int i = 0; i < union.size(); i++) {
			Node n = union.get(i);
			sum += map[n.y][n.x];
		}
		for (int i = 0; i < union.size(); i++) {
			Node n = union.get(i);
			map[n.y][n.x] = sum/union.size();
		}
		union.removeAll(union);
	}
	
	
	static class Node {
		int y, x;
		public Node (int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}

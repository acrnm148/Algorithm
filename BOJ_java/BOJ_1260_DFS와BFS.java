package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static int[][] matrix;
	static boolean[] visited;
	static int N, M, start;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		start = Integer.parseInt(st.nextToken()); // 시작점

		matrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) { // 간선 개수 만큼
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1; // 인접해있으면 1
			matrix[b][a] = 1;
		}

		// dfs
		visited = new boolean[N + 1];
		dfs(start);

		System.out.println();
		// bfs
		visited = new boolean[N + 1];
		bfs();
	}

	static void bfs() {

		Queue<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int front = queue.poll();
			System.out.print(front + " ");

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && matrix[front][i] != 0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}

	}

	static void dfs(int i) {
		visited[i] = true;
		System.out.print(i + " ");
		for (int x = 1; x <= N; x++) {
			if (!visited[x] && matrix[i][x] != 0)
				dfs(x);
		}
	}

}

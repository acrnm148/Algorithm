package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926배열돌리기1 {

	static int[] dy = { 0, -1, 0, 1 }; // 왼쪽으로 - 위쪽으로 - 오른쪽으로 - 아래로
	static int[] dx = { -1, 0, 1, 0 };
	static Node n1, n2, n3, n4;
	static int N, M, cnt, frame, len, dir;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sy = 0;
		int sx = 0;
		int y = sy;
		int x = sx;
		while (true) {
			// frame - 그 프레임에서 총 몇번 돌아야함?
			len = ((N - 1) + (M - 1)) * 2;

			if (sy == N - 1 || sx == M - 1) {
				break;
			}

			// 회전
			int keep = map[sy][sx];
			int ny = 0;
			int nx = 0;
			for (int i = 0; i < len; i++) {
				if (!(y > sy && y < N - 1 && x > sx && x < M - 1)) {

					if (y == sy && x == sx) {
						dir = 0; // 꼭짓점1 일 때
						ny = y + 1;
						nx = x;
					} else if (y == sy && x == M - 1) {
						dir = 1; // 꼭짓점2 일 때
						ny = y;
						nx = x - 1;
					} else if (y == N - 1 && x == sx) {
						dir = 2; // 꼭짓점3 일 때
						ny = y - 1;
						nx = x;
					} else if (y == N - 1 && x == M - 1) {
						dir = 3; // 꼭짓점4 일 때
						ny = y;
						nx = x + 1;
					} else {
						ny = y + dy[dir];
						nx = x + dx[dir];
					}
					System.out.println(ny + " " + nx);
				}

				map[sy + 1][M - 1] = keep;

				x = nx;
				y = ny;
				
				
				N -= 2;
				M -= 2;// 꼭짓점 4개
				sy += 1;
				sx += 1;
				
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}
}

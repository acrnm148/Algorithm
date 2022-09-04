package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926배열돌리기3 {

	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cmd = Integer.parseInt(br.readLine());

		// 2번
		if (cmd == 2) {
			int x1 = 0;
			int x2 = M - 1;
			while (true) {
				if (x1 >= x2)
					break;
				int[] tmp = new int[N];
				// 1. 맨 왼쪽줄 복사해놓음
				for (int y = 0; y < N; y++) {
					tmp[y] = arr[y][x1];
				}
				// 2. 오른쪽 줄 왼쪽으로 이동
				for (int y = 0; y < N; y++) {
					arr[y][x1] = arr[y][x2];
				}
				// 3. 오른쪽에 붙여넣음
				for (int y = 0; y < N; y++) {
					arr[y][x2] = tmp[y];
				}
				x1++;
				x2--;
			}
		}

		// 5번
		if (cmd == 5) {

			int[][] part1 = new int[N / 2][M / 2];
			int[][] part2 = new int[N / 2][M / 2];
			int[][] part3 = new int[N / 2][M / 2];
			int[][] part4 = new int[N / 2][M / 2];

			// part1 넣기
			for (int y = 0; y < N / 2; y++) {
				for (int x = 0; x < M / 2; x++) {
					part1[y][x] = arr[y][x];
				}
			}
			for (int y = 0, i = 0; y < N / 2; y++, i++) {
				for (int x = M / 2, j = 0; x < M; x++, j++) {
					part2[i][j] = arr[y][x];
				}
			}
			for (int y = N / 2, i = 0; y < N; y++, i++) {
				for (int x = 0, j = 0; x < M / 2; x++, j++) {
					part3[i][j] = arr[y][x];
				}
			}
			for (int y = N / 2, i = 0; y < N; y++, i++) {
				for (int x = M / 2, j = 0; x < M; x++, j++) {
					part4[i][j] = arr[y][x];
				}
			}
			// part1 -> part2
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part2[i][j] = part1[i][j];
				}
			}
			// part2 -> part3
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part3[i][j] = part2[i][j];
				}
			}
			// part3 -> part4
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part4[i][j] = part3[i][j];
				}
			}
			// part4 -> part1
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part1[i][j] = part4[i][j];
				}
			}
		}

		// 6번
		if (cmd == 6) {

			int[][] part1 = new int[N / 2][M / 2];
			int[][] part2 = new int[N / 2][M / 2];
			int[][] part3 = new int[N / 2][M / 2];
			int[][] part4 = new int[N / 2][M / 2];

			// part1 넣기
			for (int y = 0; y < N / 2; y++) {
				for (int x = 0; x < M / 2; x++) {
					part1[y][x] = arr[y][x];
				}
			}
			for (int y = 0, i = 0; y < N / 2; y++, i++) {
				for (int x = M / 2, j = 0; x < M; x++, j++) {
					part2[i][j] = arr[y][x];
				}
			}
			for (int y = N / 2, i = 0; y < N; y++, i++) {
				for (int x = 0, j = 0; x < M / 2; x++, j++) {
					part3[i][j] = arr[y][x];
				}
			}
			for (int y = N / 2, i = 0; y < N; y++, i++) {
				for (int x = M / 2, j = 0; x < M; x++, j++) {
					part4[i][j] = arr[y][x];
				}
			}
			// part1 -> part4
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part4[i][j] = part1[i][j];
				}
			}
			// part4 -> part3
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part3[i][j] = part4[i][j];
				}
			}
			// part3 -> part2
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part2[i][j] = part3[i][j];
				}
			}
			// part2 -> part1
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					part1[i][j] = part2[i][j];
				}
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//시계방향으로 이동
//delta
public class SW_1954달팽이숫자_prof {

	static int T, N;
	static int[][] snail;
	// 시계방향으로 이동 => delta : 순서가 있는 녀석
	// 우 - 하 - 좌 - 상
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];

			// 시작좌표, 방향
			int y = 0;
			int x = 0;
			int d = 0; // 시작방향 우 index

			int num = 1; // 시작숫자 (계속 1씩 증가)
			// NxN 만큼 반복하면서 숫자를 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[y][x] = num++; // 숫자를 저장

					// 이동
					// 현재 방향으로 이동하다가 더이상 못가면 다음방향으로 전환
					if (d == 0) { // 우
						if (x + dx[d] >= N || snail[y][x + dx[d]] != 0)
							d = 1; // 하
					} else if (d == 1) { // 하
						if (y + dy[d] >= N || snail[y + dy[d]][x] != 0)
							d = 2; // 좌
					} else if (d == 2) { // 좌
						if (x + dx[d] < 0 || snail[y][x + dx[d]] != 0)
							d = 3; // 상
					} else if (d == 3) { // 상
						if (y + dy[d] < 0 || snail[y + dy[d]][x] != 0)
							d = 0; // 우
					}

					// 위 조건에 해당하면 d는 변경됨
					x = x + dx[d];
					y = y + dy[d];
				}
			}
			System.out.println("#" + tc);
			for (int[] a : snail) {
				for (int aa : a)
					System.out.print(aa + " ");
				System.out.println();
			}

		}
	}

}

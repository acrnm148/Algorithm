package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 배열돌리기4
 * 순열 문제
 * 
 * */
public class BOJ_17406배열돌리기4 {

	static int[][] map, backup, rcs;
	static int N, M, K, min;
	static int[] tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		backup = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				backup[i][j] = n;
			}
		}
		
		//초기화
		min = Integer.MAX_VALUE;
		rcs = new int[K][3];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//순열
		tgt = new int[K];
		select = new boolean[K];
		
		perm(0);
		System.out.println(min);
	}
	
	static void perm(int tgtIdx) {
		//1. 기저조건
		if (tgtIdx == K) {
			//순열 완성
			//회전 - 최소값 갱신 - 배열 초기화
			rotate();
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = backup[i][j];
				}
			}
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (select[i]) continue;
			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
	
	
	static void rotate() {

        // tgt 배열에는 완성된 현재 순열이 저장되어 있다.
        // 첫 번째 주어진 배열 연산 순서로 실행
		for (int k = 0; k < K; k++) {

			int n = tgt[k]; // 현재 완성된 순열 index

			int r = rcs[n][0] - 1; // 0 base 보정
			int c = rcs[n][1] - 1; // 0 base 보정
			int s = rcs[n][2]; // 반복 횟수가 됨.

			int sy = r - s;
			int ey = r + s;
			int sx = c - s;
			int ex = c + s;

			while (true) {

				// 기저 조건 s만큼 수행 for 문도 가능
				if (s == 0)
					break;

				int temp = map[sy][sx]; // 백업 (왼쪽 위)
				// 이동 방향의 앞쪽부터 이동해야 함 <- 1 <- 2 <- 3 <- 4
				// 뒸쪽 부터 이동하면 계속 덮어씀 <- 4 < -3 <- 2 <- 1

				// 왼쪽 위로 1칸 이동
				for (int i = sy; i < ey; i++) {
					map[i][sx] = map[i + 1][sx];
				}

				// 아래 왼쪽 1칸 이동
				for (int i = sx; i < ex; i++) {
					map[ey][i] = map[ey][i + 1];
				}

				// 오른쪽 아래로 1칸 이동
				for (int i = ey; i > sy; i--) {
					map[i][ex] = map[i - 1][ex];
				}

				// 위 오른쪽으로 한칸 이동
				for (int i = ex; i > sx; i--) {
					map[sy][i] = map[sy][i - 1];
				}

				// temp 로부터 이동 마지막 부분 복사( 왼쪽 위의 한칸 오른쪽 )
				map[sy][sx + 1] = temp;

				sy += 1; // 시작 y는 하나 아래로
				sx += 1; // 시작 x는 하나 오른쪽으로
				ey -= 1; // 종료 y는 하나 위
				ex -= 1; // 종료 x는 하나 왼쪽으로

				s--;
			}

		}
	}
}










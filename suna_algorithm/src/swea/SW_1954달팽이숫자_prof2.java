package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 좌 <--> 우 반복
// 좌 <--> 우 반복되는 중간에 상하가 다시 반복
// 좌 <--> 우 한번 실행되면 그 다음 실행되는 숫자의 수가 하나 준다.
public class SW_1954달팽이숫자_prof2 {

	static int T, N;
	static int[][] snail;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];

			// 시작좌표, 방향
			int y = 0;
			int x = -1; // 1이 더해질 것이므로 미리 보정
			int d = 1;// 상하좌우 개념X, 1 : 증가, -1 : 감소

			int num = 1; // 시작숫자 (계속 1씩 증가)
			int count = N; // 시작부터 계속 이어지는 방향에 대해 숫자를 기록할 갯수 , 점점 줄어듦 
			int total = N * N; //while 문

			while (num <= total) {
				// 우 -> 좌 -> 우 -> 좌 ..반복
				for (int i = 0; i < count; i++) {
					x += d;
					snail[y][x] = num++;
				}
				count--;
				
				// 하 -> 상 -> 하 -> 상 ..반복
				for (int i = 0; i < count; i++) {
					y += d;
					snail[y][x] = num++;
				}
				
				//방향 전환
				d *= -1; //-1넣으면 안되고, 곱해줘야함
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

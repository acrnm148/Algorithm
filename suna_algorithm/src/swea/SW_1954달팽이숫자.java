package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1954달팽이숫자 {
	
	static int[] dir_y = {0, 1, 0, -1};
	static int[] dir_x = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(bf.readLine());
			int start = 1;
			int end = N;
			int[][] arr = new int[N+1][N+1];
			int dir = 0; //방향
			int x = 1;
			int y = 1;
			
			for (int num = 1; num <= N * N; num++) {
				arr[y][x] = num;
				if (x == start && y == start + 1) {
					dir = 0;
					start++;
					end--;
				}
				else if (x == end && y == start)
					dir = 1;
				else if (x == end && y == end)
					dir = 2;
				else if (x == start && y == end) {
					dir = 3;
				}
				x = x + dir_x[dir];
				y = y + dir_y[dir];

			}
			System.out.println("#"+tc);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(arr[i][j] +" ");
				}
				System.out.println();
			}
		}
	}

}

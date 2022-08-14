package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// memoization 
public class BOJ_11660구간합구하기5 {

	static int N, M, last;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		int[][] tmp = new int[N + 1][N + 1];
		last = 0;

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				tmp[y][x] = arr[y][x] + tmp[y-1][x] + tmp[y][x-1] + tmp[y-1][x-1];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int res = 0;
			System.out.println(tmp[endY][endX]);
			res = tmp[endY][endX] - tmp[startY][startX] + arr[startY][startX];
			System.out.println(sb);
			//sb.append(res).append("\n");
		}

		//System.out.println(sb);
	}

}

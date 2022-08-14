package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2805농작물수확하기 {

	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			//입력부
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = tmp[j] - '0';
				}
			}
			
			
			//탐색
			int sum = 0;
			int idx = 0;
			int start = N/2;
			int end = N/2;
			for (int y = 0; y < N; y++) {
				if (y < N/2) {
					for (int x = start; x <= end; x++) {
						sum += arr[y][x];
					}
					start--;
					end++;
				}
				else if (y >= N/2) {
					for (int x = start; x <= end; x++) {
						sum += arr[y][x];
					}
					start++;
					end--;
				}
				
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

}

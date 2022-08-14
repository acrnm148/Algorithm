package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010다리놓기_prof2 {

	/* DP 풀이방법===============================
	 * 공 7개 중에 4개를 뽑는다. (조합)
	 * => 공 1개를 선택한 경우의 수 + 공 1개를 선택하지 않은 경우의 수
	 * = 공 1개를 선택한 경우의 수 => 6개 중에 3개
	 * = 공 1개를 선택하지 않은 경우의 수 => 6개 중에 4개
	 * 7C4 	= 6C3 + 6C4
	 * 		= 5C2 + 5C3 + 5C3 + 5C4
	 * */
	
	/*
	 * 그냥 조합으로 풀면 그 과정에서 참여를 할 수 있다. (중복이 많이 발생)
	 * 하지만 여기서는 과정에 참여할 필요 없이 단순하게 조합의 경우의 수만 따지므로
	 * => 미리 한번 계산한 값을 저장할 자료구조를 만들고
	 * 	  반복되는 경우에 기록해두고 재사용한다. = memoization
	 * DP : memoization 을 이용해서 작은 수 -> 큰 수로 확대해 나가는 방법
	 * */
	
	static int T, N, M;
	static int[][] dp; //재귀호출 줄여줌
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[M+1][N+1];
			
			//dp로 배열 완성하기
			for (int i = 1; i <= M; i++) {
				for (int j = 0; j <= Math.min(i, N); j++) {
					if (j == 0 || j == i)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			System.out.println(dp[M][N]);
		}
	}
}

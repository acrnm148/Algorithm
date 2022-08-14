package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합 + dp
 * 조합: 2796.7025 ms
 * 조합+dp: 0.5499999999999999 ms
 * */
public class BOJ_1010다리놓기 {
	
	static int N, M, totalCnt;
	static int[] isSelected = new int[30];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			long start = System.nanoTime(); //시간 add
			
			//1. 조합
			totalCnt = 0;
			comb(0, 0); //cnt == 0, start==0
			System.out.println(totalCnt);
			
			/*
			dp = new long[31][31];
			dpcomb();
			System.out.println(dp[M][N]);
			 */
			long end = System.nanoTime(); //시간 add
			System.out.println("시간: " + (end-start)*0.000_001 + " ms");
		}
	}
	
	//조합
	static void comb(int cnt, int start) {
		//1. 기저조건
		if (cnt == N) {
			totalCnt++;
			return;
		}
		if (M == N || N == 0) {
			totalCnt = 1;
			return;
		}
		
		//2. 처음부터 순회
		for (int i = start; i < M; i++) { //0부터 하면 계속 처음부터 본다 start부터 순회 시작
			isSelected[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	//조합 + dp
	static long[][] dp;
	static void dpcomb() {
		//특징2개
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j <= i; j++) {
				if (j==0 || j==i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
	}
}

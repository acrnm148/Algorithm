package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합 + dp
 * N개 중 K개 고르는 경우의 수
 * 조합 -> 시간초과
 * */
public class BOJ_15489파스칼삼각형 {

	static int R, C, W, totalCnt, n, r, sum;
	static int[] selected = new int[31];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		//1. 조합
		/*
		for (int i = 0; i < W; i++) {
			for (int j = 0; j <= i; j++) {
				totalCnt = 0;
				n = R-1+i;
				r = C-1+j;
				comb(0, 0);
				sum += totalCnt;
			}
		}
		*/
		//2. 조합 + dp
		n = R-1+W-1;
		r = C-1;
		dpcomb();
		System.out.println(sum);
		
		/*for (int i = 0; i <= 30; i++) {
			for (int j = 1; j <= 30; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	
	//조합
	static void comb(int cnt, int start) {
		//1. 기저조건
		if (cnt == r) {
			totalCnt++;
			return;
		}
		//2. 시작지점부터 끝까지 순회
		for (int i = start; i < n; i++) {
			selected[cnt] = i;
			comb(cnt+1, i+1); //재귀
		}
	}
	
	//dp + 조합
	static long[][] dp = new long[31][31];
	static void dpcomb() {
 		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j==0 || j==1)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				if (i >= R && i <= (R+W-1)) {
					System.out.print(dp[i][j] + " ");
					sum += dp[i][j];
				}
			}
			System.out.println();
			
		}
	}
	
}

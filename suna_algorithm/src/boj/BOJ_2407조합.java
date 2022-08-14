package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/* 시간비교
 * 조합: 6336.627399999999 ms
 * 조합+dp: 12.7586 ms ==> 훠어어얼씬 빠르다
 * */
public class BOJ_2407조합 {

	static int N, M, totalCnt;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		long start = System.nanoTime(); //시간 add

		isSelected = new boolean[M];
		//1. 조합
		totalCnt = 0;
		comb(0, 0); // cnt == 0, start==0
		System.out.println(totalCnt);
		
		long end = System.nanoTime(); //시간 add
		System.out.println("time: "+(end-start)*0.000_001 +" ms"); //시간 add
		
		/*
		//2. 조합+dp
		dpcomb();
		System.out.println(dp[N][M]);
		*/
	}

	// 1. 조합
	static void comb(int cnt, int start) {
		// 1. 기저조건
		if (cnt == M) {
			totalCnt++;
			return;
		}

		// 2. 시작점부터 끝까지 순회
		for (int i = start; i < N; i++) {
			comb(cnt + 1, i + 1);
		}
	}
	
	
	//2. 조합+dp
	static BigInteger[][] dp = new BigInteger[101][101];
	static void dpcomb() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j==i)
					dp[i][j] = new BigInteger("1");
				else
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]); //BigInteger의 합 연산은 .add
					//add:더하기, subtact:빼기, multiply:곱하기, divide:나누기, mod:나머지구하기
			}
		}
	}
}

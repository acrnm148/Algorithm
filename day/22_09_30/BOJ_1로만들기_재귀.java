package a22_09_30;

import java.io.*;
import java.util.*;

public class BOJ_1로만들기_재귀 {

	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(rec(N));
	}
	
	static int rec(int n) {
		if (n == 1) return 0;
		if (dp[n] > 0) return dp[n];
		
		dp[n] = rec(n-1)+1;
		if (n%2==0) dp[n] = Math.min(dp[n], rec(n/2)+1);
		if (n%3==0) dp[n] = Math.min(dp[n], rec(n/3)+1);
		
		return dp[n];
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 부분합
 * 신맛과 쓴맛의 차이를 최대한 작게
 * 신맛과 쓴맛의 합은 1_000_000_000 보다 작다
 * */
public class BOJ_261도영이가만든맛있는음식_prof2 {
	static int[][] src;
	static int N; // 신맛과 쓴맛의 차이, 재료 개수
	static int min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			src[i][0] =  Integer.parseInt(st.nextToken());
			src[i][1] =  Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		//부분집합
		dfs(0, 1, 0);
		
		System.out.println(min);
	}
	
	
	static void dfs(int srcIdx, int sinSum, int ssnSum) {
		//1. 기저조건
		if (srcIdx == N) return;
		
		//2. 현재 srcIdx 재료의 신맛과 쓴맛을 계산
		int currSin = src[srcIdx][0] * sinSum;
		int currSsn = src[srcIdx][1] + ssnSum;
		
		//3. 최소값 비교
		min = Math.min(min, Math.abs(currSin - currSsn));
		
		//4. 다음 재료 선택
		dfs(srcIdx+1, currSin, currSsn); //현재 재료 선택 O
		dfs(srcIdx+1, sinSum, ssnSum); //현재 재료 선택 X -> 더하기 전 녀석
	}
	
	
}


















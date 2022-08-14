package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합 문제
 * N개 중 K개 고르는 경우의 수
 * */
public class BOJ_16395파스칼의삼각형 {

	static int N, K, totalCnt;
	static int[] isSelected = new int[31];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		N--; //이항계수
		K--;
		
		comb(0, 0); 
		System.out.println(totalCnt);
		
	}
	
	static void comb(int cnt, int start) {
		//1. 기저조건
		if (cnt == K) {
			totalCnt++;
			for (int i : isSelected) {
				System.out.print(i + " ");
			}
			return;
		}
		//2. 시작점부터 끝까지 순회
		for (int i = start; i < N; i++) {
			isSelected[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}

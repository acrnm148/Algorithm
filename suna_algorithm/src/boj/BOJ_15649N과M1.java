package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649N과M1 {

	static int N, M;
	static boolean[] isSelected;
	static int[] numbers;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		isSelected = new boolean[N+1];
		numbers = new int[M];
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		//1. 기저조건
		if (cnt == M) {
			//sb.append(str).append("\n");
			for (int i = 0; i < M;i++) System.out.print(numbers[i]+" ");
			System.out.println();
			return;
		}
		//2. 처음부터 끝까지 다본다
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}

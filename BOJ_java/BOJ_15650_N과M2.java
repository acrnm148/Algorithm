package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {

	static int N, M;
	static boolean[] isSelected;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N+1];
		tgt = new int[M];
		
		perm(0);

	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			//각각 수열 다만듦
			if (check(tgt)) {
				for (int i = 0; i < M; i++) 
					System.out.print(tgt[i] + " ");
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			tgt[tgtIdx] = i;
			isSelected[i] = true;
			perm(tgtIdx+1);
			isSelected[i] = false;
			
		}
	}
	static boolean check(int[] arr) { //오름차순 체크
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			if (arr[i] > arr[i+1]) return false;
		}
		
		
		return true;
	}
}

package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {

	static int[] tgt, arr, dest;
	static boolean[] isSelected;
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N+1];
		tgt = new int[M];
		dest = new int[N];
		
		//perm(0);
		/*
		arr = new int[8];
		for (int i = 0; i < 8; i++) arr[i] = i+1; 
		do{
			System.out.println(Arrays.toString(dest));
			//System.out.println();
		}while(np());
		*/
		perm_bit(0, 0);
		
	}
	
	//1. 기본 순열
	static void perm(int tgtIdx) {
		if (tgtIdx == M) {
			int idx = 0;
			for (int i = 0; i < M; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		//줄세우기
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue; //이미 쓰고있는 수면 넘기고
			tgt[tgtIdx] = i;
			isSelected[i] = true; //사용중
			
			perm(tgtIdx+1);
			isSelected[i] = false;
		}	
	}
	
	//2. 넥퍼 (nPn)
	static boolean np() {
		dest = arr;
		
		int top = dest.length - 1;
		while (top > 0 && dest[top-1] >= dest[top]) top--;
		
		if (top == 0) return false;
		
		int pre = dest.length - 1;
		while (dest[top-1] >= dest[pre]) pre--;
		
		swap(dest, top-1, pre);
		
		int sw = dest.length - 1;
		while (top < sw) swap(dest, top++, sw--);
		
		return true;
	}
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	//3. 비트마스킹
	static void perm_bit(int cnt, int flag) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if ((flag & 1<<i) != 0) continue;
			tgt[cnt] = i;
			perm_bit(cnt+1, (flag|1<<i));
		}
	}
	
}

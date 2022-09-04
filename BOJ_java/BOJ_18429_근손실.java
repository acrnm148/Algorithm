package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {

	static int N, K, cnt;
	static int[] tgt, src;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tgt = new int[N];
		src = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			src[i] = Integer.parseInt(st.nextToken());
		//입력 끝
		
		perm(0);
		System.out.println(cnt);
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == N) {
			if (check()) cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue; //이미 방문했으면 넘김
			
			isSelected[i] = true;
			tgt[tgtIdx] = src[i];
			perm(tgtIdx + 1);
			isSelected[i] = false;
			
		}
	}
	
	static boolean check() { //500 넘는지 체크
		
		int day = 500;
		for (int i = 0; i < N; i++) {
			day += tgt[i] - K;
			if (day < 500) return false;
		}
		return true;
	}
	
}

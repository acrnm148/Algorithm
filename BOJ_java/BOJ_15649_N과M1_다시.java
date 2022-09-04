package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1_다시 {

	static int[] tgt;
	static boolean[] isSelected;
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N+1]; //자연수이므로
		tgt = new int[M];
		
		long start = System.nanoTime();
		perm(0);
		long end = System.nanoTime();
		System.out.println((end-start)*0.000_001+"ms");
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == M) { //순열 하나하나 완성 시
			for (int i = 0; i < M; i++) { //이거 M이 아니라 tgtIdx하면 시간초과 나옴 //M: 5.3468ms/tgtIdx:6.7759ms
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) { //넣는 값이 자연수이고, 인덱스를 자연수로 쓰기 때문
			
			if(isSelected[i]) continue;
			tgt[tgtIdx] = i;
			isSelected[i] = true;
			
			perm(tgtIdx + 1); //순열 자리 채우러
			isSelected[i] = false;
		}
		
	}
}

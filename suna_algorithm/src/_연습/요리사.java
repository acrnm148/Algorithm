package _연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사 {

	static int[] A, B;
	static int[][] sin;
	static boolean[] isSelected;
	static int N, M, min; //n=0:A음식 저장, 1:B음식 저장
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = N/2;
			
			//초기화
			min = Integer.MAX_VALUE;
			sin = new int[N][N];
			A = new int[M];
			B = new int[M];
			isSelected = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sin[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//1. N개 중 N/2개 뽑기 조합
			comb(0, 0);
			//2. N/2개 중 2개 뽑기 조합 ==> 필요없음
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//1. 기저조건 - tgt다뽑았을 때
		if (tgtIdx == A.length) {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) continue;
				B[idx++] = i; //반반씩 나눔
			}
			check();
			return;
		}
		//2. 기저조건 - src 다봤을 때
		if (srcIdx == N) return;
		
		//3. tgt에 src넣기
		A[tgtIdx] = srcIdx;
		
		//4. 선택이냐 선택아니냐
		isSelected[srcIdx] = true;
		comb(srcIdx + 1, tgtIdx + 1);
		isSelected[srcIdx] = false;
		comb(srcIdx + 1, tgtIdx);
	}
	
	static void check() {
		int Asum = 0;
		int Bsum = 0;
		
		//어차피 2개를 선택해서 모든 시너지의 합을 구하면 되는거니까 for문 2개면 충분하다.
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				Asum += sin[A[i]][A[j]]; //1-1, 2-2 되어도 상관없다. 어차피 0이니까
				Bsum += sin[B[i]][B[j]];
			}
		}
		min = Math.min(min, Math.abs(Asum - Bsum));
	}
	
}

















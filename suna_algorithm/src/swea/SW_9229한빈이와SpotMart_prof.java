package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 조합
 * N개 중에 K개 뽑는데, max 저장
 * */
public class SW_9229한빈이와SpotMart_prof {

	static int N, M, TC, ans; // 과자봉지N개, 최대무게, 테스트케이스, 과자1, 과자2
	static int[] src, tgt; // 마트의 과자들

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		// 탐색
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//초기화
			tgt = new int[2];
			src = new int[N];
			
			ans = -1;
			
			//입력처리
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				src[i] = Integer.parseInt(st.nextToken());
			
			//조합
			comb(0,0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) { //조합 함수
		// 기저조건 - tgt
		if (tgtIdx == 2) { //과자가 2개면
			//complete code
			int sum = tgt[0] + tgt[1];
			if (sum > M) return;
			ans = Math.max(ans, sum);
			return;
		}
		
		//기저조건 - src
		if (srcIdx == N) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		//재귀호출
		comb(srcIdx + 1, tgtIdx + 1); //현재 선택을 받아 들임
		comb(srcIdx + 1, tgtIdx);
	}
	
}

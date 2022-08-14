package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 조합 - for문
 * N개 중에 K개 뽑는데, max 저장
 * */
public class SW_9229한빈이와SpotMart_prof3 {

	static int N, M, TC, ans; // 과자봉지N개, 최대무게, 테스트케이스, 과자1, 과자2
	static int[] src1, src2; // 마트의 과자들

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		// 탐색
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//초기화
			src1 = new int[N];
			src2 = new int[N];
			
			ans = -1;
			
			//입력처리
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				src1[i] = Integer.parseInt(st.nextToken());
				src2[i] = Integer.parseInt(st.nextToken());
			}
			
//			// 위치가 중복될 경우에도 계산이 이루어짐. -> 당연 사각형을 보니까
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (i == j) continue; //대각선이면
//					if (src1[i] + src2[j] <= M && src1[i] + src2[j] > ans)
//						ans = src1[i] + src2[j]; //제일 큰 값 갱신
//				}
//			}
			// 중복 제외 -> 삼각형으로 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					int sum = src1[i] + src2[j];
					if (sum > M) continue;
					ans = Math.max(ans, sum);
				}
			}
			
			//조합
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	
}

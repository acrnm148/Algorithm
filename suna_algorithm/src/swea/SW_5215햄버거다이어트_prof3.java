package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 방법3 - 재귀호출, 파라미터, 가지치기, 이차원배열
 * 파라미터 
 * Item 대신 2차원배열
 * 부분집합x -> isSelected 필요 없다
 * */
public class SW_5215햄버거다이어트_prof3 {

	static int T, N, L, max;
	static int[][] src;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//초기화
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			//src : N개로 고정
			src = new int[N][2]; // 0: point, 1: cal
			
			// tgt -> 1개로, 2개로... N개로 재료 사용
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i][0] = Integer.parseInt(st.nextToken());
				src[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0); // 맨 앞 src부터 시작
			
			System.out.println("#" + t + " " + max);
			
		}

	}

	static void dfs(int srcIdx, int point, int cal) {
		//가지치기
		if (cal > L) return;
		
		//기저조건
		if (srcIdx == N) {
			max = Math.max(max, point);
			return;
		}
		
		dfs(srcIdx+1, point, cal); // 현재 srcIdx 재료를 선택X
		dfs(srcIdx+1, point+src[srcIdx][0], cal+src[srcIdx][1]); //재료를 선택한 경우
	} 
	
}




























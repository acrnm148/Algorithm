package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조합
 * 
 * */
public class SW_5215햄버거다이어트_조합 {

	static int T, N, limit, ans;
	static int[] cal, score;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			//1. 부분집합
			//subset(0);
			
			//2. 조합
			//comb();
			
			//3. 순열+조합
			perm(0, 0, 0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	
	//순열 + 조합
	static void perm(int cnt, int start, int total_cal, int total_score) {
		//1. 기저조건
		if (cnt == N) {
			ans = Math.max(ans, total_score); //왜 여기 쓰면 안됨?
			return;
		}
		
		//2. 시작지점부터 순회
		for (int i = start; i < N; i++) {
			//줄세우기
			if (isSelected[i]) continue;
			if (total_cal + cal[i] > limit) continue;
			
//			if (total_score + score[i] > ans)
//				ans = total_score + score[i];
			
			isSelected[i] = true;
			perm(cnt+1, i+1, total_cal+cal[i], total_score+score[i]);
			isSelected[i] = false;
		}
		
	}
}






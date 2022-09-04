package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 부분집합?
 * */
public class SW_5215햄버거다이어트 {

	static int T, N, L, ans, total_score, total_cal, maxScore;
	static int[] cal, score;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0; 
			total_score = 0; 
			total_cal = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			//부분집합
			subset(0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void subset(int i) {
		if (i == N) {
			for (int n = 0; n < N; n++) {
				if (isSelected[n]) total_cal += cal[n];
			}
			if (total_cal <= L) { //칼로리 이내일 때
				for (int n = 0; n < N; n++) {
					if (isSelected[n]) total_score += score[n];
				}
			}
			ans = Math.max(total_score, ans);
			total_cal = 0;
			total_score = 0;
			return;
		}
		
		isSelected[i] = true;
		subset(i+1);
		isSelected[i] = false;
		subset(i+1);
		
	}
}

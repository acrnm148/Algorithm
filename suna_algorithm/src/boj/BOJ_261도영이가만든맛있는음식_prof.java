package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 부분합
 * 신맛과 쓴맛의 차이를 최대한 작게
 * 신맛과 쓴맛의 합은 1_000_000_000 보다 작다
 * */
public class BOJ_261도영이가만든맛있는음식_prof {
	//static int sum_s = 1, sum_b = 0;
	static int[][] src;
	static int N; // 신맛과 쓴맛의 차이, 재료 개수
	static int min = 1_000_000_000;
	static boolean[] isSelected;
	static int flag;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			src[i][0] =  Integer.parseInt(st.nextToken());
			src[i][1] =  Integer.parseInt(st.nextToken());
		}
		
		//부분집합
		subset(0);
		
		System.out.println(min);
	}
	
	
	static void subset(int i) {
		if (i == N) {
			int sin = 1;
			int ssn = 0;
			int cnt = 0;
			for (int n = 0; n < N; n++) {
				if (isSelected[n]) {
					sin *= src[n][0];
					ssn += src[n][1];
					cnt++;
				}
			}
			if (cnt > 0) min = Math.min(min, Math.abs(ssn - sin));
			
			return;
		}
		
		isSelected[i] = true;
		subset(i + 1);
		isSelected[i] = false;
		subset(i + 1);
	}
	
	
	
}


















package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 부분합
 * 신맛과 쓴맛의 차이를 최대한 작게
 * 신맛과 쓴맛의 합은 1_000_000_000 보다 작다
 * */
public class BOJ_261도영이가만든맛있는음식 {
	//static int sum_s = 1, sum_b = 0;
	static int[] arr_s;
	static int[] arr_b;
	static int N; // 신맛과 쓴맛의 차이, 재료 개수
	static int min = 1_000_000_000;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr_s = new int[N];
		arr_b = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr_s[i] =  Integer.parseInt(st.nextToken());
			arr_b[i] =  Integer.parseInt(st.nextToken());
		}
		
		//부분집합
		//subset(0);
		
		//조합
		comb(0,0,1,0);
		
		System.out.println(min);
	}
	
	
	static void subset(int i) {
		if (i == N) {
			int sum_s = 1;
			int sum_b = 0;
			for (int n = 0; n < N; n++) {
				if (isSelected[n]) {
					sum_s *= arr_s[n];
					sum_b += arr_b[n];
				}
			}
			if (sum_s!= 0 && sum_b!= 0)min = Math.min(min, Math.abs(sum_s - sum_b));
			
			return;
		}
		
		isSelected[i] = true;
		subset(i + 1);
		isSelected[i] = false;
		subset(i + 1);
	}
	
	
	static void comb(int cnt, int start, int sum_s, int sum_b) {
		if (cnt == N) {
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (sum_s + sum_b >= 1_000_000_000) continue;
			
			min = Math.min(min, Math.abs(sum_s*arr_s[i] - (sum_b+arr_b[i]))); //이 조건
			
			comb(cnt+1, i+1, sum_s * arr_s[i], sum_b + arr_b[i]);
		}
	}
	
	
	
}


















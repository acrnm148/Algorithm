package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 바이너리카운팅으로 부분집합을 구해서 풀어라? 
 * 
 * */
public class BOJ_261도영이가만든맛있는음식2 {
	//static int sum_s = 1, sum_b = 0;
	static int[] arr_s;
	static int[] arr_b;
	static int N; // 신맛과 쓴맛의 차이, 재료 개수
	static int min = 1_000_000_000;
	static boolean[] isSelected;
	static int flag;
	
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
	
	//조합
	/*
	 * 조합에서는 isSelected를 쓰지도 않는데 비트연산자가 왜 필요해?
	 * */
	static void comb(int cnt, int start, int sum_s, int sum_b) {
		
		if (cnt == N) {
			return;
		}
		
		for (int i = 0; i < (1<<N); i++) {
			if (sum_s + sum_b >= 1_000_000_000) continue;
			
			min = Math.min(min, Math.abs(sum_s*arr_s[i] - (sum_b+arr_b[i])));
			
			comb(cnt+1, i+1, sum_s * arr_s[i], sum_b + arr_b[i]);
		}
		
		for (int j = 0; (1 << N) > j; ++j) {
			if (Integer.bitCount(j) == N) {
				for (int i = 0; i < 6; ++i) {
					if (((1 << i) & j) > 0) {
						System.out.print(i+ " ");
					}
				}
				System.out.println();
			}
		}
	}
	
	
}


















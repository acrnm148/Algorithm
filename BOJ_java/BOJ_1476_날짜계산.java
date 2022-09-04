package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {

	static int E, S, M, ans, sumE, sumS, sumM;
	static int[] year = {15, 28, 19};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check();
		
	}
	
	static void check() { //브루트포스라고 해서 반드시 재귀는 아니다.
		while (true) {
			int e = 1, s = 1, m = 1;
			int year = 1;
			while (true) {
				if (e == E && s == S && m == M) {
					System.out.println(year);
					return;
				}
				
				e++;
				s++;
				m++;
				
				if (e == 16) e = 1;
				if (s == 29) s = 1;
				if (m == 20) m = 1;
				year++;
			}
			
		}
	}
}

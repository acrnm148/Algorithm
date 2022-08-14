package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 순열
 * */
public class BOJ_2023신기한소수_new {
	
	static int N;
	static boolean[] isSelected;
	static int[] numbers;
	static StringBuilder sb;
	static String str = new String();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[10]; //0 dummy
		numbers = new int[N];
		
		perm(0);
	}
	
	//순열
	static void perm(int cnt) {
		//1. 기저조건
		if (cnt == N) {
			sb.append("\n");
			System.out.println(sb);
			check(str); //소수체크
			return;
		}
		
		//2. 시작점부터 끝까지 순회
		for (int i = 1; i <= 9; i++) {
			if (isSelected[i]) continue; //다른 수로 넘긴다
			str += i;
			isSelected[i] = true; //사용이 안됐으면 방문기록 먼저 남김
			perm(cnt+1); //다음 자리로 넘어감
			isSelected[i] = false;
		}
	}
	
	static void check(String str) {
		//1. 조건 : 소수인가?
		 System.out.println(str);
		
	}
	
	static boolean isPrime(int num) {
		if (num < 10) {
			if (!(num == 2 || num == 3 || num == 5 || num == 7))
				return false;
		}
		int sqrt = (int)Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}

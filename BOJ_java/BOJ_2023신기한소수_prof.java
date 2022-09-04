package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2023신기한소수_prof {

	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// search(idx, num);
		// 어차피 맨 앞자리가 소수가 아니면 출발 X <= 2, 3, 5, 7
		search(1, 2);
		search(1, 3);
		search(1, 5);
		search(1, 7);
		
		System.out.println(sb.toString());
	}
	
	// idx : 자리수
	// 현재 자리수의 수가 소수이면 다음 자리수로 재귀호출
	// 다음자리수는 선택해서 진행 (1, 3, 7, 9) <= 짝수와 5 제외 - 짝수와 5는 무조건 나눠짐
	static void search(int idx, int num) {
		//기저조건
		if (idx == N) {
			// complete code
			sb.append(num).append("\n");
			return;
		}
		//소수인지 따져보고 맞으면 재귀 호출
		// 2 다음자리 1을 따지기 위해 21을 만드는건 2를 문자열로 바꾼 뒤 + 1 (문자열) -> 다시 숫자로 변환
		
		//1
		int nextNum = Integer.parseInt(String.valueOf(num) + 1); //int to String
		if (isPrime(nextNum)) search(idx+1, nextNum);
		//3
		nextNum = Integer.parseInt(String.valueOf(num) + 3); //int to String
		if (isPrime(nextNum)) search(idx+1, nextNum);
		//7
		nextNum = Integer.parseInt(String.valueOf(num) + 7); //int to String
		if (isPrime(nextNum)) search(idx+1, nextNum);
		//9
		nextNum = Integer.parseInt(String.valueOf(num) + 9); //int to String
		if (isPrime(nextNum)) search(idx+1, nextNum);
	}
	
	// 개선된 소수 판별법
	static boolean isPrime(int num) {
		if (num == 1) return false;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1289원재의메모리복구하기_prof2 {
	
	//Scanner -> BufferedReader
	//local변수 중 주요 변수를 static으로 선언
	//char를 int로 변환할 때 int[] -> char[] 로 변환
	//String toCharArray()
	
	static int T, cnt;
	static char[] input, memory;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			
			//입력부
			input = br.readLine().toCharArray(); //return이 String임
			//배열을 새로 생성해서 return
			
			//두개의 배열
			//1. inputArray 2.memArray
			int len = input.length;
			memory = new char[len];
			
			for (int i = 0; i < len; i++) {
				memory[i] = '0';
			}
			
			
			// 값 비교
			for (int i = 0; i < len; i++) {
				//두 값의 차이가 있을 때 비교를 해야한다
				if (memory[i] != input[i]) {
					for (int j = i; j < len; j++) {
						memory[j] = input[i];
					}
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
			
		}
	}

}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1289원재의메모리복구하기_prof3 {
	
	//Scanner -> BufferedReader
	//local변수 중 주요 변수를 static으로 선언
	//char를 int로 변환할 때 int[] -> char[] 로 변환
	//String toCharArray()
	
	static int T, cnt;
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			
			//입력부
			input = br.readLine().toCharArray(); //return이 String임

			//현재문자
			char current = '0'; // 0으로 초기화가 되었으니까
			
			int len = input.length;
			
			// 현재값과 input[i]를 비교해서 다르면 변경횟수가 증가
			for (int i = 0; i < len; i++) {
				if (input[i] != current)
					cnt++;
				current = input[i]; //항상 갱신
			}
			System.out.println("#" + t + " " + cnt);
			
		}
	}

}

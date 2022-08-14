package swea;

import java.io.IOException;
import java.util.Scanner;

public class SW_1289원재의메모리복구하기_prof1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 개행을 썼으면 nextLine() 해줘야한다
		sc.nextLine(); // 개행문자 해소. 깔끔하게 지워지고 다시 읽을 수 있음 ==> Scanner 별로다
		
		for (int t = 1; t <= T; t++) {
			
			int cnt = 0; //변경 횟수
			
			//입력부
			String str = sc.nextLine(); //개행문자까지
			//두개의 배열
			//1. inputArray 2.memArray
			int len = str.length();
			int[] inputArray = new int[len];
			int[] memArray = new int[len];
			
			for (int i = 0; i < len; i++) {
				inputArray[i] = str.charAt(i) - '0';
			}
			
			
			// 값 비교
			for (int i = 0; i < len; i++) {
				//두 값의 차이가 있을 때 비교를 해야한다
				if (memArray[i] != inputArray[i]) {
					for (int j = i; j < len; j++) {
						memArray[j] = inputArray[i];
					}
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
			
		}
	}

}

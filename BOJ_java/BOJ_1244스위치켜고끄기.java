package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력을 받으면서 처리할 수 있는 문제는 반드시 그렇게 처리 ( 입력을 위한 자료구조를 만들 필요 X )
public class BOJ_1244스위치켜고끄기 {

	
	static int N, COUNT;
	static int[] switches;  // 스위치배열
	static int gender, num; // 남여, 부여받은 숫자 <= local 선언해도 무방
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new int[N + 1]; // 0 dummy, 문제의 번호가 1부터 시작
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		COUNT = Integer.parseInt(br.readLine());
		for (int i = 0; i < COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken()); //현재 성별
			num = Integer.parseInt(st.nextToken());	   //현재 받은 번호
			
			if (gender == 1) {
				male();
			} else if (gender == 2) {
				female();
			}
		}
		
		//결과출력
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i]);
			if (i != N) {
				if (i % 20 == 0) {
					System.out.println();
				}
				else {
					System.out.print(" ");
				}
			}
		}
		
	}
	
	// 자기가 받은 번호의 배수를 바꿔야한다.
	// 1 2 3 4 5 6 7 8 
	// num == 3
	static void male() {
//		for (int i = 1; i <= N; i++) {
//			if (i % num == 0) { //스위치 번호가 N의 배수이면
//				switches[i] = switches[i] == 0? 1 : 0; //삼항연산자
//			}
//		}
		
		// new
		for (int i = num; i <= N; i +=num) { // 첫번째 이득 - 배수 인덱스만 찾아 간다
			// if 비교 X 두 번째 이득
			switches[i] = switches[i] == 0? 1 : 0; //삼항연산자
		}
	}
	
	static void female() {
		//자신이 받은 번호의 스위치를 우선 변경
		//자신 좌우 대칭인 것을 찾아 변경
		switches[num] = switches[num] == 0? 1:0;
		
		//before
//		int cnt = 1;
//		while (num - cnt >= 1 && num + cnt <= N) { //같으면
//			if (switches[num-cnt] == switches[num+cnt]) {
//				switches[num-cnt] = switches[num-cnt] == 0? 1:0;
//				switches[num+cnt] = switches[num+cnt] == 0? 1:0;
//			} else { //다르면
//				break;
//			}
//			cnt++;
//		}
		
		int left = num - 1;
		int right = num + 1;
		while (left >= 1 && right <= N) { //같으면
			if (switches[left] == switches[right]) {
				switches[left] = switches[left] == 0? 1:0;
				switches[right] = switches[left];
				
				//이렇게도 한다
				//switches[right] = switches[left] = switches[left] == 0? 1:0;
				
			} else { //다르면
				break;
			}
			left--;
			right++;
		}
	}

}

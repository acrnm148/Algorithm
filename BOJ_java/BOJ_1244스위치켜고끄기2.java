package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입력을 받으면서 처리할 수 있는 문제는 반드시 그렇게 처리 ( 입력을 위한 자료구조를 만들 필요 X )
// switches : int -> boolean
// 0, 1 값 바꿔주는 코드를 줄이는데 초점
public class BOJ_1244스위치켜고끄기2 {

	
	static int N, COUNT;
	static boolean[] switches;  // 스위치배열
	static int gender, num; // 남여, 부여받은 숫자 <= local 선언해도 무방
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N + 1]; // 0 dummy, 문제의 번호가 1부터 시작
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			if (switches[i] = st.nextToken().equals("1"))
				switches[i] = true; //else 0일 때는 필요 없다. boolean의 디폴트는 false이기 때문
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
			System.out.print(switches[i]? 1 : 0); //boolean타입 출력 그대로 하면 true, flase로 나옴
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
	

	static void male() {
		for (int i = num; i <= N; i +=num) { 
			switches[i] = !switches[i]; //삼항연산자 따질 필요없이 자기자신 반대를 넣어주면 된다
		}
	}
	
	static void female() {
		switches[num] = !switches[num];
		int left = num - 1;
		int right = num + 1;
		while (left >= 1 && right <= N) { //같으면
			if (switches[left] == switches[right]) {
				switches[left] = !switches[left];
				switches[right] = switches[left];
				
				//이렇게도 한다
				//switches[right] = switches[left] = !switches[left];
				
			} else { //다르면
				break;
			}
			left--;
			right++;
		}
	}

}

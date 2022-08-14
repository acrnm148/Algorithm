package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * binary counting <= 본질적으로 부분집합으로 문제를 푸는 방식
 * 부분집합 원소 하나를 선택 / 비선택 용도 -> boolean isSelected[]
 * boolean === bit (0,1) 동일한 성격
 * */
public class BOJ_261도영이가만든맛있는음식_prof3 {
	static int[][] src;
	static int N; // 신맛과 쓴맛의 차이, 재료 개수
	static int min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			src[i][0] =  Integer.parseInt(st.nextToken());
			src[i][1] =  Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;

		// 모든 부분집합의 경우의 수
		// 4개 2 x 2 x 2 x 2 = 2^4 = 16
		// 1 << 4
		// 00000001 => 00010000
		//                 8421
		
		// i == 0 //     0 0 0 0 0 0 0 0 0
		//        //               x x x x
		// i == 3 //     0 0 0 0 0 0 0 1 1
		//        //               x x O O
		// i == 8 //     0 0 0 0 0 1 0 0 0
		//        //               O x x x
		// i ==15 //     0 0 0 0 0 1 1 1 1
		//        //               O O O O
		//========================================================
		int count = 1 << N; // N개의 원소를 가지는 부분집합의 수
		
		for (int i = 1; i < count; i++) { //모든 부분집합에 대해서  //재료는 한가지 이상 선택하므로 1부터 출발
			// 각각의 부분집합에서 어떤 원소가 선택/비선택 되었는지 확인
			// i가 select 역할을 한다. 단순한 count변수가 아님
			int sin = 1;
			int ssn = 0;
			
			//현재 부분집합 중 선택된 재료 파악
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) != 0) { // i와 비교해보니 0이 아니다 => j가 존재한다, j가 선택되었다
					sin *= src[j][0];
					ssn += src[j][1];
				}
			}
			min = Math.min(min, Math.abs(sin - ssn));
		}
		System.out.println(min);
		System.out.println("비트 테스트 : " + (1&10));
		//========================================================
	}
	
}


















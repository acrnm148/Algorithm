package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 배열
 * */
public class BOJ_1158요세푸스문제 {

	static int N, K; // 1번~N번, K번째 제거
	static Deque<Integer> deque = new ArrayDeque<>();
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder(); // 빌더 쓰겠다

		arr = new int[N + 1]; // 0 based
		for (int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}
		// 탐색
		sb.append("<");
		int target = K;
		// 1. K번째 없애고 시작, 없애기 전 빌더에 담음
		sb.append(arr[target]).append(", ");
		arr[target] = 0; // 0은 dummy

		// 2. 인덱스 설정 - arr[target] != 0 인 target만 idx로 침
		int idx = 0; //계속 target++되는데, arr[target] != 0 일 때만 idx++ 이 됨.
		int cnt = 1; //arr[target] == 0이 될 때 cnt++, cnt==K가 되면 무한루프 종료
		
		while (cnt < N) {
			target++; //계속 다음 녀석 탐색해야함
			if (target > N) target = 1;
			
			if (arr[target] != 0) {
				idx++; // 안죽은 애 지나가면 idx++
				if (idx % K == 0) { // idx가 K만큼 이동했을 때 //idx++이 이 조건 뒤에 와야함 idx++안되면 영원히 나누어떨어짐
					sb.append(arr[target]).append(", "); // 빌더에 넣어줌
					arr[target] = 0; // 죽임
					cnt++; // N될 때까지 증가
				}
			}
		}
		sb.setLength(sb.length() - 2); //스트링빌더 파라미터 수 만큼 길이를 잘라주는 메소드
		sb.append(">");
		
		System.out.println(sb);
	}
}

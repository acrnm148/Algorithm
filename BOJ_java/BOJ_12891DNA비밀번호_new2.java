package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 슬라이딩윈도우 + 덱 (슬라이딩윈도우의 윈도우를 덱에 담은것 뿐)
 * 1) 기존꺼는 맨 처음에 검사해서 상태 미리 저장
 * 2) 앞, 뒤 값만 확인해줌으로써 불필요한 반복 없앤다
 * 탐색 시작점을 전체에서 부분길이 뺀 지점으로 지정, (탐색 시작점 = 전체 - 부분)을 기준으로 탐색
 * 본인 - 부분길이 = 이전 부분 시작점
 * 본인 = 새로운 부분 끝점
 * 시간: 0.3388 ms
 * */
public class BOJ_12891DNA비밀번호_new2 {

	static char[] arr; // DNA 배열
	static int entire, part, Amax, Cmax, Gmax, Tmax, Acnt, Ccnt, Gcnt, Tcnt, ans; // 전체길이, 부분길이, A, C, G, T, / A개수, C개수,
																					// G개수, T개수
	static Deque<Character> deque = new ArrayDeque<>();	//알파벳 넣어줄 덱

	public static void main(String[] args) throws Exception {
		// 입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		entire = Integer.parseInt(st.nextToken()); // 전체 길이
		part = Integer.parseInt(st.nextToken()); // 부분 길이
		arr = br.readLine().toCharArray(); // .toCharArray():메모리 할당까지 됨

		st = new StringTokenizer(br.readLine());
		Amax = Integer.parseInt(st.nextToken());
		Cmax = Integer.parseInt(st.nextToken());
		Gmax = Integer.parseInt(st.nextToken());
		Tmax = Integer.parseInt(st.nextToken());
		char front, last;

		// 탐색 - 슬라이딩윈도우처럼, 덱으로 풀어봄
		long start = System.nanoTime(); //시간 add
		//첫 상태 저장
		for (int i = 0; i < part; i++) {		//첫 녀석들은 덱에 넣어줌, 각각 카운트 올려줌
			deque.offer(arr[i]);	//덱에 첫 녀석들 넣어줌
			last = deque.peekLast();
			if (last == 'A') Acnt++;
			else if (last == 'C') Ccnt++;
			else if (last == 'G') Gcnt++;
			else if (last == 'T') Tcnt++;
		}
		check();	//검사
		for (int i = part; i < entire; i++) {	//나머지녀석들을 마지막녀석으로 치고 검사
			//앞에 녀석 빼주고 - 카운트 원위치
			front = deque.pollFirst();	//덱에서 앞에 애 빼주고 원위치
			if (front == 'A') Acnt--;
			else if (front == 'C') Ccnt--;
			else if (front == 'G') Gcnt--;
			else if (front == 'T') Tcnt--;
			//뒤에 녀석 추가하고 - 카운트 추가
			deque.offer(arr[i]);	//덱에 첫 녀석들 넣어줌
			last = deque.peekLast();
			if (last == 'A') Acnt++;
			else if (last == 'C') Ccnt++;
			else if (last == 'G') Gcnt++;
			else if (last == 'T') Tcnt++;
			check();	//검사 - 자리 바뀔 때마다 검사해야하니까 - for문 안에 있어야지
		}
		long end = System.nanoTime(); //시간 add
		System.out.println("시간: "+ (end-start)*0.000_001 + " ms"); //시간 add
		System.out.println(ans);
	}

	static void check() {
		if (Acnt>=Amax &&Ccnt>=Cmax &&Gcnt>=Gmax &&Tcnt>=Tmax) //최소개수다 강수나야...
			ans++;
		System.out.println(Acnt + " "+Ccnt + " "+Gcnt + " "+Tcnt + " ");
	}
}

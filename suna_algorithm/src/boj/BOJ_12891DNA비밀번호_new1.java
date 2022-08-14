package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 슬라이딩윈도우
 * 1) 기존꺼는 맨 처음에 검사해서 상태 미리 저장
 * 2) 앞, 뒤 값만 확인해줌으로써 불필요한 반복 없앤다
 * 탐색 시작점을 전체에서 부분길이 뺀 지점으로 지정, (탐색 시작점 = 전체 - 부분)을 기준으로 탐색
 * 본인 - 부분길이 = 이전 부분 시작점
 * 본인 = 새로운 부분 끝점
 * 시간 : 0.0121 ms
 * */
public class BOJ_12891DNA비밀번호_new1 {

	static char[] arr;	//DNA 배열
	static int entire, part, Amax, Cmax, Gmax, Tmax, Acnt, Ccnt, Gcnt, Tcnt, ans;	
			 //전체길이, 부분길이, A최소개수, C최소개수, G최소개수, T최소개수, / A개수, C개수, G개수, T개수
	public static void main(String[] args) throws Exception{
		//입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		entire = Integer.parseInt(st.nextToken());	//전체 길이
		part = Integer.parseInt(st.nextToken());	//부분 길이
		arr = br.readLine().toCharArray(); 			//.toCharArray():메모리 할당까지 됨
		
		st = new StringTokenizer(br.readLine());
		Amax = Integer.parseInt(st.nextToken());
		Cmax = Integer.parseInt(st.nextToken());
		Gmax = Integer.parseInt(st.nextToken());
		Tmax = Integer.parseInt(st.nextToken());
		
		//탐색 - 슬라이딩윈도우
		long start = System.nanoTime(); //시간 add
		//1. 맨 처음 상태 저장
		for (int i = 0; i < part; i++) {
			switch (arr[i]) {
			case 'A' : Acnt++; break;
			case 'C' : Ccnt++; break;
			case 'G' : Gcnt++; break;
			case 'T' : Tcnt++; break;
			}
		}
		check(); //처음 상태 넣어주고도 확인해줘야함 - 처음에 발견될 수도 있기때문
		//2. 탐색 시작
		for (int i = part; i < entire; i++) {	//i는 끝점이 된다 => 인덱스 넘어갈 일도 없음
			switch (arr[i - part]) { //시작점
			case 'A' : Acnt--; break;
			case 'C' : Ccnt--; break;
			case 'G' : Gcnt--; break;
			case 'T' : Tcnt--; break;
			}
			switch (arr[i]) {	//본인==끝점
			case 'A' : Acnt++; break;
			case 'C' : Ccnt++; break;
			case 'G' : Gcnt++; break;
			case 'T' : Tcnt++; break;
			}
			check();
		}
		long end = System.nanoTime(); //시간 add
		System.out.println("시간: "+ (end-start)*0.000_001 + " ms"); //시간 add
		System.out.println(ans);
	}
	static void check() {
		if (Acnt>=Amax &&Ccnt>=Cmax &&Gcnt>=Gmax &&Tcnt>=Tmax) ans++;
	}

}

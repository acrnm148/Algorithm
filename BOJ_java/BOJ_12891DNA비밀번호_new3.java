package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 알파벳 배열
 * 1) 앞, 뒤만 검사하는건 똑같다
 * 2) DNA 처음부터 반복문 돌면서 맨 앞녀석/맨 뒤녀석 확인 => 슬라이딩윈도우와 동일
 * 3) (알파벳-'A') 인덱스에 개수 카운트
 * 
 * 주의 : {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어짐
 * 몇번 이상!! 최소개수가 주어짐
 * 시간:0.0091 ms
 * */
public class BOJ_12891DNA비밀번호_new3 {
	
	static int entire, part, Acnt, Ccnt, Gcnt, Tcnt, Amin, Cmin, Gmin, Tmin, ans;
	static char[] dna;
	static int[] alpha = new int[20]; //T는 20번째 알파벳, 인덱스 19
	public static void main(String[] args) throws Exception{
		//입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		entire = Integer.parseInt(st.nextToken());
		part = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();	//.toCharArray하면 객체 생성안해줘도 된다
		st = new StringTokenizer(br.readLine());
		Amin = Integer.parseInt(st.nextToken());
		Cmin = Integer.parseInt(st.nextToken());
		Gmin = Integer.parseInt(st.nextToken());
		Tmin = Integer.parseInt(st.nextToken());
		
		//탐색
		long start = System.nanoTime(); //시간  add
		for (int i = 0; i < part; i++) alpha[dna[i]-'A']++;//맨 처음 멤버들은 다 더해줘야 한다
		check(); //시작검사!!!
		for (int i = part; i < entire; i++) {
			alpha[dna[i - part] - 'A']--;	//끝점 i + part - 1좌표
			alpha[dna[i] - 'A']++; 				//끝점 i좌표
			check();	//만족하는지 검사
		}
		long end = System.nanoTime(); //시간  add
		System.out.println("시간:"+(end-start)*0.000_001 +" ms");
		System.out.println(ans);
	}
	static void check() {
		if (alpha[0] >= Amin && alpha[2] >= Cmin && alpha[6] >= Gmin && alpha[19] >= Tmin) ans++; //A:0, C:2, G:6, T:19
		
	}
}

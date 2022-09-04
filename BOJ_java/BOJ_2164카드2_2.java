package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 덱
 * poll() : 맨 앞 리턴하고 삭제
 * offer()/add() : 맨 뒤에 추가 
 * size() : 덱 사이즈
 * peek() : 맨 앞 리턴(삭제x)
 * pop() : 맨 앞 삭제(리턴x)
 * addFirst()/offerFirst() : 맨 앞에 추가
 * 
 * 시간비교
 * 덱: 0.032799999999999996 ms
 * 큐: 0.0185 ms
 * 덱보다 큐가 빠른데..? 덱 왜 씀 
 * - 빠르고 말고의 문제가 아니라 덱은 앞 뒤로 넣고빼고가 편함
 * - 스택, 큐 문제는 전부 덱으로 퉁쳐라 그냥
 * */
public class BOJ_2164카드2_2 {
	
	static int N, front;
	static Deque<Integer> deque = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		//입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			deque.offer(i); //1~N까지 순서대로 덱에 넣어줌
		}
		long start = System.nanoTime(); //시간 add
		while (deque.size() > 1) { 		//한장 남으면 break; - N=1이면 들어가지도 않음
			deque.poll();				//1. 맨 위 버림 poll
			deque.offer(deque.poll());	//2. 맨위 => 맨 아래 poll => offer
		}
		long end = System.nanoTime(); //시간 add
		System.out.println("시간 : " + (end-start)*0.000_001+" ms");
		System.out.println(deque.poll()); //제일 위에 녀석 리턴하고 큐에서 삭제
	}
}

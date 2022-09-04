package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BOJ_2164카드2_prof {
	
	static Deque<Integer> deque = new ArrayDeque<>();
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in))	;
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		int res = 0;
		//task
		while (deque.size() > 1) {
			deque.remove();
			deque.add(deque.remove());
		}
		System.out.println(deque.getLast());
	}

}

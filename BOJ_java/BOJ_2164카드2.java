package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2164카드2 {
	
	static Queue<Integer> queue = new ArrayDeque<>();
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in))	;
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int res = 0;
		//task
		while (queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(res);
	}

}

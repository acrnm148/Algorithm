package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225암호생성기 {

	static Queue<Integer> queue = new ArrayDeque<>();
	static int[] arr;
	static int front, end;
	static int num;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			if (!queue.isEmpty()) queue.clear();
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			//task();
			num = 0;
			while (true) {
				front = queue.poll() - (num % 5 + 1);
				if (front <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(front);
				num++;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
	
	static void task() {
		int front = 0;
		for (int i = 1; i <= 5; i++) {
			front = queue.poll();
			front -= i;
			if (front <= 0) {
				front = 0;
				queue.add(front);
				//return;
				break;
			}
			queue.add(front);
		}
		if (front == 0) return;
		task();
	}

}

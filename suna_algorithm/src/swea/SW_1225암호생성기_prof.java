package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225암호생성기_prof {

	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String tc = br.readLine();
			if (tc == null || tc.length() == 0) break;
			
			//초기화
			queue.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			//처리
			make();
			
			System.out.print("#" + tc + " ");
			for (int num : queue) { //인덱스가 없으니까 forEach로 접근
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	static void make() {
		int num = 0;
		while (true) {
			// 1 cycle
			for (int i = 1; i <= 5; i++) {
				num = queue.poll() - i;
				if (num <= 0) {
					queue.offer(0);
					return;
				}
				
				queue.offer(num);
			}
		}
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493탑 {

	static Stack<int[]> stack = new Stack();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pre = 0;
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (i == 0) pre = num;
			
			//왼쪽으로 while 돌면서 탑 있으면 그 탑 번호 저장, 없으면 0
			
			//스택이 비지 않았을 때
			while (!stack.isEmpty()) {
				if (stack.peek()[1] > num) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			//스택이 비었을 때
			if (stack.isEmpty())
				System.out.print(0 + " ");
			
			//스택에 넣기
			stack.push(new int[] {i,num});
		}
	}
}

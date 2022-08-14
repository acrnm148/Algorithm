package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//스택을 쓰는데, 자료형은 int 배열
//Scanner쓰면 바로 메모리초과
//BufferedReader vs Scanner
//StringBuilder를 쓰냐 안쓰냐
public class BOJ_2493탑_prof {

	static int N;
	static Deque<int[]> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder(); //출력하는 녀석
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			//도장깨기 (나보다 큰 놈 있으면 나와봐~~~) 스택 뒤지기
			while (!stack.isEmpty()) {
				//나보다 큰 수가 있으면 꾸벅 하고 큰 수의 인덱스를 sb에 더하고 while 끝
				if (stack.peek()[1] >= height) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
				//나보다 작은 수를 만나면 꺼져!!!! 스택에서 제거 <===중요!!
			}
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i, height});
		}
		
		System.out.println(sb.toString());
	}
	
}

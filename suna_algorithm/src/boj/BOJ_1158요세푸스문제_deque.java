package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* 큐로 푸는게 훨씬 쉽다....
 * 큐
 * 하나씩 맨 앞에 애를 꺼냈다가 아니면 뒤에 다시 넣어주고
 * 조건에 맞으면 pop해서 죽임
 * 큐가 빌 때까지
 * */
public class BOJ_1158요세푸스문제_deque {
	
	static int N, K, front;
	static Deque <Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		//탐색
		sb.append("<");
		int idx = 0;
		while (!queue.isEmpty()) { //큐가 비지 않았을 때만
			idx++;
			front = queue.poll(); //맨 앞에 애 뺐다
			if (idx % K != 0) queue.add(front);
			else sb.append(front).append(", ");
		}
		
		sb.setLength(sb.length()-2); //스트링빌더 길이 자르기 setLength()
		sb.append(">");
		System.out.println(sb);
	}
}

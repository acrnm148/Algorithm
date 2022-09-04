package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 우선순위큐 - 힙 사용
 * */
public class BOJ_11268절대값힙 {

	static int N;
	//integer 를  natural ordering순(오름차순) => 하려면 재정의해야함. 람다식으로 해줌
	static PriorityQueue<Integer> pqueue 
	= new PriorityQueue<>( (n1, n2) -> Math.abs(n1)==Math.abs(n2)? n1-n2 :  Math.abs(n1) - Math.abs(n2) ); 
																			//앞에 꺼의 작은 값이 나온다.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num==0) { // 꺼내서 출력, 없으면 null 0출력
				Integer min = pqueue.poll();
				System.out.println(min == null? 0 : min); //poll() 은 큐가 비었을 때 null 리턴
				
			}else {
				pqueue.offer(num);
			}
		}
		
	}

}

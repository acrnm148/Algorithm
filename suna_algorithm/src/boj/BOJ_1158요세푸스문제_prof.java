package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 배열
 * */
public class BOJ_1158요세푸스문제_prof {

	static int N, K;
	static int[] input;
	static StringBuilder sb = new StringBuilder(); //빌더 쓰겠다
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N+1]; // 0 dummy
		for (int i = 1; i <= N; i++) {
			input[i] = i;
		}
		
		//변수들
		int count = 0;	//죽은사람이 결정되면 하나씩 증가 => 모두 죽으면 count == N 종료
		int idx = 1;	//순회하는 idx
		int step = 1;	//1부터 증가, 살아있는 사람만 계산
		
		while (true) {
			//기저 조건
			if (count == N) break;
			
			int newIdx = idx % N;
			if (input[idx] != 0) {	//살아 있는
				if (step % K == 0) {//살아 있는 사람 중에 K번째
					 sb.append(input[idx]).append(", ");
					 input[idx] = 0;
					 count++;
				}
				step++;
			}
			idx++;
			//if (idx > N) idx = 1;
		}
		
		//출력 정리
		sb.setLength(sb.length() - 2); //파라미터 길이만큼 잘
		sb.append(">");
		System.out.println(sb.toString());
	}

}

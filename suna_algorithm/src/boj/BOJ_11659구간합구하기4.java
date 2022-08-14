package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659구간합구하기4 {

	static int start, end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		StringBuilder builder = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[0] = 0;
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken()); // 넣을 때 누적합을 넣어주고
			//arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			int sum = 0;
			//System.out.println(arr[end] - arr[start - 1]); //제출할 땐 값 차이만 제출
			builder.append(arr[end] - arr[start - 1]).append("\n");
		}
		System.out.println(builder);
	}

}
//스트링빌더 쓰니까 1.4초 -> 0.6초
package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//accu (누적합)
public class BOJ_11659구간합구하기4_prof {
	
	static int N, M;
	static int[] accu;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		accu = new int[N + 1]; // 0 dummy
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			accu[i] = Integer.parseInt(st.nextToken()) + accu[i - 1]; //memoization
		}
		
		//M개의 구간합
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			// 2개
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//System.out.println(accu[to] - accu[from - 1]);
			sb.append(accu[to] - accu[from - 1]).append("\n");
		}
		System.out.println(sb);
	}

}
//스트링빌더 쓰니까 1.4초 -> 0.6초
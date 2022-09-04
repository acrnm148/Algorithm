package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * subset
 * */
public class BOJ_1182_부분수열의합 {

	static int N, S, ans;
	static boolean[] isSelected;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //N개의 정수 중
		S = Integer.parseInt(st.nextToken()); //합
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N]; //인덱스 개수
		
		//subset(0);
		subset_bit();
		
		System.out.println(ans);
	}
	
	static void subset(int srcIdx) { //O(2^n) => 기하급수적으로 증가, n>10일 경우 연산 시 시간초과 : 1초 1억번
		if (srcIdx == N) { //공집합 제외!!
			int sum = 0;
			int cnt = 0; // 공집합 제외하려고
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum+= arr[i];
					cnt = 1; //공집합이 아님
				}
			}
			if (sum == S && cnt != 0) ans++;
			return;
		}
		
		isSelected[srcIdx] = true;
		subset(srcIdx + 1);
		isSelected[srcIdx] = false;
		subset(srcIdx + 1);
		
		
	}
	
	//비트마스킹 : n > 10
	static void subset_bit() { //O(n2)
		
		int sum = 0;
		int count = 1 << N; //flag
		for (int i = 1; i < count; i++ ) { //i는 부분집합의 개수. 0:공집합 //여기서는 공집합X
			sum = 0;
			for (int j = 0; j < N; j++) {
				if (((1<<j) & i) != 0) { //존재한다
					sum += arr[j];
				}
			}
			if (sum == S) ans++;
		}
	}
}










package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 순열
 * */
public class BOJ_10974모든순열 {

	static int N;
	static int[] num;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N+1]; //N을 포함하기 위해 N+1
		num = new int[N]; //N자리
		perm(0);
	}
	
	static void perm(int cnt) {
		//1. 기저조건
		if (cnt == N) { //N자리 다채우고 N+1자리까지 넘어왔으면 return
			for (int i = 0; i < N; i++)
				System.out.print(num[i] + " ");
			System.out.println();
			return;
		}
		
		//2. 순회
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue; //이미 방문했으면 다른 수
			num[cnt] = i;
			isSelected[i] = true; //방문완료
			perm(cnt+1); //다음자리 채워주러감
			isSelected[i] = false;
		}
	}
}

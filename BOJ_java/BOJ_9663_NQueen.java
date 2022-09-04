package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 순열 + 가지치기
 * N이 15인 것 자체가 순열로 풀 수 없는 문제
 * 순열로 풀어야 한다면 가지치기로 전부 보지 않고 풀기
 * 
 * 순열 다 만들고 N!번 검사 => N! * N!
 * 순열 만드는 과정에서 => N! * N!보다 훨씬 줄어듦
 * */
public class BOJ_9663_NQueen {

	static int N, ans;
	static int[] chess;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		isSelected = new boolean[N];
		
		perm(0);
		System.out.println(ans);
	}
	
	static void perm(int idx) {
		if (idx == N) {
			ans++; 
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			chess[idx] = i;
			
			/*
			//넣으면서 검사하기 (가지치기)
			if (!check(idx)) { //false라면 isSelected 다시 돌려줌
				isSelected[i] = false;
				continue;//대각선 체크
			}
			perm(idx + 1);
			*/
			if (check2(idx)) //true일 때만 perm 돌아라
				perm(idx + 1);
			
			isSelected[i] = false; //백트래킹
		}
	}
	
	static boolean check2(int row) {//윗줄 대각선 공식
		
		for (int i = row-1; i >= 0; i--) {
			if (row - i == Math.abs(chess[row] - chess[i])) { 
				return false;
			}
		}
		return true;
	}
	
	static boolean check(int row) { //윗줄 일일이 좌표 검사
		int ny = 0;
		int nx1 = 0; //오른쪽 대각선
		int nx2 = 0; //왼쪽 대각선
		for (int i = row; i >= 1; i--) {
			ny = i - 1;
			nx1 = chess[i] + 1;
			nx2 = chess[i] - 1;
			while (ny >= 0) {
				if (chess[ny] == nx1 || chess[ny] == nx2) return false;
				ny--;
				nx1++;
				nx2--;
			}
		}
		return true;
	}
	
}

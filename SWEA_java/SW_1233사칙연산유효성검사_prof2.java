package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DFS.
 * 리프노드가 숫자여야함
 * */
public class SW_1233사칙연산유효성검사_prof2 {
	
	static int N, ans;
	static char[] node;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			
			for (int i = 1; i <= N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}

			ans = dfs(1)? 1:0; // true면 유효X, 계속 false면 유효
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static boolean dfs(int x) { //x : index
		if (x > N) { //기저조건
			return false; // 범위
		}
		
		//1. 현재노드가 문자인지 따져봤을 때, 숫자라면. 자식노드가 없어야함 
		if (Character.isDigit(node[x])) {
			if (x*2 > N) return true; // 숫잔데 자식도 없다? true 자식은 왼쪽부터~
			return false;
		} else { //현재 인덱스 노드가 연산자라면
			return dfs(x*2) && dfs(x*2+1);
		}
	}
}

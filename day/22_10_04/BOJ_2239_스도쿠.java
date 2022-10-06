package a22_10_04;

import java.util.*;
import java.io.*;

public class BOJ_2239_스도쿠 {

	static int[][] map;
	static boolean end;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		dfs(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void dfs(int depth) {
		if (depth == 81) {
			end = true;
			return;
		}
		
		int y = depth/9;
		int x = depth%9;
		
		if (map[y][x] != 0) {
			dfs( depth+1 );
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!isValid(y, x, i)) continue;
				map[y][x] = i;
				dfs( depth+1 );
				
				//dfs가 끝나고
				if (end) return;
				map[y][x] = 0; //1~9사이에 값이 무조건 존재하므로 절대 0넣은 채로 끝까지 가지 않는다.
			}
		}
	}
	
	static boolean isValid(int y, int x, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[y][i] == n || map[i][x] == n) return false;
		}
		
		int yy = y/3 * 3;
		int xx = x/3 * 3;
		for (int i = yy; i < yy+3; i++) {
			for (int j = xx; j < xx+3; j++) {
				if (map[i][j] == n) return false;
			}
		}
		
		return true;
	}
}

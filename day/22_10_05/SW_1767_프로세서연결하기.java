package a22_10_05;

import java.io.*;
import java.util.*;

public class SW_1767_프로세서연결하기 {

	static int[][] map;
	static int N, ans, noConCnt;
	static List<Core> cores;
	static int[] dy = {-1,1,0,0,0};
	static int[] dx = {0,0,-1,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			noConCnt = 0;
			cores = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n==1) {
						if (i == 0 || j == N-1 || i == N-1 || j == 0) {
							map[i][j] = 2;
						} else {
							map[i][j] = 1;
							cores.add(new Core(i, j));
						}
					}
				}
			}//입력 끝
			
			noConCnt = Integer.MAX_VALUE;
			ans = Integer.MAX_VALUE;
			dfs(0, 0); //idx, noConnect
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void dfs(int idx, int noCon) {
		if (idx == cores.size()) { //코어 전부 다 봤다
			int cnt = checkColor(); //이중for문으로 색칠한 개수 세어줌
			
			if (noConCnt > noCon) { //최대한 많이 연결
				ans = cnt;
				noConCnt = noCon;
			} else if (noConCnt == noCon) {
				if (ans >= cnt) { //최대한 적게 색칠
					ans = cnt;
				}
			}
			return;
		}
		
		Core core = cores.get(idx);
		for (int d = 0; d < 5; d++) {
			if (d == 4) {
				dfs(idx+1, noCon+1);
			}
			else {
				int ny = core.y + dy[d];
				int nx = core.x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (!isValid(ny, nx, d)) continue; //색칠 가능하면
				color(ny, nx, d); //색칠
				dfs(idx+1, noCon); //다음 코어로 이동
				erase(ny, nx, d); //색칠 지우기
			}
		}
	}
	
	static void erase(int y, int x, int d) {
		while (true) {
			if (y < 0 || y >= N || x < 0 || x >= N) {  //경계값을 넘으면 break;
				break;
			}
			if (map[y][x] == 9) {
				map[y][x] = 0;
			}
			y += dy[d];
			x += dx[d];
		}
	}
	
	static void color(int y, int x, int d) {
		while (true) {
			if (y < 0 || y >= N || x < 0 || x >= N) {  //경계값을 넘으면 break;
				break;
			}
			map[y][x] = 9; //색칠
			y += dy[d];
			x += dx[d];
		}
	}
	
	static boolean isValid(int y, int x, int d) {
		
		int ny = y;
		int nx = x;
		while (true) {
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) {  //경계값을 넘으면 break;
				break;
			}
			if (map[ny][nx] == 9 || map[ny][nx] == 1 || map[ny][nx] == 2) {
				return false;
			}
			ny += dy[d];
			nx += dx[d];
		}
		return true;
	}
	
	static int checkColor() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 9) cnt++;
			}
		}
		return cnt;
	}
	
	static class Core {
		int y, x;
		Core(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

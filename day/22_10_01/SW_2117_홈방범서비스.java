package a22_10_01;

import java.util.*;
import java.io.*;

public class SW_2117_홈방범서비스 {

	static int N, M, max;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} 

			max = 0;
			solution();
			System.out.println("#"+t+" "+max);
		}
	}

	static void solution() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int K = 1;
				
				while (K <= N+1) { 
					int cnt = 0;
					int len = K-1;
					for (int ny = y-len; ny <= y+len; ny++) {
						for (int nx = x-len; nx <= x+len; nx++) {
							if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
							if (len < Math.abs(x-nx)+Math.abs(y-ny)) continue;
							if (map[ny][nx] == 1) 
								cnt++;
						}
					}

					int win = M*cnt - (K*K + (K-1)*(K-1));
					K++;
					if (win < 0) continue;
					max = Math.max(max, cnt);
				}
			}
		}
	}
}

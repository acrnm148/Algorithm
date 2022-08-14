package boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 조합
 * */
public class BOJ_15686치킨배달 {

	static int hi, ci, min;
	static boolean[] isSelected;
	static Point[] home;
	static Point[] chicken;
	static Point[] tmp1, tmp2;
	static int r, c, N, M;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new Point[13];
		chicken = new Point[13];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home[hi++] = new Point(i, j);
				}
				if (map[i][j] == 2) {
					chicken[ci++] = new Point(i, j);
				}
			}
		}
		min = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(min);
	}
	
	
	static void comb(int cnt, int start) {
		if (cnt == M) { //M개를 뽑는다
			int sum = 0;
			int tmp = 0;
			//home에서 하나를 뺌
			for (int i = 0; i < hi; i++) { //집마다 가까운 치킨집도 있고 먼 치킨집도 있을거임. 최대한 가까운 거리로
				tmp = Integer.MAX_VALUE;
				//치킨조합에서도 하나씩 빼서 집이랑 최소 거리 구함
				for (int c = 0; c < M; c++) {
					tmp=Math.min(tmp, (Math.abs(chicken[c].x - home[i].x) + Math.abs(chicken[c].y - home[i].y)));
				}
				sum += tmp;
			}
			//합의 최소거리 구함
			min = Math.min(sum, min);
			return;
		}
		
		
		
		for (int i = start; i < ci; i++) { //치킨집 개수 중에서
			
			comb(cnt+1, i+1);
			
		}
	}	
	
	
	static class Point {
		int x, y;
		Point() {}
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}

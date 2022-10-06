package a22_10_01;

import java.util.*;
import java.io.*;

public class SW_5644_무선충전 {

	static int M, A, res;
	static int[] dirA, dirB;
	static BC[] BC;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			dirA = new int[M];
			dirB = new int[M];
			BC = new BC[A];
			res = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				dirA[m] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				dirB[m] = Integer.parseInt(st.nextToken());
			}
			
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine());
				BC[a] = new BC(new Point( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			solution();
			
			System.out.println("#"+t+" "+res);
		}
	}

	static void solution() {
		
		Point userA = new Point(1,1);
		Point userB = new Point(10,10);
		charge(userA, userB);
		
		
		for (int i = 0; i < M; i++) {
			move(userA, dirA[i]);
			move(userB, dirB[i]);
			charge(userA, userB);
		}
	}
	
	
	static void charge(Point userA, Point userB) {
		List<Integer> ListA = new ArrayList<> ();
		List<Integer> ListB = new ArrayList<> ();
		
		for (int i = 0; i < A; i++) {
			if (BC[i].c >= Math.abs( BC[i].point.x - userA.x ) + Math.abs( BC[i].point.y - userA.y ) ) {
				ListA.add(i);
			}
			if (BC[i].c >= Math.abs( BC[i].point.x - userB.x ) + Math.abs( BC[i].point.y - userB.y ) ) {
				ListB.add(i);
			}
		}
		
		int max = 0, tmp = 0;
		
		if ( ListA.size() >= 1 && ListB.size() >= 1 ) {
			for (int i : ListA) {
				for (int j : ListB) {
					tmp = 0;
					if (i == j) {
						tmp = BC[i].p;
					} else {
						tmp = (BC[i].p + BC[j].p);
					}
					max = Math.max( max, tmp );
				}
			}
		}
		else if ( ListA.size() >= 1 && ListB.size() == 0 ) {
			for (int i : ListA) {
				max = Math.max( max, BC[i].p );
			}
		}
		else if ( ListA.size() == 0 && ListB.size() >= 1 ) {
			for (int i : ListB) {
				max = Math.max( max, BC[i].p );
			}
		}
		res += max;
	}
	

	static void move(Point point, int dir) {
		int[] dy = {0,-1,0,1,0};
		int[] dx = {0,0,1,0,-1};
		point.y += dy[dir];
		point.x += dx[dir];
	}
	
	static class BC {
		Point point;
		int c, p;
		public BC(Point point, int c, int p) {
			this.point = point;
			this.c = c;
			this.p = p;
		}
	}
	
	static class Point {
		int y, x;
		public Point(int x, int y) {
			this.y = y;
			this.x = x;
		}
	}
}

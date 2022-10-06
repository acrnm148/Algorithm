package a22_10_02;

import java.util.*;
import java.io.*;

public class SW_2383_점심식사시간 {

	static int N, perIdx, min;
	static int[][] map;
	static Stair[] stair;
	static Person[] per;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			stair = new Stair[2];
			per = new Person[N*N];
			int idx = 0; 
			perIdx = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						per[perIdx++] = new Person(i, j);
					}
					if (map[i][j] >= 2) {
						stair[idx++] = new Stair(i, j,map[i][j] ); 
					}
				}
			}
			min = Integer.MAX_VALUE;
			subset(0);
			System.out.println("#"+tc+" "+min);
		}
	}

	static void subset(int cnt) {
		if (cnt == perIdx) {
			int totalTime = 0;
			for (int i = 0; i < 2; i++) {
				PriorityQueue<Person> pq = new PriorityQueue<> ();
				int time[] = new int[100]; 
				
				for (int j = 0; j < perIdx; j++) {
					if (per[j].stair == i) {
						pq.add(per[j]); 
					}
				}

				while (!pq.isEmpty()) {
					Person front = pq.poll();
					int start = front.moveTime; 
					int end = start+stair[i].len; 
					for (int j = start; j < end; j++) {
						if (time[j] == 3) {
							end++;
							continue;
						}
						time[j]++;
					}
					totalTime = Math.max(totalTime, end); 
				}
			}
			min = Math.min(totalTime, min);
			return;
		}
		
		//1����� ����
		per[cnt].stair=0;
		per[cnt].moveTime = 1 + Math.abs( per[cnt].y-stair[0].y ) + Math.abs( per[cnt].x-stair[0].x );
		subset(cnt+1);
		//2����� ����
		per[cnt].stair=1;
		per[cnt].moveTime = 1 + Math.abs( per[cnt].y-stair[1].y ) + Math.abs( per[cnt].x-stair[1].x );
		subset(cnt+1);
	}
	
	static class Person implements Comparable<Person>{
		int y, x, moveTime, stair; //dist:��ܰ��ǰŸ�, t:������ ���
		public Person(int y, int x) { 
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Person o) {
			return this.moveTime - o.moveTime; //d���������� ����
		}
	}
	static class Stair {
		int y, x, len;
		public Stair(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}
	}
}

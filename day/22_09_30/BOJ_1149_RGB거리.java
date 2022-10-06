package a22_09_30;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리 {

	static int[][] arr, cost;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][3];
		cost = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		cost[1][0] = arr[1][0];
		cost[1][1] = arr[1][1];
		cost[1][2] = arr[1][2];
		
		for (int i = 2; i <= N; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + arr[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + arr[i][1];
			cost[i][2] = Math.min(cost[i-1][1], cost[i-1][0]) + arr[i][2];
		}
		
		System.out.println(Math.min(Math.min(cost[N][0], cost[N][1]), cost[N][2]));
	}
}

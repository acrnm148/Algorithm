package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1210Ladder1 {

	static int ansX = 0;
	static int[] dir_x = {-1,0, 1}; //좌, 상, 우 
	static int[] dir_y = {0,-1, 0}; //좌, 상, 우
	static int[][] arr;
	static int startX, startY;
	//바닥에 도착하면 멈춘다
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(br.readLine());
					
				}
			}
			
			
		}
	}

}

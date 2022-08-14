package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2023신기한소수 {

	static int start = 1000;
	static int end = 9999;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = start; i <= end; i++) {
			if (find(i)) list.add(i);
		}
		
		Collections.sort(list);
		for (int num : list) {
			System.out.println(num);
		}
	}
	
	static boolean find(int num) {
		int tmp = num;
		int i;
		
		//소수 체크
		while (num > 0) {
			i = 2;
			while (i*i < num) {
				if (num % i == 0) {
					return false;
				}
				i++;
			}
			num = num/10;
		}
		return true;
	}
}

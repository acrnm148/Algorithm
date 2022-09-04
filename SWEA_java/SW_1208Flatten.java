package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1208Flatten {
	
	static int[] sorted;
	static int[] arr;
	static int dump;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 1; T <= 10; T++) {

			dump = Integer.parseInt(br.readLine()); //dump 수
			arr = new int[100]; //배열
			//입력부
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//정렬됨
			sorted = Arrays.copyOf(arr, arr.length);
			Arrays.sort(sorted);
			//재귀
			recursive(dump);
			
//			System.out.println("#"+ T +" "+ans);
			int num = sorted[99] - sorted[0];
			System.out.println("#"+ T +" "+ num);
		}
	}
	static int max_cnt = 99;
	static int min_cnt = 0;
	static int ans = 0;
	static int tmp = 0;
	static void recursive(int dump) {
		Arrays.sort(sorted);
		max_cnt = 99;
		min_cnt = 0;
		// 1. 기저조건
		if (dump == 0 || (sorted[max_cnt] == sorted[min_cnt]))
			return;

		// 2. 하고싶은일
		sorted[max_cnt]-=1;
		sorted[min_cnt]+=1;
//		tmp = sorted[max_cnt] - sorted[min_cnt];
//		if (tmp > ans)
//			ans = tmp;

		// 3. 재귀
		recursive(dump-1);
	}
}

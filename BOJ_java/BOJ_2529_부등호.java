package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2529_부등호 {
	
	static int[] tgt;
	static boolean[] isSelected;
	static List<Character> sign = new ArrayList<>(); //부등호 ArrayList
	static List<String> ans = new ArrayList<> (); //정답 순열 ArrayList
	static int k; //부등호 몇 개
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int strlen = str.length();
		for (int i = 0; i < strlen; i++) {
			if (i %2 ==0) sign.add(str.charAt(i));
		}
		
		isSelected = new boolean[10];
		tgt = new int[k+1];
		
		perm(0); //순열 자리 시작인덱스(0~k+1) , 숫자 시작 인덱스(0~9)
		for (int i = 0; i < ans.size(); i++) 
			System.out.println("?"+ans.get(i));
	}
	
	
	
	
	//조합이 아니라 순열이었음 => 자리가 달라지면 값도 달라짐
	static void perm(int tgtIdx) {
		if (tgtIdx == k + 1) { // 조합 하나 완성
			if (check(tgt)) {
				String num = "";	
				for (int i : tgt) num += (char) i;  // String에 for문으로 하나하나 붙여줌
				ans.add(num);						// 만든 String을 ans에 넣어줌
			}
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (isSelected[i]) continue;
			tgt[tgtIdx] = i;
			isSelected[i] = true;
			perm(tgtIdx+1);
			isSelected[i] = false;
		}
		
	}
	
	static boolean check(int[] arr) {
		//System.out.println(Arrays.toString(arr));
		for (int i = 0; i < k; i++) {
			int num1 = arr[i];
			int num2 = arr[i+1];
			//System.out.println(num1 + " " +sign.get(i) +" " + num2);
			switch (sign.get(i)) {
			case '<': if (num1 >= num2) return false; break;
			case '>': if (num1 <= num2) return false; break;
			}
		}
		//System.out.println();
		return true;
	}
}











package a22_10_04;

import java.io.*;
import java.util.*;

public class SW_4008_숫자만들기_perm {

	static int N, min, max, o[], a[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		perm(1, a[0]);
	}
	
	static void perm(int idx, int val) {
		if (idx == N) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (o[i]==0) continue;
			o[i]--; //visited true
			if(i==0) perm(idx+1, val+a[idx]);
			if(i==1) perm(idx+1, val-a[idx]);
			if(i==2) perm(idx+1, val*a[idx]);
			if(i==3) perm(idx+1, val/a[idx]);
			o[i]++; //visited false
		}
	}
	
	
}

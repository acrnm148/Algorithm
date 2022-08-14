package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분집합 subset
public class BOJ_12891DNA비밀번호 {

	static int aCnt = 0;
	static int cCnt = 0;
	static int gCnt = 0;
	static int tCnt = 0;
	static int len, plen, aNum, cNum, gNum, tNum, totalCnt;
	static boolean[] select;
	static char[] dna;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		len = Integer.parseInt(st.nextToken());
		plen = Integer.parseInt(st.nextToken());
		
		dna = new char[plen];
		select = new boolean[len];
		
		dna = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		aNum = Integer.parseInt(st.nextToken());
		cNum = Integer.parseInt(st.nextToken());
		gNum = Integer.parseInt(st.nextToken());
		tNum = Integer.parseInt(st.nextToken());
		
		subset(0);
		System.out.println(totalCnt);
		
	}

	static void subset(int idx) {
		if (idx == len) {
			if (aNum == aCnt && cNum == cCnt && gNum == gCnt && tNum == tCnt) totalCnt++;
			aCnt = 0;
			cCnt = 0;
			gCnt = 0;
			tCnt = 0;
			return;
		}
		
		select[idx] = true;
		int num = dna[idx];
		if (num == 'A') aCnt++;
		if (num == 'C') cCnt++;
		if (num == 'G') gCnt++;
		if (num == 'T') tCnt++;
		subset(idx + 1);
		
		select[idx] = false;
		subset(idx + 1);
	}
}

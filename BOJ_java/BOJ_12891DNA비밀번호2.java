package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//
public class BOJ_12891DNA비밀번호2 {

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
		
		for (int i = 0; i <= len - plen; i++) {
			aCnt = 0;cCnt = 0;gCnt = 0;tCnt = 0;
			int idx = 0;
			while (idx < plen) {
				if (i + idx >= len) break;
				char ch = dna[i + idx];
				//System.out.print(ch);
				if (ch == 'A') aCnt++;
				if (ch == 'C') cCnt++;
				if (ch == 'G') gCnt++;
				if (ch == 'T') tCnt++;
				idx++;
			}
			//System.out.println(aCnt + " "+ cCnt + " "+ gCnt + " "+ tCnt);
			if (aNum == aCnt && cNum == cCnt && gNum == gCnt && tNum == tCnt) totalCnt++;
			if (i+idx >= len) break;
		}
			
		System.out.println(totalCnt);
		
	}

}

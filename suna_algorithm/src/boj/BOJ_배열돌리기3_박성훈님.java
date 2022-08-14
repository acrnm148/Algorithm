package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_배열돌리기3_박성훈님 {

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static StringBuilder sb = new StringBuilder();
static StringTokenizer st;
static int N, M, R;
static int[][] a;
static int[] dx = { 1, 0, -1, 0 };
static int[] dy = { 0, 1, 0, -1 };
static char[] command;

public static void main(String[] args) throws IOException {
    input();
    pro();
}

static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    a = new int[N][M];
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            a[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    command = br.readLine().toCharArray();
}

static void change(char com) {
    if (com == '1') {
        for (int m = 0; m < M; m++) {

            for (int i = N - 1; i >= N / 2; i--) {
                int temp = a[i][m];
                a[i][m] = a[N - i - 1][m];
                a[N - i - 1][m] = temp;

            }
        }
    } else if (com == '2') {

        for (int i = 0; i < N; i++) {
            for (int m = M - 1; m >= M / 2; m--) {
                int temp = a[i][m];
                a[i][m] = a[i][M - m - 1];
                a[i][M - m - 1] = temp;

            }
        }

    } else if (com == '3') {
        int[][] temp = new int[M][N];
        for (int m = 0; m < M; m++) {
            for (int i = N - 1; i >= 0; i--) {
                temp[m][N - i - 1] = a[i][m];
            }
        }
        a = temp;
        int n = N;
        N = M;
        M = n;

    } else if (com == '4') {
        int[][] temp = new int[M][N];
        for (int m = 0; m < M; m++) {
            for (int i = N - 1; i >= 0; i--) {
                temp[M - m - 1][i] = a[i][m];
            }
        }
        a = temp;
        int n = N;
        N = M;
        M = n;
    } else if (com == '5') {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = new int[M / 2];
            for (int j = 0; j < M / 2; j++) {
                temp[j] = a[i][j + M / 2];
                a[i][j + M / 2] = a[i][j];
            }
            int[] next = new int[M / 2];
            for (int j = M / 2; j < M; j++) {
                next[j - M / 2] = a[i + N / 2][j];
                a[i + N / 2][j] = temp[j - M / 2];
            }
            for (int j = 0; j < M / 2; j++) {
                temp[j] = a[i + N / 2][j];
                a[i + N / 2][j] = next[j];
            }
            for (int j = 0; j < M / 2; j++) {
                a[i][j] = temp[j];
            }

        }
    } else {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = new int[M / 2];
            for (int j = 0; j < M / 2; j++) {
                temp[j] = a[i + N / 2][j];
                a[i + N / 2][j] = a[i][j];
            }

            int[] next = new int[M / 2];
            for (int j = M / 2; j < M; j++) {
                next[j - M / 2] = a[i + N / 2][j];
                a[i + N / 2][j] = temp[j - M / 2];
            }

            for (int j = 0; j < M / 2; j++) {
                temp[j] = a[i][j + M / 2];
                a[i][j + M / 2] = next[j];
            }
            for (int j = 0; j < M / 2; j++) {
                a[i][j] = temp[j];
            }
        }

    }
}

static void pro() {

    for (char com : command) {
        if (com == ' ')
            continue;
        change(com);
    }
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
            sb.append(a[i][j]).append(' ');

        }
        sb.append('\n');
    }
    System.out.println(sb.toString());
}
}

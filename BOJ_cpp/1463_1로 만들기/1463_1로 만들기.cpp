#include<iostream>
using namespace std;
int main() {
	int N;
	scanf("%d", &N);

	for (int i = 1; i <= N * 2 - 1; i++) {
		if (i <= N) {
			for (int j = N - i; j > 0; j--) cout << " ";
			for (int k = i; k > 0; k--) cout << "*";
		}
		else {
			for (int j = i; j > N; j--) cout << " ";
			for (int k = i - N; k < N; k++) cout << "*";
		}
		cout << "\n";
	}
}
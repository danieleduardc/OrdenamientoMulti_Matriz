package algorithm;

import tools.Imprimir;

public class WinogradOriginal extends Imprimir {

    public static void winogradOriginal(int[][] A, int[][] B) {
        int N = A.length;
        int P = A[0].length;
        int M = B[0].length;
        int[][] Result = new int[N][N];
        int upsilon = P % 2;
        int gamma = P - upsilon;
        int[] y = new int[M];
        int[] z = new int[N];
        for (int i = 0; i < M; i++) {
            int aux = 0;
            for (int j = 0; j < gamma; j += 2) {
                aux += A[i][j] * A[i][j + 1];
            }
            y[i] = aux;
        }
        for (int i = 0; i < N; i++) {
            int aux = 0;
            for (int j = 0; j < gamma; j += 2) {
                aux += B[j][i] * B[j + 1][i];
            }
            z[i] = aux;
        }
        if (upsilon == 1) {
            /*
             * P is odd
             * The value A[i][P]*B[P][k] is missing in all auxiliary sums.
             */
            int PP = P - 1;
            for (int i = 0; i < M; i++) {
                for (int k = 0; k < N; k++) {
                    int aux = 0;
                    for (int j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j + 1][k]) * (A[i][j + 1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP] * B[PP][k];
                }
            }
        } else {
            /*
             * P is even
             * The result can be computed with the auxiliary sums.
             */
            for (int i = 0; i < M; i++) {
                for (int k = 0; k < N; k++) {
                    int aux = 0;
                    for (int j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j + 1][k]) * (A[i][j + 1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k];
                }
            }
        }
//        imprimirMatriz(Result);
    }
}

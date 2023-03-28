package algorithm;

import tools.Imprimir;

public class WinogradScaled extends Imprimir {

    public static void winogradScaled(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int q = B[0].length;
        int[][] result = new int[m][q];

        // Constants used in the algorithm
        int r = 2;
        int m_r = m / r;
        int q_r = q / r;
        int[] rowFactor = new int[m];
        int[] colFactor = new int[q];
        int d = n / 2;

        // Precompute row factors
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < d; j++) {
                rowSum += A[i][2 * j] * A[i][2 * j + 1];
            }
            rowFactor[i] = rowSum;
        }

        // Precompute column factors
        for (int j = 0; j < q; j++) {
            int colSum = 0;
            for (int i = 0; i < d; i++) {
                colSum += B[2 * i][j] * B[2 * i + 1][j];
            }
            colFactor[j] = colSum;
        }

        // Compute matrix product
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                int sum = -rowFactor[i] - colFactor[j];
                for (int k = 0; k < d; k++) {
                    sum += (A[i][2 * k] + B[2 * k + 1][j]) * (A[i][2 * k + 1] + B[2 * k][j]);
                }
                result[i][j] = sum;
            }
        }

        // Adjust the result for odd matrix dimensions
        if (n % 2 == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < q; j++) {
                    result[i][j] += A[i][n - 1] * B[n - 1][j];
                }
            }
        }

        // Scale the result
        int factor = n / r;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                result[i][j] *= factor;
            }
        }

//        imprimirMatriz(result);
    }

}

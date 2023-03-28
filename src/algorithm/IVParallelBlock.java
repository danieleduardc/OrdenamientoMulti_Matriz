package algorithm;

import java.util.concurrent.*;
public class IVParallelBlock {

    public static void multiply(int[][] A, int[][] B, int[][] C) {
        int size = A.length;
        int bsize = 16;

        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.invoke(new RecursiveAction() {
            protected void compute() {
                for (int i1 = 0; i1 < size; i1 += bsize) {
                    for (int j1 = 0; j1 < size; j1 += bsize) {
                        for (int k1 = 0; k1 < size; k1 += bsize) {
                            for (int i = i1; i < Math.min(i1 + bsize, size); i++) {
                                for (int j = j1; j < Math.min(j1 + bsize, size); j++) {
                                    for (int k = k1; k < Math.min(k1 + bsize, size); k++) {
                                        A[i][k] += B[i][j] * C[j][k];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
    public static void parallelBlock(int[][] A, int[][] B) {
        int m = A.length;
        int n = B[0].length;
        int o = B.length;
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

}


package algorithm;

public class IIIParallelBlock {
    public static void parallelBlock(int[][] B, int[][] C) {
        int size = B.length;
        int[][] A = new int[size][size];
        int bsize = 16; // tamaño del bloque
        int i1, j1, k1, i, j, k;

        for (i1 = 0; i1 < size; i1 += bsize) {
            for (j1 = 0; j1 < size; j1 += bsize) {
                for (k1 = 0; k1 < size; k1 += bsize) {
                    for (i = i1; i < i1 + bsize && i < size; i++) {
                        for (j = j1; j < j1 + bsize && j < size; j++) {
                            for (k = k1; k < k1 + bsize && k < size; k++) {
                                A[i][j] += B[i][k] * C[k][j];
                            }
                        }
                    }
                }
            }
        }
    }

}

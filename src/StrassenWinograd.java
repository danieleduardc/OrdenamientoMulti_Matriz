public class StrassenWinograd {

    public static int[][] strassenWinograd(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int[][] A11 = submatrix(A, 0, 0, n/2);
        int[][] A12 = submatrix(A, 0, n/2, n/2);
        int[][] A21 = submatrix(A, n/2, 0, n/2);
        int[][] A22 = submatrix(A, n/2, n/2, n/2);

        int[][] B11 = submatrix(B, 0, 0, n/2);
        int[][] B12 = submatrix(B, 0, n/2, n/2);
        int[][] B21 = submatrix(B, n/2, 0, n/2);
        int[][] B22 = submatrix(B, n/2, n/2, n/2);

        int[][] M1 = strassenWinograd(add(A11, A22), add(B11, B22));
        int[][] M2 = strassenWinograd(add(A21, A22), B11);
        int[][] M3 = strassenWinograd(A11, sub(B12, B22));
        int[][] M4 = strassenWinograd(A22, sub(B21, B11));
        int[][] M5 = strassenWinograd(add(A11, A12), B22);
        int[][] M6 = strassenWinograd(sub(A21, A11), add(B11, B12));
        int[][] M7 = strassenWinograd(sub(A12, A22), add(B21, B22));

        int[][] C11 = add(sub(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(sub(add(M1, M3), M2), M6);

        copy(C, C11, 0, 0);
        copy(C, C12, 0, n/2);
        copy(C, C21, n/2, 0);
        copy(C, C22, n/2, n/2);

        return C;
    }


    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    public static int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];

            }
        }
        return C;
    }

    public static int[][] submatrix(int[][] A, int startRow, int startCol, int size) {
        int[][] B = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                B[i][j] = A[startRow + i][startCol + j];
            }
        }
        return B;
    }

    public static void copy(int[][] A, int[][] B, int startRow, int startCol) {
        int n = B.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[startRow + i][startCol + j] = B[i][j];
            }
        }
    }

}


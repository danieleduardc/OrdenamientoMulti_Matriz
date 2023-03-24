
public class IIISequentialBlock {
    static int tam = 1;
    public static void sequentialBlock(int[][] B, int[][] C) {
        int size = B.length;
        int bsize = obtenerBsize(size);
        int[][] A = new int[size][size];

        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                A[i][j] += B[i][k] * C[k][j];
                            }
                        }
                    }
                }
            }
        }
        tam++;
       if(tam == 13)
           tam = 1;
    }

    public static int obtenerBsize(int size){
        if (size < 9){
            return 1;
        }if (size < 33){
            return 4;
        }if (size < 267){
            return 8;
        }if (size < 1024){
            return 32;
        }if (size < 4096){
            return 64;
        }
        return size;
    }

}

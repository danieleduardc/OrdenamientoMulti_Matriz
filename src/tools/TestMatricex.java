package tools;

public class TestMatricex {

    public static void main(String[] args) {
        int[][] firstMatrix = {{1520, 7532}, {2407, 3518}};
        int[][] secondMatrix = {{6174, 5172}, {2559, 1798}};

        int[][] result = new int[2][2];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        System.out.println("Result:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

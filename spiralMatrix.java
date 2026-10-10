
public class spiralMatrix {
    public static void spiral(int matrix[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;
        while (startrow <= endrow && startcol <= endcol) {
            // top
            for (int i = startcol; i <= endcol; i++) {
                System.out.println(matrix[startrow][i] + " ");
            }
            // right
            for (int j = startrow + 1; j <= endrow; j++) {
                System.out.println(matrix[j][endcol] + " ");
            }
            // bottom
            for (int i = endcol - 1; i >= startcol; i--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.println(matrix[endrow][i] + " ");
            }
            // left
            for (int j = endrow - 1; j >= startrow + 1; j++) {
                if (startcol == endcol) {
                    break;
                }
                System.out.println(matrix[j][startcol]);
            }
            startcol++;
            startrow++;
            endcol++;
            endcol++;
        }
    }

    /*
     * Question: How does spiral traversal print a matrix layer by layer?
     * Example: Matrix {{1,2,3},{4,5,6},{7,8,9}} -> output 1 2 3 6 9 8 7 4 5.
     */
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        spiral(matrix);

    }
}
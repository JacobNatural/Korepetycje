package zajecia01;

public class SortRowsAndColumns {
    public static int[][]  sortTab(int[][] tab){
        int temp;
        boolean check = true;
        while (check) {
            check = false;
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length - 1; j++) {
                    if (tab[i][j] > tab[i][j + 1]) {
                        check = true;
                        temp = tab[i][j];
                        tab[i][j] = tab[i][j + 1];
                        tab[i][j + 1] = temp;
                    }
                }
            }
        }
        check = true;

        while (check) {
            check = false;
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length - 1; j++) {
                    if (tab[j][i] > tab[j + 1][i]) {
                        check = true;
                        temp = tab[j][i];
                        tab[j][i] = tab[j + 1][i];
                        tab[j +1 ][i] = temp;

                    }
                }
            }
        }
        return  tab;
    }

    public static void main(String[] args) {
        int tab1[][] = {{11, 45, 5, 6},
                {5, 2, 3, 6},
                {7, 8, 10, 6},
                {6, 5, 10, 3}};
        int tab2[][];

        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                System.out.print(tab1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        tab2 = sortTab(tab1);

        for (int i = 0; i < tab2.length; i++) {
            for (int j = 0; j < tab2[i].length; j++) {
                System.out.print(tab2[i][j] + " ");
            }
            System.out.println();
        }

    }
}

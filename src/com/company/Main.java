package com.company;
public class Main {

    /**
     * Affiche la grille placer en paramètre.
     * @param grille
     */
    public static void PrintGrille(int grille[][]){
        int line=0;
        int colonne=0;

        while (colonne<9 && line<9){
            if (colonne==8){
                System.out.println(grille[line][colonne]);
                colonne=0;
                line=line+1;
            }else {
                System.out.print(grille[line][colonne]);
                System.out.print(" ");
                colonne++;
            }
        }

    }

    /**
     * Vérifie si une ligne suis la règle du Sudoku.
     * @param grille
     * @param i
     * @return True si la ligne est correct sinon revoie False
     */

    public static boolean GoodLine(int grille[][],int i){

        int line=0;
        int [] valeurLine= new int[9];
        while (line<9 ){
            for (int m=0; m<=8;m++) {
                if (grille[i][line] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (grille[i][line] == valeurLine[n]) {
                            return false;
                        }
                    }
                }
                valeurLine[line]= grille[i][line];
                line++;
            }
        }
        return true;
    }

    /**
     *
     * Vérifie si une colonne suis la règle du Sudoku.
     * @param grille
     * @param j
     * @return True si la colonne est correct sinon revoie False
     */
    public static boolean GoodColonne(int grille[][],int j){

        int colonn=0;
        int [] valeurColonne= new int[9];
        while (colonn < 9){
            for (int m=0 ; m<=8 ; m++) {
                if (grille[colonn][j] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (grille[colonn][j] == valeurColonne[n]) {
                            return false;
                        }
                    }
                }
                valeurColonne[colonn]= grille[colonn][j];
                colonn++;
            }
        }
        return true;
    }

    public static boolean GoodSection(int grille[][], int i, int j ) {
        int [] valeurSection= new int[9];
        int I = i;
        int J = j;
        while (i < I + 3){
            while (j < J + 3) {
                for (int m = 0; m < 3; m++) {
                    if (grille[i][j] == 0) {

                    } else {
                        for (int n = 0; n < 9; n++) {
                            if (grille[i][j] == valeurSection[n]) {
                                return false;
                            }
                        }
                    }
                    int index = (i-I)*3 + j-J;
                    valeurSection[index] = grille[i][j];
                    j++;
                }
                i++;
            }

            j = J ;
        }
        return true ;
    }

    public static boolean GoodBoard (int grille[][]) {
        int i = 0 ;
        int j = 0 ;
        int I = i ;
        int J = i ;

        while (i < 9 && j < 9) {
            while (i < 9) {
                boolean GoodLines = GoodLine(grille, i);
                GoodLine(grille, i);
                if (!GoodLines) {
                    return false;
                }
                i++;
            }
            while (j < 9) {
                boolean GoodColonnes = GoodColonne(grille, j);
                GoodColonne(grille, j);
                if (!GoodColonnes) {
                    return false ;
                }
                j++;
            }
            i = I ;
            j = J ;
            while (i < 9) {
                while (j < 9) {
                    boolean GoodSections = GoodSection(grille , i , j) ;
                    GoodSection(grille , i , j ) ;
                    if (!GoodSections) {
                        return false;
                    }
                j = j + 3 ;
                }
            i = i + 3 ;
            j = J ;
            }
        }
        return true ;
    }

    public static boolean Resolve1 (int grille [][]) {
        int i = 0 ;
        int j = 0 ;
        int I = i ;
        int J = j ;
        int possiblité [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            while (i < 9 && j < 9) {
                while (i < 9) {
                    if (grille[i][j] == 0) {
                        int n = 0 ;
                        int N = n ;
                        grille[i][j] = possiblité[0];
                            if (!GoodBoard(grille)) {
                                grille[i][j] = possiblité[n];
                                n = n + 1;
                            }
                    }
                    else {

                    }
                    i++ ;
                }
                j++ ;
                i = I ;
            }

            PrintGrille(grille);
            return true ;
        }






    public static void main(String[] args) {

//	PrintGrille(Boards.boardEasy);
//	boolean GoodLine=GoodLine(Boards.boardEasy,0);
//	System.out.println("la ligne est-elle bonne ? :" +GoodLine);
//	boolean GoodColonne=GoodColonne(Boards.boardEasy,0);
//	System.out.println("la colonne est-elle bonne ? :" +GoodColonne);
//	boolean GoodSection = GoodSection(Boards.boardEasy, 3, 3);
//	System.out.println("la sous-section est-elle bonne ? :" + GoodSection);
//    boolean GoodBoards = GoodBoard(Boards.boardEasy);
//    System.out.println("La grille est-elle bonne ? :" +GoodBoards);

//    int Possible[] = {1, 2, 3, 4, 5, 6, 7, 8, 9} ;
//    Resolve(Boards.boardEasy, Possible) ;

    Resolve1(Boards.boardEasy);


    }
}

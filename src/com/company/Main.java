package com.company;

public class Main {

    /**
     * Displays the board in parameter
     * @param grille The original board
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
     * Verifies if a line is valid
     * @param grille The original board
     * @param i Index of the line
     * @return True if the line is valid, if not returns False
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
     * Verifies if a column is valid
     * @param grille The original board
     * @param j Index of the column
     * @return True if the column is valid, if not returns False
     */
    public static boolean GoodColonne(int grille[][],int j){

        int colonne=0;
        int [] valeurColonne= new int[9];
        while (colonne < 9){
            for (int m=0 ; m<=8 ; m++) {
                if (grille[colonne][j] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (grille[colonne][j] == valeurColonne[n]) {
                            return false;
                        }
                    }
                }
                valeurColonne[colonne]= grille[colonne][j];
                colonne++;
            }
        }
        return true;
    }

    /**
     * Verifies if a sub-section is valid
      * @param grille The original board
     * @param i Index of the beggining line
     * @param j Index of the beggining column
     * @return True if the sub-szection is valid, if not returns False
     */
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

    /**
     * Verifies if the whole board is valid
     * @param grille The original board
     * @return True if the whole board is valid, if not returns False
     */
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

    /**
     * Fills every empty slots with valid values
     * @param grille The original board
     * @return True if a possibility is valid, False if it is invalid
     */
    public static boolean Resolve (int grille [][]) {
        int i ;
        int j ;
        for (j = 0 ; j < 9 ; j++) {
            for (i = 0 ; i < 9 ; i++){
                if  (grille[i][j] == 0) {
                    for (int possibilité = 1 ; possibilité < 10 ; possibilité++) {
                        grille[i][j] = possibilité;
                        if (GoodBoard(grille)) {
                            if (Resolve(grille)) {
                                return true;
                            }
                        }
                    }
                    grille[i][j] = 0 ;
                    return false ;
                }
            }
        }
        PrintGrille(grille);
        System.out.println("_________________");
        return false ;
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

    Resolve(Boards.boardEasy);


    }
}

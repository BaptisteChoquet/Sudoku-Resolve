package com.company;
public class Main {

    /**
     * Affiche la grille placer en paramètre.
     * @param grille
     */
    public static void PrintGrille(int grille[][]){
        int line=0;
        int colonn=0;

        while (colonn<9 && line<9){
            if (colonn==8){
                System.out.println(grille[line][colonn]);
                colonn=0;
                line=line+1;
            }else {
                System.out.print(grille[line][colonn]);
                System.out.print(" ");
                colonn++;
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

    public static void Resolve(int grille [][], int Results[]) {
        int line=0;
        int colonn=0;
        int x = 0 ;
            while (colonn < 9 && line < 9) {
                if (x < 81) {
                    if (colonn == 8) {
                        colonn = 0;
                        line = line + 1;
                        if (grille[colonn][line] != 0) {
                            x++;
                        }
                        else {
                            colonn = 0 ;
                            int R[] = Results ;
                                for (int r = 0 ; r < R.length ; r++) {
                                    grille[colonn][line] = R[r] ;
                                    if (!GoodBoard(grille)) {
                                    }
                                    else {
                                        break ;
                                    }
                            }
                        }
                    }else {
                        colonn++;
                        int R[] = Results ;
                        for (int r = 0 ; r < R.length ; r++) {
                            grille[colonn][line] = R[r] ;
                            if (!GoodBoard(grille)) {
                                if (grille[colonn][line]==8) {
                                    grille[colonn][line] = 0 ;
                                }
                            }
                            else {
                                PrintGrille(grille);
                                System.out.println("______________________");
                                break ;
                            }
                        }
                    }
                }
                else {
                    PrintGrille(grille);
                    return ;
                }
            }
    }




    public static void main(String[] args) {

//	PrintGrille(Boards.boardEasy);
//	boolean GoodLine=GoodLine(Boards.boardEasy,0);
//	System.out.println("la est ligne est-elle bonne ? :" +GoodLine);
//	boolean GoodColonne=GoodColonne(Boards.boardEasy,0);
//	System.out.println("la est colonne est-elle bonne ? :" +GoodColonne);
//	boolean GoodSection = GoodSection(Boards.boardEasy, 3, 3);
//	System.out.println("la sous-section est-elle bonne ? :" + GoodSection);
    boolean GoodBoards = GoodBoard(Boards.boardEasy);
    //    System.out.println("La grille est-elle bonne ? :" +GoodBoards);
    int Possible[] = {1, 2, 3, 4, 5, 6, 7, 8, 9} ;
    Resolve(Boards.boardEasy, Possible) ;



    }
}

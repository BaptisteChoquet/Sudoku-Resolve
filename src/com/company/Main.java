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
        int [] valeur= new int[9];
        while (line<9 ){
            for (int m=0; m<=8;m++) {
                if (grille[i][line] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (grille[i][line] == valeur[n]) {
                            return false;
                        }
                    }
                }
                valeur[line]= grille[i][line];
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
        int [] valeur= new int[9];
        while (colonne < 9){
            for (int m=0 ; m<=8 ; m++) {
                if (grille[colonne][j] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (grille[colonne][j] == valeur[n]) {
                            return false;
                        }
                    }
                }
                valeur[colonne]= grille[colonne][j];
                colonne++;
            }
        }
        return true;
    }

    public static boolean GoodSection(int grille[][], int i, int j ) {
        int [] valeur= new int[9];
        int I = i;
        int J = j;
        while (i < I + 3){
            while (j < J + 3) {
                for (int m = 0; m < 3; m++) {
                    if (grille[i][j] == 0) {

                    } else {
                        for (int n = 0; n < 9; n++) {
                            if (grille[i][j] == valeur[n]) {
                                return false;
                            }
                        }
                    }
                    int index = (i-I)*3 + j-J;
                    valeur[index] = grille[i][j];
                    j++;
                }
                i++;
            }

            j = J ;
        }
        return true ;
    }

    public static void main(String[] args) {

	PrintGrille(Boards.boardEasy);
	boolean GoodLine=GoodLine(Boards.boardEasy,0);
	System.out.println("la est ligne est-elle bonne ? :" +GoodLine);
	boolean GoodColonne=GoodColonne(Boards.boardEasy,0);
	System.out.println("la est colonne est-elle bonne ? :" +GoodColonne);
	boolean GoodSection = GoodSection(Boards.boardEasy, 3, 3);
	System.out.println("la sous-section est-elle bonne ? :" + GoodSection);




    }
}

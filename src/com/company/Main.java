package com.company;
public class Main {

    /**
     * Affiche la grille placer en paramètre.
     * @param grille
     */
    public static void PrintGrille(int grille[][]){
        int colonne=0;
        int ligne=0;
        while (ligne<9 && colonne<9){
            if (ligne==8){
                System.out.println(grille[ligne][colonne]);
                ligne=0;
                colonne=colonne+1;
            }else {
                System.out.print(grille[ligne][colonne]);
                System.out.print(" ");
                ligne++;
            }
        }

    }
    public static boolean GoodLine(int grille[][],int colonne){

        int ligne=0;
        int [] valeur= new int[9];
        while (ligne<9 ){

                for (int i=0; i<=valeur.length-1;i++){
                    if (grille[ligne][colonne]==0 ||grille[ligne][colonne]==valeur[i]){
                        return false;

                    }
                }
                valeur[ligne]= grille[ligne][colonne];
                ligne++;
            }

        return true;
    }

    public static void main(String[] args) {

	PrintGrille(Boards.boardEasy);
	boolean GoodLine=GoodLine(Boards.boardEasy,1);
	System.out.print(GoodLine);




    }
}

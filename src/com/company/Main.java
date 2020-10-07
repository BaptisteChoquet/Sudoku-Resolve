package com.company;
public class Main {

    /**
     * Affiche la grille placer en paramètre.
     * @param grille
     */
    public static void PrintGrille(int grille[][]){
        int colonne=0;
        int ligne=0;
        while (ligne<9 && colonn<9){
            if (ligne==8){
                System.out.println(grille[ligne][colonn]);
                ligne=0;
                colonn=colonn+1;
            }else {
                System.out.print(grille[ligne][colonn]);
                System.out.print(" ");
                ligne++;
            }
        }

    }

    public static void main(String[] args) {

	PrintGrille(Boards.boardEasy);




    }
}

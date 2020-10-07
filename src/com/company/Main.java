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
    public static boolean GoodLine(int grille[][],int line){

        int colonn=0;
        int [] valeur= new int[9];
        while (colonn<9 ){

                for (int i=0; i<=8;i++) {
                    if (grille[line][colonn] == 0) {

                    } else {
                        for (int n = 0; n <= 8; n++) {
                            if (grille[line][colonn] == valeur[n]) {
                                return false;
                            }
                        }
                    }

                    valeur[colonn]= grille[line][colonn];
                    colonn++;

                }
        }

        return true;
    }

    public static void main(String[] args) {

	PrintGrille(Boards.boardEasy);
	boolean GoodLine=GoodLine(Boards.boardEasy,0);
	System.out.print(GoodLine);




    }
}

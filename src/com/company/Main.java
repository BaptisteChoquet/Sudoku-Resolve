package com.company;

public class Main {

    /**
     * Displays the board in parameter
     * @param board The original board
     */
    public static void PrintGrille(int board[][]){
        int line=0;
        int column=0;

        while (column<9 && line<9){
            if (column==8){
                System.out.println(board[line][column]);
                column=0;
                line=line+1;
            }else {
                System.out.print(board[line][column]);
                System.out.print(" ");
                column++;
            }
        }

    }

    /**
     * Verifies if a line is valid
     * @param board The original board
     * @param i Index of the line
     * @return True if the line is valid, if not returns False
     */

    public static boolean GoodLine(int board[][],int i){

        int line=0;
        int [] valeurLine= new int[9];
        while (line<9 ){
            for (int m=0; m<=8;m++) {
                if (board[i][line] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (board[i][line] == valeurLine[n]) {
                            return false;
                        }
                    }
                }
                valeurLine[line]= board[i][line];
                line++;
            }
        }
        return true;
    }

    /**
     * Verifies if a column is valid
     * @param board The original board
     * @param j Index of the column
     * @return True if the column is valid, if not returns False
     */
    public static boolean GoodColumn(int board[][],int j){

        int column=0;
        int [] valeurColumn= new int[9];
        while (column < 9){
            for (int m=0 ; m<=8 ; m++) {
                if (board[column][j] == 0) {

                }
                else {
                    for (int n = 0; n <= 8; n++) {
                        if (board[column][j] == valeurColumn[n]) {
                            return false;
                        }
                    }
                }
                valeurColumn[column]= board[column][j];
                column++;
            }
        }
        return true;
    }

    /**
     * Verifies if a sub-section is valid
      * @param board The original board
     * @param i Index of the beggining line
     * @param j Index of the beggining column
     * @return True if the sub-szection is valid, if not returns False
     */
    public static boolean GoodSection(int board[][], int i, int j ) {
        int [] valeurSection= new int[9];
        int I = i;
        int J = j;
        while (i < I + 3){
            while (j < J + 3) {
                for (int m = 0; m < 3; m++) {
                    if (board[i][j] == 0) {

                    } else {
                        for (int n = 0; n < 9; n++) {
                            if (board[i][j] == valeurSection[n]) {
                                return false;
                            }
                        }
                    }
                    int index = (i-I)*3 + j-J;
                    valeurSection[index] = board[i][j];
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
     * @param board The original board
     * @return True if the whole board is valid, if not returns False
     */
    public static boolean GoodBoard (int board[][]) {
        int i = 0 ;
        int j = 0 ;
        int I = i ;
        int J = i ;

        while (i < 9 && j < 9) {
            while (i < 9) {
                boolean GoodLines = GoodLine(board, i);
                GoodLine(board, i);
                if (!GoodLines) {
                    return false;
                }
                i++;
            }
            while (j < 9) {
                boolean GoodColonnes = GoodColumn(board, j);
                GoodColumn(board, j);
                if (!GoodColonnes) {
                    return false ;
                }
                j++;
            }
            i = I ;
            j = J ;
            while (i < 9) {
                while (j < 9) {
                    boolean GoodSections = GoodSection(board , i , j) ;
                    GoodSection(board , i , j ) ;
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
     * @param board The original board
     * @return True if a possibility is valid, False if it is invalid
     */
    public static boolean Resolve (int board [][]) {
        int i ;
        int j ;
        for (j = 0 ; j < 9 ; j++) {
            for (i = 0 ; i < 9 ; i++){
                if  (board[i][j] == 0) {
                    for (int possibilité = 1 ; possibilité < 10 ; possibilité++) {
                        CPU ++ ;
                        board[i][j] = possibilité;
                        if (GoodBoard(board)) {
                            if (Resolve(board)) {
                                return true;
                            }
                        }
                    }
                    board[i][j] = 0 ;
                    return false ;
                }
            }
        }
        PrintGrille(board);
        System.out.println("_________________");
        return false ;
    }
    static int CPU ;

    public static void main(String[] args) {

    long timerStart = System.currentTimeMillis() ;
    PrintGrille (Boards.boardGodLike);
    System.out.println("_________________");

    Resolve(Boards.boardGodLike);
    long timerEnd = System.currentTimeMillis() ;
    long timer = timerEnd - timerStart ;
    System.out.println("The board was resolved in " + timer + " ms and " + CPU + " tries");

    }
}

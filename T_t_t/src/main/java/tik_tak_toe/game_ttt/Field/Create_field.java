package tik_tak_toe.game_ttt.Field;

import tik_tak_toe.game_ttt.Constant.Constant_field;

import java.util.Scanner;

/*
Аналаіз:
1. Гравці попорядку ходять
2. показувати оновлене поле
3. перевірити хто переміг
4. сказати  хто переміг або поле заповнене
5. вивести переможця
 */
public class Create_field extends Constant_field {

    public static void main(String[] args) {

        Start_game();
        do{
            Get_Input();
            Info_game();
            get_field();
            if(status_game==WIN_GAME_X){
                System.out.println("Winner X");
            }else if(status_game==WIN_GAME_O){
                System.out.println("Winner O");
            }else if(status_game==END_GAME){
                System.out.println("Winner X and O");
            }
            active_player=(active_player==KHRESTYK?ZERO:KHRESTYK);
        }while (status_game==ARE_GAME);

    }

    public static void Start_game(){
        for (int i = 0; i <RYADOK ; i++) {
            for (int j = 0; j <STOPCHUK ; j++) {
                game_field[i][j]=LEss;
            }
        }
        active_player = KHRESTYK;
        get_field();
    }

    public static void Get_Input() {
        boolean input_true=false;
        do{
            System.out.println("Pleyare " + active_player +" input ryad");
            int input_player_stovp = in.nextInt()-1;
            int input_player_riad = in.nextInt()-1;
            if(input_player_riad>=0&&input_player_riad<=RYADOK&&input_player_stovp>=0&&input_player_stovp<=STOPCHUK&&game_field[input_player_riad][input_player_stovp]==LEss){
                game_field[input_player_riad][input_player_stovp]= active_player;
                input_true=true;
            }else{
                System.out.println("Try again");
            }
        }while (!input_true);

    }

    public static void Info_game(){

        String winner =  Get_winner();
        if(winner.equals(KHRESTYK)){
            status_game = WIN_GAME_X;
        }else if (winner.equals(ZERO)){
            status_game=WIN_GAME_O;
        }else if (winner.equals(end_field())){
            status_game=END_GAME;
        }else {
            status_game=ARE_GAME;
        }


    }

    public static boolean end_field(){
        for (int i = 0; i <RYADOK ; i++) {
            for (int j = 0; j <STOPCHUK ; j++) {
                if(game_field[i][j]==LEss){
                    return false;
                }
            }
        }
        return true;
    }

    public static String Get_winner(){

        int count;

        for (int i = 0; i <RYADOK ; i++) {
            count=0;
            for (int j = 0; j <STOPCHUK ; j++) {
                if(game_field[i][0]!=LEss&&game_field[i][0]==game_field[i][j]){
                    count++;
                }
            }
            if(count==3){
                return game_field[i][0];
            }
        }

        for (int i = 0; i <STOPCHUK ; i++) {
            count=0;
            for (int j = 0; j <RYADOK ; j++) {
                if(game_field[0][i]!=LEss&&game_field[0][i]==game_field[i][j]){
                    count++;
                }
            }
            if(count==3){
                return game_field[0][i];
            }
        }
        if(game_field[0][0]!=LEss&&game_field[0][0]==game_field[1][1]&&game_field[0][0]==game_field[2][2]){
                    return game_field[0][0];
        }
        if(game_field[0][2]!=LEss&&game_field[0][2]==game_field[1][1]&&game_field[0][2]==game_field[2][0]){
            return game_field[0][2];
        }

        return LEss;
    }

    public static void get_field(){
        for (int i = 0; i <RYADOK ; i++) {
            for (int j = 0; j <STOPCHUK ; j++) {
                System.out.print(game_field[i][j]);
                if(j!=RYADOK-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i!=RYADOK-1){
                System.out.println("---------");
            }
        }
        System.out.println();
    }


}

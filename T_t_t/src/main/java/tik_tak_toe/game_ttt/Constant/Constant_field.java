package tik_tak_toe.game_ttt.Constant;

import java.util.Scanner;

public class Constant_field {

    public static final String LEss= "  ";
    public static final String KHRESTYK = " X ";
    public static final String ZERO = " 0 ";

    public static final int RYADOK = 3;
    public static final int STOPCHUK = 3;
    public static String active_player;
    public static String  game_field [] [] = new String[RYADOK][STOPCHUK];

    public static int status_game;
    public static final int ARE_GAME = 0;
    public static final int END_GAME = 1;
    public static final int WIN_GAME_X = 2;
    public static final int WIN_GAME_O = 3;

    public static Scanner in = new Scanner(System.in);

}

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        final char EMPTY_CELL = '*';
        final char KRESTIK_CELL = 'X';
        final char HOLIK_CELL = 'O';

        final int Steps = 5;

        final int USER_STEP = 1;
        final int COMP_STEP = 2;

        final String USER_WIN = "Победил игрок";
        final String COMP_WIN = "Победил компьютер";

        int fieldSize = 3;
        char Field[][] = new char[fieldSize][fieldSize];
        boolean isCorrectInput = true;
        boolean isPlay = true;
        int step = USER_STEP;


        int iCell = 0, jCell = 0;


        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                Field[i][j] = EMPTY_CELL;
            }
        }
        System.out.println("Поле:");
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.printf("%-2c", Field[i][j]);
            }
            System.out.println();
        }

        while (isPlay == true) {
            for (int k = 0; k < 2; k++) {
                System.out.println();
            }


            switch (step) {
                case USER_STEP:

                    System.out.println("Ход игрока");

                    do {
                        isCorrectInput = true;
                        Scanner input = new Scanner(System.in);

                        try {
                            System.out.print("Введите i: ");
                            iCell = input.nextInt();

                            System.out.print("Введите j: ");
                            jCell = input.nextInt();
                        } catch (Exception e) {
                            isCorrectInput = false;
                            continue;
                        }

                        if (iCell < 0 || iCell > fieldSize - 1 || jCell < 0 || jCell > fieldSize - 1) {
                            isCorrectInput = false;
                            continue;
                        }
                        if (Field[iCell][jCell] == KRESTIK_CELL || Field[iCell][jCell] == HOLIK_CELL) {
                            isCorrectInput = false;
                            continue;
                        }
                    } while (isCorrectInput == false);
                    if(Field[iCell][jCell]==EMPTY_CELL){
                        Field[iCell][jCell]=KRESTIK_CELL;
                        step=COMP_STEP;
                    }

                    break;

                case COMP_STEP:
                    System.out.println("Ход компьютера");
                    System.out.println("Для продолжения нажмите <Enter>");

                    Scanner input = new Scanner(System.in);
                    input.nextLine();

                    do {
                        isCorrectInput = true;

                        iCell = random.nextInt(fieldSize);
                        jCell = random.nextInt(fieldSize);

                        if (Field[iCell][jCell] == KRESTIK_CELL) {
                            isCorrectInput = false;
                            continue;
                        }
                    } while (isCorrectInput == false);
                    if(Field[iCell][jCell]==EMPTY_CELL){
                        Field[iCell][jCell]=HOLIK_CELL;
                        step=USER_STEP;
                    }

                    System.out.println("Поле:");
                    for (int i = 0; i < fieldSize; i++) {
                        for (int j = 0; j < fieldSize; j++) {
                            System.out.printf("%-2c", Field[i][j]);
                        }
                        System.out.println();
                    }
            }

            // Ready player one.   -- Условия победы игрока.

            if (Field[0][0] == KRESTIK_CELL && Field[0][1] == KRESTIK_CELL && Field[0][2] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }

            if (Field[1][0] == KRESTIK_CELL && Field[1][1] == KRESTIK_CELL && Field[1][2] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (Field[2][0] == KRESTIK_CELL && Field[2][1] == KRESTIK_CELL && Field[2][2] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (Field[0][0] == KRESTIK_CELL && Field[1][0] == KRESTIK_CELL && Field[2][0] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }

            if (Field[0][1] == KRESTIK_CELL && Field[1][1] == KRESTIK_CELL && Field[2][1] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (Field[0][2] == KRESTIK_CELL && Field[1][2] == KRESTIK_CELL && Field[2][2] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (Field[2][0] == KRESTIK_CELL && Field[1][1] == KRESTIK_CELL && Field[0][2] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }
            if (Field[0][0] == KRESTIK_CELL && Field[1][1] == KRESTIK_CELL && Field[2][2] == KRESTIK_CELL) {
                System.out.println("Победил игрок");
                isPlay=false;
            }

            // All you base belong to us (c) PC.  -- Условия победы ПК.

            if (Field[0][0] == HOLIK_CELL && Field[0][1] == HOLIK_CELL && Field[0][2] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[1][0] == HOLIK_CELL && Field[1][1] == HOLIK_CELL && Field[1][2] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[2][0] == HOLIK_CELL && Field[2][1] == HOLIK_CELL && Field[2][2] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[0][0] == HOLIK_CELL && Field[1][0] == HOLIK_CELL && Field[2][0] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[0][1] == HOLIK_CELL && Field[1][1] == HOLIK_CELL && Field[2][1] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[0][2] == HOLIK_CELL && Field[1][2] == HOLIK_CELL && Field[2][2] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[2][0] == HOLIK_CELL && Field[1][1] == HOLIK_CELL && Field[0][2] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
            if (Field[0][0] == HOLIK_CELL && Field[1][1] == HOLIK_CELL && Field[2][2] == HOLIK_CELL) {
                System.out.println("Победил компьютер");
                isPlay=false;
            }
        }
    }
}

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("/home/gwalieh/IdeaProjects/untitled2/src/com/company/input.txt");
        try {
            Scanner scn = new Scanner(file);
            int totalWords = scn.nextInt();
            int[] row = new int[totalWords];
            int[] col = new int[totalWords];
            for(int i = 0; i < totalWords; i++){
                row[i] = scn.nextInt();
                col[i] = scn.nextInt();
                char[][] kataAcak = new char[row[i]][col[i]];
                for(int j = 0; j < kataAcak.length; j++){
                    kataAcak[j] = checkKataAcak(kataAcak[j], scn, col[i]);
                }
                String kataDicari = scn.next();
                int kataDitemukan = find(kataDicari, kataAcak);
                System.out.println("case "+ (i+1) + " : " + kataDitemukan);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(args[0]);
        }
    }

    static char[] checkKataAcak(char[] strChar, Scanner scn, int x){
        String str = scn.next();
        strChar = str.toCharArray();
        if(str == null || str.length() != x){
            System.out.println("input kembali kata acak");
            strChar = checkKataAcak(strChar,scn, x);
            return strChar;
        }
        return strChar;
    }

    static int find(String kataDicari, char[][] kataAcak){
        int size = kataAcak[0].length;
        int kataDitemukan = 0;
        for(int row = 0; row < kataAcak.length; row++){
            for(int column = 0; column < size; column++){
             if(kataAcak[row][column] == kataDicari.charAt(0)){
                 kataDitemukan = kataDitemukan + checkMacth(kataDicari, kataAcak, row, column);
             }
            }
        }
        return kataDitemukan;
    }

    static int checkMacth(String kataDicari, char[][] kataAcak, int row, int col){
        int kataDitemukan = 0;
        int len = kataDicari.length();

        if((col + len) <= kataAcak[0].length){
            int wordPos = 0;
            for(int i = col; i <= (col + len) - 1; i++){
                if(kataDicari.charAt(wordPos) != kataAcak[row][i]){
                    break;
                }
                if(i == (col + len) - 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
            }
        }
        if((col - len) + 1 > -1){
            int wordPos = 0;
            for(int i = col; i >= (col - len) + 1; i--){
                if(kataDicari.charAt(wordPos) != kataAcak[row][i]){
                    break;
                }
                if(i == (col - len) + 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
            }
        }

        if((row - len) >= -1){
            int wordPos = 0;
            for(int i = row; i >= (row - len) + 1; i--){
                if(kataDicari.charAt(wordPos) != kataAcak[i][col]){
                    break;
                }
                if(i == (row - len) + 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
            }
        }

        if((row + len) <= kataAcak.length){
            int wordPos = 0;
            for(int i = row; i <= (row + len) - 1; i++){
                if(kataDicari.charAt(wordPos) != kataAcak[i][col]){
                    break;
                }
                if(i == (row + len) - 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
            }
        }

        if((row - len) >= -1 && (col + len) <= kataAcak[0].length){
            int wordPos = 0;
            int j = col;
            for(int i = row; i >= (row - len) + 1; i--){
                if(kataDicari.charAt(wordPos) != kataAcak[i][j]){
                    break;
                }
                if(i == (row - len) + 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
                j++;
            }
        }

         if((row - len) >= -1 && (col - len) >= -1){
            int wordPos = 0;
            int j = col;
            for(int i =row; i >= (row - len) + 1; i--){
                if(kataDicari.charAt(wordPos) != kataAcak[i][j]){
                    break;
                }
                if(i == (row - len) + 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
                j--;
            }
        }

        if((row + len) <= kataAcak.length && (col + len) <= kataAcak[0].length){
            int wordPos = 0;
            int j = col;
            for(int i = row; i <= (row + len) -1; i++){
                if(kataDicari.charAt(wordPos) != kataAcak[i][j]){
                    break;
                }
                if(i == (row + len) - 1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
                j++;
            }
        }

        if((row + len) <= kataAcak.length && (col - len) >= -1){
            int wordPos = 0;
            int j = col;
            for(int i = row; i <= (row + len) -1; i++){
                if(kataDicari.charAt(wordPos) != kataAcak[i][j]){
                    break;
                }
                if(i == (row + len) -1){
                    kataDitemukan = kataDitemukan + 1;
                }
                wordPos++;
                j--;
            }
        }
        return kataDitemukan;
    }

}
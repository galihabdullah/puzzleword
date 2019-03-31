package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("input total");
        int totalWorlds = scn.nextInt();
        int[] row = new int[totalWorlds];
        int[] column = new int[totalWorlds];
        for(int i = 0; i < totalWorlds; i++){
            System.out.println("input row");
            row[i] = scn.nextInt();
            System.out.println("input column");
            column[i] = scn.nextInt();
            char[][] kataAcak = new char[row[i]][column[i]];
            for(int j = 0; j < kataAcak.length; j++){
                System.out.println("input kata acak dengan panjang huruf : " + column[i]);
                kataAcak[j] = checkKataAcak(kataAcak[j], scn, column[i]);

            }
            System.out.println("input kata yang dicari");
            String kataDicari = scn.next();
            System.out.println("kata acak : "+ Arrays.deepToString(kataAcak));
            int kataDitemukan = find(kataDicari, kataAcak);
            System.out.println("case "+ (i + 1) + " :" + kataDitemukan);
        }

        scn.close();
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
        if((col - len) + 1 >= -1){
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

        if((row + len) <= kataAcak[0].length){
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

        if((row + len) <= kataAcak[0].length && (col + len) <= kataAcak[0].length){
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

        if((row + len) <= kataAcak[0].length && (col - len) >= -1){
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
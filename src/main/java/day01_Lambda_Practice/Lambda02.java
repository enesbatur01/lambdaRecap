package day01_Lambda_Practice;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> meyve = new ArrayList<>(Arrays.asList("elma","portakal","uzum","cilek",
                "greyfurt","nar","mandalina","armut","elma","keciboynuzu","elma"));


        printIfStartsWithEOrC(meyve);
        System.out.println();

        printElementsWithStar(meyve);
        System.out.println();

        printElementsIfContainsE(meyve);
        System.out.println();

        printRemoveLLetters(meyve);
        System.out.println();

        printWithLambdaExpressionElementsSortedLenghtLessThanGreater(meyve);
        System.out.println();

        printWithMethodReferanceSortedLenghtGreaterThanLess(meyve);
        System.out.println();

        printBooleanIfAllElementsLenghtGreaterThanTwoLenght(meyve);
        System.out.println();



    }

    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari,
    // Method References ile aralarında bosluk bırakarak yazdıralım

    public static void printIfStartsWithEOrC (List<String> meyve){

        meyve
                .stream()
                .filter(t-> t.startsWith("e")||t.startsWith("c"))
                .forEach(Utils::printWithOneSpace);

    }

    // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void printElementsWithStar(List<String>meyve){

        meyve
                .stream()
                .map(t-> "*"+t+"*")
                .forEach(Utils::printWithOneSpace);

    }


    // SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın
    public static void printElementsIfContainsE(List<String>meyve){

        meyve
                .stream()
                .filter(t-> t.contains("e"))
                .forEach(Utils::printWithOneSpace);

    }

    // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız
    public static void printRemoveLLetters(List<String>meyve){

        meyve
                .stream()
                .map(t-> t.replaceAll("l",""))
                .forEach(Utils::printWithOneSpace);

    }


    // SORU5 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız

    public static void printWithLambdaExpressionElementsSortedLenghtLessThanGreater(List<String>meyve){

        meyve
                .stream()
                .sorted(Comparator.comparing(t-> t.length()))
                .forEach(Utils::printWithOneSpace);
    }

    // SORU6 : List elemanlarini, Method References kullanarak
    // karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız

    public static void printWithMethodReferanceSortedLenghtGreaterThanLess(List<String>meyve){

        meyve
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(Utils::printWithOneSpace);

    }

    // SORU7 : List elemanlarının tumu 2 karakterden fazla ise ekrana 'True' yazdırınız
    public static void printBooleanIfAllElementsLenghtGreaterThanTwoLenght(List<String>meyve){
        boolean result=meyve
                .stream()
                .allMatch(t-> t.length()>2);
        System.out.println(result);

    }

}

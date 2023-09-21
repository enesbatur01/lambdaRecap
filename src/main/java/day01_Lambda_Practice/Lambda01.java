package day01_Lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> num = new ArrayList<>(Arrays.asList(-5,-8,-12,0,1,12,5,5,6,9,15,8));

        printElementsOfEvenAndPositive(num);
        System.out.println();

        printWithMethodReffarenceElementsOfEvenAndPositive(num);
        System.out.println();

        printSquaredOfList(num);
        System.out.println();

        printDistinctSquareOfList(num);
        System.out.println();

        printElementsGreaterThanLess(num);
        System.out.println();

        printElementsEvenAndCubeAndLastElementOne(num);
        System.out.println();

        printWithMethodRefferanceSumOfList(num);

        printWithLambdaExpressionSumOfList(num);

        int a=getEvenMultiplyWithLambdaExpression(num);
        System.out.println(a);

        List num2 =getElementsOfEvenSquaredWithLessThanGreaterSorted(num);
        System.out.println(num2);


    }

    //SORU1: List elemanlarının çift ve pozitif olanlarını,
    // Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void printElementsOfEvenAndPositive(List<Integer> num){

        num.stream().filter(t-> t>0&&t%2==0).forEach(t-> System.out.print(t+" "));

    }

    //SORU2: List elemanlarının çift ve pozitif olanlarını,
    // Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void printWithMethodReffarenceElementsOfEvenAndPositive(List<Integer> num){
        num
                .stream()
                .filter(Utils::getElementsOfEvenAndPositive)
                .forEach(Utils::printWithOneSpace);

    }


    //SORU3 : List elemanlarının karelerini, aralarında bosluk olacak sekilde yazdırın

    public static void printSquaredOfList(List<Integer>num){

        num
                .stream()
                .map(t-> t*t)
                .forEach(Utils::printWithOneSpace);

    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın

    public static void printDistinctSquareOfList(List<Integer>num){

        num
                .stream()
                .map(t-> t*t)
                .distinct()
                .forEach(Utils::printWithOneSpace);

    }

    //SORU5: List elemanlarını buyukten kucuge sıralayarak yazdırın

    public static void printElementsGreaterThanLess(List<Integer>num){

        num
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(Utils::printWithOneSpace);

    }
    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız

    public static void printElementsEvenAndCubeAndLastElementOne (List<Integer> num){

        num
                .stream()
                .filter(t-> t>0)
                .map(t-> t*t*t)
                .filter(t-> t%10==5) //bir sayının 10'a bölümünden kalan 5 ise sayının birler basamağı 5 tir
                .forEach(Utils::printWithOneSpace);
    }

    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın

    public static void printWithMethodRefferanceSumOfList(List<Integer>num){

        int result1 = num
                .stream()
                .reduce(Integer::sum)
                .get();
        System.out.println(result1);

    }

    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın
    public static void printWithLambdaExpressionSumOfList(List<Integer>num){
        int result1=num
                .stream()
                .reduce(0,(a,b)->a+b);
        System.out.println(result1);

    }

    //SORU9 : Listin pozitif elemanlarının, carpımını Lambda Expression ile return ederek yazdırın

    public static int getEvenMultiplyWithLambdaExpression(List<Integer>num){

       return num
                .stream()
                .filter(t-> t>0)
                .reduce(1,(a,b)->a*b);
    }

    //SORU10 : Listin cift elemanlarının, karelerini,
    // kucukten buyuge sıralayıp list halinde return ederek yazdırınız
    public static List<Integer> getElementsOfEvenSquaredWithLessThanGreaterSorted(List<Integer>num){

       return num
                .stream()
                .filter(t-> t>0)
                .map(t-> t*t)
                .sorted()
                .collect(Collectors.toList());

    }

}

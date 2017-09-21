import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tamás Ferenc on 2017. 09. 15..
 */
public class Main {

    //Reverse a String

    public String reverseString(String str){
        char[]strLetters = str.toCharArray();
        String result = "";

        for (int i = strLetters.length-1; i >= 0 ; i--) {
            result += strLetters[i];
        }
        return result;
    }

    //Factorialize a number

    public long factorialize(int number){
        long result = number;

        if(number == 0){
            return 1;
        }
        else{
            for (int i = number-1; i > 1 ; i--) {
                result = result * i;
            }
        }

        return result;
    }

    //Check for palindromes

    public boolean palindrome(String str){
        str = str.toLowerCase();
        char[]chars = str.toCharArray();

        String originalString = "";
        String reverseString = "";

        for (int i = 0; i < chars.length ; i++) {
            if(Character.isLetterOrDigit(chars[i])){
                originalString += chars[i];
            }
        }

        for (int i = chars.length-1; i >= 0; i--) {
            if(Character.isLetterOrDigit(chars[i])){
                reverseString += chars[i];
            }
        }

        return(reverseString.equals(originalString));

    }

    //Find the longest word in a String

    public int longestWord(String sentence) {

        String[] words = sentence.split(" ");

        int max = 0;
        int counter = 0;

        for (String w : words) {
            counter = 0;
            for (int i = 0; i < w.length(); i++) {
                counter += 1;
            }
            if (counter > max) {
                max = counter;
            }
        }
        return max;
    }

    //Title Case a Sentence

    public String titleCase(String str){
        String[] words = str.split(" ");

        String result = "";

        for (String word:words) {
            result += word.toUpperCase().charAt(0);
            result += word.substring(1).toLowerCase() + " ";
        }
        return result;
    }

    //Return largest numbers in arrays

    public int[] getLargest(int[][] array) {
        int[] result = new int[4];

        for (int i = 0; i < array.length; i++) {
            int max = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
            result[i] = max;
        }

        return result;
    }


    //Confirm the ending

    public boolean confirmEnding(String str, String ending){

        char[] strEnding = str.substring(str.length()-ending.length()).toCharArray();

        String result = "";

        for (char c:strEnding) {
            result += c;
        }

        return(result.equals(ending));

    }

    //Repeat a string a given time

    public String repeatStringnumTimes(String str, int num){

        String result = "";

        int counter = 0;


        if( num < 1){
            return "";
        }
        else{
            while(counter < num ){
                result += str;
                counter ++;
            }
        }
        return result;
    }

    //Truncate a String

    public String truncateString(String str, int number){
        String result ="";

        if(number < 4){
            for (int i = 0; i < number ; i++) {
                result += str.charAt(i);
            }
            result += "...";
        }
        else if(number >= str.length()){
            return str;
        }
        else{
            for (int i = 0; i <number-3 ; i++) {
                result += str.charAt(i);
            }
            result += "...";
        }
        return result;
    }

    //Chunky Monkey

    public int[][] chunkArrayInGroups(int[] startArray, int number){

        Double temp = new Double(Math.ceil(startArray.length / (double)number));
        int numberOfSubarrays = temp.intValue();
        int counter = 0;
        int subArrayCounter = 0;

        int[][]result = new int[numberOfSubarrays][];


        List<Integer> startArrayList = new ArrayList<>();

        for (int i:startArray) {
            startArrayList.add(i);
        }

        int[]tempArray= new int[number];
        while(startArrayList.size() > number){
            if(counter < number){
                tempArray[counter] = startArrayList.get(0);
                startArrayList.remove(0);
                counter ++;
            }
            else{
                result[subArrayCounter] = tempArray;
                tempArray = new int[number];
                subArrayCounter ++;
                counter = 0;
            }
        }

        while(counter != number){
            tempArray[counter] = startArrayList.get(0);
            startArrayList.remove(0);
            counter ++;
        }
        result[subArrayCounter] = tempArray;
        subArrayCounter++;
        counter = 0;

        if(startArrayList.size() != 0){
            tempArray = new int[startArrayList.size()];
            for (int i:startArrayList) {
                tempArray[counter] = i;
                counter ++;
            }
            result[subArrayCounter] = tempArray;
        }

        return result;

    }

    //Slasher Flick

    public int[] slasher(int[] startArray, int number){
        int resultLenght;
        int counter = 0;
        List<Integer> startArrayList = new ArrayList<>();

        for (int i:startArray) {
            startArrayList.add(i);
        }

        if(startArray.length-number >=0 ){
            resultLenght = startArray.length-number;
        }
        else{
            resultLenght = 0;
        }
        int[] result = new int[resultLenght];

        if(resultLenght>0) {
            while (counter != number) {
                startArrayList.remove(0);
                counter++;
            }

            counter = 0;
            for (int i : startArrayList) {
                result[counter] = i;
                counter++;
            }
        }
        return result;
    }

    //Falsy Bouncer

    public Object[] bouncer(Object[] startArray){

        List<Object> falsyValues = Arrays.asList(false, null, 0, "", "undefined", "NaN" );

        int counter = 0;

        List<Object>result = new ArrayList<>();

        for (Object o:startArray) {
            if(!falsyValues.contains(o)){
                result.add(o);
            }
        }

        return result.toArray();
    }


    //Seek and Destroy

    public Object[] destroyer(Object[]startArray, Object... obj){

        List<Object> objects = Arrays.asList(obj);

        List<Object> result = new ArrayList<>();

        for(Object o: startArray){
            if(!objects.contains(o)){
                result.add(o);
            }
        }

        return result.toArray();
    }

    //Where do I belong

    public int getIndexToIns(int[] array, int number) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        int indexCounter = 0;
        for (int i : array) {
            if (i < number) {
                indexCounter += 1;
            }
        }
        return indexCounter;
    }

    //Caesar Cipher

    public String rot13(String str){

        str = str.toUpperCase();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if(Character.isAlphabetic(str.charAt(i))){
                if(str.charAt(i)>= 'A' && str.charAt(i) < 'N'){
                   result += (char)(str.charAt(i) + 13);
                }
                else{
                    result +=(char)(str.charAt(i)-13);
                }
            }
            else{
                result +=(str.charAt(i));
            }
        }
        return result;
    }


    //OTHER EXERCISES:

    //Coin counter

    public int coinCounter(int value) {

        value = roundMoney(value);

        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(200, 100, 50, 20, 10, 5));

        int remain = value;
        int sumCoins = 0;

        for (int c : coins) {
            sumCoins += remain / c;
        remain = remain % c;
        }

        return sumCoins;
}


    //Money rounder

    public int roundMoney(int num) {

        int remain = num % 5;

        if (remain <= 2) {
            num = num - remain;
        } else {
            num = num + (5 - remain);

        }
        return num;
}


    //Get the middle two characters from a String

    private String middleTwoResult = "";

    public void middleTwo(String str) {
        middleTwoResult = "";
        int half = str.length();

        half = half / 2;

        middleTwoResult += str.charAt(half - 1);
        middleTwoResult += str.charAt(half);

        System.out.println(middleTwoResult);

    }

    public String getMiddleTwoResult() {
        return middleTwoResult;
    }

    //Remove the first two characters from a string except if the first char is "a" or the second is "b"

    public static String deFront(String str) {

        String result = "";

        if ((str.charAt(0) == 'a')) {
            result += str.charAt(0);
        }
        if (str.charAt(1) == 'b') {
            result += str.charAt(1);
        }

        result += str.substring(2);

        return result;
    }

    //Tests if a string contains every character only once

    public boolean isUnique(String str) {

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //Return the count of occurences of the 7 number in an integer

    public int count7(int number) {
        return Integer.toString(number).replaceAll("[^7]", "").length();

    }



    public static void main(String[] args) {
      Main main = new Main();
      int[] testArray = {1,22,13,10,26,33,42};
      System.out.println(main.rot13("GUR DHVPX OEBJA QBT WHZCRQ BIRE GUR YNML SBK."));

    }
}

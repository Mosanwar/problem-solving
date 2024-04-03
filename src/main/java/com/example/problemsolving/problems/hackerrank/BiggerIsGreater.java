package com.example.problemsolving.problems.hackerrank;

public class BiggerIsGreater {
    public static void main(String[] args) {
        System.out.println(biggerIsGreater("bb"));
    }

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 1;
        while (i > 0) {
            if (chars[i-1] >= chars[i]) {
                i--;
            } else {
                int j = i;

                while(j<chars.length && chars[j]>chars[i-1]){
                    j++;
                }

                char temp = chars[j-1];
                chars[j-1] = chars[i-1];
                chars[i-1] = temp;

                char[] newChars = new char[chars.length];
                for (int k = 0; k <= i; k++) {
                    newChars[k] = chars[k];
                }

                int end = chars.length-1;

                for(int k=i;k<chars.length;k++){
                    newChars[k]=chars[end--];
                }
                return new String(newChars);
            }
        }

        return "no answer";
    }

}

package com.example.problemsolving.problems.leetcode;

import java.util.*;

//https://leetcode.com/problems/guess-the-word/description/?envType=study-plan-v2&envId=google-spring-23-high-frequency
public class GuessTheWord {
    public static void main(String[] args) {
//        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
//        Master master = new Master(words, 5);
//        findSecretWord(words, master);
        Stack<Integer> stack = new Stack<>();
        stack.peek();
    }

    public static void findSecretWord(String[] words, Master master) {
        String mostMatchedWord = "";
        int mostMatchedLetters = 0;
        int currentMatch;
        for(String word: words) {
            if (mostMatchedLetters == 0) {
                mostMatchedLetters = master.guess(word);
                if (mostMatchedLetters == 6) {
                    System.out.println("You guessed the secret word correctly.");
                    break;
                } else if(mostMatchedLetters != 0) {
                    mostMatchedWord = word;
                }
            } else {
                currentMatch = getMatches(word, mostMatchedWord);
                if (currentMatch >= mostMatchedLetters) {
                    currentMatch = master.guess(word);
                    if (currentMatch == 6) {
                        System.out.println("You guessed the secret word correctly.");
                        break;
                    } else if (currentMatch >= mostMatchedLetters) {
                        mostMatchedLetters = currentMatch;
                        mostMatchedWord = word;
                    }
                }
            }
            System.out.println("Either you took too many guesses, or you did not find the secret word.");
        }
    }

    private static int getMatches(String word, String mostMatchedWord) {
        int numberOfMatches = 0;
        for (int i = 0; i <mostMatchedWord.length(); i++) {
            if (mostMatchedWord.charAt(i) == word.charAt(i)) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    static class Master {
        private int allowedGuesses;
        private Set<String> wordsSet;
        private String secret;

        public Master(String[] words, int allowedGuesses) {
            this.allowedGuesses = allowedGuesses;
            wordsSet = new HashSet<>(Arrays.asList(words));
            secret = words[new Random().nextInt(words.length)];
        }

        public int guess(String word) {
            if (allowedGuesses-- <= 0 || !wordsSet.contains(word)) {
                return -1;
            } else if (word.equals(secret)) {
                return 6;
            } else
                return getMatches(word);
        }

        private int getMatches(String word) {
            int numberOfMatches = 0;
            for (int i = 0; i <secret.length(); i++) {
                if (secret.charAt(i) == word.charAt(i)) {
                    numberOfMatches++;
                }
            }
            return numberOfMatches;
        }
    }
}

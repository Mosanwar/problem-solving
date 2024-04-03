package com.example.problemsolving.problems.annotationdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

public class ReadFileConstructASentence {
    public static void main(String[] args) throws IOException {
        System.out.println(decodeFile(new File("src/main/resources/test.txt")));
    }

    public static String decodeFile(File message_file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(message_file));
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        String[] words = new String[lines];
        br = new BufferedReader(new FileReader(message_file));
        int position;
        String line = br.readLine();
        while (line != null) {
            position = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            words[position-1] = line.substring(line.indexOf(" ")+1);
            line = br.readLine();
        }
        StringJoiner sj = new StringJoiner(" ");
        int n = 0, i = 1;
        while (n < words.length) {
            sj.add(words[n]);
            i++;
            n = n + i;
        }
        return sj.toString();
    }
}

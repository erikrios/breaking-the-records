package com.erikriosetiawan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static int[] breakingRecords(int[] scores) {
        int max = scores[0];
        int min = scores[0];

        int highestScore = 0;
        int lowestScore = 0;

        for (int i = 0; i < scores.length - 1; i++) {
            if (max < scores[i + 1]) {
                max = scores[i + 1];
                highestScore++;
            }

            if (min > scores[i + 1]) {
                min = scores[i + 1];
                lowestScore++;
            }
        }

        return new int[]{highestScore, lowestScore};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

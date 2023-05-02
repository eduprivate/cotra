package br.eduprivate.problems_solving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            int value = grades[i];
            if (value < 38) {
            	continue;
            }
            else if (value % 5 == 0) {
                continue;
            }
            else {
            	int oldValue = value;
                while (value % 5 != 0) {
                    value++;
                }
                if (value - oldValue < 3) {
                	grades[i] = value;
                }
                else if (value - oldValue == 3) {
                	grades[i] = oldValue;
                }
            }
        }
        return grades;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}

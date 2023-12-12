package br.eduprivate.problems_solving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopKElementsHashMap {

    public HashMap<String, Integer> parseFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));

        HashMap<String, Integer> result = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String name = line.substring(0, line.indexOf(">") + 1);
            String text = line.substring(line.indexOf(">") + 1);
            String[] arrayText = text.split(" ");

            if (result.containsKey(name)){
                Integer count = result.get(name);
                result.put(name, count+arrayText.length);
            } else {
                result.put(name, arrayText.length);
            }

        }

        scanner.close();

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String file = "logs";
        int n = 2;
        TopKElementsHashMap topKElements = new TopKElementsHashMap();
        HashMap<String, Integer> hash = topKElements.parseFile(file);

        Object[] values = hash.entrySet().toArray();
        Arrays.sort(values, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });



        for (Object e : values) {
            if (n>0) {
                System.out.println(((Map.Entry<String, Integer>) e).getKey() + " : "
                        + ((Map.Entry<String, Integer>) e).getValue());
                n--;
            } else {
                break;
            }
        }

    }

}

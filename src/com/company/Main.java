package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите номер задания: ");
        Scanner in1 = new Scanner(System.in);
        int x  = in1.nextInt();
        switch (x) {
            case (1) -> {
                ArrayList<String> lastNamesList = new ArrayList<>();
                System.out.println("Введите список фамилий: ");
                for (int i = 0; i < 10; i++) {
                    Scanner in = new Scanner(System.in);
                    String n = in.nextLine();
                    lastNamesList.add(n);
                }
                Collections.sort(lastNamesList);
                System.out.println("Сортировка по алфавиту: ");
                for (int i = 0; i < lastNamesList.size(); i++) {
                    System.out.println(lastNamesList.get(i));
                }
                int[] lastNamesCount = new int[lastNamesList.size()];
                for (int i = 0; i < lastNamesList.size(); i++) {
                    for (int j = 0; j < lastNamesList.size(); j++) {
                        if (lastNamesList.get(i).equals(lastNamesList.get(j))) {
                            lastNamesCount[i]++;
                        }

                    }
                }
                ArrayList<Pair> pairedList = new ArrayList<>();
                for (int i = 0; i < lastNamesList.size(); i++) {
                    Pair tempPair = new Pair(lastNamesList.get(i), lastNamesCount[i]);
                    pairedList.add(tempPair);
                }
                Set<Pair> temp = new HashSet<>(pairedList);
                pairedList.clear();
                pairedList.addAll(temp);
                System.out.println("Сколько раз встречается каждая фамилия: ");
                for (Pair pair : pairedList) {
                    System.out.println(pair.getLeft() + "  " + pair.getRight() + " раза");
                }
            }
            case (2) -> {
                Date beforeArraylist = new Date();
                ArrayList<Integer> exampleArraylist = new ArrayList<>();
                for (int i = 0; i < 1000000; i++) {
                    exampleArraylist.add(1);
                }
                for (int i = 0; i < 1000; i++) {
                    exampleArraylist.remove(1);
                }
                Date afterArraylist = new Date();
                long ArrayList = afterArraylist.getTime() - beforeArraylist.getTime();
                System.out.println("ArrayList  : " + ArrayList);


                Date beforeLinkedlist = new Date();
                LinkedList<Integer> exampleLinkedlist = new LinkedList<>();
                for (int i = 0; i < 1000000; i++) {
                    exampleLinkedlist.addLast(1);
                }
                for (int i = 0; i < 1000; i++) {
                    exampleLinkedlist.removeFirst();
                }
                Date afterLinkedlist = new Date();
                long LinkedList = afterLinkedlist.getTime() - beforeLinkedlist.getTime();
                System.out.println("LinkedList : " + LinkedList);
            }
            case (3) -> {
                ArrayList<Student> Students = GetFile("students.txt");
                TreeMap<Double, String> StudentsTreeMap = new TreeMap<Double, String>();
                for (int i = 0; i < Students.size(); i++){
                    StudentsTreeMap.put(Students.get(i).averageMark, Students.get(i).lastName);
                }

                for(Map.Entry<Double, String> entry : StudentsTreeMap.entrySet()) {
                    Double key = entry.getKey();
                    String value = entry.getValue();

                    System.out.println(value + " => " + key);
                }

            }
            case (4) -> {


            }
            default -> System.out.println("Такого задания нет");
        }

    }

    public static ArrayList<Student> GetFile(String path){
        ArrayList<Student> value = new ArrayList<>();
        File file = new File(path);
        try {

            int count=0;
            Scanner size2scanner = new Scanner(file);
            while(size2scanner.hasNextLine()) {
                size2scanner.nextLine();
                count++;
            }
            size2scanner.close();




            Scanner scanner = new Scanner(file);

            for (int i = 0; i < count; i++) {
                String[] strings = scanner.nextLine().split(" ");
                Student temp = new Student();
                temp.lastName = strings[0];
                temp.averageMark = Double.parseDouble(strings[1]);
                temp.age = Integer.parseInt(strings[1]);
                value.add(temp);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}

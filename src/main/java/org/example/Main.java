package org.example;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        HashMap<String, HashSet<Integer>> phoneBook = new HashMap<String, HashSet<Integer>>();
        LinkedHashMap<String, HashSet<Integer>> phoneBookSort = new LinkedHashMap<String, HashSet<Integer>>();
        while (true){
            String name = InputFIO("Для завершения ввода введите 'end'.\nВведите имя: ");
            if(name.equalsIgnoreCase("end")) {
                break;
            } else {
                if (phoneBook.containsKey(name)) {
                    if(phoneBook.get(name).add(InputNum("Имя существует\nДобавте номер: "))) {
                        System.out.println("Номер добавлен: " + phoneBook.get(name));
                        System.out.println("-".repeat(35));
                    }
                    else {
                        System.out.println("Ошибка: номер уже был добавлен.");
                        System.out.println("-".repeat(35));
                    }
                } else {
                    phoneBook.put(name, InputNums("Введите номер: "));
                    System.out.println("Номер добавлен: " + phoneBook.get(name));
                    System.out.println("-".repeat(35));
                }
            }
        }

        ArrayList<String> names = new ArrayList<String>();
        String name = null;
        int size = 0;
        for(int i = 0; i < phoneBook.size(); i++) {
            for (String line : phoneBook.keySet()) {
                if (names.contains(line)) {
                    continue;
                }
                else if (size < phoneBook.get(line).size()) {
                    size = phoneBook.get(line).size();
                    name = line;
                }
            }
            names.add(name);
            size = 0;
        }
        for(String line: names){
            phoneBookSort.put(line, phoneBook.get(line));
        }
        System.out.println(phoneBookSort.toString());

        /*phoneBookSort.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e->e.getValue().size());*/
    }


    static String InputFIO (String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String name = input.nextLine();
        return name;
    }
    static HashSet<Integer> InputNums (String message) {
        HashSet<Integer> numbers = new HashSet<>();
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int number = input.nextInt();
        numbers.add(number);
        return numbers;
    }
    static int InputNum (String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int number = input.nextInt();
        return number;
    }
}
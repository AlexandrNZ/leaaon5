package org.example;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем телефонную книгу
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addPhone(phoneBook, "Иванов", "111-111-111");
        addPhone(phoneBook, "Иванов", "222-222-222");
        addPhone(phoneBook, "Петров", "333-333-333");
        addPhone(phoneBook, "Сидоров", "444-444-444");
        addPhone(phoneBook, "Сидоров", "555-555-555");
        addPhone(phoneBook, "Сидоров", "666-666-666");

        // Выводим результаты
        printPhoneBook(phoneBook);
    }

    // Метод для добавления телефонного номера в книгу
    public static void addPhone(Map<String, List<String>> phoneBook, String name, String phone) {
        // Если имя уже существует в книге, добавляем новый номер в список для этого имени
        if (phoneBook.containsKey(name)) {
            List<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            // Если имя еще не существует в книге, создаем новый список номеров и добавляем его в книгу
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    // Метод для вывода телефонной книги в отсортированном виде
    public static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей книги, сортируем их по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
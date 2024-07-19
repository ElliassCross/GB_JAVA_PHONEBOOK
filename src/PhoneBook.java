import java.util.*;

public class PhoneBook {

    // HashMap для хранения телефонной книги
    private HashMap<String, List<String>> phoneBook;

    // Конструктор
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления нового номера телефона для человека
    public void addPhoneNumber(String name, String phoneNumber) {
        // Проверяем, существует ли уже запись с таким именем
        if (!phoneBook.containsKey(name)) {
            // Если нет, создаем новый список и добавляем номер
            phoneBook.put(name, new ArrayList<>(Arrays.asList(phoneNumber)));
        } else {
            // Если существует, добавляем новый номер в существующий список
            phoneBook.get(name).add(phoneNumber);
        }
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    public void printPhoneBook() {
        // Создаем список записей из HashMap для сортировки
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по размеру списка телефонов (по убыванию)
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + String.join(", ", phoneNumbers));
        }
    }

    // Основной метод для тестирования
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем номера телефонов
        phoneBook.addPhoneNumber("John Doe", "123-456-7890");
        phoneBook.addPhoneNumber("Jane Smith", "234-567-8901");
        phoneBook.addPhoneNumber("John Doe", "345-678-9012");
        phoneBook.addPhoneNumber("Jane Smith", "345-678-9012");
        phoneBook.addPhoneNumber("Alice Johnson", "456-789-0123");

        // Печатаем телефонную книгу
        phoneBook.printPhoneBook();
    }
}

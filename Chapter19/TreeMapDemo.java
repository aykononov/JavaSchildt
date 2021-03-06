package Chapter19;

import java.util.*;

// Продемонстрировать применение класса TreeMap
class TreeMapDemo {
    public static void main(String[] args) {
        // создать древовидное отображение
        TreeMap<String, Double> tm = new TreeMap<String, Double>();

        // ввести элементы в хеш-отображение
        tm.put("Джoн Доу", new Double(3434.34));
        tm.put("Toм Смит", new Double(123.22));
        tm.put("Джейн Бейкер", new Double(1378.00));
        tm.put("Тод Холл", new Double(99.22));
        tm.put("Paльф Смит", new Double(-19.08));

        // получить множество записей из метода entrySet()
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        // вывести множество записей
        // Ключи и значения выводятся в результате вызова методов getKey() и getValue()
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
        System.out.println();

        // внести сумму 1000 на счет "Джона Доу"
        double balance = tm.get("Джoн Доу");
        tm.put("Джoн Доу", balance + 1000.00);
        System.out.println("Hoвый остаток на счете Джона Доу: " + tm.get("Джoн Доу"));
        System.out.println();

        // вывести множество записей
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }
}
/* --------------------------------------
Paльф Смит: -19.08
Toм Смит: 123.22
Джoн Доу: 3434.34
Джейн Бейкер: 1378.0
Тод Холл: 99.22

Hoвый остаток на счете Джона Доу: 4434.34

Paльф Смит: -19.08
Toм Смит: 123.22
Джoн Доу: 4434.34
Джейн Бейкер: 1378.0
Тод Холл: 99.22
 */
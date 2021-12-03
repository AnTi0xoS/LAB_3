package com.lab_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Программа для проверки введенной пользователем строки на соответствие формату даты dd/mm/yyyy
// начиная с 1900 года до 9999 года

// Программа учитывает количество дней в определенных месяцах (30 или 31),
// для февраля допустимо 29-ое число для любого года в указанном диапазоне

public class Main {
    public static boolean checkDate(String s) {  // Функция для проверки даты
        Pattern patternFor30 = Pattern.compile("(0[1-9]|[12]\\d|30)/(0[469]|11)[/](19|[2-9]\\d)\\d{2}");
        Pattern patternFor31 = Pattern.compile("(0[1-9]|[12]\\d|3[01])[/](0[13578]|1[02])[/](19|[2-9]\\d)\\d{2}");
        Pattern patternForFebruary = Pattern.compile("(0[1-9]|1\\d|2[0-9])[/]02[/](19|[2-9]\\d)\\d{2}");

        // patternFor30 - проверка для месяцев с 30-ю днями
        // patternFor31 - проверка для месяцев с 31-им днем
        // patternForFebruary - проверка для февраля (29 дней вне зависимости от высокосности года)

        Matcher matcherFor30 = patternFor30.matcher(s);
        Matcher matcherFor31 = patternFor31.matcher(s);
        Matcher matcherForFebruary = patternForFebruary.matcher(s);

        return matcherFor30.matches() || matcherFor31.matches() || matcherForFebruary.matches();
        // Программа считает строку удовлетворяющей формату dd/mm/yyyy только тогда,
        // когда вся строка подходит под этот шаблон, поэтому используется метод matches()
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);             // Ввод пользователем данных с клавиатуры
        System.out.println("Enter the date in the format dd/mm/yyyy");
        String date = in.nextLine();

        if (checkDate(date)) {
            System.out.println("The date is correct.");
        }
        else {
            System.out.println("The date is wrong!");
        }
        in.close();
    }
}

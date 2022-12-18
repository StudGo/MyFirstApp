package lab4;

import java.util.Scanner;

public class example9 {


    public static String getEncryptString(String encryptString, int shift) {
        char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        char[] ArrayChar = encryptString.toCharArray(); // преобразуем переданную в метод строку в символьный массив
        long[] ArrayInt = new long[ArrayChar.length]; // создаем массив с типом данных long, размер массива равен размеру символьного массива
        char[] ArrayCharNew = new char[ArrayChar.length]; // создаем символьный массив в который будем записывать преобразованные символы

        for (int i = 0; i < ArrayChar.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (ArrayChar[i] == alphabet[j]) {
                    ArrayCharNew[i] = alphabet[(j + shift) % 33];
                }
            }
        }

        //в цикле перебираем все символы из которых состоит переданная нами строка и прибавляем к ним число, ключ (сдвиг)
        for (int i = 0; i< ArrayChar.length; i++)
        {
            ArrayInt[i] = ArrayChar[i] + shift; // прибавляем к символу с индексом i сдвиг
            ArrayCharNew[i] = (char)ArrayInt[i]; // преобразовываем число в символ char и записываем на нужное место в новый массив
        }
        encryptString = new String (ArrayCharNew); // преобразовываем новый массив символов в строку
        return encryptString; // возвращаем строку в метод из которого был вызван текущий метод
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = in.nextLine();
        System.out.println("Введите ключ:");
        int key = in.nextInt();
        text = getEncryptString(text, key);
        System.out.println("Текст после преобразования");
        System.out.println(text);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        boolean b = true;
        while(b) {

            String ans = in.next();

            switch (ans.toLowerCase()) {
                case "y" -> {
                    text = getEncryptString(text, -key);
                    System.out.println(text);

                    b = false;
                }
                case "n" -> {
                    System.out.println("До свидания!");

                    b = false;
                }
                default -> System.out.println("Введите корректный ответ");
            }
        }
    }
}

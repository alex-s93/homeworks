package com.alevel.homework12;

public class Exceptions {
    public static void main(String[] args) {
        ClassCastExceptionTest("test");
        NullPointerExceptionTest(null);
        NumberFormatExceptionTest("test1");
        ArrayIndexOutOfBoundsExceptionTest(new String[]{"test1", "test2"}, 2);
    }

    static void ClassCastExceptionTest(Object x) {
        try {
            System.out.println((int) x);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException message: " + e.getMessage());
        }
    }

    static void NullPointerExceptionTest(Integer x) {
        try {
            System.out.println(x * 2);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException message: " + e.getMessage());
        }
    }

    static void NumberFormatExceptionTest(String value) {
        try {
            Integer.parseInt(value);
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException message: " + e.getMessage());
        }
    }

    static void ArrayIndexOutOfBoundsExceptionTest(String[] strings, int index) {
        try {
            System.out.println(strings[index]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException message: " + e.getMessage());
        }
    }

    /**
     * По поводу обработки исключений:
     *      Если мы ожидаем, что в программе могут возникнуть какие-либо исключения и такое поведение будет
     *      нормальным - добавляем обработку тех самых исключений.
     *      Из вышеперечисленного списка исключений любое может попасть под такие условия.
     */

}

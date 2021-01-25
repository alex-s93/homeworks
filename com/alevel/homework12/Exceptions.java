package com.alevel.homework12;

public class Exceptions {
    public static void main(String[] args) {
//        ClassCastExceptionTest();
//        NullPointerExceptionTest();
//        NumberFormatExceptionTest();
        ArrayIndexOutOfBoundsExceptionTest();
    }

    static void ClassCastExceptionTest() {
        Object x = "test";
        System.out.println((int) x);
    }

    static void NullPointerExceptionTest() {
        Integer x = null;
        System.out.println(x * 2);
    }

    static void NumberFormatExceptionTest() {
        String[] a = {"test1", "test2"};
        Integer.parseInt(a[0]);
    }

    static void ArrayIndexOutOfBoundsExceptionTest() {
        String[] a = {"test1", "test2"};
        System.out.println(a[2]);
    }

    /**
     * По поводу обработки исключений:
     *      Если мы ожидаем, что в программе могут возникнуть какие-либо исключения и такое поведение будет
     *      нормальным - добавляем обработку тех самых исключений.
     *      Из вышеперечисленного списка исключений любое может попасть под такие условия.
     */

}

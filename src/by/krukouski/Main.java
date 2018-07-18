package by.krukouski;

public class Main {

    public static void main(String[] args) {

        byte myByteValue =  122; // объявление и инициализация переменной типа byte

        short myShortValue = 32_323; // объявление и инициализация переменной типа short

        int myIntValue = 2_147_483_647; // объявление и инициализация переменной типа int

        long myLongValue = 9_223_372_036_854_775_807L; // объявление и инициализация переменной типа long

        float myFloatValue = 3.4e38f; // объявление и инициализация переменной типа float

        double myDoubleValue = 4.9e-324; // объявление и инициализация переменной типа double

        char myCharValue = 'A'; // объявление и инициализация переменной типа char
        char myCharIntValue = 97;

        boolean myBooleanValue = true; // объявление и инициализация переменной типа boolean


        String myStr1 = new String("My String 1"); // создание строки с помощью конструктора
        String myStr2 = "My String 2"; //создание строки с помощью кавычек ""
        String myStr3 = myStr1 + myStr2; // объединение (конкатенация) двух строк в одну. Вывод: "My String 1My String 2"


        int intValue = 33;
        byte byteValue = (byte) intValue; // преобразование int в byte (явное преобразование)

        byte b1 = 3;
        byte b2 = 1 + 7;

        //b1 = b2 + 9; //ошибка приведения типов int в byte
        b1 = (byte)(b2 + 9);

        final byte B = 12;
        b1 = B + 2;

        //b1 = -b2; //ошибка приведения типов
        b1 = (byte) -b2;

        int i = 7;
        //b1 = i; ошибка приведения типов, int больше чем byte
        b1 = (byte) i;

        final int D = 15;
        b1 = D;
        final int D2 = 128;
        //b1 = D2; //ошибка приведения типов, 128 больше чем максимальное значение 127
        b1 = (byte) D2;

        b1 += i++;
        b1 += 1000;
        b2 *= 2;
        float f =1.3f;
        b1 /= f;
        /* все сокращенные операторы автоматически преобразуют результат выражения к типу переменной,
        которой присваивается это значение. Например, b /= f; равнасильно b = (byte)(b / f);
         */




        /*int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b)); // Вывод: a + b = 30
        System.out.println("a - b = " + (a - b)); // Вывод: a - b = -10
        System.out.println("a * b = " + (a * b)); // Вывод: a * b = 200
        System.out.println("b / a = " + (b / a)); // Вывод: b / a = 2
        System.out.println("b % a = " + (b % a)); // Вывод: b % a = 0
        System.out.println("c % a = " + (c % a)); // Вывод: c % a = 5
        System.out.println("a++   = " +  (a++));  // Вывод: a++   = 10
        System.out.println("b--   = " +  (a--));  // Вывод: b--   = 11
        // Проверьте разницу в d++ и ++d
        System.out.println("d++   = " +  (d++));  // Вывод: d++   = 25
        System.out.println("++d   = " +  (++d));  // Вывод: ++d   = 27*/



        /*int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) ); // Вывод: a == b = false
        System.out.println("a != b = " + (a != b) ); // Вывод: a != b = true
        System.out.println("a > b = " + (a > b) );   // Вывод: a > b = false
        System.out.println("a < b = " + (a < b) );   // Вывод: a < b = true
        System.out.println("b >= a = " + (b >= a) ); // Вывод: b >= a = true
        System.out.println("b <= a = " + (b <= a) ); // Вывод: b <= a = false*/




        /*int a = 60;	*//* 60 = 0011 1100 *//*
        int b = 13;	*//* 13 = 0000 1101 *//*
        int c = 0;

        c = a & b;       *//* 12 = 0000 1100 *//*
        System.out.println("a & b = " + c );   // Вывод: a & b = 12

        c = a | b;       *//* 61 = 0011 1101 *//*
        System.out.println("a | b = " + c );   // Вывод: a | b = 61

        c = a ^ b;       *//* 49 = 0011 0001 *//*
        System.out.println("a ^ b = " + c );   // Вывод: a ^ b = 49

        c = ~a;          *//*-61 = 1100 0011 *//*
        System.out.println("~a = " + c );      // Вывод: ~a = -61

        c = a << 2;     *//* 240 = 1111 0000 *//*
        System.out.println("a << 2 = " + c );  // Вывод: a << 2 = 240

        c = a >> 2;     *//* 215 = 1111 *//*
        System.out.println("a >> 2  = " + c ); // Вывод: a >> 15

        c = a >>> 2;     *//* 215 = 0000 1111 *//*
        System.out.println("a >>> 2 = " + c ); // Вывод: a >>> 15
*/

        /*boolean a = true;
        boolean b = false;

        System.out.println("a && b = " + (a&&b));        // Output: a && b = false

        System.out.println("a || b = " + (a||b) );       // Output: a || b = true

        System.out.println("!(a && b) = " + !(a && b));  // Output: !(a && b) = true*/


        /*int a = 10; int b = 20; int c = 0;

        c = a + b;
        System.out.println("c = a + b = " + c ); // Output: c = a + b = 30

        c += a ;
        System.out.println("c += a  = " + c );   // Output: c += a  = 40

        c -= a ;
        System.out.println("c -= a = " + c );    // Output: c -= a = 30

        c *= a ;
        System.out.println("c *= a = " + c );    // Output: c *= a = 300

        a = 10; c = 15; c /= a ;
        System.out.println("c /= a = " + c );    // Output: c /= a = 1

        a = 10; c = 15; c %= a ;
        System.out.println("c %= a  = " + c );   // Output: c %= a  = 5

        c <<= 2 ;
        System.out.println("c <<= 2 = " + c );   // Output: c <<= 2 = 20

        c >>= 2 ;
        System.out.println("c >>= 2 = " + c );   // Output: c >>= 2 = 5

        c >>= 2 ;
        System.out.println("c >>= a = " + c );   // Output: c >>= 2 = 1

        c &= a ;
        System.out.println("c &= 2  = " + c );   // Output: c &= a  = 0

        c ^= a ;
        System.out.println("c ^= a   = " + c );  // Output: c ^= a   = 10

        c |= a ;
        System.out.println("c |= a   = " + c );  // Output: c |= a   = 10*/


        /*int a , b;
        a = 10;
        b = (a == 1) ? 20 : 30;
        System.out.println( "Значение b: " +  b ); // Output: Значение b: 30

        b = (a == 10) ? 20 : 30;
        System.out.println( "Значение b: " + b );  // Output: Значение b: 20*/


        String name = "Олег";
        // Следующее вернётся верно, поскольку тип String
        boolean result = name instanceof String;
        System.out.println( result ); // Output: true

    }
}

public class SmallestModulo {
    public static void main(String[] args) {
        double numberOne = -19.22;
        double numberTwo = 16.73;
        double numberThree = -24.98;

        numberOne = (numberOne <= 0) ? 0 - numberOne : numberOne;
        numberTwo = (numberTwo <= 0) ? 0 - numberTwo : numberTwo;
        numberThree = (numberThree <= 0) ? 0 - numberThree : numberThree;

        if ((numberOne < numberTwo) && (numberOne < numberThree)) {
            System.out.println(numberOne + " is smallest");
        } else if (numberTwo < numberThree) {
            System.out.println(numberTwo + " is smallest");
        } else {
            System.out.println(numberThree + " is smallest");
        }

        // This is solving our problem using default Java packages. Compare with rows 7-17  :-)
//        double smallestNumber = Math.min(Math.abs(numberOne), Math.min(Math.abs(numberTwo), Math.abs(numberThree)));
//        System.out.println(smallestNumber);
    }
}

public class TestMyInteger {
    public static void main(String[] args) {
        MyInteger num = new MyInteger(17);

        System.out.println("Value: " + num.getValue());
        System.out.println("isEven(): " + num.isEven());
        System.out.println("isOdd(): " + num.isOdd());
        System.out.println("isPrime(): " + num.isPrime());

        System.out.println("isEven(10): " + MyInteger.isEven(10));
        System.out.println("isOdd(10): " + MyInteger.isOdd(10));
        System.out.println("isPrime(10): " + MyInteger.isPrime(10));

        MyInteger num2 = new MyInteger(10);
        System.out.println("isEven(MyInteger): " + MyInteger.isEven(num2));
        System.out.println("isOdd(MyInteger): " + MyInteger.isOdd(num2));
        System.out.println("isPrime(MyInteger): " + MyInteger.isPrime(num2));

        System.out.println("equals(17): " + num.equals(17));
        System.out.println("equals(MyInteger): " + num.equals(num2));

        char[] charArr = {'1', '2', '3'};
        System.out.println("parseInt(char[]): " + MyInteger.parseInt(charArr));
        System.out.println("parseInt(String): " + MyInteger.parseInt("456"));
    }
}

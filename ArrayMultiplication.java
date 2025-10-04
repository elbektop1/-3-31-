import java.util.Arrays;
import java.util.Scanner;

public class ArrayMultiplication {

    public static int[] multiplyArrays(int[] num1, int[] num2) {
        int n1 = num1.length;
        int n2 = num2.length;
        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                int sum = num1[i] * num2[j] + result[i + j + 1] + carry;
                result[i + j + 1] = sum % 10;
                carry = sum / 10;
            }
            result[i] += carry;
        }

        int start = 0;
        while (start < result.length - 1 && result[start] == 0) {
            start++;
        }

        return Arrays.copyOfRange(result, start, result.length);
    }

    public static int[] stringToDigitsArray(String numberStr) {
        int[] digits = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = numberStr.charAt(i) - '0';
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        String firstNumberStr = scanner.nextLine();

        System.out.println("Введите второе число: ");
        String secondNumberStr = scanner.nextLine();

        int[] number1 = stringToDigitsArray(firstNumberStr);
        int[] number2 = stringToDigitsArray(secondNumberStr);

        int[] product = multiplyArrays(number1, number2);

        System.out.println("Результат умножения: " + Arrays.toString(product));
    }
}
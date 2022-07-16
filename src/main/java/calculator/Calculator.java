package calculator;

import org.graalvm.compiler.serviceprovider.IsolateUtil;

import java.sql.SQLOutput;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    // 사칙연산 구현
    public int calculate(int firstVal, String operator, int secondVal) {
        switch (operator) {
            case "+":
                return add(firstVal, secondVal);
            case "-":
                return subtract(firstVal, secondVal);
            case "*":
                return multiply(firstVal, secondVal);
            case "/":
                return divide(firstVal, secondVal);
        }
        throw new IllegalArgumentException("연산자 자리에 확인되지 않은 문자가 들어왔습니다. 연산자 : " + operator);
    }

    public int add(int firstVal, int secondVal) {
        return  firstVal + secondVal;
    }

    public int subtract(int firstVal, int secondVal) {
        return  firstVal - secondVal;
    }

    public int multiply(int firstVal, int secondVal) {
        return  firstVal * secondVal;
    }

    public int divide(int firstVal, int secondVal) {
        try {
            return  firstVal / secondVal;
        } catch (ArithmeticException e){
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
    }

    // 계산하기
    public int stringCalculator(String inputStr) {
        String[] str = splitString(inputStr);
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1], toInt(str[i + 2]));
        }
        return result;
    }

    public String[] splitString(String str) {
        return str.split(" ");
    }

    public int toInt(String str) {
        return Integer.parseInt(str);
    }

    // 문자열 입력받아 계산하기
    public int inputStringCalculator() {
        Scanner scanner = new Scanner(System.in);
        String str;
        try {
            str = scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("공백은 입력될 수 없습니다.");
        }

        int result = 0;
        try {
            result = stringCalculator(str);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("띄워쓰기가 잘못되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자가 잘못입력되었습니다.");
        }
        scanner.close();
        return result;

    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static int calc1(int num1, int num2, String input) {
        int r = 0;
        if (num1 == 0 || num2 == 0 || num1 > 10 || num2 > 10) {
            System.exit(1);
        }
        if (input.contains("+")) {
            r = num1 + num2;
        }
        if (input.contains("-")) {
            r = num1 - num2;
        }
        if (input.contains("/")) {
            r = num1 / num2;
        }
        if (input.contains("*")) {
            r = num1 * num2;
        }
        return r;
    }

    public static String calc(String input) {
        String[] part = input.split("[+\\-/*]", 2);
        String part1 = part[0];
        String part2 = part[1];
        String one = part1.trim();
        String two = part2.trim();
        if (one.codePointAt(0) <= 57 && two.codePointAt(0) <= 57) {
            int num1 = Integer.parseInt(one);
            int num2 = Integer.parseInt(two);
            String res = Integer.toString(calc1(num1, num2, input));
            return res;
        }
        if (one.codePointAt(0) >= 73 && two.codePointAt(0) >= 73) {
            number n1 = number.valueOf(one);
            number n2 = number.valueOf(two);
            int num1 = n1.ordinal();
            int num2 = n2.ordinal();
            int result = calc1(num1, num2, input);
            if (result > 0) {
                number[] num3 = number.values();
                number ress = num3[result];
                String res = ress.name();
                return res;
            }
        }
        System.exit(1);
        return part1;
    }

    public enum number {
        O, I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX,
        XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX, XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX, XL,
        XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX, L, LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX,
        LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII, LXIX, LXX,
        LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX, LXXX,
        LXXXI, LXXXII, LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC,
        XCI, XCII, XCIII, XCIV, XCV, XCVI, XCVII, XCVIII, XCIX, C
    }
}
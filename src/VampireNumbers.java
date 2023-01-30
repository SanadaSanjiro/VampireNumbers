public class VampireNumbers {
    public static void vampireNumbersSearch()
        {
            for (int i = 1000; i<10000; i++) {
                int[] digits = splitToDigits(i);
                checkNumber(digits, i);
            }
        }

    public static void main(String[] args) {
        vampireNumbersSearch();
    }

    public static int[] splitToDigits(int digit)
    {
        int[] digits = new int[4];
        for (int i = 3; i>=0; i--)
        {
            digits[i] = digit % 10;
            digit /=10;
        }
        return digits;
    }

    public static void checkNumber(int[] digits, int number)
    {
        int digit1, digit2, digit3, digit4;
        int numberLeft;
        int numberRight;
        label:
        for (int i = 0; i < 4; i++)
        {
            digit1 = digits[i];
            for (int j = 0; j < 4; j++)
            {
                if (i==j) continue;
                digit3 = digits[j];
                for (int k = 0; k < 4; k++)
                {
                    if(k==i||k==j) continue;
                    digit2 = digits[k];
                    for (int l = 0; l < 4; l++) {
                        if (l == k || l == j || l == i) continue;
                        digit4 = digits[l];
                        //System.out.println("Проверяем цифры " + digit1 + ", " +
                        //        digit2 + ", " + digit3 + ", " + digit4);
                        numberLeft = digit1 * 10 + digit2;
                        numberRight = digit3 * 10 + digit4;
                        //System.out.println("Получили сочетание чисел " + numberLeft +
                        //        " и " + numberRight);

                        if ((numberLeft * numberRight) == number) {
                            System.out.println("Найдено число-вампир " + number);
                            System.out.println(number + " = " + numberLeft +
                                    " * " + numberRight);
                            break label;
                        }
                    }
                }
            }
        }
    }
}

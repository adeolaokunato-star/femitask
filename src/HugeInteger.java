public class HugeInteger {

    private int[] digits = new int[40];

    public void parse(String number) {
        int start = 40 - number.length();

        for (int yum = 0; yum < number.length(); yum++) {
            digits[start + yum] = number.charAt(yum) - '0';
        }
    }

    public String toString() {
        String result = "";
        boolean started = false;

        for (int digit : digits) {
            if (digit != 0 || started) {
                result += digit;
                started = true;
            }
        }

        if (!started) {
            return "0";
        }

        return result;
    }

    public HugeInteger add(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int carry = 0;

        for (int i = 39; i >= 0; i--) {
            int sum = digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }

        return result;
    }

    public HugeInteger subtract(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int borrow = 0;

        for (int i = 39; i >= 0; i--) {
            int difference = digits[i] - other.digits[i] - borrow;

            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.digits[i] = difference;
        }

        return result;
    }

    public HugeInteger multiply(HugeInteger other) {
        HugeInteger result = new HugeInteger();

        for (int i = 39; i >= 0; i--) {
            int carry = 0;

            for (int j = 39; j >= 0; j--) {
                int position = i + j - 39;

                if (position >= 0) {
                    int product = digits[i] * other.digits[j]
                            + result.digits[position]
                            + carry;

                    result.digits[position] = product % 10;
                    carry = product / 10;
                }
            }
        }

        return result;
    }

    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isGreaterThan(HugeInteger other) {
        for (int i = 0; i < 40; i++) {
            if (digits[i] > other.digits[i]) {
                return true;
            }

            if (digits[i] < other.digits[i]) {
                return false;
            }
        }

        return false;
    }

    public boolean isLessThan(HugeInteger other) {
        for (int i = 0; i < 40; i++) {
            if (digits[i] < other.digits[i]) {
                return true;
            }

            if (digits[i] > other.digits[i]) {
                return false;
            }
        }

        return false;
    }

    public HugeInteger divide(HugeInteger other) {
        HugeInteger result = new HugeInteger();

        int div = 0;

        for (int i = 0; i < 40; i++) {

            div = div * 10 + digits[i];

            int quotientDigit = 0;

            while (div >= other.digits[39]) {
                div = div - other.digits[39];
                quotientDigit++;
            }

            result.digits[i] = quotientDigit;
        }

        return result;
    }
}
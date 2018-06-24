public interface NumberFormatter {
    String format(int n);
}

class BaseFormatter implements NumberFormatter {
    int base;
    
    BaseFormatter(int base) {
        this.base = base;
    }

    String format(int n) {
        // 5 ==> 101
        String ret = "";
        while (n > 0) {
            int digit = n % base;
            char digitAscii;
            if (digit < 10)   
                digitAscii = (char)(digit + '0');
            else
                digitAscii = (char)(digit - 10 + 'A')

            ret = digitAscii + ret;
            n /= base;
        }
        
        return ret;
        
    }
}

class DefaultFormatter implements NumberFormatter {
    String format(int n) {
        return "" + n ; // "n"
    }
}

class DecimalSeparatorFormatter implements NumberFormatter {
    String format(int n) {
        String currentString = "" + n;
        String ret = "";
        
        // 10000
        int counter = 1;
        for (int i = currentString.length() - 1; i >= 0; i--) {
            if (counter % 3 == 0) {
                ret += ",";
            }
           // return String.format("%,d", n);
            ret += currentString.charAt(i);
            counter++;
        }
        
        return ret;
    }
}

class AccountingFormatter implements NumberFormatter {
    String format(int n) {
        if (n < 0)
            return "(" + (int)Math.abs(n) + ")";
        else
            return n + "";
    }
}


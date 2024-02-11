package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class FibonacciCounter {

    private FibonacciCounter() {
    }

    private final static int actualDayOfTheMonth = Integer.parseInt(new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));

    private static int fibonacci(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    public static int getFibonacciByActualDay() {
        return fibonacci(actualDayOfTheMonth);
    }
}

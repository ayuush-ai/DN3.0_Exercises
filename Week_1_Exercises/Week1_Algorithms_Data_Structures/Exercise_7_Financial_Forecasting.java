


public class Exercise_7_Financial_Forecasting {

    // Step 2: Setup - Create a method to calculate the future value using a recursive approach
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        // Base case: If no more years to predict, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Recursive case: Calculate the future value for the next year
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized version using memoization
    public static double predictFutureValueMemo(double currentValue, double growthRate, int years, double[] memo) {
        // Base case: If no more years to predict, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Check if the value has already been computed
        if (memo[years] != 0) {
            return memo[years];
        }
        // Recursive case: Calculate the future value for the next year
        memo[years] = predictFutureValueMemo(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Current value
        double growthRate = 0.05;     // 5% annual growth rate
        int years = 10;               // Number of years to predict

        // Predict future value using the recursive method
        double futureValue = predictFutureValue(currentValue, growthRate, years);
        System.out.println("Predicted future value calculated by our code (recursive): " + futureValue);

        // Predict future value using the optimized recursive method with memoization
        double[] memo = new double[years + 1];
        double futureValueMemo = predictFutureValueMemo(currentValue, growthRate, years, memo);
        System.out.println("Predicted future value calculated by our code (optimized recursive): " + futureValueMemo);
    }
}

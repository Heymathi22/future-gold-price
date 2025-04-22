import java.util.Scanner;

public class GoldPricePrediction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the current year's gold price
        System.out.print("Enter the current year's gold price (per ounce): ");
        double currentPrice = scanner.nextDouble();
        
        // Input the last 10 years of gold prices
        double[] historicalPrices = new double[10];
        System.out.println("Enter the gold prices for the last 10 years:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Year " + (2025 - i) + " price: ");
            historicalPrices[i] = scanner.nextDouble();
        }
        
        // Calculate the average yearly percentage change in price
        double averageAnnualChangeRate = calculateAverageAnnualChangeRate(historicalPrices);
        
        // Predict the future price for the next year (assuming the same growth rate)
        double predictedPrice = predictFuturePrice(currentPrice, averageAnnualChangeRate);
        
        // Output the results
        System.out.printf("The average annual price change rate is: %.2f%%\n", averageAnnualChangeRate);
        System.out.printf("Predicted gold price for next year: %.2f\n", predictedPrice);
        
        scanner.close();
    }

    // Method to calculate the average annual percentage change rate
    public static double calculateAverageAnnualChangeRate(double[] prices) {
        double totalChangeRate = 0;
        for (int i = 1; i < prices.length; i++) {
            double changeRate = ((prices[i] - prices[i - 1]) / prices[i - 1]) * 100;
            totalChangeRate += changeRate;
        }
        return totalChangeRate / (prices.length - 1);  // Average change rate over the 9 intervals
    }

    // Method to predict the future price based on the current price and average change rate
    public static double predictFuturePrice(double currentPrice, double averageAnnualChangeRate) {
        return currentPrice * (1 + averageAnnualChangeRate / 100);
    }
}

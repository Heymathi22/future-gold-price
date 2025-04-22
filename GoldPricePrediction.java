import java.util.Scanner;

public class GoldPricePrediction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the current year's gold price (per ounce): ");
        double currentPrice = scanner.nextDouble();
        double[] historicalPrices = new double[10];
        System.out.println("Enter the gold prices for the last 10 years:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Year " + (2025 - i) + " price: ");
            historicalPrices[i] = scanner.nextDouble();
        }
        double averageAnnualChangeRate = calculateAverageAnnualChangeRate(historicalPrices);
        double predictedPrice = predictFuturePrice(currentPrice, averageAnnualChangeRate);
        System.out.printf("The average annual price change rate is: %.2f%%\n", averageAnnualChangeRate);
        System.out.printf("Predicted gold price for next year: %.2f\n", predictedPrice);
        
        scanner.close();
    }
    public static double calculateAverageAnnualChangeRate(double[] prices) {
        double totalChangeRate = 0;
        for (int i = 1; i < prices.length; i++) {
            double changeRate = ((prices[i] - prices[i - 1]) / prices[i - 1]) * 100;
            totalChangeRate += changeRate;
        }
        return totalChangeRate / (prices.length - 1);  
    public static double predictFuturePrice(double currentPrice, double averageAnnualChangeRate) {
        return currentPrice * (1 + averageAnnualChangeRate / 100);
    }
}

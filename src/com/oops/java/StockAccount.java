package com.oops.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Renamed from Stock to StockAccount to match your file name
public class StockAccount {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    // Constructor matching the class name
    public StockAccount(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }

    public String getStockName() {
        return stockName;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    // Main execution entrypoint moved inside the public class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Stock #" + (i + 1) + ":");
            System.out.print("Stock Name: ");
            String name = scanner.next();
            System.out.print("Number of Shares: ");
            int shares = scanner.nextInt();
            System.out.print("Share Price: ");
            double price = scanner.nextDouble();

            // Creating StockAccount objects instead of Stock objects
            portfolio.addStock(new StockAccount(name, shares, price));
        }

        portfolio.printStockReport();
        scanner.close();
    }
}

// Managing a collection of StockAccount objects (Package-private helper class)
class StockPortfolio {
    private List<StockAccount> stocks;

    public StockPortfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(StockAccount stock) {
        stocks.add(stock);
    }

    public double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (StockAccount stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("\n--- STOCK REPORT ---");
        System.out.printf("%-15s %-15s %-12s %-12s\n", "Stock Name", "No. of Shares", "Share Price", "Total Value");
        System.out.println("---------------------------------------------------------");

        for (StockAccount stock : stocks) {
            System.out.printf("%-15s %-15d $%-11.2f $%-11.2f\n",
                    stock.getStockName(),
                    stock.getNumberOfShares(),
                    stock.getSharePrice(),
                    stock.calculateStockValue());
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("Total Portfolio Value: $%.2f\n", calculateTotalPortfolioValue());
    }
}
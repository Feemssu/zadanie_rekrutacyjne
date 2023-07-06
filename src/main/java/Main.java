import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Coin> coinList = getCoinList();

        System.out.println("Monety w kasie " + coinList);

        restCalculate(new BigDecimal("1.30"), coinList);

        restCalculate(new BigDecimal("11.70"), coinList);

        restCalculate(new BigDecimal("6.70"), coinList);

        restCalculate(new BigDecimal("4.30"), coinList);
    }

    private static List<Coin> getCoinList() {
        List<Coin> coinList = new ArrayList<>();
        coinList.add(new Coin("5 zł", new BigDecimal(5), 1));
        coinList.add(new Coin("2 zł", new BigDecimal(2), 3));
        coinList.add(new Coin("1 zł", new BigDecimal(1), 5));
        coinList.add(new Coin("50 gr", new BigDecimal("0.5"), 10));
        coinList.add(new Coin("20 gr", new BigDecimal("0.2"), 20));
        coinList.add(new Coin("10 gr", new BigDecimal("0.1"), 200));
        coinList.add(new Coin("5 gr", new BigDecimal("0.05"), 100));
        coinList.add(new Coin("2 gr", new BigDecimal("0.02"), 100));
        coinList.add(new Coin("1 gr", new BigDecimal("0.01"), 10000));
        return coinList;
    }


     public static void restCalculate(BigDecimal amount, List<Coin> coinList) {
        coinList.sort(Comparator.comparing(Coin::getValue).reversed());
        BigDecimal remainingAmount = amount;
        Map<Coin, Integer> usedCoinCounts = new LinkedHashMap<>();

         for (Coin coin : coinList) {
             int count = 0;
             while (remainingAmount.compareTo(coin.getValue()) >= 0 && coin.getQuantity() > 0) {
                 remainingAmount = remainingAmount.subtract(coin.getValue());
                 coin.setQuantity(coin.getQuantity() - 1);
                 count++;
             }
             if (count > 0 ) {
                 usedCoinCounts.put(coin, count);
             }
         }

         System.out.println("\nDla reszty " + amount + " zł");
         for (Map.Entry<Coin, Integer> entry : usedCoinCounts.entrySet()) {
             Coin coin = entry.getKey();
             int count = entry.getValue();
             System.out.println("Wydaj " + count + " monet " + coin.getName());
         }
         System.out.println("\nMonety w kasie " + coinList);
    }


}

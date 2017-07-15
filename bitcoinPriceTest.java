/**
 * Created by J on 2017-07-12.
 */

public class bitcoinPriceTest {
    public static void main(String[] args) {
        Bitcoin bitstamp = BitstampPrice.getPrices();
        Bitcoin bitfinex = BitfinexPrice.getPrices();
        System.out.println(bitstamp.toString());
    }
}

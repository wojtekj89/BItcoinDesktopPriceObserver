/**
 * Created by J on 2017-07-12.
 */
public class Bitcoin {
    String market;
    Double open, max, min, current;

    public Bitcoin(String market, Double open, Double max, Double min, Double current) {
        this.market = market;
        this.open = open;
        this.max = max;
        this.min = min;
        this.current = current;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "market='" + market + '\'' +
                ", open=" + open +
                ", max=" + max +
                ", min=" + min +
                ", current=" + current +
                '}';
    }
}

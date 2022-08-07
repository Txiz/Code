package main.java.common;

/**
 * 抽象类使用
 *
 * @author Txiz
 */
public abstract class AbstractDemo {

    /**
     * Calculate double.
     *
     * @param value the value
     * @return the double
     */
    protected abstract double calculate(int value);

    /**
     * Sqrt double.
     *
     * @param value the value
     * @return the double
     */
    protected double sqrt(int value) {
        return Math.sqrt(value);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        AbstractDemo abstractDemo = new AbstractDemo() {
            @Override
            protected double calculate(int value) {
                return value * value;
            }
        };
        System.out.println(abstractDemo.calculate(2));
        System.out.println(abstractDemo.sqrt(2));
    }
}

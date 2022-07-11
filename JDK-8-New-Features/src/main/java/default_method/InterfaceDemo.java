package main.java.default_method;

/**
 * 接口使用
 *
 * @author Txiz
 */
public interface InterfaceDemo {

    /**
     * Calculate double.
     *
     * @param value the value
     * @return the double
     */
    double calculate(int value);

    /**
     * Sqrt double.
     *
     * @param value the value
     * @return the double
     */
    default double sqrt(int value) {
        return Math.sqrt(value);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    static void main(String[] args) {

        InterfaceDemo interfaceDemo = value -> value * value;
        System.out.println(interfaceDemo.calculate(2));
        System.out.println(interfaceDemo.sqrt(2));
    }

}

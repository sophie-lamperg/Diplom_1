package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBuns() {
        return new Object[][] {
                {"Краторная булка N-200i", 1255},
                {"Флюоресцентная булка R2-D3", 988},
                {"Отсталая", 0.001f},
                {"Пустая", -3}
        };
    }
    @Test
    public void checkBuns() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0);
    }
};
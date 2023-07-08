package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

public class BurgerTest {

    @Mock
     Bun bun;
    Database database = new Database();
    Burger burger;
    List <Bun> buns = database.availableBuns();
    List <Ingredient> ingredients = database.availableIngredients();

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }


    @Test
    public void addIngreduentsTest() {
        ingredients.forEach((ingredient -> burger.addIngredient(ingredient)));
        Assert.assertEquals(ingredients, burger.ingredients);
    };

    @Test
    public void removeIngredientsTest() {
        List<Ingredient> remove = Arrays.asList(ingredients.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(1);
        Assert.assertEquals(remove, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> move = Arrays.asList(ingredients.get(0), ingredients.get(1));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(0));
        burger.moveIngredient(1,0);
        Assert.assertEquals(move, burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        Assert.assertEquals(500, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptTest() {
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(5));
        burger.setBuns(buns.get(2));
        String expected = "(==== red bun ====)" + "\n" + "= sauce hot sauce =" + "\n" +"= filling sausage ="+ "\n" + "(==== red bun ====)" + "\n\n" + "Price: 1000,000000" + "\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }
}

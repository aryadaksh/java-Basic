package ecom.OrderMgmt.Junit.Sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DiscountCalcultorTest {

    @Test
    public void testCalculateDiscountRegular() {
        // Arrange
    	DiscountCalcultor calcultor = new DiscountCalcultor();
    	
        int price = 1000;
        String type = "REGULAR";
        int discount = 10;

        // Act
        int actual = calcultor.calculateDiscount(price, type, discount);

        // Assert
        assertEquals(900, actual);
    }

    @Test
    public void testCalculateDiscountGold() {
        // Arrange
    	DiscountCalcultor calcultor = new DiscountCalcultor();
    	
        int price = 1000;
        String type = "GOLD";
        int discount = 10;

        // Act
        int actual = calcultor.calculateDiscount(price, type, discount);

        // Assert
        assertEquals(800, actual);
    }
    
	/*
	 * @Test public void testCalculateDiscountNull() { // Arrange DiscountCalcultor
	 * calcultor = new DiscountCalcultor(); int price = 1000; String type = null;
	 * int discount = 10;
	 * 
	 * // Act int actual = calcultor.calculateDiscount(price, type, discount);
	 * 
	 * // Assert assertEquals(1000, actual); }
	 */
    @Test
    public void testCalculateDiscountDefault() {
        // Arrange
    	DiscountCalcultor calcultor = new DiscountCalcultor();
        int price = 1000;
        String type = "SILVER";
        int discount = 10;

        // Act
        int actual = calcultor.calculateDiscount(price, type, discount);

        // Assert
        assertEquals(1000, actual);
        
    }
}

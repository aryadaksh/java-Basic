package ecom.OrderMgmt.Junit.Sample;

public class DiscountCalcultor {

	public int calculateDiscount(int price, String type, int discount) {

		int finalAmount = 0;

		/* try { */
			type = type.toUpperCase();
		switch (type) {
		case "REGULAR":
			finalAmount = price -(price*discount)/100;
			break;
		case "GOLD":
			finalAmount = price -(price*discount)/100-100;
			break;
			
		/*
		 * case "DIAMOND": finalAmount = price -(price*discount)/100-180; break;
		 */
		default:
			finalAmount = price;
			break;
		}
		/*}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		return finalAmount;
	}
}

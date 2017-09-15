package purchaseTracking;

public class QuantityException extends Exception {

	public QuantityException(){
		super("QuantityException: ");
	}
	
	public QuantityException(String message){
		super("QuantityException: "+ message);
	}
}

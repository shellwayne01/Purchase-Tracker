package purchaseTracking;

public class Purchase extends Item {

	private Item item; 
	private int quantity; 
	private double cost; 
	private int purchaseNumber; 
	private int numOfPurchases; 
	
	public Purchase(){
		super();
		quantity = 0; 
		cost = quantity * super.getPrice();
		NumOfPurchases.numOfPurchases++;
		numOfPurchases = NumOfPurchases.numOfPurchases;
		purchaseNumber = 100000 + numOfPurchases;
	}
	
	public Purchase(int quantity){
		this();
		this.quantity = quantity; 
		cost = quantity * super.getPrice(); 
		
	}
	public Purchase(int quantity, int purchaseNumber){
		this();
		this.quantity = quantity; 
		cost = quantity * super.getPrice();
		this.purchaseNumber = purchaseNumber;
	}
	
	public int getPurchaseNumber(){
		return purchaseNumber; 
	}
	
	private void setPurchaseNumber(int purchaseNum){
		purchaseNumber = purchaseNum;
	}
	
	public int getNumberOfPurchases(){
		return numOfPurchases;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity; 
	}
	
	public Item getItem(){
		return item; 
	}
	
	public double getCost(){
		cost = quantity * super.getPrice(); 
		return cost; 
	}

	@Override
	public String toString(){  
		String s = super.toString() + "\n quantity: " + this.getQuantity() + "\n cost: $ " 
					+ this.getCost() + "\n purchaseNumber: " + this.getPurchaseNumber() + "\n Number of Purchases: "
					+ numOfPurchases; 
		return s;
	}

	
	public boolean equals(Object obj){ 
		if(obj instanceof Purchase){
			Purchase otherPurchase = (Purchase)obj; 
			if(this.item.equals(otherPurchase.item)){ 
				if(this.quantity == otherPurchase.quantity){
					if(this.cost == otherPurchase.cost){
						if(this.purchaseNumber == otherPurchase.purchaseNumber){
							if(this.numOfPurchases == otherPurchase.numOfPurchases){
								return true; 
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	
	
	
}
package purchaseTracking;

public class Item {

	private String name; 
	private double price; 
	
	public Item(){ 
		name = "N/A";
		price = 0.0; 
	}
	
	public Item(String name, double price){ 
		this.name = name; 
		this.price = price; 
	}
	
	public double getPrice(){
		return price; 
	}
	
	public void setPrice(double price){ 
		this.price = price;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){ 
		this.name = name;
	}
	
	@Override
	public String toString(){  
		String s = " Item\n name: " + name + "\n price: $" + price; 
		return s;
	}
	
	@Override
	public boolean equals(Object obj){  
		if(obj instanceof Item){
			Item otherItem = (Item)obj; 
			if(this.name.equalsIgnoreCase(otherItem.name)){ 
				if(this.price == otherItem.price){
					return true;
				}
			}
		}
		return false; 
	}
	
	
	
}
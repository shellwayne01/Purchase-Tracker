package purchaseTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ItemBtns extends JPanel implements ActionListener{
	public String [] items = {"Apples","Oranges", "Bananas", "Broccoli", "Carrots", "Grapes", "Tomatoes", "Potatoes"}; //list for ease; you could also create items objects
	public double [] prices = {1.00, 1.50, 2.00, 3.00, 2.50, 3.00, 2.50, 3.75 }; 
	public int x = items.length; 
	
	private JToggleButton [] itemBtns; 
	public boolean [] itemSelected; //for toggle buttons
	
	
	public ItemBtns(){
		itemSelected = new boolean[x];
		itemBtns = new JToggleButton[x];
		
		for(int i=0; i<items.length; i++){
			itemBtns[i] = new JToggleButton(items[i]);
			itemBtns[i].addActionListener(this);
			add(itemBtns[i]);
			itemSelected[i] = false;
		}	
	}
	
	public double [] getPrices(){
		return prices;
	}
	public int getX(){
		return x;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JToggleButton btnClicked = (JToggleButton) e.getSource();
		for(int i=0; i<itemBtns.length; i++){
			if(btnClicked.equals(itemBtns[i])){
				itemSelected[i] = !itemSelected[i];
				System.out.println(items[i] + " was clicked"); //just checking
				System.out.println(itemSelected[i]); //just checking
			}
		}
	}
	
	public JLabel[] infoNeeded(){ 
		JLabel[] theSelected = new JLabel[x];
		for(int i=0; i<itemSelected.length; i++){
			if(itemSelected[i]){
				 theSelected[i] = new JLabel(items[i]);
			}
		}	
		return theSelected;
	}	
}

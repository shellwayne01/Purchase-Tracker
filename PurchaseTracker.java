package purchaseTracking;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

//First page
public class PurchaseTracker extends JFrame implements ActionListener{
	private JLabel jl1; 
	private ItemBtns jpItemButtons;
	private JButton jb1, jb4;
	
	public PurchaseTracker(){
		JPanel containerJP = new JPanel();
		containerJP.setBackground(Color.ORANGE);
	    containerJP.setLayout(new GridLayout(3,5));	
		
		jl1 = new JLabel(" Choose Items:");
		jpItemButtons = new ItemBtns();
		jb1 = new JButton("Continue");
		jb1.addActionListener(this);
		
		containerJP.add(jl1);
		containerJP.add(jpItemButtons);
		containerJP.add(jb1);
		
		add(containerJP);
		setTitle("Purchase Tracker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,450);
		setVisible(true);
	}
		
	@Override 
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
			if(btnClicked.equals(jb1)){ 
				System.out.println("Continue to next panel\n");
				this.dispose();
				new PurchaseTracker2().setVisible(true);
			}		
	}
	
	// Second page
	public class PurchaseTracker2 extends JFrame implements ActionListener{
		private JButton jb2, jb3, jb4;
		private JLabel jlx;
		private JTextArea jlA;
		private JLabel [] theSelected;
		private JTextField[] inputQuants;
		private Purchase [] purchases;
			
		public PurchaseTracker2(){
			JPanel containerJP2 = new JPanel();
			containerJP2.setBackground(Color.ORANGE);
			
			theSelected = jpItemButtons.infoNeeded(); 
			int y = theSelected.length;
			inputQuants = new JTextField[y];
			purchases = new Purchase[y];
			
			for(int i=0; i< y; i++){	
				if(theSelected[i] != null){
					containerJP2.add(theSelected[i]);
					inputQuants[i] = new JTextField("quantity", 5);
					containerJP2.add(inputQuants[i]);
				}		
			}
			
			jb3 = new JButton("Go Back");
			jb3.addActionListener(this);
			
			jb2 = new JButton("Purchase");
			jb2.addActionListener(this);
			
			jlx = new JLabel("Your purchase:");
			jlA = new JTextArea(20,20);
			
			JScrollPane scroll = new JScrollPane(jlA,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						
			containerJP2.add(jlx);
			containerJP2.add(scroll);
			containerJP2.add(jb3);
			containerJP2.add(jb2);
			
			add(containerJP2);
			setTitle("Checkout");
			setSize(300,550);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);	
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btnClicked = (JButton) e.getSource();
				if(btnClicked.equals(jb3)){
					this.dispose();
					new PurchaseTracker().setVisible(true);
				}
				else if(btnClicked.equals(jb2)){ //Displays transaction info on GUI and also appends it to purchases.txt
						String s = "";
						s = Purchases();
						if (s != ""){ 
							TextFileHandler fileHandler = new TextFileHandler(); 
							fileHandler.appendToFile("purchases.txt", s);
							System.out.println("\nTransaction complete."); //Just checking
							JOptionPane.showMessageDialog(null, "Transaction Complete. Thank you!");
							System.out.print(s); //Just checking
						}
						else{
							System.out.println("You can't make a purchase this way. Try again."); 
						}
				}
		}

		public String Purchases(){
			String s ="";
			try{
				for (int i=0; i<inputQuants.length; i++){
				if(inputQuants[i]!=null){
						int q = Integer.parseInt(inputQuants[i].getText()); 
						if (q<1) 
							throw new QuantityException("All purchases terminated.");
						purchases[i] = new Purchase(q);
						purchases[i].setName(theSelected[i].getText());
						purchases[i].setPrice(jpItemButtons.getPrices()[i]);
						System.out.println("Purchasing " + q + " "+ theSelected[i].getText());
						s += "\n" + (purchases[i].toString() +"\n");
					}
				}
			}
			catch(QuantityException e){ 
					System.out.println(e.getMessage()+ " Non positive integer quantities are invalid when purchasing. ");
					s = "";
				}
			jlA.setText(s);
			System.out.println("Transaction in progress..."); //Just checking		
			return s;
		}			
	}
}
	

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.util.Vector;
import java.text.DecimalFormat;

public class UpdateFrame extends JFrame implements ActionListener, ItemListener
{
	
	JComboBox cbMatchList;
	JTextField tfPrice;
	JList jlInventory;
	JTextArea taInventory;
	String txInventory;
	JScrollPane scrInventory;
	JButton btnUpdated;
	JMenuBar mb;
	JMenu menuFr;
	JMenuItem fullList, clear;
	JCheckBox chbAvailable;
	Vector vtMatch;
	JPanel mainPn, matchPn, priceAvailPn, pricePn, availablePn, updatedPn, inventoryPn;
	
	DecimalFormat decimal = new DecimalFormat("0.00");
	
	WorldCupList matchList;
	
	Container con;
	
	UpdateFrame(WorldCupList a)
	{
		matchList = a;
	}
	
	public void createScreen()
	{
		
		mb = new JMenuBar();
		menuFr = new JMenu("Match List");
		menuFr.setMnemonic('M');

		fullList = new JMenuItem("Full List");
		fullList.setMnemonic('F');
		fullList.addActionListener(this);

		clear = new JMenuItem("Clear");
		clear.setMnemonic('C');
		clear.addActionListener(this);

	    menuFr.add(fullList);
	    menuFr.add(clear);
	    
		mb.add(menuFr);
		setJMenuBar(mb);

		//Main UpdateFrame Panel
		mainPn = new JPanel();
		mainPn.setLayout(new GridLayout(2,2));

		//ComboBox MatchList
		
	    String[] listItem = new String[matchList.wcList.length];
	    for(int i = 0;i < matchList.wcList.length; i++)
	    {
	    	listItem[i] = matchList.wcList[i].getStrWorldCupMatch() + " " + matchList.wcList[i].getChWorldCupStage() + " " + matchList.wcList[i].getIntWorldCupTournament();
	    }
	    
		matchPn = new JPanel();
		matchPn.setLayout(new BorderLayout());
		cbMatchList = new JComboBox(listItem);
		cbMatchList.setFont(new Font(null,Font.BOLD + Font.ITALIC,14));
		cbMatchList.addItemListener(this);
		matchPn.add(cbMatchList, BorderLayout.NORTH);

		//CheckBox Available and TextField Price 
		
		//Price
		priceAvailPn = new JPanel();
		priceAvailPn.setLayout(new GridLayout(2, 1));
	      
		pricePn = new JPanel();
		tfPrice = new JTextField();
		tfPrice.setBackground(Color.yellow);
	    TitledBorder border = new TitledBorder("Match Price"); 
	    tfPrice.setBorder(border);
		
	    //Available
		availablePn = new JPanel();
		availablePn.setLayout(new GridLayout(1, 1)); 
	      
	    chbAvailable = new JCheckBox("Available");
	    chbAvailable.addActionListener(this);
	           
	    availablePn.add(chbAvailable);

	    priceAvailPn.add(tfPrice);
	    priceAvailPn.add(availablePn);

	    //Button Updated
		
		updatedPn = new JPanel();
		updatedPn.setLayout(new BorderLayout());
		btnUpdated = new JButton("Update Current Match");
		btnUpdated.setFont(new Font(null,Font.BOLD + Font.ITALIC,18));
		btnUpdated.addActionListener(this);
		updatedPn.add(btnUpdated);

		//TextArea Inventory
		
		inventoryPn = new JPanel();
		inventoryPn.setLayout(new BorderLayout());
	    TitledBorder title = new TitledBorder("Inventory"); 
	    title.setTitleFont(new Font(null,Font.BOLD + Font.ITALIC,20));
	    title.setTitlePosition(TitledBorder.CENTER);
	    inventoryPn.setBorder(title);
		taInventory = new JTextArea();
		taInventory.setFont(new Font("Helvetica",Font.BOLD + Font.ITALIC,14));
		taInventory.setBackground(Color.ORANGE);
		scrInventory = new JScrollPane(taInventory);
		inventoryPn.add(scrInventory);
		
		//All Panels in one
		mainPn.add(matchPn);
		mainPn.add(priceAvailPn);
		mainPn.add(updatedPn);
		mainPn.add(inventoryPn);
		
		con = getContentPane();
		con.add(mainPn);
	    
	    insertPrice();

	}
	
	public void actionPerformed(ActionEvent e)
	{
	   if(e.getSource() instanceof JButton)
	   {
			if(e.getSource() == btnUpdated) 
			{
				int i = cbMatchList.getSelectedIndex();
				double newValue = Double.parseDouble(tfPrice.getText());
				
				tfPrice.setText(decimal.format(newValue));
				newValue = Double.parseDouble(tfPrice.getText());
				matchList.wcList[i].setDoubPrice(newValue);
				matchList.wcList[i].setBoolAvail(chbAvailable.isSelected());
			}
		}
		
	   if(e.getSource() instanceof JMenuItem)
		{
			if (e.getSource() == fullList) 
			{
				txInventory = "";
				for(int i = 0; i < matchList.wcList.length; i++)
				{
					txInventory += matchList.wcList[i].getStrWorldCupMatch() + " " + matchList.wcList[i].getChWorldCupStage() + " " + matchList.wcList[i].getIntWorldCupTournament() + " ==== $" + matchList.wcList[i].getDoubPrice() + " " + matchList.wcList[i].getIsBoolAvail() + "\n";
				}
				taInventory.setText(txInventory);

			}
			else 
			{
				if (e.getSource() == clear)
					txInventory = "";
			}
			taInventory.setText(txInventory);
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource() == cbMatchList)
		{
			if(cbMatchList.getSelectedIndex() != -1)
			{
				insertPrice();
			}
		}
	}
	
	public void insertPrice()
	{
		int i = cbMatchList.getSelectedIndex();
		
		String price = decimal.format(matchList.wcList[i].getDoubPrice());
		boolean getIsBoolAvail = matchList.wcList[i].getIsBoolAvail();
		
		tfPrice.setText(price);
		
		if(getIsBoolAvail == true)
		{
			chbAvailable.setSelected(true);
		}
		else
		{
			chbAvailable.setSelected(false);
		}
		
	}
		

}

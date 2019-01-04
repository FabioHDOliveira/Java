import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.text.NumberFormat;

class WorldCup extends JFrame implements ActionListener, ItemListener, ListSelectionListener
{
	
	JPanel mainPn, tourPn, imagePn, matchPn, matchPn1, matchPn2, selectionPn, selectionPn1, 
	selectionPn2, passwordPn, passwordPn0, passwordPn1, passwordPn2, passwordPn3, totalPn;
	JComboBox cbTournament;
	JList lMatches, lYourSelection;
	Vector vtMatch, vtTour, vtYourSelection, vtMatchIndex, vtMatchPrice;
	ImageIcon[] picture = new ImageIcon[4];
	Image[] cupLogo = new Image[4];
	String[] worldCupLogo = {"wc2014.jpg","wc2010.jpg","wc2006.jpg","wc2002.jpg"};
	String[] tourList = {"2014 Tournament","2010 Tournament","2006 Tournament","2002 Tournament"};
	JScrollPane imageScr, scrMatch, scrSelect;
	JButton btnSelect, btnClear, btnClearAll, btnReset, btnEnter, btnSubmit;
	JButton[] btnPass = new JButton[10];
	String[] btnPassArray = {"A","B","C","D","E","F","G","H","I","J"};
	JRadioButton rbAll, rbFinal, rbSemi, rbQuart;
	ButtonGroup rbGroup,nGroup;
	JTextField tfTotal;
	JPasswordField pwPassword,pwCredit;
	JLabel keypadLb, imageLb;
	
	String password = "";
	String keypassword = "F";
	double totalPrice = 0.00;
   
	Container con;
   
	WorldCupList matchList;
	
	NumberFormat dollar = NumberFormat.getCurrencyInstance();

	public static void main(String[] args)
	{
		WorldCup frame = new WorldCup();
		frame.createScreen();
		frame.setTitle("FABIO DIAS World Cup Matches");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 900);
		frame.setVisible(true);
	}
	
   public void createScreen()
   {
      
      mainPn = new JPanel();
      mainPn.setLayout(new GridLayout(3,2));
	      
      //ComboBox
      tourPn = new JPanel();
      tourPn.setLayout(new BorderLayout());

      vtTour = new Vector();
   		
      for(int i = 0; i < tourList.length; i++)
      {
         vtTour.add(tourList[i]);
         cbTournament = new JComboBox(vtTour);
         cbTournament.setFont(new Font(null,Font.BOLD + Font.ITALIC,14));
         tourPn.add(cbTournament,BorderLayout.NORTH);
         cbTournament.addItemListener(this);   	
      }	
      tourPn.setBorder(new TitledBorder("Select Tournament"));
      mainPn.add(tourPn);
      
 		//Image Panel
      imagePn = new JPanel();
      imagePn.setBackground(Color.YELLOW);

      imageLb = new JLabel("",SwingConstants.CENTER);
      imageLb.setOpaque(true);
      imageLb.setBackground(Color.yellow);
      
      imageScr = new JScrollPane();
      imageScr.add(imageLb);
      
      for(int i = 0; i < worldCupLogo.length; i++)
      {
    	  picture[i] = new ImageIcon(worldCupLogo[i]);
      }
      
      imageLb.setIcon(picture[0]);
      imagePn.add(imageLb);
      mainPn.add(imagePn);

 		//Available Matches Panel
 		
 		//Radio Buttons:
      
      rbGroup = new ButtonGroup();
 		
      matchPn = new JPanel();
      matchPn.setLayout(new GridLayout(1, 3));
   		
      matchPn1 = new JPanel();
      matchPn1.setLayout(new GridLayout(2,1));
   		
      matchPn2 = new JPanel();
      matchPn2.setLayout(new GridLayout(3, 2));
   		
      rbAll = new JRadioButton("All Matches", true);
      rbAll.addItemListener(this);
      matchPn1.add(rbAll);
      rbGroup.add(rbAll);
   		
      rbFinal = new JRadioButton("Final", false);
      rbFinal.addItemListener(this);
      matchPn1.add(rbFinal);
      rbGroup.add(rbFinal);
   		
      rbSemi = new JRadioButton("Semi-Final", false);
      rbSemi.addItemListener(this);
      matchPn1.add(rbSemi);
      rbGroup.add(rbSemi);
   		
      rbQuart = new JRadioButton("Quart.-Final");
      rbQuart.addItemListener(this);
      matchPn1.add(rbQuart);
      rbGroup.add(rbQuart);
      
 		//ListBox Available Matches
 		
      vtMatch = new Vector();
      vtMatchIndex = new Vector();
      vtMatchPrice = new Vector();
      matchList = new WorldCupList();
      matchList.createList();
   		
      for(int i = 0; i < matchList.wcList.length; i++) 
      {
         vtMatch.add(matchList.wcList[i]);
      }
   		
      lMatches = new JList(vtMatch);
      lMatches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      lMatches.setVisibleRowCount(10);
   		
      scrMatch = new JScrollPane(lMatches);
      lMatches.addListSelectionListener(this);
   		
      btnSelect = new JButton("Select");
      btnSelect.setFont(new Font(null,Font.BOLD + Font.ITALIC,18));
      btnSelect.addActionListener(this);	
      matchPn2.add(btnSelect);
   		
      matchPn.setBorder(new TitledBorder("Available Matches"));
      matchPn.add(matchPn1);
      matchPn.add(scrMatch);
      matchPn.add(matchPn2);
      mainPn.add(matchPn);

 		//Your Selection
      selectionPn = new JPanel();
      selectionPn.setLayout(new GridLayout(1, 2));
      selectionPn.setBorder(new TitledBorder("Your Selection"));
   	      
      selectionPn1 = new JPanel();
      selectionPn1.setLayout(new FlowLayout());
      selectionPn2 = new JPanel();
      selectionPn2.setLayout(new GridLayout(2, 1)); 
   	      
      btnClear = new JButton("Clear");
      btnClear.setFont(new Font(null,Font.BOLD + Font.ITALIC,18));
      btnClear.addActionListener(this);
   	      
      btnClearAll = new JButton("Clear All");
      btnClearAll.setFont(new Font(null,Font.BOLD + Font.ITALIC,18));
      btnClearAll.addActionListener(this);
   	    
      vtYourSelection = new Vector();
      lYourSelection = new JList(vtYourSelection);
      lYourSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      lYourSelection.setVisibleRowCount(10);
      scrSelect = new JScrollPane(lYourSelection);
   	      
      selectionPn2.add(btnClear);
      selectionPn2.add(btnClearAll);
      selectionPn.add(scrSelect);
      selectionPn.add(selectionPn2);
      mainPn.add(selectionPn);

 	    //password:
 		
	  passwordPn = new JPanel();
	  passwordPn.setBorder(new TitledBorder("For Employee use ONLY"));
	  passwordPn.setLayout(new GridLayout(3, 1));
	  passwordPn.setBackground(Color.RED);
	    
	  passwordPn0 = new JPanel();
	  passwordPn0.setLayout(new GridLayout(2, 1));
	  passwordPn0.setBackground(Color.red);
	  keypadLb = new JLabel("Use keypad to enter password for settings");
	  keypadLb.setFont(new Font("Time New Roman", Font.PLAIN, 11));
	  passwordPn0.add(keypadLb);
	    
	  passwordPn1 = new JPanel();
	  passwordPn1.setLayout(new GridLayout(2, 5));
	  
	  passwordPn2 = new JPanel();
	  passwordPn2.setLayout(new GridLayout(1, 2));
	    
	  passwordPn3 = new JPanel();
	  passwordPn3.setLayout(new GridLayout(1, 2));
	 	    	
	  for(int i = 0; i < btnPass.length; i++)
	  {        		
	     btnPass[i] = new JButton();
	     passwordPn1.add(btnPass[i]);
	     btnPass[i].addActionListener(this);
	     btnPass[i].setText(btnPassArray[i]);
	  }
	 		
	  pwPassword = new JPasswordField();
	  pwPassword.setEditable(false);
	  pwPassword.setEchoChar('*');
	  passwordPn2.add(pwPassword);
	 		
	  btnReset = new JButton("Reset");
	  btnReset.addActionListener(this);
	  passwordPn3.add(btnReset);
	 		
	  btnEnter = new JButton("Enter");
	  btnEnter.addActionListener(this);
	  passwordPn3.add(btnEnter);
	 		
	  passwordPn.add(passwordPn0);
	  passwordPn2.add(passwordPn1);
	  passwordPn.add(passwordPn2);
	  passwordPn.add(passwordPn3);
	 		
	  mainPn.add(passwordPn);

 		//total
      totalPn = new JPanel();
      totalPn.setLayout(new GridLayout(3, 1));
   	         
      tfTotal = new JTextField();
      tfTotal.setText("Total: ");
      tfTotal.setBackground(Color.cyan);
      tfTotal.setEditable(false); 
      tfTotal.setFont(new Font("Time New Roman", Font.BOLD, 30));

 	    //CreditCard
 		
      pwCredit = new JPasswordField();
      pwCredit.setBorder(new TitledBorder("Enter CC#"));
      pwCredit.setEchoChar('*');
      totalPn.add(pwCredit);
 		
      btnSubmit = new JButton("Submit");
      btnSubmit.setFont(new Font(null,Font.BOLD + Font.ITALIC,18));
      btnSubmit.addActionListener(this);
 	
      totalPn.add(tfTotal);
      totalPn.add(pwCredit);
      totalPn.add(btnSubmit);
 	      
      mainPn.add(totalPn);

 		//container
      con = getContentPane();
      con.add(mainPn);

      createAllMatchList(2014);
   }
   
   public void actionPerformed(ActionEvent e)
   {
	   int message;
	   
	   if(e.getSource() instanceof JButton)
	   {
		   if(e.getSource() == btnSelect)
		   {
			   if(lMatches.getSelectedIndex() != -1)
			   {
				   int i = (int)vtMatchIndex.elementAt(lMatches.getSelectedIndex());
				   
				   if(searchIndex(i) == false)
				   {
					   vtMatchPrice.add(i);
					   vtYourSelection.add(matchList.wcList[i].getStrWorldCupMatch() + " " + matchList.wcList[i].getChWorldCupStage() + " " + matchList.wcList[i].getIntWorldCupTournament() + " $" + matchList.wcList[i].getDoubPrice());   
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(this, "Match Already selected\nPlease re-enter another match","Duplicate",JOptionPane.ERROR_MESSAGE);
				   }
				   lYourSelection.setListData(vtYourSelection);
				   totalPrice();
			   }   
		   }
		   else if(e.getSource() == btnClear)
		   {
			   if(lYourSelection.getSelectedIndex() != -1)
			   {
				   vtYourSelection.remove(vtYourSelection.elementAt(lYourSelection.getSelectedIndex()));
				   vtMatchPrice.remove(vtMatchPrice.elementAt(lYourSelection.getSelectedIndex()));
				   lYourSelection.setListData(vtYourSelection);
				   totalPrice();
			   } 
		   }
		   else if(e.getSource() == btnClearAll)
		   {
			   if(vtYourSelection.size() != 0)
			   {
				   message = JOptionPane.showConfirmDialog(this, "Are You SURE?","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				   if(message == JOptionPane.YES_OPTION)
				   {
					   vtYourSelection.removeAllElements();
					   vtMatchPrice.removeAllElements();
					   lYourSelection.setListData(vtYourSelection);
					   totalPrice();
				   }
			   }
		   }
		   else if(e.getSource() == btnReset)
		   {
			   password = "";
			   pwPassword.setText(password);
		   }
		   else if(e.getSource() == btnEnter)
		   {
		         if(password.equals(keypassword))
		         {
		            UpdateFrame updateFrame = new UpdateFrame(matchList);
		            updateFrame.createScreen();
		            updateFrame.setSize(1200, 300);
		            updateFrame.setVisible(true);
		         
		            
		            rbGroup.clearSelection();
		            vtMatch.removeAllElements();
		            password = "";
		            pwPassword.setText(password);
		         }
		         else
		         {
		            JOptionPane.showConfirmDialog(pwPassword, "WRONG Password, please re-enter", "Not Allowed", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
		            password = "";
		            pwPassword.setText(password);
		         }
		   }
		   else if(e.getSource() == btnSubmit)
		   {
			   if(vtYourSelection.size() != 0)
			   {
				   message = JOptionPane.showConfirmDialog(this, "Are You SURE?","WARNING",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

				   if(!pwCredit.getText().equals(""))
				   {
					   if(message == JOptionPane.YES_OPTION)
					   {
						   JOptionPane.showConfirmDialog(this, "Total: " + dollar.format(totalPrice) + " has been charged to your card. Thank you!\nAll selected Matches will be available for streaming for 1 week","Confirmation",JOptionPane.PLAIN_MESSAGE,JOptionPane.INFORMATION_MESSAGE);
						   vtYourSelection.removeAllElements();
						   vtMatchPrice.removeAllElements();
						   pwCredit.setText("");
						   lYourSelection.setListData(vtYourSelection);
						   totalPrice();
					   }
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(this, "Please Enter a VALID Credit Card","Not Allowed",JOptionPane.ERROR_MESSAGE);
				   } 
			   }
			   else
			   {
		            JOptionPane.showMessageDialog(this, "No Match selected, Please select a match","Not Allowed",JOptionPane.ERROR_MESSAGE);
			   }
		   }
		   
		   else
		   {
			   password += e.getActionCommand();
			   pwPassword.setText(password);
		   }
		   
	   }
   }
   
   public void itemStateChanged(ItemEvent e)
   {
	   
	   if(e.getSource() instanceof JComboBox)
	   {
		   if(e.getSource() == cbTournament)
		   {
			   
			   if(cbTournament.getSelectedIndex() == 0)
			   {
				   imageLb.setIcon(picture[0]);
				   if(rbFinal.isSelected())
				   {
					   createList(2014,'f');
				   }
				   else if(rbSemi.isSelected())
				   {
					   createList(2014,'s');
				   }
				   else if(rbQuart.isSelected())
				   {
					   createList(2014,'q');
				   }
				   else if(rbAll.isSelected())
				   {
					   createAllMatchList(2014);
				   }
			   }
			   else if(cbTournament.getSelectedIndex() == 1)
			   {
				   imageLb.setIcon(picture[1]);
				   if(rbFinal.isSelected())
				   {
					   createList(2010,'f');
				   }
				   else if(rbSemi.isSelected())
				   {
					   createList(2010,'s');
				   }
				   else if(rbQuart.isSelected())
				   {
					   createList(2010,'q');
				   }
				   else if(rbAll.isSelected())
				   {
					   createAllMatchList(2010);
				   }
			   }
			   else if(cbTournament.getSelectedIndex() == 2)
			   {
				   imageLb.setIcon(picture[2]);
				   if(rbFinal.isSelected())
				   {
					   createList(2006,'f');
				   }
				   else if(rbSemi.isSelected())
				   {
					   createList(2006,'s');
				   }
				   else if(rbQuart.isSelected())
				   {
					   createList(2006,'q');
				   }
				   else if(rbAll.isSelected())
				   {
					   createAllMatchList(2006);
				   }
			   }
			   else
			   {
				   imageLb.setIcon(picture[3]);
				   if(rbFinal.isSelected())
				   {
					   createList(2002,'f');
				   }
				   else if(rbSemi.isSelected())
				   {
					   createList(2002,'s');
				   }
				   else if(rbQuart.isSelected())
				   {
					   createList(2002,'q');
				   }
				   else if(rbAll.isSelected())
				   {
					   createAllMatchList(2002);
				   }
			   }
			   lMatches.setListData(vtMatch);
		   }
	   }
	   else if(e.getSource() instanceof JRadioButton)
	   {
		   
		   if(rbFinal.isSelected())
		   {
			   if(cbTournament.getSelectedIndex() == 0)
			   {
				   createList(2014,'f');
			   }
			   else if(cbTournament.getSelectedIndex() == 1)
			   {
				   createList(2010,'f');
			   }
			   else if(cbTournament.getSelectedIndex() == 2)
			   {
				   createList(2006,'f');
			   }
			   else if(cbTournament.getSelectedIndex() == 3)
			   {
				   createList(2002,'f');
			   }
		   }
		   else if(rbSemi.isSelected())
		   {
			   if(cbTournament.getSelectedIndex() == 0)
			   {
				   createList(2014,'s');
			   }
			   else if(cbTournament.getSelectedIndex() == 1)
			   {
				   createList(2010,'s');
			   }
			   else if(cbTournament.getSelectedIndex() == 2)
			   {
				   createList(2006,'s');
			   }
			   else if(cbTournament.getSelectedIndex() == 3)
			   {
				   createList(2002,'s');
			   }
		   }
		   else if(rbQuart.isSelected())
		   {
			   
			   if(cbTournament.getSelectedIndex() == 0)
			   {
				   createList(2014,'q');
			   }
			   else if(cbTournament.getSelectedIndex() == 1)
			   {
				   createList(2010,'q');
			   }
			   else if(cbTournament.getSelectedIndex() == 2)
			   {
				   createList(2006,'q');
			   }
			   else if(cbTournament.getSelectedIndex() == 3)
			   {
				   createList(2002,'q');
			   }
		   }
		   else
		   {
			   if(cbTournament.getSelectedIndex() == 0)
			   {
				   createAllMatchList(2014);
			   }
			   else if(cbTournament.getSelectedIndex() == 1)
			   {
				   createAllMatchList(2010);
			   }
			   else if(cbTournament.getSelectedIndex() == 2)
			   {
				   createAllMatchList(2006);
			   }
			   else if(cbTournament.getSelectedIndex() == 3)
			   {
				   createAllMatchList(2002);
			   }
		   }
		   lMatches.setListData(vtMatch);
	   }
   }
   
   public void valueChanged(ListSelectionEvent e)
   {
	   if(lMatches.getSelectedIndex() != -1)
	   {
		   int i = (int)vtMatchIndex.elementAt(lMatches.getSelectedIndex());
		   
		   if(matchList.wcList[i].getChWorldCupStage() == 'f')
		   {
			   lMatches.setSelectionBackground(Color.red);
			   lMatches.setSelectionForeground(Color.white);
		   }
		   else if(matchList.wcList[i].getChWorldCupStage() == 's')
		   {
			   lMatches.setSelectionBackground(Color.blue);
			   lMatches.setSelectionForeground(Color.white);
		   }
		   else //('q')
		   {
			   lMatches.setSelectionBackground(Color.yellow);
			   lMatches.setSelectionForeground(Color.black);
		   }
	   } 
   }
   
   public boolean searchIndex(int index)
   {
	   boolean found = false;
	   for(int i = 0; i < vtMatchPrice.size(); i++)
	   {
		   if((int)vtMatchPrice.elementAt(i) == index)
		   {
			   found = true;
			   break;
		   }
	   }
	   return found;
   }

   public void totalPrice()
   {
	   totalPrice = 0.00;
	   for(int i = 0; i < vtMatchPrice.size(); i++)
	   {
		   totalPrice += matchList.wcList[(int)vtMatchPrice.elementAt(i)].getDoubPrice();
	   }
	   tfTotal.setText("Total: " + dollar.format(totalPrice));
   }
   
   public void createList(int year, char stage)
   {
	   vtMatch.removeAllElements();
	   vtMatchIndex.removeAllElements();
	   for(int i = 0; i < 20; i++)
	   {
		   if(matchList.wcList[i].getIntWorldCupTournament() == year)
		   {
			   if(matchList.wcList[i].getChWorldCupStage() == stage)
			   {
				   if(matchList.wcList[i].getIsBoolAvail() == true)
				   {
					   vtMatchIndex.add(i);
					   vtMatch.add(matchList.wcList[i].getStrWorldCupMatch() + " " + matchList.wcList[i].getChWorldCupStage() + " " + matchList.wcList[i].getIntWorldCupTournament() + " $" + matchList.wcList[i].getDoubPrice());
				   }  
			   }
		   }
	   }
   }
   
   public void createAllMatchList(int year)
   {
	   vtMatch.removeAllElements();
	   vtMatchIndex.removeAllElements();
	   for(int i = 0; i < matchList.wcList.length; i++)
	   {
		   if(matchList.wcList[i].getIntWorldCupTournament() == year)
		   {
			   if(matchList.wcList[i].getIsBoolAvail() == true)
			   {
				   vtMatchIndex.add(i);
				   vtMatch.add(matchList.wcList[i].getStrWorldCupMatch() + " " + matchList.wcList[i].getChWorldCupStage() + " " + matchList.wcList[i].getIntWorldCupTournament() + " $" + matchList.wcList[i].getDoubPrice());
			   }
			   
		   }
		   
	   }
   }
}

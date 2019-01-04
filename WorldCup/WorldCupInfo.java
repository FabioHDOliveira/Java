
class WorldCupInfo
{

  private String strWorldCupMatch;
  private char chWorldCupStage;
  private int intWorldCupTournament;
  private String strWorldCupLogo;
  private boolean boolAvail; // available for streaming
  
  private double doubPrice;


  WorldCupInfo(String match, char stage, int tournament, String pic, double price, boolean avail )
  {
  
      strWorldCupMatch = match;
      chWorldCupStage = stage;
      intWorldCupTournament = tournament;
      strWorldCupLogo = pic;
  
      doubPrice = price;
      boolAvail = avail; // available for streaming

  }

////////////////////////////////////////////////
//Finish this class by writing the various public set/get methods
// for the above instance variables
////////////////////////////////////////////////

  
	public void setStrWorldCupMatch(String match) 
	{
		strWorldCupMatch = match;
	}
	public String getStrWorldCupMatch() 
	{
		return strWorldCupMatch;
	}
	
	public void setChWorldCupStage(char stage) 
	{
		chWorldCupStage = stage;
	}
	
	public char getChWorldCupStage() 
	{
		return chWorldCupStage;
	}
	
	public void setIntWorldCupTournament(int tournament) 
	{
		intWorldCupTournament = tournament;
	}
	
	public int getIntWorldCupTournament() 
	{
		return intWorldCupTournament;
	}
	
	public void setStrWorldCupLogo(String pic) 
	{
		strWorldCupLogo = pic;
	}
	
	public String getStrWorldCupLogo() 
	{
		return strWorldCupLogo;
	}
	
	public void setBoolAvail(boolean avail) 
	{
		boolAvail = avail;
	}
	
	public boolean getIsBoolAvail() 
	{
		return boolAvail;
	}
	
	public void setDoubPrice(double price) 
	{
		doubPrice = price;
	}
	
	public double getDoubPrice() 
	{
		return doubPrice;
	}

      
}

///////////////////////////////

class WorldCupList
{

  WorldCupInfo[] wcList;
  
  public void createList()
  {
 
      wcList = new WorldCupInfo[20];
	  wcList[0] = new WorldCupInfo("Eng. v Bra.",'q',2002,"wc2002.jpg",9.99,true);
      wcList[1] = new WorldCupInfo("Ger. v USA",'q',2002,"wc2002.jpg",9.99,true);
      wcList[2] = new WorldCupInfo("Spa. v S. Kor.",'q',2002,"wc2002.jpg",9.99,true);
      wcList[3] = new WorldCupInfo("Sen. v Tur.",'q',2002,"wc2002.jpg",9.99,true);
      wcList[4] = new WorldCupInfo("Ger. v S. Kor.",'s',2002,"wc2002.jpg",9.99,true);
      wcList[5] = new WorldCupInfo("Bra. v Tur.",'s',2002,"wc2002.jpg",9.99,true);
      wcList[6] = new WorldCupInfo("Ger. v Bra.",'f',2002,"wc2002.jpg",19.99,true);
      
      
      wcList[7] = new WorldCupInfo("Ger. v Ita.",'s',2006,"wc2006.jpg",9.99,true);
      wcList[8] = new WorldCupInfo("Por. v Fra.",'s',2006,"wc2006.jpg",9.99,true);
      wcList[9] = new WorldCupInfo("Ita. v Fra.",'f',2006,"wc2006.jpg",19.99,true);
      
      
      wcList[10] = new WorldCupInfo("Uru. v Hol.",'s',2010,"wc2010.jpg",12.99,true);
      wcList[11] = new WorldCupInfo("Ger. v Spa.",'s',2010,"wc2010.jpg",12.99,true);
      wcList[12] = new WorldCupInfo("Hol. v Spa.",'f',2010,"wc2010.jpg",19.99,true);
		 
	  wcList[13] = new WorldCupInfo("Fra. v Ger.",'q',2014,"wc2014.jpg",9.99,true);
      wcList[14] = new WorldCupInfo("Bra. v Col.",'q',2014,"wc2014.jpg",9.99,true);
      wcList[15] = new WorldCupInfo("Arg. v Belg.",'q',2014,"wc2014.jpg",9.99,true);
      wcList[16] = new WorldCupInfo("Hol. v Cos. Rica",'q',2014,"wc2014.jpg",19.99,true);
      wcList[17] = new WorldCupInfo("Bra. v Ger.",'s',2014,"wc2014.jpg",19.99,false);
      wcList[18] = new WorldCupInfo("Hol. v Arg.",'s',2014,"wc2014.jpg",19.99,true);
      wcList[19] = new WorldCupInfo("Ger. v Arg.",'f',2014,"wc2014.jpg",29.99,true);
       
       
       
  }


} 

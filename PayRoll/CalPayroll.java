import java.text.NumberFormat; 

class CalPayroll extends Pay
{
	Accept acpt = new Accept();

	NumberFormat dollars = NumberFormat.getCurrencyInstance();
	
	Payroll cpu = new Payroll();

	public void displayinfo()
	{
		double gross = super.calc_payroll();
		
		System.out.println("Gross pay is: " + dollars.format(gross));
		System.out.println("Tax is      : " + tax(gross) + "%");
		System.out.println("Net pay is  : " + dollars.format(cpu.calc_payroll()));
	}

	public void acceptPay() 
	{
		char out = 'a';
		int strTime;
		float rate, hours;
		
		while (out!='e' && out!='E') 
		{
			System.out.println("Payroll Computation\n");
			System.out.print("Enter number of hours worked (00.0) <0 for Quick exit>: ");
			hours = acpt.acceptInputFloat();
			cpu.setHours(hours);
			super.setHours(hours);

			if (super.getHours() != 0)
			{
				System.out.print("Enter first number of hours straight (integer or 0 to disable): ");
				strTime = acpt.acceptInputInt();
					if(strTime<0)
					{
						super.setStrTime(0);
						cpu.setStrTime(0);
					}
					else
					{
						cpu.setStrTime(strTime);
						super.setStrTime(strTime);	
					}
				
				System.out.print("Enter hourly rate of worker (00.00): ");
				rate = acpt.acceptInputFloat();
					if(rate<0)
					{
						super.setRate(0);
						cpu.setRate(0);
					}
					else
					{
						cpu.setRate(rate);
						super.setRate(rate);				
					}
				
					System.out.println(" ");
					Screen.scrollscreen('=', 65, 2);
					displayinfo();
					System.out.println(" ");

			}
			
			System.out.print("Enter 'e' to exit or any other letter + <Enter> to continue: ");
			out=acpt.acceptInputChar();
			if (out != 'e')
			{
				Screen.scrollscreen(15);
			}
		} 

	}

}

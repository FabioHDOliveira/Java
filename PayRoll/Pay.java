class Pay 
{
	private float hours, rate;
	private int strTime;
	
	public void setHours(float h) 
	{
		hours = h;
	}

	public void setRate(float h) 
	{
		rate = h;
	}

	public void setStrTime(int h) 
	{
		strTime = h;
	}

	public float getHours() 
	{
		return hours;
	}

	public float getRate() 
	{
		return rate;
	}

	public int getStrTime() 
	{
		return strTime;
	}
	
	public double calc_payroll() 
	{
		double gross;
		
		if (strTime != 0)
		{
			if (hours > strTime)
			{
				gross = (strTime*rate) + (hours-strTime) * (rate*1.25);
			}
			else
			{
				gross = hours * rate;
			}
		} 
		else 
		{
			gross = hours * rate;
		}
		
		return gross;
	}

	public double tax(double gross)
	{
		double taxRate;
		
		if ((gross>=0) && (gross<=399.99))
		{
			taxRate = 7;
		}
		else 
			if ((gross>=400) && (gross<=899.99))
			{
			taxRate = 11;
			}
		else
		{
			taxRate = 15;
		}

		return taxRate;
	}

}

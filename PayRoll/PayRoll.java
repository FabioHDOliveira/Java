class Payroll extends Pay 
{
	
	public double calc_payroll() 
	{
		double gross, taxRate;
		
		gross = super.calc_payroll();
		taxRate = super.tax(super.calc_payroll());
		
		return gross - (gross*taxRate/100);

	}
}
import java.util.*;

class Accept
{
    Scanner stdin = new Scanner(System.in); 
    
    public int acceptInputInt()  
    {
       return(stdin.nextInt());
	}
    
    public char acceptInputChar()
    {
    	return (stdin.next().charAt(0)); 
    }

    public float acceptInputFloat()
	{
    	return (stdin.nextFloat());
	}

    public double acceptInputDouble()
    {
    	return (stdin.nextDouble());
    }
}
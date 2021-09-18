import java.text.DecimalFormat;
//Kashaf Mujeeb, Worked with Moez Ullah Khan on this project
public class Triangle 
{
	private static final DecimalFormat FORMATER = new DecimalFormat("#.###"); 
	private double sideA;
	private double sideB;
	private double sideC;
	 
	//This private method checks if a triangle is possible with the given sides
	private static boolean isTriangle(double side1, double side2, double side3)
	{
		if (side1 > 0 && side2 > 0 && side3 > 0 && side1 < side2 + side3 && side2 < side1 + side3 && side3 < side1 + side2)
		{
			return true; 
		}
		else 
		{
			return false;
		}
	}
	
	public Triangle(double side1, double side2, double side3)
	{
		
		if (isTriangle(side1, side2, side3))
		{
			sideA = side1;
			sideB = side2;
			sideC = side3;
		}
		else
		{
			sideA = 1;
			sideB = 1;
			sideC = 1;
		}
		
	}
	
	//Accessing the data
	public double getSideA()
	{
		return sideA;
	}
	
	public double getSideB()
	{
		return sideB;
	}

	public double getSideC()
	{
		return sideC;
	}
	
	//Checking if the side should be changed by creating mutators
	public boolean setSideA(double changedSideA)
	{
		if (isTriangle(changedSideA, sideB, sideC))
		{
			sideA = changedSideA;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setSideB(double changedSideB)
	{
		if (isTriangle(sideA, changedSideB, sideC))
		{
			sideB = changedSideB;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean setSideC(double changedSideC)
	{
		if (isTriangle(sideA, sideB, changedSideC))
		{
			sideC = changedSideC;
			return true;
		}
		else
		{
			return false;
		}
	}
	//Using toString to print out the data.
	public String toString()
	{
		return "Triangle(" + FORMATER.format(sideA) + ", " + FORMATER.format(sideB) + ", " + FORMATER.format(sideC) + ")";
	}
}

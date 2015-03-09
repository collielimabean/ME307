
public abstract class Point 
{
	protected double stress;
	protected double strain;
	
	public Point(double stress, double strain)
	{
		this.stress = stress;
		this.strain = strain;
	}
	
	public final double getStress()
	{
		return stress;
	}
	
	public final double getStrain()
	{
		return strain;
	}
	
	public final double getYieldStressSlope()
	{
	    return ((stress - getRegression()[1]) / (strain - 0.002));
	}
	
	protected abstract double[] getRegression();
	
	public String toString()
	{
	    return "Stress: " + stress + " | Strain: " + strain;
	}
}


public class SteelPoint extends Point
{
	public SteelPoint(double stress, double strain)
	{
		super(stress, strain);
	}
	
	protected double[] getRegression()
	{
		return new double[]{};
	}
}
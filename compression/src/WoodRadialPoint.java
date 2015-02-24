
public class WoodRadialPoint extends Point 
{
	public WoodRadialPoint(double stress, double strain)
	{
		super(stress, strain);
	}

	@Override
	protected double[] getRegression() 
	{
		return new double[]{39666, 21.201};
	}

}


public class WoodParallelPoint extends Point 
{
	public WoodParallelPoint(double stress, double strain)
	{
		super(stress, strain);
	}

	@Override
	protected double[] getRegression() 
	{
		return new double[]{626240, -103.12};
	}

}


public class AcrylicPoint extends Point
{

	public AcrylicPoint(double stress, double strain)
	{
		super(stress, strain);
		this.strain /= 100.0;
	}

	@Override
	protected double[] getRegression()
	{
		return new double[]{282.71, 0.0794};
	}

}

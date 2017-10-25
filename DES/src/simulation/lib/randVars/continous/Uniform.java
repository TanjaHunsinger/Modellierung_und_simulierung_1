package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.1 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Uniform distributed random variable.
 */
public class Uniform extends RandVar {

	protected double a;
	protected double b;

	public Uniform(RNG rng) {
		super(rng);
		// TODO Auto-generated constructor stub
		a = 1;
		b = 1;
	}

	@Override
	public double getRV() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		double mean = (a+b)/2;
		return mean;
	}

	@Override
	public double getVariance() {
		// TODO Auto-generated method stub
		double var = (1/12)*(Math.pow((b-a),2));
		return var;
	}

	@Override
	public void setMean(double m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStdDeviation(double s) {
		// TODO Auto-generated method stub
		/*
		Formel umstellen :
		s = Wurzel((b-a)^2 /12)
		s = (b-a)/Wurzel(12)
		s = b/Wurzel(12) - a/Wurzel(12)

		b/Wurzel(12) = a/Wurzel(12) + s
		b = a + s* Wurzel(12) = a + 2* s* Wurzel(3)
		a = b - s* Wurzel(12) = b - 2* s* Wurzel(3)
		 */
		a = b - ( 2 * s * Math.sqrt(3));
		b = a + ( 2 * s * Math.sqrt(3));
	}

	@Override
	public void setMeanAndStdDeviation(double m, double s) {
		// TODO Auto-generated method stub
		setMean(m);
		setStdDeviation(s);

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Uniform: ";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

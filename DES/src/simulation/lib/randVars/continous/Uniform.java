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
		b = 0;
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
		this.a = m;
		this.b = 0;

	}

	@Override
	public void setStdDeviation(double s) {
		// TODO Auto-generated method stub
		this.a = s;
		this.b = 0;
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
		return "Uniform";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	"Type: " + getType() + "\n" +
		"Mean: " + getMean() + "\n" +
		"Cvar: " + getCvar() + "\n" +	
		"std Deviation: " + getStdDeviation() + "\n" +
		"Variance: " + getVariance() +"\n";
	}
	
}

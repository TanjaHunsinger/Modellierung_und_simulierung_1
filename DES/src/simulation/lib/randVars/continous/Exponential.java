/**
 * 
 */
package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.2 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Expnential distributed random variable.
 */
public class Exponential extends RandVar {

	protected double lambda;

	public Exponential(RNG rng) {
		super(rng);
		// TODO Auto-generated constructor stub
		lambda = 1;
	}

	@Override
	public double getRV() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		double mean = 1/lambda;
		return mean;
	}

	@Override
	public double getVariance() {
		// TODO Auto-generated method stub
		double var = 1/(Math.pow(lambda,2));
		return var;
	}

	@Override
	public void setMean(double m) {
		// TODO Auto-generated method stub
		this.lambda = m;
	}

	@Override
	public void setStdDeviation(double s) {
		// TODO Auto-generated method stub
		this.lambda = s;

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
		return "Exponential";
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

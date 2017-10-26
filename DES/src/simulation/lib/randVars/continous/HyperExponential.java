package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;
import static java.lang.Math.*;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.4 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Hyperexponential distributed random variable.
 */
public class HyperExponential extends RandVar {

	protected double p;
	protected double lambda;
	protected double n;

	public HyperExponential(RNG rng) {
		super(rng);
		// TODO Auto-generated constructor stub
		p = 1;
		n = 1;
		lambda = 1;
	}

	@Override
	public double getRV() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		double mean = 0;
		
		for( int i = 1; i <= n; i++){
			mean += p/lambda;
		}

		return mean;
	}

	@Override
	public double getVariance() {
		// TODO Auto-generated method stub
		
		double var = 0;

		for( int i = 1; i <= n; i++){
			var += (2/lambda)* p; 
		}

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
		return "HyperExponential";
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

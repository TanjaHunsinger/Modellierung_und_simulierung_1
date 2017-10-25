package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.3 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Erlang-k distributed random variable.
 */
public class ErlangK extends RandVar {

	protected double k;       //k exponentiell verteilte Phasen
	protected double lambda;

	public ErlangK(RNG rng) {
		super(rng);
		// TODO Auto-generated constructor stub
		k = 1;
		lambda = 1;
	}

	@Override
	public double getRV() {
		// TODO Auto-generated method stub
		/*
		Erzeugung durch Inversion siehe VL:
		X = - 1/lambda * ln (MUL_{0<=i<k} U
		 */
		double X = 0;

		for( int i = 0; i < k; i++){
			X += (-1/lambda) * Math.log(rng.rng())
		}

		return X;
	}

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		double mean = k/lambda;
		return mean;
	}

	@Override
	public double getVariance() {
		// TODO Auto-generated method stub
		double var = k(Math.pow(lambda,2));
		return var;
	}

	@Override
	public void setMean(double m) {
		// TODO Auto-generated method stub
		lambda = k/m;

	}

	@Override
	public void setStdDeviation(double s) {
		// TODO Auto-generated method stub
		/*
		 Formel nach s umstellen:
		 s = Wurzel(k/lambda^2)
		 S = Wurzel(k)/lambda
		 lambda = Wurzel(k)/s
		  */
		if (s > 0 ){
			lambda = Math.sqrt(k)/s;
		}

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
		return "k-Erlangverteilung ";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}		
}

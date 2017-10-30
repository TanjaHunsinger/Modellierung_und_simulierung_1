package study;

import simulation.lib.randVars.RandVar;
import simulation.lib.randVars.continous.*;
import simulation.lib.rng.StdRNG;

/*
 * TODO Problem 2.3.3 and 2.3.4[Bonus] - implement this class
 * You can call your test from the main-method in SimulationStudy
 */
public class RandVarTest {

    public static void testRandVars() {
        // TODO Auto-generated method stub
    	   	
    			//Test uniform 
    			Uniform uni1 = new Uniform(null);
    			uni1.setMeanAndStdDeviation(1, 0.1);
    			System.out.println("Input: setMean = 1, setCvar = 0.1" + "\n" + uni1.toString());

    			Uniform uni2 = new Uniform(null);
    			uni2.setMeanAndStdDeviation(1, 1);
    			System.out.println("Input: setMean = 1, setCvar = 1" + "\n" + uni2.toString());

    			Uniform uni3 = new Uniform(null);
    			uni3.setMeanAndStdDeviation(1, 2);
    			System.out.println("Input: setMean = 1, setCvar = 2" + "\n" + uni3.toString());

    			//Test erlang
    			ErlangK erl1 = new ErlangK(null);
    			erl1.setMeanAndCvar(1, 0.1);
    			System.out.println("Input: setMean = 1, setCvar = 0.1" + "\n" + erl1.toString());

    			ErlangK erl2 = new ErlangK(null);
    			erl2.setMeanAndCvar(1, 1);
    			System.out.println("Input: setMean = 1, setCvar = 1" + "\n" + erl2.toString());

    			ErlangK erl3 = new ErlangK(null);
    			erl3.setMeanAndCvar(1, 2);
    			System.out.println("Input: setMean = 1, setCvar = 2" + "\n" + erl3.toString());

    			//Test exp
    			Exponential exp1 = new Exponential(null);
    			exp1.setMeanAndCvar(1, 0.1);
    			System.out.println("Input: setMean = 1, setCvar = 0.1" + "\n" + exp1.toString());

    			Exponential exp2 = new Exponential(null);
    			exp2.setMeanAndCvar(1, 1);
    			System.out.println("Input: setMean = 1, setCvar = 0.1" + "\n" + exp2.toString());

    			Exponential exp3 = new Exponential(null);
    			exp3.setMeanAndCvar(1, 2);
    			System.out.println("Input: setMean = 1, setCvar = 0.1" + "\n" + exp3.toString());

    			//Test hyerexp
    			HyperExponential hyexp1 = new HyperExponential(null);
    			hyexp1.setMeanAndCvar(1, 0.1);
    			System.out.println("Input: setMean = 1, setCvar = 0.1" + "\n" + hyexp1.toString());

    			HyperExponential hyexp2 = new HyperExponential(null);
    			hyexp2.setMeanAndCvar(1, 1);
    			System.out.println("Input: setMean = 1, setCvar = 1" + "\n" + hyexp2.toString());

    			HyperExponential hyexp3 = new HyperExponential(null);
    			hyexp3.setMeanAndCvar(1, 2);
    			System.out.println("Input: setMean = 1, setCvar = 2" + "\n" + hyexp3.toString());

    }
}

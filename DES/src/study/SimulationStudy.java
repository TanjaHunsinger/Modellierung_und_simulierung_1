package study;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import simulation.lib.Simulator;
import simulation.lib.counter.DiscreteCounter;
import simulation.lib.histogram.DiscreteHistogram;
import simulation.lib.rng.StdRNG;
import simulation.lib.statistic.IStatisticObject;

import simulation.lib.randVars.continous.*;

/**
 * Represents a simulation study. Contains diverse counters for statistics and
 * program/simulator parameters. Starts the simulation.
 */
public class SimulationStudy {
	/*
	 * TODO Problem 2.2.4 - configure program arguments here
	 * Here you can set the different parameters for your simulation
	 * Note: Units are real time units (seconds).
	 * They get converted to simulation time units in setSimulationParameters.
	 */
	
	protected long cInterArrivalTime = 10;
	protected long cServiceTime 	 = 11;
	protected long cSimulationTime 	 = 10000;

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		/*
		 * create simulation object
		 */
		Simulator sim = new Simulator();
		/*
		 * run simulation
		 */
		sim.start();
		/*
		 * print out report
		 */
		sim.report();


		//Aufruf Problem 2.3
		System.out.println("\n" + "=========== Results Problem 2.3 ===========" + " \n");
		RandVarTest randVar = new RandVarTest();
		randVar.testRandVars();



	}

	// PARAMETERS
	/**
	 * Turn on/off debug report in console.
	 */
	protected boolean isDebugReport = true;

	/**
	 * Turn on/off report in csv-files.
	 */
	protected boolean isCsvReport = true;

	/**
	 * Simulation time.
	 */
	public long simulationTime;


	/**
	 * inter arrival time of customers (in simulation time).
	 */
	public long interArrivalTime;

	/**
	 * service time of a customer (in simulation time).
	 */
	public long serviceTime;

	// STATISTICS
	/**
	 * Map that contains all statistical relevant object such as counters and
	 * histograms.
	 */
	public HashMap<String, IStatisticObject> statisticObjects;

	/**
	 * Maximum queue size.
	 */
	public long maxQS;

	/**
	 * Minimum queue size.
	 */
	public long minQS;

	/*
	 * TODO Problem 2.2 - naming your statistic objects
	 * Here you have to set some names (as Sting objects) for all your statistic objects
	 * They are later used to retrieve them from the dictionary
	 */
	// Example for discrete counter which measures customer waiting time:
	public String dcWaitingTime 	= "discreteCounterWaitingTime";
	public String histDcWaitingTime = "discreteHistorgrammWaitingTime";
	
	public String dcServiceTime 	= "discreteCounterServiceTime";
	public String histDcServiceTime = "discreteHistogramServiceTime";

	public String cnQueueOcc 		= "continuousCounterQueueOccupancy";
	public String histCnQueueOcc 	= "continuousHistogramQueueOccupancy";

	public String cnServerUtil 		= "continuousCountServerUtilization";
	public String histCnServerUtil  = "continuousHistogramServerUtilization";


	private Simulator simulator;

	/**
	 * Constructor
	 * @param sim Simulator instance.
	 */
	public SimulationStudy(Simulator sim) {
		simulator = sim;
		simulator.setSimTimeInRealTime(1000);
		setSimulationParameters();
		initStatistics();
	}

	/**
	 * Sets simulation parameters, converts real time to simulation time if
	 * needed.
	 */
	private void setSimulationParameters() {
		interArrivalTime = simulator.realTimeToSimTime(cInterArrivalTime);
		serviceTime 	 = simulator.realTimeToSimTime(cServiceTime);
		simulationTime 	 = simulator.realTimeToSimTime(cSimulationTime);
	}

	/**
	 * Initializes statistic objects. Adds them into Hashmap.
	 */
	private void initStatistics() {
		maxQS = Long.MIN_VALUE;
		minQS = Long.MAX_VALUE;
		
		int lowerBoundDc   = 0;
		int upperBoundDc   = 20000000;
		int lowerBoundOcc  = 0;
		int upperBoundOcc  = 200;
		int lowerBoundUtil = 0;
		int upperBoundUtil = 200;

		int numIntervalDcWaiting  = 100;
		int numIntervalDcService  = 50;
		int numIntervalOccupation = 25;
		int numIntervalsUtil 	  = 10;
		
		statisticObjects = new HashMap<>();

		/*
          TODO Problem 2.2 - add statistic objects (counters) to the HashMap
          Here you have to create your counters and add them to the statisticObjects HashMap
          Use the name which you specified above as the key
		 */
		
		statisticObjects.put(dcWaitingTime, new DiscreteCounter("waiting time/customer"));
		statisticObjects.put(histDcWaitingTime, new DiscreteHistogram("waiting_time-customer", numIntervalDcWaiting , lowerBoundDc, upperBoundDc));

		statisticObjects.put(dcServiceTime, new DiscreteCounter("service_time/customer"));
		statisticObjects.put(histDcServiceTime, new DiscreteHistogram("service_time-customer", numIntervalDcService, lowerBoundDc, upperBoundDc));

		statisticObjects.put(cnQueueOcc, new DiscreteCounter("occupency/queue_discrete"));
		statisticObjects.put(histCnQueueOcc, new DiscreteHistogram("occupeny/queue_continuous", numIntervalOccupation, lowerBoundOcc, upperBoundOcc));

		statisticObjects.put(cnServerUtil, new DiscreteCounter("utilization/server_discrete"));
		statisticObjects.put(histCnServerUtil, new DiscreteHistogram("utilization/server_continuous", numIntervalsUtil, lowerBoundUtil, upperBoundUtil));
	}


	/**
	 * Report results. Print to console if isDebugReport = true. Print to csv
	 * files if isCsvReport = true. Note: Histogramms are only printed to csv
	 * files.
	 */
	public void report() {
		String sd = new SimpleDateFormat("yyyyMMdd_HHmmss_").format(new Date(System.currentTimeMillis()));
		String destination = sd + this.getClass().getSimpleName();

		if (isCsvReport) {
			File file = new File(destination);
			file.mkdir();
			for (IStatisticObject so : statisticObjects.values()) {
				so.csvReport(destination);
			}
		}
		if (isDebugReport) {
			System.out.println("E[interArrivalTime] = " + simulator.simTimeToRealTime(interArrivalTime) + "\n"
					+ "E[serviceTime] = " + simulator.simTimeToRealTime(serviceTime) + "\n"
					+ "server utilization: "+ ((double) serviceTime / (double) interArrivalTime) + "\n");

			for (IStatisticObject so : statisticObjects.values()) {
				System.out.println(so.report());
			}

			System.out.println("minimum queue size: " + minQS + "\n" + "maximum queue size: " + maxQS);
		}
	}
}

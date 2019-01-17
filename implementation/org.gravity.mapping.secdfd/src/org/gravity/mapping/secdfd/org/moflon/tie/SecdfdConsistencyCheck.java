package org.gravity.mapping.secdfd.org.moflon.tie;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;


import org.gravity.mapping.secdfd.SecdfdPackage;


public class SecdfdConsistencyCheck extends SynchronizationHelper{

   public SecdfdConsistencyCheck()
   {
      super(SecdfdPackage.eINSTANCE, ".");
   }
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

        SecdfdConsistencyCheck helper = new SecdfdConsistencyCheck();
        helper.loadSrc("instances/src.xmi");
		helper.loadTrg("instances/trg.xmi");

		boolean prepareDeltas = true;
		
		//TODO
		//set your solver here:
		//helper.setILPSolver(GurobiSolver.create().build());
		// OR
		//helper.setILPSolver(CplexSolver.create().withPresolve().build());
		
		helper.createCorrespondences(prepareDeltas);

		if(prepareDeltas){
			//src and trg models are modified when preparing deltas.
			//save all files in a separate location
			helper.saveSrc("instances/cc_result/src.xmi");
			helper.saveTrg("instances/cc_result/trg.xmi");
			helper.saveCorr("instances/cc_result/corr.xmi");
			helper.saveConsistencyCheckProtocol("instances/cc_result/protocol.xmi");
			helper.saveInconsistentSourceDelta();
			helper.saveInconsistentTargetDelta();
		}
		else{
			//src and trg models are not modified.
			//save correspondence model and protocol only
			helper.saveCorr("instances/corr.xmi");
			helper.saveConsistencyCheckProtocol("instances/protocol.xmi");
		}
	}
}
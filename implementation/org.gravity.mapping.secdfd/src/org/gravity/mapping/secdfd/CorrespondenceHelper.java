package org.gravity.mapping.secdfd;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.moflon.tgg.runtime.AbstractCorrespondence;

/**
 * Helper methods for correspondences
 * 
 * @author speldszus
 *
 */
public class CorrespondenceHelper {

	private static final Logger LOGGER = Logger.getLogger(CorrespondenceHelper.class);

	/**
	 * A getter for the source of a correspondence
	 * 
	 * @param correspondence The correspondence for which the source is requested
	 * @return The source
	 */
	public static EObject getSource(AbstractCorrespondence correspondence) {
		try {
			return (EObject) correspondence.getClass().getDeclaredMethod("getSource").invoke(correspondence);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

	/**
	 * A getter for the target of a correspondence
	 * 
	 * @param correspondence The correspondence for which the target is requested
	 * @return The target
	 */
	public static EObject getTarget(AbstractCorrespondence correspondence) {
		try {
			return (EObject) correspondence.getClass().getDeclaredMethod("getTarget").invoke(correspondence);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

}

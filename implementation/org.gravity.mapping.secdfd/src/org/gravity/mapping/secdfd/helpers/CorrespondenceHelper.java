package org.gravity.mapping.secdfd.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.gravity.mapping.secdfd.AbstractCorrespondence;

public final class CorrespondenceHelper {

	private static final Logger LOGGER = Logger.getLogger(CorrespondenceHelper.class);

	private CorrespondenceHelper() {
		// This class shouldn't be instantiated
	}

	/**
	 * A getter for the source of a correspondence
	 * 
	 * @param correspondence The correspondence for which the source is requested
	 * @return The source
	 */
	public static EObject getSource(AbstractCorrespondence correspondence) {
		Method method;
		try {
			method = correspondence.getClass().getDeclaredMethod("getSource");
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
			try {
				method = correspondence.getClass().getMethod("getSource");
			} catch (NoSuchMethodException | SecurityException e1) {
				LOGGER.log(Level.ERROR, e);
				return null;
			}
		}
		try {
			return (EObject) method.invoke(correspondence);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
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
		Method method;
		try {
			method = correspondence.getClass().getDeclaredMethod("getTarget");
		} catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
			try {
				method = correspondence.getClass().getMethod("getTarget");
			} catch (NoSuchMethodException | SecurityException e1) {
				LOGGER.log(Level.ERROR, e);
				return null;
			}
		}
		try {
			return (EObject) method.invoke(correspondence);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.log(Level.ERROR, e);
			return null;
		}
	}

}

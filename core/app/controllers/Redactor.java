package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation;

public class Redactor {

	/**
	 * Calls removeAnnotations without the need for the user to create a singleton list.
	 * @param textAnnotations
	 * @param viewToKeep
	 * @return
	 */
	public static List<TextAnnotation> removeAnnotations(List<TextAnnotation> textAnnotations, String viewToKeep) {
		List<String> viewsToKeep = new ArrayList<>();
		viewsToKeep.add(viewToKeep);
		return removeAnnotations(textAnnotations, viewsToKeep);
	}
	/**
	 * Static method to remove views from `TextAnnotation` objects.  Each task variant has a number of views
	 * necessary for the learner to solve it.  All other views should be removed.
	 * @param textAnnotations
	 * @param viewsToKeep
	 * @return
	 */
	public static List<TextAnnotation> removeAnnotations(List<TextAnnotation> textAnnotations, List<String> viewsToKeep) {
		if (viewsToKeep == null) {
			viewsToKeep = Collections.EMPTY_LIST;
		}
		
		for (TextAnnotation textAnnotation : textAnnotations) {
			for (String viewName : textAnnotation.getAvailableViews()) {
				if (!viewsToKeep.contains(viewName)) {
					textAnnotation.removeView(viewName);
				}
			}
		}
		return textAnnotations;
	}
}
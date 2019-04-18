package org.cocome.tradingsystem.inventory.application.reporting;

import java.io.Serializable;

/**
 * Transfer object class for encapsulating report information in simple text format.
 * @author herold
 *
 */
public class ReportTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2388667179057402191L;
	protected String reportText;

	/**
	 * Gets the report in text(html) format.
	 * @return the report
	 */
	public String getReportText()
	{
		return reportText;
	}

	/**
	 * Sets report text.
	 * @param reportText The report text.
	 */
	public void setReportText(String reportText)
	{
		this.reportText  = reportText;
	}
}

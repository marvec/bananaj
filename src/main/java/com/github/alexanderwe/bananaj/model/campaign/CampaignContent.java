/**
 * @author alexanderweiss
 * @date 12.12.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

import org.json.JSONObject;

import java.net.URL;

public class CampaignContent {

	private Campaign campaign;
	private String plain_text;
	private String html;
	
	protected CampaignContent(String plain_text, String html, Campaign campaign) {
		this.campaign = campaign;
		this.plain_text = plain_text;
		this.html = html;
	}

	/**
	 * Set the html content of this campaign. Plain text will be automatically generated by MailChimp
	 * @param htmlContent
	 * @throws Exception
	 */
	public void changeHTMLContent(String htmlContent) throws Exception{
		JSONObject content = new JSONObject();
		content.put("html", htmlContent);
		getCampaign().getConnection().do_Post(new URL(getCampaign().getConnection().getCampaignendpoint()+"/"+this.getCampaign().getId()+"/content"),content.toString(), this.getCampaign().getConnection().getApikey());
		this.html = htmlContent;
	}

	/**
	 * @return the plain_text
	 */
	public String getPlain_text() {
		return plain_text;
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 *
	 * @return the campaign this content belongs to
	 */
	public Campaign getCampaign() {
		return campaign;
	}

}

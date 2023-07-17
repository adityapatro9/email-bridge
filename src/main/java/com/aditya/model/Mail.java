package com.aditya.model;

public class Mail {

	String to;
	String from;
	String subject;
	String body;
	String image;
	String attachment;

	public Mail() {
	}

	public Mail(String to, String from, String subject, String body, String image, String attachment) {
		super();
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.body = body;
		this.image = image;
		this.attachment = attachment;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}

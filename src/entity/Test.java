package entity;

import java.io.Serializable;

public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String acho;
    private String bcho;
    private String ccho;
    private String answer;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcho() {
		return acho;
	}
	public void setAcho(String acho) {
		this.acho = acho;
	}
	public String getBcho() {
		return bcho;
	}
	public void setBcho(String bcho) {
		this.bcho = bcho;
	}
	public String getCcho() {
		return ccho;
	}
	public void setCcho(String ccho) {
		this.ccho = ccho;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}

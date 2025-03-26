package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diet")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texture;
    private String dietType;
    private Boolean autonomous;
    private String prosthesis;
    private String dietConsistency;
    private String dietRestrictions;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	public String getDietType() {
		return dietType;
	}
	public void setDietType(String dietType) {
		this.dietType = dietType;
	}
	public Boolean getAutonomous() {
		return autonomous;
	}
	public void setAutonomous(Boolean autonomous) {
		this.autonomous = autonomous;
	}
	public String getProsthesis() {
		return prosthesis;
	}
	public void setProsthesis(String prosthesis) {
		this.prosthesis = prosthesis;
	}
	public String getDietConsistency() {
		return dietConsistency;
	}
	public void setDietConsistency(String dietConsistency) {
		this.dietConsistency = dietConsistency;
	}
	public String getDietRestrictions() {
		return dietRestrictions;
	}
	public void setDietRestrictions(String dietRestrictions) {
		this.dietRestrictions = dietRestrictions;
	}
    
    
}
package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mobilization")
public class Mobilization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sittingType;
    private Boolean wandering;
    private String wanderingType;
    private Boolean posturalChange;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSittingType() {
		return sittingType;
	}
	public void setSittingType(String sittingType) {
		this.sittingType = sittingType;
	}
	public Boolean getWandering() {
		return wandering;
	}
	public void setWandering(Boolean wandering) {
		this.wandering = wandering;
	}
	public String getWanderingType() {
		return wanderingType;
	}
	public void setWanderingType(String wanderingType) {
		this.wanderingType = wanderingType;
	}
	public Boolean getPosturalChange() {
		return posturalChange;
	}
	public void setPosturalChange(Boolean posturalChange) {
		this.posturalChange = posturalChange;
	}
}
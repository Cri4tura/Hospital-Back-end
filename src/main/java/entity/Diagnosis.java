package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dependence;
    private String O2;
    private Boolean diaper;
    private Integer numberOfChronicDiseases;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDependence() {
		return dependence;
	}
	public void setDependence(String dependence) {
		this.dependence = dependence;
	}
	public String getO2() {
		return O2;
	}
	public void setO2(String o2) {
		O2 = o2;
	}
	public Boolean getDiaper() {
		return diaper;
	}
	public void setDiaper(Boolean diaper) {
		this.diaper = diaper;
	}
	public Integer getNumberOfChronicDiseases() {
		return numberOfChronicDiseases;
	}
	public void setNumberOfChronicDiseases(Integer numberOfChronicDiseases) {
		this.numberOfChronicDiseases = numberOfChronicDiseases;
	}
    
    
}
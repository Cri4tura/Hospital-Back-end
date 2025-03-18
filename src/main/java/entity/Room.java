package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String section;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    public Integer getId() {
 		return id;
 	}
 	public void setId(Integer id) {
 		this.id = id;
 	}
 	public String getName() {
 		return name;
 	}
 	public void setName(String name) {
 		this.name = name;
 	}
 	public String getSection() {
 		return section;
 	}
 	public void setSection(String section) {
 		this.section = section;
 	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}

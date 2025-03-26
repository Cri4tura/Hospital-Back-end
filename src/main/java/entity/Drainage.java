package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "drainage")
public class Drainage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String drainageType;
    private Float drainageDebit;
    private String notes;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDrainageType() {
		return drainageType;
	}
	public void setDrainageType(String drainageType) {
		this.drainageType = drainageType;
	}
	public Float getDrainageDebit() {
		return drainageDebit;
	}
	public void setDrainageDebit(Float drainageDebit) {
		this.drainageDebit = drainageDebit;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
    
    
}
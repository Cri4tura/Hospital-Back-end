package entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "care")
public class Care {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date careDate;
    private String careShift;
    private Integer pulse;
    private Float temperature;
    private Float respirationRate;
    private Float oxygenSaturation;
    private Integer lowBloodPressure;
    private Integer highBloodPressure;
    private String observations;

    @ManyToOne
    @JoinColumn(name = "id_nurse")
    private Nurse nurse;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "id_drainage")
    private Drainage drainage;

    
    // GETTERS SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCareDate() {
		return careDate;
	}

	public void setCareDate(Date careDate) {
		this.careDate = careDate;
	}

	public String getCareShift() {
		return careShift;
	}

	public void setCareShift(String careShift) {
		this.careShift = careShift;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(Float respirationRate) {
		this.respirationRate = respirationRate;
	}

	public Float getOxygenSaturation() {
		return oxygenSaturation;
	}

	public void setOxygenSaturation(Float oxygenSaturation) {
		this.oxygenSaturation = oxygenSaturation;
	}

	public Integer getLowBloodPressure() {
		return lowBloodPressure;
	}

	public void setLowBloodPressure(Integer lowBloodPressure) {
		this.lowBloodPressure = lowBloodPressure;
	}

	public Integer getHighBloodPressure() {
		return highBloodPressure;
	}

	public void setHighBloodPressure(Integer highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Drainage getDrainage() {
		return drainage;
	}

	public void setDrainage(Drainage drainage) {
		this.drainage = drainage;
	}
    
}
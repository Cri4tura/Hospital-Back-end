package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "care_diet")
public class CareDiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_care")
    private Care care;

    @ManyToOne
    @JoinColumn(name = "id_diet")
    private Diet diet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Care getCare() {
		return care;
	}

	public void setCare(Care care) {
		this.care = care;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}
    
    
}
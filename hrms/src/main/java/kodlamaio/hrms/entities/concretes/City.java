package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "city_id")
	private int cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private List<JobPostingForm> jobPostingForms;	

}

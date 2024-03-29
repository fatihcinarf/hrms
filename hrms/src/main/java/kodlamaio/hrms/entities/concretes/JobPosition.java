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
@Table(name="jop_positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "jop_position_id")
	private int jopPositionId;
	
	@Column(name="jop_position_name")
	private String jopPositionName;
	
	@OneToMany(mappedBy = "jopPosition")
	@JsonIgnore
	private List<JobPostingForm> jopPostingForms;
	
	
	
	
}

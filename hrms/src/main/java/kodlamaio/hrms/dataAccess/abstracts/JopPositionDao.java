package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JopPosition;

public interface JopPositionDao extends JpaRepository<JopPosition, Integer>{
	JopPosition getByJopPositionName(String jopPositionName);
}
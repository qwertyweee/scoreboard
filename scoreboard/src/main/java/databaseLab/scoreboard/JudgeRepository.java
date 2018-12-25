package databaseLab.scoreboard;

import org.springframework.data.repository.CrudRepository;
import databaseLab.scoreboard.Judge;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface JudgeRepository extends CrudRepository<Judge, Integer> {

	Judge findById(int id);
}
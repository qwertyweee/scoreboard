package databaseLab.scoreboard;

import org.springframework.data.repository.CrudRepository;
import databaseLab.scoreboard.Team;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TeamRepository extends CrudRepository<Team, Integer> {

	Team findById(int id);
}
package be.brahms.Forum.repositories;

import be.brahms.Forum.Models.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepo extends JpaRepository<Forum,String> {
}

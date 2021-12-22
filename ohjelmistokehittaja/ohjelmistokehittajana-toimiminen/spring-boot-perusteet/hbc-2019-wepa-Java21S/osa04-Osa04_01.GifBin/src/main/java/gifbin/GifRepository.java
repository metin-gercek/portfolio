package gifbin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GifRepository extends JpaRepository<Gif, Long> {
    
}
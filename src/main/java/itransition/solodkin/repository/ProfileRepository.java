package itransition.solodkin.repository;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eabil on 28.04.2017.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {
    @Query("select p from Profile p where p.nickname LIKE CONCAT('%',:nickname,'%')")
    List<Profile> findProfileByNicknameLike(@Param("nickname") String nickname);
}

package itransition.solodkin.repository;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by eabil on 28.04.2017.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {
}

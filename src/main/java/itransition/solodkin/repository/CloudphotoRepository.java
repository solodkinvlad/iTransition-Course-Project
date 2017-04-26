package itransition.solodkin.repository;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

/**
 * Created by eabil on 26.04.2017.
 */
public interface CloudphotoRepository extends JpaRepository<CloudPhoto, Long>, JpaSpecificationExecutor<CloudPhoto> {

}

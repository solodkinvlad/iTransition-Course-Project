package itransition.solodkin.repository;

import itransition.solodkin.model.CloudPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by eabil on 26.04.2017.
 */
@Repository
public interface CloudphotoRepository extends JpaRepository<CloudPhoto, Long>, JpaSpecificationExecutor<CloudPhoto> {

}

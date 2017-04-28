package itransition.solodkin.repository;

import itransition.solodkin.model.CloudPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudphotoRepository extends JpaRepository<CloudPhoto, Long>, JpaSpecificationExecutor<CloudPhoto> {

}

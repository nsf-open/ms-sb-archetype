#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.dao.repository.flp;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ${groupId}.${artifactIdInLowerCase}.dao.entity.flp.OtherEntity;

@Repository
public interface OtherRepository extends JpaRepository<OtherEntity, Integer>{

}
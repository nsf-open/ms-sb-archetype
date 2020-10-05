#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.dao.repository.csd;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ${groupId}.${artifactIdInLowerCase}.dao.entity.csd.${mainPojo}Entity;

@Repository
public interface ${mainPojo}Repository extends JpaRepository<${mainPojo}Entity, Integer>{

}
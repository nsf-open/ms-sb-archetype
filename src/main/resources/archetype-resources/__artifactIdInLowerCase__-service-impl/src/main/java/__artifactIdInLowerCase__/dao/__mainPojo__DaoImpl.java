#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))

package ${groupId}.${artifactIdInLowerCase}.dao;

import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};
import ${groupId}.${artifactIdInLowerCase}.dao.repository.csd.${mainPojo}Repository;
import ${groupId}.${artifactIdInLowerCase}.dao.repository.flp.OtherRepository;
import ${groupId}.${artifactIdInLowerCase}.common.exception.${mainPojo}SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ${mainPojo}DaoImpl implements ${mainPojo}Dao{

    //Primary
    @Autowired
    private ${mainPojo}Repository ${lowerCamelCasedPojo}Repository;

    //Secondary
    @Autowired
    private OtherRepository otherRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(${mainPojo}DaoImpl.class);

    @Override
    public ${mainPojo} get${mainPojo}(String id) throws ${mainPojo}SQLException {

        return new ${mainPojo}(id);
    }

    @Override
    public ${mainPojo} create${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}SQLException {

        return $lowerCamelCasedPojo;
    }

    @Override
    public ${mainPojo} update${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}SQLException {

        return $lowerCamelCasedPojo;
    }

    @Override
    public void delete${mainPojo}(String id) throws ${mainPojo}SQLException {

    }

}
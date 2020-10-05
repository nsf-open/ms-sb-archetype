#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))


package ${groupId}.${artifactIdInLowerCase}.service;

import ${groupId}.${artifactIdInLowerCase}.dao.${mainPojo}Dao;
import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};
import ${groupId}.${artifactIdInLowerCase}.common.exception.${mainPojo}NotFoundException;
import ${groupId}.${artifactIdInLowerCase}.common.exception.${mainPojo}ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ${mainPojo}ServiceImpl implements ${mainPojo}Service {

    @Autowired
    private ${mainPojo}Dao dao;

    private static final Logger LOGGER = LoggerFactory.getLogger(${mainPojo}ServiceImpl.class);

    @Override
    public ${mainPojo} get${mainPojo}(String id) throws ${mainPojo}ServiceException {

        ${mainPojo} $lowerCamelCasedPojo = dao.get${mainPojo}(id);
        if( $lowerCamelCasedPojo == null ){
            throw new ${mainPojo}NotFoundException("No ${mainPojo} found for ID: " + id);
        }

        return $lowerCamelCasedPojo;
    }

    @Override
    public ${mainPojo} create${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}ServiceException {
        return dao.create${mainPojo}($lowerCamelCasedPojo);
    }

    @Override
    public ${mainPojo} update${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}ServiceException {

        ${mainPojo} stored${mainPojo} = dao.get${mainPojo}(${lowerCamelCasedPojo}.getId());
        if( stored${mainPojo} == null ){
            throw new ${mainPojo}NotFoundException("No ${mainPojo} found for ID: " + ${lowerCamelCasedPojo}.getId());
        }

        return dao.update${mainPojo}($lowerCamelCasedPojo);
    }

    @Override
    public ${mainPojo} delete${mainPojo}(String id) throws ${mainPojo}ServiceException {

        ${mainPojo} $lowerCamelCasedPojo = dao.get${mainPojo}(id);
        if( $lowerCamelCasedPojo == null ){
            throw new ${mainPojo}NotFoundException("No ${mainPojo} found for ID: " + id);
        }

        dao.delete${mainPojo}(id);

        return $lowerCamelCasedPojo;
    }

}
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.dao;

import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};
import ${groupId}.${artifactIdInLowerCase}.common.exception.${mainPojo}SQLException;

public interface ${mainPojo}Dao {

    ${mainPojo} get${mainPojo}(String id) throws ${mainPojo}SQLException;

    ${mainPojo} create${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}SQLException;

    ${mainPojo} update${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}SQLException;

    void delete${mainPojo}(String id) throws ${mainPojo}SQLException;
}
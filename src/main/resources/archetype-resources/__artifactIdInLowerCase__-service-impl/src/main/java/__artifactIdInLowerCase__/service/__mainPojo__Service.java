#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))

package ${groupId}.${artifactIdInLowerCase}.service;

import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};
import ${groupId}.${artifactIdInLowerCase}.common.exception.${mainPojo}ServiceException;

public interface ${mainPojo}Service {

    ${mainPojo} get${mainPojo}(String id) throws ${mainPojo}ServiceException;

    ${mainPojo} create${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}ServiceException;

    ${mainPojo} update${mainPojo}(${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}ServiceException;

    ${mainPojo} delete${mainPojo}(String id) throws ${mainPojo}ServiceException;

}
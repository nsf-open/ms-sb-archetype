#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))
package ${groupId}.${artifactIdInLowerCase}.client;

import gov.nsf.components.rest.model.response.ModelResponse;
import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};

public interface ${mainPojo}ServiceClient {

	ModelResponse<${mainPojo}> get${mainPojo}(String id);

	ModelResponse<${mainPojo}> create${mainPojo}(${mainPojo} $lowerCamelCasedPojo);

	ModelResponse<${mainPojo}> update${mainPojo}(${mainPojo} $lowerCamelCasedPojo);

	ModelResponse<${mainPojo}> delete${mainPojo}(String id);

}

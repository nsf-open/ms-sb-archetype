#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ${mainPojo} {

    private String id;

    public ${mainPojo}( ){

    }

    public ${mainPojo}(String id){
        setId(id);
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

}
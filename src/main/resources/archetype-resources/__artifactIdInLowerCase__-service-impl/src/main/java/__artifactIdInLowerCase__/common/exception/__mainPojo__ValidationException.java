package ${groupId}.${artifactIdInLowerCase}.common.exception;

import java.util.List;
import java.util.ArrayList;
import gov.nsf.components.rest.model.message.NsfResponseMessage;
import ${groupId}.${artifactIdInLowerCase}.common.Constants;
/**
 * ${mainPojo}ValidationException superclass exception
 */
public class ${mainPojo}ValidationException extends ${mainPojo}ServiceException {


    private final List<NsfResponseMessage> errors;



    /**
     * ${mainPojo}ValidationException constructor
     *
     * @param message - the validation error message
     */
    public ${mainPojo}ValidationException(String message) {
        super(message);
        this.errors = null;
    }

    /**
    * ${mainPojo}ValidationException constructor
    *
    * @param errors - the exception errors
    */
    public ${mainPojo}ValidationException(List<NsfResponseMessage> errors) {
        super(Constants.BAD_REQUEST);
        this.errors = errors;
    }

    /**
     * ${mainPojo}ValidationException constructor
     *
     * @param message - the validation message
     * @param errors - the validation errors
     */
    public ${mainPojo}ValidationException(String message, List<NsfResponseMessage> errors) {
        super(message);
        this.errors = errors;
    }

    public List<NsfResponseMessage> getErrors(){
        return this.errors;
    }

}



package ${groupId}.${artifactIdInLowerCase}.common.exception;

import java.lang.Exception;

/**
 * ${mainPojo}ServiceException superclass exception
 */
public abstract class ${mainPojo}ServiceException extends Exception {

    /**
     * ${mainPojo}ServiceException constructor
     *
     * @param throwable - the thrown exception
     */
    public ${mainPojo}ServiceException(Throwable throwable) {
        this(null, throwable);
    }

    /**
     * ${mainPojo}ServiceException constructor
     *
     * @param message - the exception message
     */
    public ${mainPojo}ServiceException(String message) {
        this(message, null);
    }

    /**
     * ${mainPojo}ServiceException constructor
     *
     * @param message   - the exception message
     * @param throwable - the thrown exception
     */
    public ${mainPojo}ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}



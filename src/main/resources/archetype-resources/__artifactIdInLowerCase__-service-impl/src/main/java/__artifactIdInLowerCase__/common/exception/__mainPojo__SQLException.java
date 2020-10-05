package ${groupId}.${artifactIdInLowerCase}.common.exception;


/**
 * ${mainPojo}SQLException superclass exception
 */
public class ${mainPojo}SQLException extends ${mainPojo}ServiceException {

    /**
     * ${mainPojo}SQLException constructor
     *
     * @param throwable - the thrown exception
     */
    public ${mainPojo}SQLException(Throwable throwable) {
        this(null, throwable);
    }

    /**
     * ${mainPojo}SQLException constructor
     *
     * @param message - the exception message
     */
    public ${mainPojo}SQLException(String message) {
        this(message, null);
    }

    /**
     * ${mainPojo}SQLException constructor
     *
     * @param message   - the exception message
     * @param throwable - the thrown exception
     */
    public ${mainPojo}SQLException(String message, Throwable throwable) {
        super(message, throwable);
    }

}



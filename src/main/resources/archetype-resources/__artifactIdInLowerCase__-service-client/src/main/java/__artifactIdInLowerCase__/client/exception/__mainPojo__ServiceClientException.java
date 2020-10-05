package ${groupId}.${artifactIdInLowerCase}.client.exception;

import java.lang.Throwable;
import java.lang.RuntimeException;

public class ${mainPojo}ServiceClientException extends RuntimeException {

    public ${mainPojo}ServiceClientException(Throwable throwable){
        super(throwable);
    }

    public ${mainPojo}ServiceClientException(String message, Throwable throwable){
        super(message, throwable);
    }
}
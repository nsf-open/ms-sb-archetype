#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCasedPojo = $mainPojo.toLowerCase())

package ${groupId}.${artifactIdInLowerCase}.controller;

import ${groupId}.${artifactIdInLowerCase}.common.Constants;

import gov.nsf.components.rest.model.message.NsfResponseMessage;
import gov.nsf.components.rest.model.message.Source;
import gov.nsf.components.rest.model.response.BaseResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

import ${groupId}.${artifactIdInLowerCase}.common.exception.*;

@RestController
public class ${mainPojo}ServiceBaseController {

	/**
	 * Handles ${mainPojo}ValidationException
	 *
	 * @param ex - contains the validation errors
	 * @return BaseResponse
	 */
	@ExceptionHandler({${mainPojo}ValidationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResponse process${mainPojo}ValidationException(${mainPojo}ValidationException ex) {
		List<NsfResponseMessage> errors = ex.getErrors();

		if( errors == null ){
			NsfResponseMessage error = new NsfResponseMessage();
			error.setTitle(Constants.BAD_REQUEST);
			error.setDescription(ex.getMessage());
			error.setHttpStatus(HttpStatus.BAD_REQUEST.value());

			errors = Collections.singletonList(error);
		}

		return new BaseResponse(errors, null, null);
	}


	/**
	 * Handles ${mainPojo}NotFoundException thrown when a resource isn't found
	 *
	 * @param httpRequest - the current http request
	 * @param ex          - the thrown exception
	 * @return
	 */
	@ExceptionHandler({${mainPojo}NotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseResponse process${mainPojo}NotFoundException(HttpServletRequest httpRequest, ${mainPojo}NotFoundException ex) {

		NsfResponseMessage error = new NsfResponseMessage();
		error.setTitle(Constants.RESOURCE_NOT_FOUND);
		error.setDescription(ex.getMessage());
		error.setHttpStatus(HttpStatus.NOT_FOUND.value());
		error.setSource(new Source(httpRequest.getRequestURI()));

		return new BaseResponse(Collections.singletonList(error), null, null);
	}

	/**
	 * Handles unexpected Exceptions
	 *
	 * @param ex - the thrown exception
	 * @return BaseResponse
	 */
	@ExceptionHandler({Exception.class, ${mainPojo}ServiceException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseResponse processException(Exception ex) {

		NsfResponseMessage error = new NsfResponseMessage();
		error.setTitle(Constants.SERVER_ERROR);
		error.setDescription(ex.getMessage());
		error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMeta(ExceptionUtils.getStackTrace(ex));

		return new BaseResponse(Collections.singletonList(error), null, null);
	}

	/**
	* Gets the current authenticated user
	*
	* @return Authentication
	*/

	protected static Authentication getAuthenticatedUser() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCasedPojo = $mainPojo.toLowerCase())
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))


package ${groupId}.${artifactIdInLowerCase}.controller;

import gov.nsf.components.rest.model.ember.EmberModel;
import ${groupId}.${artifactIdInLowerCase}.common.exception.${mainPojo}ServiceException;
import ${groupId}.${artifactIdInLowerCase}.service.${mainPojo}Service;
import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ${mainPojo}ServiceController extends ${mainPojo}ServiceBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(${mainPojo}ServiceController.class);

	@Autowired
	private ${mainPojo}Service service;

    @ApiOperation(value = "Get a ${mainPojo}",
    		notes = "This API returns a ${mainPojo}",
    		response = ${mainPojo}.class)
	@RequestMapping(path = {"/${lowerCamelCasedPojo}s/{id}", "/auth/${lowerCamelCasedPojo}s/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmberModel get${mainPojo}(@PathVariable String id) throws ${mainPojo}ServiceException {

		return new EmberModel.ModelBuilder(
			"${lowerCamelCasedPojo}", service.get${mainPojo}(id))
		.build();
	}

	@ApiOperation(value = "Create a ${mainPojo}",
			notes = "This API creates a ${mainPojo}",
			response = ${mainPojo}.class)
	@RequestMapping(path = {"/${lowerCamelCasedPojo}s", "/auth/${lowerCamelCasedPojo}s"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmberModel create${mainPojo}(@RequestBody ${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}ServiceException {

		return new EmberModel.ModelBuilder(
			"${lowerCamelCasedPojo}", service.create${mainPojo}($lowerCamelCasedPojo))
		.build();
	}

	@ApiOperation(value = "Update a ${mainPojo}",
		notes = "This API updates a ${mainPojo}",
		response = ${mainPojo}.class)
	@RequestMapping(path = {"/${lowerCamelCasedPojo}s/{id}", "/auth/${lowerCamelCasedPojo}s/{id}"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmberModel update${mainPojo}(@PathVariable String id, @RequestBody ${mainPojo} $lowerCamelCasedPojo) throws ${mainPojo}ServiceException {

		return new EmberModel.ModelBuilder(
			"${lowerCamelCasedPojo}", service.update${mainPojo}($lowerCamelCasedPojo))
		.build();
	}


	@ApiOperation(value = "Delete a ${mainPojo}",
		notes = "This API deletes a ${mainPojo}",
		response = ${mainPojo}.class)
	@RequestMapping(path = {"/${lowerCamelCasedPojo}s/{id}", "/auth/${lowerCamelCasedPojo}s/{id}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmberModel delete${mainPojo}(@PathVariable String id) throws ${mainPojo}ServiceException {

		return new EmberModel.ModelBuilder(
			"${lowerCamelCasedPojo}", service.delete${mainPojo}(id))
		.build();
	}

}
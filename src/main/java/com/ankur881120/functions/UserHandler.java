package com.ankur881120.functions;

import java.util.Optional;

import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import com.ankur881120.functions.model.User;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

public class UserHandler extends AzureSpringBootRequestHandler<String,User>{
	
	@FunctionName("GetUserFunction")
	public User execute(
			@HttpTrigger(name="req", 
			methods= {HttpMethod.GET},
			authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
			ExecutionContext context) {
		String id = request.getQueryParameters().get("id");
		return handleRequest(id, context);
	}

}

package kodlamaio.hrms.core.utilities.ApiError;

import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class ApiError {
	private String message;
	
	private int errorCode;
	
	private String errorApi;
	
	private String path;
	
	private long timestamp=new Date().getTime();
	
	private Map<String, String> validations;
	
	
	public ApiError(int errorCode,String message,String errorApi) {
		this.errorCode=errorCode;
		this.message=message;
		this.errorApi=errorApi;
	}
	
	

}

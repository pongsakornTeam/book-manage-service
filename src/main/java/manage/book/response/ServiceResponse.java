package manage.book.response;

import java.util.List;


public class ServiceResponse {
	private String status;
	private String errorCode;
	private List<BookResponse> response;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public List<BookResponse> getResponse() {
		return response;
	}
	public void setResponse(List<BookResponse> response) {
		this.response = response;
	}
}

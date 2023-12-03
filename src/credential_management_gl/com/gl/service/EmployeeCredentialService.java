package credential_management_gl.com.gl.service;

import credential_management_gl.com.gl.model.Employee;

public interface EmployeeCredentialService {
	
	String generateEmail(String firstName, String lastName, String deptName);
	String generatePassword();
	void showEmployeeDetails(Employee employee);

}

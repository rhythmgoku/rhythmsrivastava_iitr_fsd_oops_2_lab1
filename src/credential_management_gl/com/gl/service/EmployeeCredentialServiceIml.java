package credential_management_gl.com.gl.service;

import java.util.Random;

import credential_management_gl.com.gl.model.Employee;

public class EmployeeCredentialServiceIml implements EmployeeCredentialService {

	@Override
	public String generateEmail(String firstName, String lastName, String deptName) {
		return firstName+lastName+"@"+deptName+"."+"greatlearning.com";
	}

	@Override
	public String generatePassword() {
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = caps.toLowerCase();
		String nums = "0123456789";
		String special = "!@#$%^&*()";
		
		String combined = caps+lower+nums+special;
		
		String Password = "";
		Random random = new Random();
		
		for (int i = 0; i < 9; i++) {
			Password += combined.charAt(random.nextInt(71));
		}
		return Password;
	}

	@Override
	public void showEmployeeDetails(Employee employee) {
		System.out.println(employee.toString());
		
	}

}

package credential_management_gl.com.gl.app;

import java.util.Scanner;
import credential_management_gl.com.gl.model.Employee;
import credential_management_gl.com.gl.service.EmployeeCredentialService;
import credential_management_gl.com.gl.service.EmployeeCredentialServiceIml;

public class Driver {

	public static void main(String[] args) {

		try(Scanner scanner = new Scanner(System.in)) {
			EmployeeCredentialService credentialService = new EmployeeCredentialServiceIml();
			
			System.out.println("Please Enter the First Name");
			String firstName = scanner.next();
			firstName = firstName.toLowerCase();
			
			System.out.println("Please Enter the Last Name");
			String lastName = scanner.next();
			lastName = lastName.toLowerCase();
			
			System.out.println("1 : Technical");
			System.out.println("2 : Admin");
			System.out.println("3 : Human Resource");
			System.out.println("4 : Legal");
			
			System.out.println("Please Choose the Dept");
			int deptCode = scanner.nextInt();
		    
			String generatedEmail = "";
			
			switch (deptCode) {
			case 1: 
				generatedEmail = credentialService.generateEmail(firstName, lastName, "tech");
				break;
				
			case 2: 
				generatedEmail = credentialService.generateEmail(firstName, lastName, "admin");
				break;
			case 3: 
				generatedEmail = credentialService.generateEmail(firstName, lastName, "hr");
				break;
			case 4: 
				generatedEmail = credentialService.generateEmail(firstName, lastName, "legal");
				break;
			default:
				System.out.print("Please Select a valid Department option");
			}
			
			System.out.println("\n --- Generated Email Id --- \n");
			System.out.println(generatedEmail);
			System.out.print("\n --- Generated Password --- \n");
			String password = credentialService.generatePassword();
			System.out.println(password);
			Employee employee = new Employee(firstName, lastName, generatedEmail, password);
			System.out.println("\n --- Displaying Employee Informations --- \n");
			credentialService.showEmployeeDetails(employee);
			
		}catch(Exception exception) {
			System.out.println("Exception occured during the Program Execution");
		}
		
		
	}

}

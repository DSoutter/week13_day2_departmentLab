package com.example.departmentlab;

import com.example.departmentlab.models.Department;
import com.example.departmentlab.models.Employee;
import com.example.departmentlab.models.Project;
import com.example.departmentlab.repositories.DepartmentRepository;
import com.example.departmentlab.repositories.EmployeeRepository;
import com.example.departmentlab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentlabApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDeparment() {
		Department department = new Department("Software Development");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Jeremy", "Yoo", 1234, department);
		employeeRepository.save(employee1);
		Employee employee2 = new Employee("Duncan", "Soutter", 4321, department);
		employeeRepository.save(employee2);

	}

	@Test
	public void addEmployeesAndProjects() {
		Department department = new Department("Software Development");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Jeremy", "Yoo", 1234, department);
		employeeRepository.save(employee1);
		Employee employee2 = new Employee("Duncan", "Soutter", 4321, department);
		employeeRepository.save(employee2);

		Project project = new Project("React-app", 14);
		projectRepository.save(project);

		project.addEmployee(employee1);
		project.addEmployee(employee2);
		projectRepository.save(project);

	}

}

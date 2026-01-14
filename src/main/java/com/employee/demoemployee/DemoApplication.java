package com.employee.demoemployee;

import com.employee.demoemployee.dao.ContactDAO;
import com.employee.demoemployee.dao.EmployeeParamDAO;
import com.employee.demoemployee.dao.ModuleDAO;
import com.employee.demoemployee.entity.ContactEntity;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.entity.ModuleEntity;
import com.github.javafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

public class DemoApplication {

	private final static EmployeeParamDAO employeeDAO = new EmployeeParamDAO();
	private final static ContactDAO contactDAO = new ContactDAO();
	private final static ModuleDAO moduleDAO = new ModuleDAO();

	private final static Faker faker = new Faker(new Locale("pt-BR"));

	public static void main(String[] args) {

		var flyway = Flyway.configure()
						.dataSource("jdbc:postgresql://localhost/jdbc-sample","postgres","Neves123")
								.load();

		flyway.migrate();

		var insert  = new EmployeeEntity();
		insert.setName("Miguel");
		insert.setSalary(new BigDecimal("2000"));
		insert.setBirthday(OffsetDateTime.now().minusYears(18));
		employeeDAO.insert(insert);
		System.out.println(insert);

		var entities = Stream.generate(() -> {
			var employee = new EmployeeEntity();
			employee.setName(faker.name().fullName());
			employee.setSalary(new BigDecimal(faker.number().digits(4)));
			employee.setBirthday(OffsetDateTime.now().minusYears(18));
			employee.setModules(new ArrayList<>());
			var moduleAmount = faker.number().numberBetween(1,4);
			for (int i = 0; i < moduleAmount; i++) {
				var module = new ModuleEntity();
				module.setId(i + 1);
				employee.getModules().add(module);
			}

			return employee;
		}).limit(100).toList();

	    entities.forEach(employeeDAO::insert);


		var contact  = new ContactEntity();
		contact.setDescription("Miguel@migual");
		contact.setType("e-mail");
		contact.setEmployee(insert);
		contactDAO.insert(contact);

		moduleDAO.findAll().forEach(System.out::println);

	}

}

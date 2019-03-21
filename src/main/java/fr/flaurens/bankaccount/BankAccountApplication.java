package fr.flaurens.bankaccount;

import fr.flaurens.bankaccount.adapters.AccountDAO;
import fr.flaurens.bankaccount.adapters.OperationDAO;
import fr.flaurens.bankaccount.dao.AccountDAOImpl;
import fr.flaurens.bankaccount.dao.OperationDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}

	@Bean
	public AccountDAO accountDAO(){
		return new AccountDAOImpl();
	}

	@Bean
	public OperationDAO operationDAO(){
		return new OperationDAOImpl();
	}
}

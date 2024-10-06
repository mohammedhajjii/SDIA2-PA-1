package md.hajji.practicalactivity1;

import md.hajji.practicalactivity1.entities.BankAccount;
import md.hajji.practicalactivity1.enums.AccountType;
import md.hajji.practicalactivity1.enums.Currency;
import md.hajji.practicalactivity1.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class PracticalActivity1Application {

    public static void main(String[] args) {
        SpringApplication.run(PracticalActivity1Application.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {

            IntStream.iterate(0, i -> i <= 10 , i -> i + 1)
                    .mapToObj(i -> BankAccount.builder()
                            .balance(1000 + Math.random() * 9000)
                            .createdAt(LocalDateTime.now())
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .currency(Math.random() > 0.5 ? Currency.MAD: Currency.EUR)
                            .build()
                    )
                    .forEach(bankAccountRepository::save);

        };
    }

}

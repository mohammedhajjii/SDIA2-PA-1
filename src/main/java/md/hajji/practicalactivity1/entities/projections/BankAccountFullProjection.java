package md.hajji.practicalactivity1.entities.projections;

import md.hajji.practicalactivity1.entities.BankAccount;
import md.hajji.practicalactivity1.enums.AccountType;
import md.hajji.practicalactivity1.enums.Currency;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;


@Projection(name = "full", types = {BankAccount.class})
public interface BankAccountFullProjection {
    String getId();
    LocalDateTime getCreatedAt();
    Double getBalance();
    AccountType getType();
    Currency getCurrency();
}

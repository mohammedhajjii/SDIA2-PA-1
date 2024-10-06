package md.hajji.practicalactivity1.entities.projections;

import md.hajji.practicalactivity1.entities.BankAccount;
import md.hajji.practicalactivity1.enums.AccountType;
import md.hajji.practicalactivity1.enums.Currency;
import org.springframework.data.rest.core.config.Projection;



@Projection(name = "basic", types = {BankAccount.class})
public interface BankAccountBasicProjection {
    String getId();
    Double getBalance();
}

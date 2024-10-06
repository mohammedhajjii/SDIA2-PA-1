package md.hajji.practicalactivity1.dtos;

import md.hajji.practicalactivity1.enums.AccountType;
import md.hajji.practicalactivity1.enums.Currency;
import md.hajji.practicalactivity1.exceptions.NegativeBalanceException;
import md.hajji.practicalactivity1.exceptions.NullFieldException;

public record BankAccountRequestDTO(
        Double balance,
        AccountType type,
        Currency currency
) {
    public void validate(){
        if (balance == null || balance <= 0)
            throw new NegativeBalanceException(balance);

        if(type == null || currency == null)
            throw new NullFieldException();

    }
}

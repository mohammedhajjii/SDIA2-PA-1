package md.hajji.practicalactivity1.dtos;

import md.hajji.practicalactivity1.enums.AccountType;
import md.hajji.practicalactivity1.enums.Currency;
import java.time.LocalDateTime;

public record BankAccountResponseDTO(
        String id,
        LocalDateTime createdAt,
        Double balance,
        Currency currency,
        AccountType type
) {
}

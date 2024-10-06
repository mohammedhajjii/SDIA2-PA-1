package md.hajji.practicalactivity1.mappers;

import md.hajji.practicalactivity1.dtos.BankAccountRequestDTO;
import md.hajji.practicalactivity1.dtos.BankAccountResponseDTO;
import md.hajji.practicalactivity1.entities.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccount toBankAccount(BankAccountRequestDTO requestDTO);
    BankAccountResponseDTO toDTO(BankAccount bankAccount);
    void mapToExistingBankAccount(BankAccountRequestDTO source, @MappingTarget BankAccount target);
}

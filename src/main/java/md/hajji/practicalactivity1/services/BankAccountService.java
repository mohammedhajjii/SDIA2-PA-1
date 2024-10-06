package md.hajji.practicalactivity1.services;

import md.hajji.practicalactivity1.dtos.BankAccountRequestDTO;
import md.hajji.practicalactivity1.dtos.BankAccountResponseDTO;

import java.util.List;

public interface BankAccountService {
    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO);
    BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO accountRequestDTO);
    void deleteBankAccount(String id);
    List<BankAccountResponseDTO> getAllBankAccounts();
    BankAccountResponseDTO getBankAccount(String id);
}

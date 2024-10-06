package md.hajji.practicalactivity1.services.impl;

import lombok.RequiredArgsConstructor;
import md.hajji.practicalactivity1.dtos.BankAccountRequestDTO;
import md.hajji.practicalactivity1.dtos.BankAccountResponseDTO;
import md.hajji.practicalactivity1.entities.BankAccount;
import md.hajji.practicalactivity1.exceptions.ResourceNotFoundException;
import md.hajji.practicalactivity1.mappers.BankAccountMapper;
import md.hajji.practicalactivity1.repositories.BankAccountRepository;
import md.hajji.practicalactivity1.services.BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        bankAccountRequestDTO.validate();
        BankAccount account = bankAccountMapper.toBankAccount(bankAccountRequestDTO);
        account.setCreatedAt(LocalDateTime.now());
        bankAccountRepository.save(account);
        return bankAccountMapper.toDTO(account);
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id,  BankAccountRequestDTO accountRequestDTO) {

        accountRequestDTO.validate();

        BankAccount account = bankAccountRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("account: " + id));

        bankAccountMapper.mapToExistingBankAccount(accountRequestDTO, account);
        bankAccountRepository.save(account);
        return bankAccountMapper.toDTO(account);
    }

    @Override
    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public List<BankAccountResponseDTO> getAllBankAccounts() {
        return bankAccountRepository.findAll()
                .stream()
                .map(bankAccountMapper::toDTO)
                .toList();
    }

    @Override
    public BankAccountResponseDTO getBankAccount(String id) {
        return bankAccountRepository
                .findById(id)
                .map(bankAccountMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("account: " + id));
    }
}

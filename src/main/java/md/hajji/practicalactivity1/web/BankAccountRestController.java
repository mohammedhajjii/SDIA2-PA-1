package md.hajji.practicalactivity1.web;


import lombok.RequiredArgsConstructor;
import md.hajji.practicalactivity1.dtos.BankAccountRequestDTO;
import md.hajji.practicalactivity1.entities.BankAccount;
import md.hajji.practicalactivity1.repositories.BankAccountRepository;
import md.hajji.practicalactivity1.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/bankAccounts")
@RequiredArgsConstructor
public class BankAccountRestController {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountService bankAccountService;


    @GetMapping
    public ResponseEntity<?> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.getAllBankAccounts());
    }

    @PostMapping
    public ResponseEntity<?> createBankAccount(@RequestBody final BankAccountRequestDTO accountRequestDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankAccountService.addBankAccount(accountRequestDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBankAccountById(@PathVariable final String id) {
      return ResponseEntity.ok(bankAccountService.getBankAccount(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBankAccount
            (@PathVariable String id, @RequestBody BankAccountRequestDTO accountRequestDTO) {
       return ResponseEntity
               .ok(bankAccountService.updateBankAccount(id, accountRequestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
        return ResponseEntity.noContent().build();
    }

}

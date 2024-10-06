package md.hajji.practicalactivity1.repositories;


import md.hajji.practicalactivity1.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.web.ProjectedPayload;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}


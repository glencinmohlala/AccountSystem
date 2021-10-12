package za.ac.nwu.ac.domain.flow;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.flow.Impl.AccountTypeTranslator;
import za.ac.nwu.ac.domain.flow.Impl.CreateAccountTypeFlowImpl;
import za.ac.nwu.ac.domain.flow.CreateAccountTypeFlow;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlow implements CreateAccountTypeFlowImpl {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlow(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        if (null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        accountTypeTranslator.someMethod();
        return accountTypeTranslator.create(accountType);
    }

}

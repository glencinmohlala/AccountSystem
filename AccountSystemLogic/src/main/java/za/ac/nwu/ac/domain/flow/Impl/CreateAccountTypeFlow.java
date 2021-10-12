package za.ac.nwu.ac.domain.flow.Impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }


    public AccountTypeDto create(AccountTypeDto accountType) {
        if (null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        accountTypeTranslator.someMethod();
        return accountTypeTranslator.create(accountType);
    }

}

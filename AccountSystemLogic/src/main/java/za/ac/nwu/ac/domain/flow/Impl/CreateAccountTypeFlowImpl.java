package za.ac.nwu.ac.domain.flow.Impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl<AccountTypeDto> implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;
    private za.ac.nwu.ac.domain.dto.AccountTypeDto accountType;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto AccountType){
        if (null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }

    private class AccountTypeTranslator {
    }
}

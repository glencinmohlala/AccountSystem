package za.ac.nwu.ac.domain.flow.Impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.flow.CreateAccountTypeTransactionFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
class CreateAccountTypeTransactionFlowImpl implements CreateAccountTypeTransactionFlow {

    private AccountTypeTranslator accountTypeTranslator;
    private za.ac.nwu.ac.domain.dto.AccountTypeDto accountType;

    public void CreateAccountTypeTransactionFlowImplFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }


    public void create(AccountTypeDto AccountType){
        if (null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
    }


}

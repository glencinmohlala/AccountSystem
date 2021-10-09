package za.ac.nwu.ac.logic.flow.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAccountTypeDto() {
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        return accountTypeTranslator.getAccountTypeDtoByMnemonic(mnemonic);
    }
}

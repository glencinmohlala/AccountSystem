package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.persistence.AccountType;
import java.util.List;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
}

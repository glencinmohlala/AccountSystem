package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountType;
import javax.persistence.Query;
import javax.persistence.Entity;
import javax.persistence.QueryHint;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@ApiModel(value = "AccountType",
        description = "A DTO that represents the AccountType"
)
public class AccountTypeDto implements Serializable {

    //private static final long serialVersionUID = ;

    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
        this.setMnemonic(accountType.getMnemonic());
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Query(value = "SELECT " +
            "        ACCOUNT_TYPE_ID, " +
            "        ACCOUNT_TYPE_NAME," +
            "        CREATION_DATE," +
            "        MNEMONIC" +
            "     FROM " +
            "        SCHEMA.DATABASE" +
            "     WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT " +
            "         at " +
            "     FROM " +
            "       AccountType at" +
            "     WHERE at.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( " +
            "       at.mnemonic, " +
            "       at.accountTypeName, " +
            "       at.creationDate )" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
}

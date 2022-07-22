package Account.controllers.HDFC_Bank;

import AccountType.AccountType;
import Account.services.pkg.Account;
import Account.services.pkg.bankAccount;
import Exceptions.minimumbalanceException;

import java.math.BigDecimal;

public class HDFC_Bank_Controller extends Account implements bankAccount{

    public BigDecimal min_balance;
    public AccountType account_type;

    public HDFC_Bank_Controller(String owner, BigDecimal balance, BigDecimal min_balance, AccountType account_type)
            throws minimumbalanceException {
        super(owner, balance, min_balance, account_type);
        super.setMinBalance(BigDecimal.valueOf(5000));
        super.setOverDraft(this.getbalance(min_balance).multiply(BigDecimal.valueOf(0.2)));

        try {
            if (balance.compareTo(min_balance) >= 0) {
                this.balance = balance;
            } else {
                throw new minimumbalanceException("Minimum balance insufficent");

            }
        } catch (minimumbalanceException e) {
            e.getMessage();
            throw new minimumbalanceException("Minimum balance insufficent");
        }

    }

    @Override
    public void Widthdraw(BigDecimal balance) {

    }

    @Override
    public BigDecimal Deposite(BigDecimal balance) {

        return super.Deposite(balance);

    }

    @Override
    public boolean checkBalance(BigDecimal amount) {
        return false;
    }
}

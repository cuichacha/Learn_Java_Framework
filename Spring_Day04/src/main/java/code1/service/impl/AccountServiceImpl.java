package code1.service.impl;

import code1.dao.AccountDao;
import code1.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void transfer(String innName, String outName, Double money) {

    }
}

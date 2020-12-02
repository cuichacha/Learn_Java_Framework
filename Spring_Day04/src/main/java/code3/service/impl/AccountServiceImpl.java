package code3.service.impl;

import code3.domain.Account;
import code3.dao.AccountDao;
import code3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void transfer(String inName, String outName, Double money) {
        accountDao.inMoney(inName, money);
//        int i = 1 / 0;
        accountDao.outMoney(outName, money);
    }
}

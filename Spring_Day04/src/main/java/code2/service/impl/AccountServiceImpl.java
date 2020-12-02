package code2.service.impl;

import code2.dao.AccountDao;
import code2.domain.Account;
import code2.service.AccountService;
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

    public void save(Account account) {
        accountDao.save(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void transfer(String inName, String outName, Double money) {
        accountDao.inMoney(inName, money);
//        int i = 1 / 0;
        accountDao.outMoney(outName, money);
    }
}

package code1.service.impl;

import code1.dao.AccountDao;
import code1.service.AccountService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    private DataSource dataSource;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void transfer(String innName, String outName, Double money) {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
//        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
//        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        accountDao.inMoney(innName, money);
        int i = 1 / 0;
        accountDao.outMoney(outName, money);
//        dataSourceTransactionManager.commit(transactionStatus);
    }
}

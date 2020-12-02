package code3.dao;

import code3.domain.Account;

import java.util.List;

public interface AccountDao {

    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);
}
package code3.service;

import code3.domain.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
public interface AccountService {

    List<Account> findAll();

    @Transactional
    void transfer(String inName, String outName, Double money);

}

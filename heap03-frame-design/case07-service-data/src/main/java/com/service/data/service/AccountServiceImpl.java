package com.service.data.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private JdbcTemplate jdbcTemplateOne ;

    @Resource
    private JdbcTemplate jdbcTemplateTwo ;

    /**
     * @param fromUser 出账 账户
     * @param toUser   入账 账户
     * @param money    涉及 金额
     */
    @Transactional(isolation= Isolation.SERIALIZABLE)
    @Override
    public void transfer(String fromUser, String toUser, int money) {
        // fromUser 出账
        jdbcTemplateOne.update(
                "UPDATE user_account SET money = money-? WHERE username= ?",
                    new Object[] {money, fromUser});
        int i = 1/0 ;
        // toUser 入账
        jdbcTemplateTwo.update(
                "UPDATE user_account SET money = money+? WHERE username= ?",
                    new Object[] {money, toUser});
    }
}

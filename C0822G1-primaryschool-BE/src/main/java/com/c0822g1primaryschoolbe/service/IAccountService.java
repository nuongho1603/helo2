package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.dto.request.ChangePasswordDto;
import com.c0822g1primaryschoolbe.entity.account.Account;
import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);

    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     * Description: create method service of change password
     *
     */
    void save(Long accountId);

    void changePassword(ChangePasswordDto changePasswordDto) throws Exception;

    Boolean existsAccountByUsername(String username);

    Boolean existsAccountByEmail( String email);

    void save(Account account);

}

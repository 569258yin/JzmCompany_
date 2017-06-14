package com.jinzhimu.company.repository;

import com.jinzhimu.company.model.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MyPC on 2017/6/13.
 */
@Transactional
public interface SysUserRepository extends CrudRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}

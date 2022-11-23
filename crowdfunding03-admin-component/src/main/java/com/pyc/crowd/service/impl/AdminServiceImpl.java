package com.pyc.crowd.service.impl;

import com.pyc.crowd.entity.Admin;
import com.pyc.crowd.mapper.AdminMapper;
import com.pyc.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 彭远春
 * @create 2022-11-23 10:20
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}

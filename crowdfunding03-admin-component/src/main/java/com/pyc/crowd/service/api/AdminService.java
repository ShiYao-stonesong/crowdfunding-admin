package com.pyc.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.pyc.crowd.entity.Admin;

import java.util.List;

/**
 * @author 彭远春
 * @create 2022-11-23 10:19
 */
public interface AdminService {
    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);
}

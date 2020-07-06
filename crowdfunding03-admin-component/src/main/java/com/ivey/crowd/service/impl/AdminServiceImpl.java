package com.ivey.crowd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivey.crowd.constant.CrowdConstant;
import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.entity.AdminExample;
import com.ivey.crowd.exception.LoginFailedException;
import com.ivey.crowd.mapper.AdminMapper;
import com.ivey.crowd.service.AdminService;
import com.ivey.crowd.util.CrowdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/6/28 17:47
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int saveAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByLoginName(String loginName, String password) {

        // 1. 根据登录账号查询Admin对象
        // ① 创建AdminExample对象
        AdminExample adminExample = new AdminExample();

        // ② 创建 Criteria 对象
        AdminExample.Criteria criteria = adminExample.createCriteria();

        // ③ 在 Criteria 对象中封装查询条件
        criteria.andLoginNameEqualTo(loginName);

        // ④ 调用 AdminMapper 的方法执行查询
        List<Admin> adminList = adminMapper.selectByExample(adminExample);

        // 2. 判断Admin对象是否为null
        if (adminList == null || adminList.size() == 0) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        if (adminList.size() > 1) {
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }

        // 3. 如果Admin对象为null则抛出异常
        Admin admin = adminList.get(0);

        if (admin == null) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 4. 如果Admin对象不为null则将数据库密码从Admin对象中取出
        String passwordDB = admin.getPassword();

        // 5. 将表单提交的明文密码进行加密
        String passwordForm = CrowdUtil.md5(password);

        // 6. 对密码进行比较
        if (!Objects.equals(passwordDB, passwordForm)) {

            // 7. 如果比较结果是不一致则抛出异常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 8. 如果一致则返回Admin对象
        return admin;
    }

    @Override
    public PageInfo<Admin> getAdminByPage(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Admin> adminList = adminMapper.selectByKeyword(keyword);

        return new PageInfo<>(adminList);
    }
}

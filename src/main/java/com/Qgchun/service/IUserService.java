package com.Qgchun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Qgchun.dto.LoginFormDTO;
import com.Qgchun.dto.Result;
import com.Qgchun.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QGC
 * @since 2021-12-22
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result sign();

    Result signCount();
}

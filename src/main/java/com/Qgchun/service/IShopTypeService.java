package com.Qgchun.service;

import com.Qgchun.dto.Result;
import com.Qgchun.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QGC
 * @since 2021-12-22
 */
public interface IShopTypeService extends IService<ShopType> {

    Result queryList();
}

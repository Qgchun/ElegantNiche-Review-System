package com.Qgchun.service;

import com.Qgchun.dto.Result;
import com.Qgchun.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QGC
 * @since 2021-12-22
 */
public interface IShopService extends IService<Shop> {

    Result queryByid(Long id);

    Result update(Shop shop);

    Result queryShopByType(Integer typeId, Integer current, Double x, Double y);
}

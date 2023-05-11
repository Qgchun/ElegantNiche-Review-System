package com.Qgchun.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.Qgchun.dto.Result;
import com.Qgchun.entity.ShopType;
import com.Qgchun.mapper.ShopTypeMapper;
import com.Qgchun.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.Qgchun.utils.RedisConstants.CACHE_LIST_TTL;
import static com.Qgchun.utils.RedisConstants.CACHE_SHOP_LIST;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QGC
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ShopTypeMapper shopTypeMapper;
    @Override
    public Result queryList() {
        //1.从redis查询商铺列表
        String shopList = stringRedisTemplate.opsForValue().get(CACHE_SHOP_LIST);
        //2.判断是否存在
        if(StrUtil.isNotBlank(shopList)){
            //3.存在，直接返回
            List<ShopType> shopTypeList = JSONUtil.toList(shopList, ShopType.class);
            return Result.ok(shopTypeList);
        }
        //4.不存在，查询数据库
        QueryWrapper<ShopType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<ShopType> shopTypeList = shopTypeMapper.selectList(queryWrapper);
        //5.不存在，返回错误
        if(shopTypeList==null){
            return Result.fail("商铺列表不存在");
        }
        //6.存在，将其写入redis
        stringRedisTemplate.opsForValue().set(CACHE_SHOP_LIST,JSONUtil.toJsonStr(shopTypeList),CACHE_LIST_TTL, TimeUnit.MINUTES);
        //7.返回
        return Result.ok(shopTypeList);
    }
}

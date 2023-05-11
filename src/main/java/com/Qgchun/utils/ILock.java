package com.Qgchun.utils;

/**
 * @author shkstart
 * @create 2022-11-02 17:32
 */
public interface ILock {
    /**
     * 尝试获取锁
     */
    boolean tryLock(long timeoutSec);

    /**
     * 释放锁
     */
    void unlock();
}

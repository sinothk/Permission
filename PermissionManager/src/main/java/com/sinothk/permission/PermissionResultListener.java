package com.sinothk.permission;


/**
 * Created by 梁玉涛 on 2017/12/23.
 */

public interface PermissionResultListener {
    /**
     * 通过授权
     *
     * @param permission
     */
    void permissionSuccess(String[] permission);

    /**
     * 拒绝授权
     *
     * @param permission
     */
    void permissionFail(String[] permission);
}

package com.sinothk.permission;

import android.content.Context;
import android.support.annotation.NonNull;

import com.sinothk.permission.lib.PermissionListener;
import com.sinothk.permission.lib.PermissionsUtil;

/**
 * Created by 梁玉涛 on 2017/12/21.
 */

public class PermissionManager {
    public static boolean haveAllPermission(Context context, String[] permissions) {
        return PermissionsUtil.hasPermission(context, permissions);
    }

    public static void requestAllPermission(Context context, final PermissionResultListener listener , String[] permission, boolean showTip, PermissionsUtil.TipInfo tip) {

        PermissionsUtil.requestPermission(context, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {
                listener.permissionSuccess(permission);
            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {
                listener.permissionFail(permission);
            }
        }, permission, showTip, tip);
    }
}

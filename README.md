# permission
permission lib

# Step 1. Add the JitPack repository to your build file
    Add it in your root build.gradle at the end of repositories:
    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
# Step 2. Add the dependency
    dependencies {
      implementation 'com.github.sinothk:Permission:v2.0.180222'
    }

# Step 3. use
    val tip = PermissionsUtil.TipInfo("授权提示", "获取必须的手机权限不全！", "放弃使用", "授权")
    if (PermissionManager.haveAllPermission(this, permissions)) {
        next ...
    } else {
        PermissionManager.requestAllPermission(this, object : PermissionResultListener {
            override fun permissionFail(p0: Array<out String>?) {
                HYToast.show("放弃使用")
                finish()
            }
            override fun permissionSuccess(p0: Array<out String>?) {
                requestAppPermission(userAccount, userPwd)
            }
        }, permissions, true, tip)
    }
    
    public static final String[] permissions = {
        Manifest.permission.READ_PHONE_STATE
        , Manifest.permission.ACCESS_NETWORK_STATE,
       Manifest.permission.ACCESS_WIFI_STATE,
        Manifest.permission.READ_LOGS
    };

package com.haier.uhome.usdk.base.api;

/* JADX INFO: loaded from: classes2.dex */
public class VersionManager {
    private static final int SDK_TYPE_PHONE = 1;
    private static final int SDK_TYPE_PHONE_GEA = 3;
    private static final int SDK_TYPE_SMART_DEVICE = 2;
    private static final int SDK_TYPE_SMART_DEVICE_GEA = 4;
    private int mCurrentType;
    private String mSDKReleaseDate;
    private String mSDKTypeName;
    private String mSDKTypeVersion;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final VersionManager f31102a = new VersionManager();

        private a() {
        }
    }

    public static VersionManager getInstance() {
        return a.f31102a;
    }

    private void setSDKReleaseDate(String str) {
        this.mSDKReleaseDate = str;
    }

    private void setSDKType(int i7) {
        this.mCurrentType = i7;
    }

    private void setSDKTypeName(String str) {
        this.mSDKTypeName = str;
    }

    private void setSDKVersion(String str) {
        this.mSDKTypeVersion = str;
    }

    public String getSDKReleaseDate() {
        return this.mSDKReleaseDate;
    }

    public int getSDKType() {
        return this.mCurrentType;
    }

    public String getSDKTypeName() {
        return this.mSDKTypeName;
    }

    public String getSDKVersion() {
        return this.mSDKTypeVersion;
    }

    public void init(int i7, String str, String str2, String str3) {
        setSDKType(i7);
        setSDKTypeName(str);
        setSDKVersion(str2);
        setSDKReleaseDate(str3);
    }

    public boolean isInt() {
        int i7 = this.mCurrentType;
        return i7 == 3 || i7 == 4;
    }

    public boolean isSmartDevice() {
        int i7 = this.mCurrentType;
        return i7 == 2 || i7 == 4;
    }

    private VersionManager() {
    }
}

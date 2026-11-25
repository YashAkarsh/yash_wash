package com.haier.uhome.usdk.scanner;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ExtendInfo {
    private final String configVer;
    private final String hwPlatform;
    private final String hwVer;
    private final String keyVer;
    private final String protoVer;

    public ExtendInfo(String str, String str2, String str3, String str4, String str5) {
        this.protoVer = str;
        this.configVer = str2;
        this.keyVer = str3;
        this.hwVer = str4;
        this.hwPlatform = str5;
    }

    public String getConfigVer() {
        return this.configVer;
    }

    public String getHwPlatform() {
        return this.hwPlatform;
    }

    public String getHwVer() {
        return this.hwVer;
    }

    public String getKeyVer() {
        return this.keyVer;
    }

    public String getProtoVer() {
        return this.protoVer;
    }

    public String toString() {
        return "ExtendInfo{protoVer='" + this.protoVer + "', configVer='" + this.configVer + "', keyVer='" + this.keyVer + "', hwVer='" + this.hwVer + "', hwPlatform='" + this.hwPlatform + "'}";
    }
}

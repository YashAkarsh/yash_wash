package com.haier.uhome.usdk.scanner;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public enum ConfigStatus {
    CONFIG_ABLE("可配置"),
    TRIGGER_CONFIG_ABLE("触发可配置"),
    ALREADY_CONFIGURED("已经配置");

    String name;

    ConfigStatus(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}

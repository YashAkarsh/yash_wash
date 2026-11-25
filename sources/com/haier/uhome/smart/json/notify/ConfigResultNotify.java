package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.alipay.sdk.util.m;
import com.haier.uhome.smart.handler.ConfigResultNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigResultNotify extends BasicNotify {

    @b(name = w.h.f3145c)
    private int from;

    @b(name = m.f13818c)
    private int result;

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new ConfigResultNotifyHandler();
    }

    public int getResult() {
        return this.result;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setResult(int i7) {
        this.result = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "ConfigResultNotify{result=" + this.result + ", from=" + this.from + '}';
    }
}

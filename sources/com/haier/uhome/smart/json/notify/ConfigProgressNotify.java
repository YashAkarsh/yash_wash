package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.ConfigProgressNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigProgressNotify extends BasicNotify {

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "status")
    private int status;

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new ConfigProgressNotifyHandler();
    }

    public int getStatus() {
        return this.status;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "ConfigProgressNotify{status=" + this.status + ", from=" + this.from + '}';
    }
}

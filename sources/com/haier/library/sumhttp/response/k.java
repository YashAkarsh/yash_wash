package com.haier.library.sumhttp.response;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class k extends c implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f28051d;

    public i f() {
        return this.f28051d;
    }

    public void g(i iVar) {
        this.f28051d = iVar;
    }

    public boolean h() {
        i iVar = this.f28051d;
        return (iVar == null || TextUtils.isEmpty(iVar.d()) || TextUtils.isEmpty(this.f28051d.c())) ? false : true;
    }

    @Override // com.haier.library.sumhttp.response.c
    public String toString() {
        return "ShortCodeToLongCodeResponse{data=" + this.f28051d + '}';
    }
}

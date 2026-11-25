package com.haier.uhome.usdk.scanner;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public enum NewDirectLinkVerificationMethod {
    VERIFICATION_CODE(0),
    MANUAL_CONFIRM(1);

    int methodId;

    NewDirectLinkVerificationMethod(int i7) {
        this.methodId = i7;
    }

    public int getMethodId() {
        return this.methodId;
    }
}

package com.alipay.sdk.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
final class f implements DialogInterface.OnKeyListener {
    f() {
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i7, KeyEvent keyEvent) {
        return i7 == 4;
    }
}

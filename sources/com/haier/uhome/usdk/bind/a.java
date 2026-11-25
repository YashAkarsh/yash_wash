package com.haier.uhome.usdk.bind;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<R> implements IBindCallback<R> {
    public void a(Bitmap bitmap) {
    }

    @Override // com.haier.uhome.usdk.bind.IBindResultCallback
    public void notifyProgress(BindProgress bindProgress, String str, String str2) {
        e3.a.e(new RuntimeException("not notifyProgress").toString(), new Object[0]);
    }

    @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
    public void switchNetworkNotify() {
        e3.a.e(new RuntimeException("not switchNetworkNotify").toString(), new Object[0]);
    }
}

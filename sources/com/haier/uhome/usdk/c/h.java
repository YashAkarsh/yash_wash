package com.haier.uhome.usdk.c;

import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.uSDKErrorConst;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class h extends com.haier.uhome.usdk.base.utils.b {
    @Deprecated
    public static void a(final IuSDKCallback iuSDKCallback, final uSDKErrorConst usdkerrorconst) {
        if (iuSDKCallback == null) {
            e3.a.v("CallbackUtils.uSDKCallback %s with null callback", com.haier.uhome.usdk.base.utils.b.a());
            return;
        }
        if (usdkerrorconst == null) {
            e3.a.v("CallbackUtils.uSDKCallback %s with null error", com.haier.uhome.usdk.base.utils.b.a());
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.c.p
            @Override // java.lang.Runnable
            public final void run() {
                iuSDKCallback.onCallback(usdkerrorconst);
            }
        });
    }
}

package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a();

    void a(com.haier.uhome.control.local.api.a aVar);

    void a(ICallback<FOTAInfo> iCallback);

    boolean a(FOTAStatusInfo fOTAStatusInfo);

    void b(ICallback<Void> iCallback);

    void f();
}

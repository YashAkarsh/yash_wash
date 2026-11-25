package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u7 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}

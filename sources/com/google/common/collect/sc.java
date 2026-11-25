package com.google.common.collect;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class sc<K, V> {
    public static void a(tc tcVar, final BiConsumer biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        tcVar.entries().forEach(new Consumer() { // from class: com.google.common.collect.rc
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                biConsumer.accept(entry.getKey(), entry.getValue());
            }
        });
    }
}

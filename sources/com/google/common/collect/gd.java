package com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class gd<E> {
    public static void a(hd hdVar, final Consumer consumer) {
        com.google.common.base.e0.E(consumer);
        hdVar.entrySet().forEach(new Consumer() { // from class: com.google.common.collect.fd
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                gd.d(consumer, (hd.a) obj);
            }
        });
    }

    @s1.a
    public static void b(hd hdVar, final ObjIntConsumer objIntConsumer) {
        com.google.common.base.e0.E(objIntConsumer);
        hdVar.entrySet().forEach(new Consumer() { // from class: com.google.common.collect.ed
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                hd.a aVar = (hd.a) obj;
                objIntConsumer.accept(aVar.getElement(), aVar.getCount());
            }
        });
    }

    public static Spliterator c(hd hdVar) {
        return md.C(hdVar);
    }

    public static /* synthetic */ void d(Consumer consumer, hd.a aVar) {
        Object element = aVar.getElement();
        int count = aVar.getCount();
        for (int i7 = 0; i7 < count; i7++) {
            consumer.accept(element);
        }
    }
}

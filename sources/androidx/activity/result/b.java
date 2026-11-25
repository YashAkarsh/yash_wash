package androidx.activity.result;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @m0
    <I, O> c<I> registerForActivityResult(@m0 b.a<I, O> aVar, @m0 ActivityResultRegistry activityResultRegistry, @m0 a<O> aVar2);

    @m0
    <I, O> c<I> registerForActivityResult(@m0 b.a<I, O> aVar, @m0 a<O> aVar2);
}

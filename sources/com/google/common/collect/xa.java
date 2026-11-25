package com.google.common.collect;

import com.haier.uhome.account.api.RetInfoContent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class xa<K, V> extends v7<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient Map<K, V> f21408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient d7<Map.Entry<K, V>> f21409g;

    xa(Map<K, V> map, d7<Map.Entry<K, V>> d7Var) {
        this.f21408f = map;
        this.f21409g = d7Var;
    }

    static <K, V> v7<K, V> L(int i7, Map.Entry<K, V>[] entryArr) {
        HashMap mapK0 = wb.k0(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            w7 w7VarO = ie.O(entryArr[i8]);
            entryArr[i8] = w7VarO;
            Object objPutIfAbsent = mapK0.putIfAbsent(w7VarO.getKey(), entryArr[i8].getValue());
            if (objPutIfAbsent != null) {
                throw v7.e(RetInfoContent.BindKEY_ISNULL, entryArr[i8], entryArr[i8].getKey() + "=" + objPutIfAbsent);
            }
        }
        return new xa(mapK0, d7.l(entryArr, i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(BiConsumer biConsumer, Map.Entry entry) {
        biConsumer.accept(entry.getKey(), entry.getValue());
    }

    @Override // java.util.Map
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        this.f21409g.forEach(new Consumer() { // from class: com.google.common.collect.wa
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                xa.M(biConsumer, (Map.Entry) obj);
            }
        });
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        return this.f21408f.get(obj);
    }

    @Override // com.google.common.collect.v7
    u8<Map.Entry<K, V>> k() {
        return new x7.b(this, this.f21409g);
    }

    @Override // com.google.common.collect.v7
    u8<K> l() {
        return new z7(this);
    }

    @Override // com.google.common.collect.v7
    x6<V> m() {
        return new c8(this);
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f21409g.size();
    }
}

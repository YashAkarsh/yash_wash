package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class q3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15392d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.collection.a<c<?>, String> f15390b = new androidx.collection.a<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.tasks.n<Map<c<?>, String>> f15391c = new com.google.android.gms.tasks.n<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15393e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.collection.a<c<?>, ConnectionResult> f15389a = new androidx.collection.a<>();

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public q3(Iterable<? extends com.google.android.gms.common.api.l<?>> iterable) {
        Iterator<? extends com.google.android.gms.common.api.l<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.f15389a.put(it.next().b(), null);
        }
        this.f15392d = this.f15389a.keySet().size();
    }

    public final com.google.android.gms.tasks.m<Map<c<?>, String>> a() {
        return this.f15391c.a();
    }

    public final Set<c<?>> b() {
        return this.f15389a.keySet();
    }

    public final void c(c<?> cVar, ConnectionResult connectionResult, @c.o0 String str) {
        this.f15389a.put(cVar, connectionResult);
        this.f15390b.put(cVar, str);
        this.f15392d--;
        if (!connectionResult.s0()) {
            this.f15393e = true;
        }
        if (this.f15392d == 0) {
            if (!this.f15393e) {
                this.f15391c.c(this.f15390b);
            } else {
                this.f15391c.b(new com.google.android.gms.common.api.c(this.f15389a));
            }
        }
    }
}

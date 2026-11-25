package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
@c1.a
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Account f15718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Scope> f15719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Scope> f15720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, i0> f15721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final View f15723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f15724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f15725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.gms.signin.a f15726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f15727j;

    @c1.a
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Account f15728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.collection.b<Scope> f15729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f15730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f15731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.google.android.gms.signin.a f15732e = com.google.android.gms.signin.a.f16748j;

        @c1.a
        @c.m0
        public f a() {
            return new f(this.f15728a, this.f15729b, null, 0, null, this.f15730c, this.f15731d, this.f15732e, false);
        }

        @c1.a
        @c.m0
        public a b(@c.m0 String str) {
            this.f15730c = str;
            return this;
        }

        @c.m0
        public final a c(@c.m0 Collection<Scope> collection) {
            if (this.f15729b == null) {
                this.f15729b = new androidx.collection.b<>();
            }
            this.f15729b.addAll(collection);
            return this;
        }

        @c.m0
        public final a d(@Nullable Account account) {
            this.f15728a = account;
            return this;
        }

        @c.m0
        public final a e(@c.m0 String str) {
            this.f15731d = str;
            return this;
        }
    }

    @c1.a
    public f(@c.m0 Account account, @c.m0 Set<Scope> set, @c.m0 Map<com.google.android.gms.common.api.a<?>, i0> map, int i7, @Nullable View view, @c.m0 String str, @c.m0 String str2, @Nullable com.google.android.gms.signin.a aVar) {
        this(account, set, map, i7, view, str, str2, aVar, false);
    }

    @c1.a
    @c.m0
    public static f a(@c.m0 Context context) {
        return new com.google.android.gms.common.api.k.a(context).p();
    }

    @c.o0
    @c1.a
    public Account b() {
        return this.f15718a;
    }

    @c.o0
    @c1.a
    @Deprecated
    public String c() {
        Account account = this.f15718a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @c1.a
    @c.m0
    public Account d() {
        Account account = this.f15718a;
        return account != null ? account : new Account("<<default account>>", b.f15664a);
    }

    @c1.a
    @c.m0
    public Set<Scope> e() {
        return this.f15720c;
    }

    @c1.a
    @c.m0
    public Set<Scope> f(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        i0 i0Var = this.f15721d.get(aVar);
        if (i0Var == null || i0Var.f15746a.isEmpty()) {
            return this.f15719b;
        }
        HashSet hashSet = new HashSet(this.f15719b);
        hashSet.addAll(i0Var.f15746a);
        return hashSet;
    }

    @c1.a
    public int g() {
        return this.f15722e;
    }

    @c1.a
    @c.m0
    public String h() {
        return this.f15724g;
    }

    @c1.a
    @c.m0
    public Set<Scope> i() {
        return this.f15719b;
    }

    @c.o0
    @c1.a
    public View j() {
        return this.f15723f;
    }

    @c.m0
    public final com.google.android.gms.signin.a k() {
        return this.f15726i;
    }

    @c.o0
    public final Integer l() {
        return this.f15727j;
    }

    @c.o0
    public final String m() {
        return this.f15725h;
    }

    @c.m0
    public final Map<com.google.android.gms.common.api.a<?>, i0> n() {
        return this.f15721d;
    }

    public final void o(@c.m0 Integer num) {
        this.f15727j = num;
    }

    public f(@Nullable Account account, @c.m0 Set<Scope> set, @c.m0 Map<com.google.android.gms.common.api.a<?>, i0> map, int i7, @Nullable View view, @c.m0 String str, @c.m0 String str2, @Nullable com.google.android.gms.signin.a aVar, boolean z7) {
        this.f15718a = account;
        Set<Scope> setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f15719b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f15721d = map;
        this.f15723f = view;
        this.f15722e = i7;
        this.f15724g = str;
        this.f15725h = str2;
        this.f15726i = aVar == null ? com.google.android.gms.signin.a.f16748j : aVar;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator<i0> it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f15746a);
        }
        this.f15720c = Collections.unmodifiableSet(hashSet);
    }
}

package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;
import kotlin.jvm.internal.l0;
import kotlin.u0;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F a(@a7.d Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F b(@a7.d s<F, S> sVar) {
        l0.p(sVar, "<this>");
        return sVar.f6387a;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S c(@a7.d Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return (S) pair.second;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S d(@a7.d s<F, S> sVar) {
        l0.p(sVar, "<this>");
        return sVar.f6388b;
    }

    @a7.d
    public static final <F, S> Pair<F, S> e(@a7.d u0<? extends F, ? extends S> u0Var) {
        l0.p(u0Var, "<this>");
        return new Pair<>(u0Var.e(), u0Var.f());
    }

    @a7.d
    public static final <F, S> s<F, S> f(@a7.d u0<? extends F, ? extends S> u0Var) {
        l0.p(u0Var, "<this>");
        return new s<>(u0Var.e(), u0Var.f());
    }

    @a7.d
    public static final <F, S> u0<F, S> g(@a7.d Pair<F, S> pair) {
        l0.p(pair, "<this>");
        return new u0<>(pair.first, pair.second);
    }

    @a7.d
    public static final <F, S> u0<F, S> h(@a7.d s<F, S> sVar) {
        l0.p(sVar, "<this>");
        return new u0<>(sVar.f6387a, sVar.f6388b);
    }
}

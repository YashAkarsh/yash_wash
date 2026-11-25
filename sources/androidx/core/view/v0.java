package androidx.core.view;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
public interface v0 {
    void addMenuProvider(@c.m0 p1 p1Var);

    void addMenuProvider(@c.m0 p1 p1Var, @c.m0 androidx.lifecycle.q qVar);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(@c.m0 p1 p1Var, @c.m0 androidx.lifecycle.q qVar, @c.m0 androidx.lifecycle.m.c cVar);

    void invalidateMenu();

    void removeMenuProvider(@c.m0 p1 p1Var);
}

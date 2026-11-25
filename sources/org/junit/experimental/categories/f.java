package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends c {

    private static class a extends org.junit.experimental.categories.a.C0529a {
        public a(List<Class<?>> list) {
            this(new HashSet(list));
        }

        @Override // org.junit.experimental.categories.a.C0529a, org.junit.runner.manipulation.a
        public String b() {
            return "includes " + super.b();
        }

        public a(Set<Class<?>> set) {
            super(true, set, true, null);
        }
    }

    @Override // org.junit.experimental.categories.c
    protected org.junit.runner.manipulation.a b(List<Class<?>> list) {
        return new a(list);
    }
}

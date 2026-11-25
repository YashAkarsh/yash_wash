package org.hamcrest;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements g {
    private g i(String str, String str2, String str3, Iterator<? extends m> it) {
        h(str);
        boolean z7 = false;
        while (it.hasNext()) {
            if (z7) {
                h(str2);
            }
            b(it.next());
            z7 = true;
        }
        h(str3);
        return this;
    }

    private <T> g j(String str, String str2, String str3, Iterator<T> it) {
        return i(str, str2, str3, new org.hamcrest.internal.d(it));
    }

    private String k(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    private void l(char c8) {
        if (c8 == '\t') {
            h("\\t");
            return;
        }
        if (c8 == '\n') {
            h("\\n");
            return;
        }
        if (c8 == '\r') {
            h("\\r");
        } else if (c8 != '\"') {
            g(c8);
        } else {
            h("\\\"");
        }
    }

    private void m(String str) {
        g(h0.f35376b);
        for (int i7 = 0; i7 < str.length(); i7++) {
            l(str.charAt(i7));
        }
        g(h0.f35376b);
    }

    @Override // org.hamcrest.g
    public g a(String str, String str2, String str3, Iterable<? extends m> iterable) {
        return i(str, str2, str3, iterable.iterator());
    }

    @Override // org.hamcrest.g
    public g b(m mVar) {
        mVar.b(this);
        return this;
    }

    @Override // org.hamcrest.g
    public <T> g c(String str, String str2, String str3, T... tArr) {
        return f(str, str2, str3, Arrays.asList(tArr));
    }

    @Override // org.hamcrest.g
    public g d(String str) {
        h(str);
        return this;
    }

    @Override // org.hamcrest.g
    public g e(Object obj) {
        if (obj == null) {
            h("null");
        } else if (obj instanceof String) {
            m((String) obj);
        } else if (obj instanceof Character) {
            g(h0.f35376b);
            l(((Character) obj).charValue());
            g(h0.f35376b);
        } else if (obj instanceof Short) {
            g(h0.f35379e);
            h(k(obj));
            h("s>");
        } else if (obj instanceof Long) {
            g(h0.f35379e);
            h(k(obj));
            h("L>");
        } else if (obj instanceof Float) {
            g(h0.f35379e);
            h(k(obj));
            h("F>");
        } else if (obj.getClass().isArray()) {
            j("[", ", ", "]", new org.hamcrest.internal.a(obj));
        } else {
            g(h0.f35379e);
            h(k(obj));
            g(h0.f35380f);
        }
        return this;
    }

    @Override // org.hamcrest.g
    public <T> g f(String str, String str2, String str3, Iterable<T> iterable) {
        return j(str, str2, str3, iterable.iterator());
    }

    protected abstract void g(char c8);

    protected void h(String str) {
        for (int i7 = 0; i7 < str.length(); i7++) {
            g(str.charAt(i7));
        }
    }
}

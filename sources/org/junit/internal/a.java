package org.junit.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends AssertionError {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f39829c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Integer> f39830a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39831b;

    public a(String str, AssertionError assertionError, int i7) {
        this.f39831b = str;
        initCause(assertionError);
        a(i7);
    }

    public void a(int i7) {
        this.f39830a.add(0, Integer.valueOf(i7));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        String str = this.f39831b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("arrays first differed at element ");
        Iterator<Integer> it = this.f39830a.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            sb.append("[");
            sb.append(iIntValue);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}

package org.junit.runner.manipulation;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class e implements Comparator<org.junit.runner.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f39993b = new e(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator<org.junit.runner.c> f39994a;

    static class a implements Comparator<org.junit.runner.c> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(org.junit.runner.c cVar, org.junit.runner.c cVar2) {
            return 0;
        }
    }

    public e(Comparator<org.junit.runner.c> comparator) {
        this.f39994a = comparator;
    }

    public void a(Object obj) {
        if (obj instanceof d) {
            ((d) obj).e(this);
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(org.junit.runner.c cVar, org.junit.runner.c cVar2) {
        return this.f39994a.compare(cVar, cVar2);
    }
}

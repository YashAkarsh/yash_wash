package com.haier.library.okhttp.b.g;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f27338a = new a();

    static class a implements l {
        a() {
        }

        @Override // com.haier.library.okhttp.b.g.l
        public void a(int i7, b bVar) {
        }

        @Override // com.haier.library.okhttp.b.g.l
        public boolean b(int i7, List<c> list, boolean z7) {
            return true;
        }

        @Override // com.haier.library.okhttp.b.g.l
        public boolean c(int i7, List<c> list) {
            return true;
        }

        @Override // com.haier.library.okhttp.b.g.l
        public boolean d(int i7, com.haier.library.a.i iVar, int i8, boolean z7) throws IOException {
            iVar.j0(i8);
            return true;
        }
    }

    void a(int i7, b bVar);

    boolean b(int i7, List<c> list, boolean z7);

    boolean c(int i7, List<c> list);

    boolean d(int i7, com.haier.library.a.i iVar, int i8, boolean z7) throws IOException;
}

package com.haier.uhome.usdk.c;

import com.haier.uhome.usdk.api.uSDKPingResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.haier.library.common.b.n f32057a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.haier.library.common.b.n.b f32060a = new com.haier.library.common.b.n.b();

        public a a(List<String> list) {
            this.f32060a.c(list);
            return this;
        }

        public a b(long j7) {
            this.f32060a.f(j7);
            return this;
        }

        public a a(int i7, int i8) {
            this.f32060a.a(i7, i8);
            return this;
        }

        public a a(boolean z7) {
            this.f32060a.d(z7);
            return this;
        }

        public a a(long j7) {
            this.f32060a.b(j7);
            return this;
        }

        public g a() {
            return new g(this.f32060a.e());
        }
    }

    public interface b {
        void a(double d8);

        void a(String str);

        void a(List<uSDKPingResult> list);
    }

    public void a(final b bVar) {
        this.f32057a.l(new com.haier.library.common.b.n.c() { // from class: com.haier.uhome.usdk.c.g.1
            @Override // com.haier.library.common.b.n.c
            public void a(double d8) {
                bVar.a(d8);
            }

            @Override // com.haier.library.common.b.n.c
            public void a(List<com.haier.library.common.b.o> list) {
                if (list == null) {
                    bVar.a("no result");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.haier.library.common.b.o> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new uSDKPingResult(it.next()));
                }
                bVar.a(arrayList);
            }

            @Override // com.haier.library.common.b.n.c
            public void a(String str) {
                bVar.a(str);
            }
        });
    }

    private g(com.haier.library.common.b.n nVar) {
        this.f32057a = nVar;
    }
}

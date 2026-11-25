package androidx.databinding;

/* JADX INFO: loaded from: classes.dex */
abstract class b extends androidx.databinding.a {

    class a extends s.a {
        a() {
        }

        @Override // androidx.databinding.s.a
        public void f(s sVar, int i7) {
            b.this.e();
        }
    }

    public b() {
    }

    public b(s... sVarArr) {
        if (sVarArr == null || sVarArr.length == 0) {
            return;
        }
        a aVar = new a();
        for (s sVar : sVarArr) {
            sVar.a(aVar);
        }
    }
}

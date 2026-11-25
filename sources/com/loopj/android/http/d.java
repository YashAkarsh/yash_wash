package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<JSON_TYPE> extends r {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f32508p = "BaseJsonHttpResponseHandler";

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Header[] f32511c;

        /* JADX INFO: renamed from: com.loopj.android.http.d$a$a, reason: collision with other inner class name */
        class RunnableC0393a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f32513a;

            RunnableC0393a(Object obj) {
                this.f32513a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.this.K(aVar.f32510b, aVar.f32511c, aVar.f32509a, this.f32513a);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Throwable f32515a;

            b(Throwable th) {
                this.f32515a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.this.J(aVar.f32510b, aVar.f32511c, this.f32515a, aVar.f32509a, null);
            }
        }

        a(String str, int i7, Header[] headerArr) {
            this.f32509a = str;
            this.f32510b = i7;
            this.f32511c = headerArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.E(new RunnableC0393a(d.this.L(this.f32509a)));
            } catch (Throwable th) {
                Log.d(d.f32508p, "parseResponse thrown an problem", th);
                d.this.E(new b(th));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f32517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Header[] f32519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Throwable f32520d;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f32522a;

            a(Object obj) {
                this.f32522a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.this.J(bVar.f32518b, bVar.f32519c, bVar.f32520d, bVar.f32517a, this.f32522a);
            }
        }

        /* JADX INFO: renamed from: com.loopj.android.http.d$b$b, reason: collision with other inner class name */
        class RunnableC0394b implements Runnable {
            RunnableC0394b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                d.this.J(bVar.f32518b, bVar.f32519c, bVar.f32520d, bVar.f32517a, null);
            }
        }

        b(String str, int i7, Header[] headerArr, Throwable th) {
            this.f32517a = str;
            this.f32518b = i7;
            this.f32519c = headerArr;
            this.f32520d = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.E(new a(d.this.L(this.f32517a)));
            } catch (Throwable th) {
                Log.d(d.f32508p, "parseResponse thrown an problem", th);
                d.this.E(new RunnableC0394b());
            }
        }
    }

    public d() {
        super("UTF-8");
    }

    @Override // com.loopj.android.http.c
    public final void A(int i7, String str) {
        super.A(i7, str);
    }

    @Override // com.loopj.android.http.r, com.loopj.android.http.c
    public void B(int i7, Header[] headerArr, String str) {
        if (i7 != 204) {
            new Thread(new a(str, i7, headerArr)).start();
        } else {
            K(i7, headerArr, null, null);
        }
    }

    @Override // com.loopj.android.http.r, com.loopj.android.http.c
    public final void C(int i7, Header[] headerArr, byte[] bArr) {
        super.C(i7, headerArr, bArr);
    }

    @Override // com.loopj.android.http.c
    public final void D(String str) {
        super.D(str);
    }

    @Override // com.loopj.android.http.r
    public void H(int i7, Header[] headerArr, String str, Throwable th) {
        if (str != null) {
            new Thread(new b(str, i7, headerArr, th)).start();
        } else {
            J(i7, headerArr, th, null, null);
        }
    }

    @Override // com.loopj.android.http.r
    public final void I(String str, Throwable th) {
        super.I(str, th);
    }

    public abstract void J(int i7, Header[] headerArr, Throwable th, String str, JSON_TYPE json_type);

    public abstract void K(int i7, Header[] headerArr, String str, JSON_TYPE json_type);

    protected abstract JSON_TYPE L(String str) throws Throwable;

    @Override // com.loopj.android.http.c
    public final void r(int i7, Throwable th, String str) {
        super.r(i7, th, str);
    }

    @Override // com.loopj.android.http.c
    public final void s(int i7, Header[] headerArr, Throwable th, String str) {
        super.s(i7, headerArr, th, str);
    }

    @Override // com.loopj.android.http.r, com.loopj.android.http.c
    public final void t(int i7, Header[] headerArr, byte[] bArr, Throwable th) {
        super.t(i7, headerArr, bArr, th);
    }

    @Override // com.loopj.android.http.c
    public final void u(Throwable th) {
        super.u(th);
    }

    @Override // com.loopj.android.http.c
    public final void v(Throwable th, String str) {
        super.v(th, str);
    }

    public d(String str) {
        super(str);
    }
}

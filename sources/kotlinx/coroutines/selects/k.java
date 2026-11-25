package kotlinx.coroutines.selects;

import i5.l;
import kotlin.jvm.internal.i0;
import kotlin.l2;
import kotlinx.coroutines.d2;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {37}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f37242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f37243e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f37244f;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f37243e = obj;
            this.f37244f |= Integer.MIN_VALUE;
            return k.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x0058
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlinx.coroutines.d2
    @a7.e
    public static final java.lang.Object a(@a7.d i5.l<? super kotlinx.coroutines.selects.a<? super java.lang.Boolean>, kotlin.l2> r4, @a7.d kotlin.coroutines.d<? super kotlin.l2> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.selects.k.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.selects.k$a r0 = (kotlinx.coroutines.selects.k.a) r0
            int r1 = r0.f37244f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37244f = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.k$a r0 = new kotlinx.coroutines.selects.k$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f37243e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f37244f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f37242d
            i5.l r4 = (i5.l) r4
            kotlin.e1.n(r5)
            goto L59
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.e1.n(r5)
        L38:
            r0.f37242d = r4
            r0.f37244f = r3
            kotlinx.coroutines.selects.b r5 = new kotlinx.coroutines.selects.b
            r5.<init>(r0)
            r4.z(r5)     // Catch: java.lang.Throwable -> L45
            goto L49
        L45:
            r2 = move-exception
            r5.e1(r2)
        L49:
            java.lang.Object r5 = r5.d1()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.b.h()
            if (r5 != r2) goto L56
            kotlin.coroutines.jvm.internal.h.c(r0)
        L56:
            if (r5 != r1) goto L59
            return r1
        L59:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L62
            goto L38
        L62:
            kotlin.l2 r4 = kotlin.l2.f34958a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.k.a(i5.l, kotlin.coroutines.d):java.lang.Object");
    }

    @d2
    private static final Object b(l<? super kotlinx.coroutines.selects.a<? super Boolean>, l2> lVar, kotlin.coroutines.d<? super l2> dVar) {
        Object objD1;
        do {
            i0.e(0);
            b bVar = new b(dVar);
            try {
                lVar.z(bVar);
            } catch (Throwable th) {
                bVar.e1(th);
            }
            objD1 = bVar.d1();
            if (objD1 == kotlin.coroutines.intrinsics.d.h()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            i0.e(1);
        } while (((Boolean) objD1).booleanValue());
        return l2.f34958a;
    }
}

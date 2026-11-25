package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.share.internal.ShareConstants;
import easypay.appinvoke.manager.Constants;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.a1;
import kotlin.collections.r0;
import kotlin.e1;
import kotlin.l2;
import kotlin.p1;
import kotlin.u0;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.n1;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class v {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class a<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f35685e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35686f;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35685e = obj;
            this.f35686f |= Integer.MIN_VALUE;
            return v.a(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {434, 436}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class a0<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35688e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35689f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35690g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f35691h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35692i;

        a0(kotlin.coroutines.d<? super a0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35691h = obj;
            this.f35692i |= Integer.MIN_VALUE;
            return v.N(null, null, this);
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.l<Throwable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<?> f35693a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlinx.coroutines.channels.i0<?> i0Var) {
            super(1);
            this.f35693a = i0Var;
        }

        public final void b(@a7.e Throwable th) {
            kotlinx.coroutines.channels.s.b(this.f35693a, th);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class b0<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f35695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35696f;

        b0(kotlin.coroutines.d<? super b0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35695e = obj;
            this.f35696f |= Integer.MIN_VALUE;
            return v.O(null, this);
        }
    }

    static final class c extends kotlin.jvm.internal.n0 implements i5.l<Throwable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<?>[] f35697a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlinx.coroutines.channels.i0<?>[] i0VarArr) {
            super(1);
            this.f35697a = i0VarArr;
        }

        public final void b(@a7.e Throwable th) throws Throwable {
            kotlinx.coroutines.channels.i0<?>[] i0VarArr = this.f35697a;
            int length = i0VarArr.length;
            Throwable th2 = null;
            int i7 = 0;
            while (i7 < length) {
                kotlinx.coroutines.channels.i0<?> i0Var = i0VarArr[i7];
                i7++;
                try {
                    kotlinx.coroutines.channels.s.b(i0Var, th);
                } catch (Throwable th3) {
                    if (th2 == null) {
                        th2 = th3;
                    } else {
                        kotlin.p.a(th2, th3);
                    }
                }
            }
            if (th2 != null) {
                throw th2;
            }
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) throws Throwable {
            b(th);
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c0 extends kotlin.coroutines.jvm.internal.o implements i5.p<Object, kotlin.coroutines.d<Object>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35699f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35700g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(kotlinx.coroutines.channels.i0<Object> i0Var, kotlin.coroutines.d<? super c0> dVar) {
            super(2, dVar);
            this.f35700g = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            c0 c0Var = new c0(this.f35700g, dVar);
            c0Var.f35699f = obj;
            return c0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.coroutines.intrinsics.d.h();
            if (this.f35698e != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(obj);
            Object obj2 = this.f35699f;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.f35700g + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.e Object obj, @a7.e kotlin.coroutines.d<Object> dVar) {
            return ((c0) D(obj, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class d<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35702e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35703f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35704g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35705h;

        d(kotlin.coroutines.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35704g = obj;
            this.f35705h |= Integer.MIN_VALUE;
            return v.d(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {136, 139}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class d0<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35707e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35708f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35709g;

        d0(kotlin.coroutines.d<? super d0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35708f = obj;
            this.f35709g |= Integer.MIN_VALUE;
            return v.Q(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends kotlin.coroutines.jvm.internal.o implements i5.p<Object, kotlin.coroutines.d<Object>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35711f;

        e(kotlin.coroutines.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            e eVar = new e(dVar);
            eVar.f35711f = obj;
            return eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.coroutines.intrinsics.d.h();
            if (this.f35710e != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(obj);
            return this.f35711f;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(Object obj, @a7.e kotlin.coroutines.d<Object> dVar) {
            return ((e) D(obj, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {com.alibaba.fastjson.asm.j.D, Constants.ACTION_UID_VIEWER}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class e0<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35715g;

        e0(kotlin.coroutines.d<? super e0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35714f = obj;
            this.f35715g |= Integer.MIN_VALUE;
            return v.R(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    static final class f<E> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super E>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35719h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private /* synthetic */ Object f35720i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<E> f35721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i5.p<E, kotlin.coroutines.d<? super K>, Object> f35722k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(kotlinx.coroutines.channels.i0<? extends E> i0Var, i5.p<? super E, ? super kotlin.coroutines.d<? super K>, ? extends Object> pVar, kotlin.coroutines.d<? super f> dVar) {
            super(2, dVar);
            this.f35721j = i0Var;
            this.f35722k = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            f fVar = new f(this.f35721j, this.f35722k, dVar);
            fVar.f35720i = obj;
            return fVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0082 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x0083  */
        /* JADX WARN: Code duplicated, block: B:19:0x0092  */
        /* JADX WARN: Code duplicated, block: B:21:0x00a8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:30:0x00d2  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v19 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.util.HashSet] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.m0] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c5 -> B:29:0x00cb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d2 -> B:13:0x0071). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 219
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.f.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super E> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((f) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class f0 extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<Object>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35724f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35725g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f35726h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f35727i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35728j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f0(int i7, kotlinx.coroutines.channels.i0<Object> i0Var, kotlin.coroutines.d<? super f0> dVar) {
            super(2, dVar);
            this.f35727i = i7;
            this.f35728j = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            f0 f0Var = new f0(this.f35727i, this.f35728j, dVar);
            f0Var.f35726h = obj;
            return f0Var;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0060 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x0061  */
        /* JADX WARN: Code duplicated, block: B:25:0x006d  */
        /* JADX WARN: Code duplicated, block: B:27:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x0080  */
        /* JADX WARN: Code duplicated, block: B:31:0x0086  */
        /* JADX WARN: Code duplicated, block: B:33:0x0089  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0080 -> B:29:0x0082). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r8.f35725g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L36
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                int r1 = r8.f35724f
                java.lang.Object r4 = r8.f35723e
                kotlinx.coroutines.channels.p r4 = (kotlinx.coroutines.channels.p) r4
                java.lang.Object r5 = r8.f35726h
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r9)
                r9 = r5
                r5 = r8
                goto L82
            L1f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L27:
                int r1 = r8.f35724f
                java.lang.Object r4 = r8.f35723e
                kotlinx.coroutines.channels.p r4 = (kotlinx.coroutines.channels.p) r4
                java.lang.Object r5 = r8.f35726h
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r9)
                r6 = r8
                goto L65
            L36:
                kotlin.e1.n(r9)
                java.lang.Object r9 = r8.f35726h
                kotlinx.coroutines.channels.g0 r9 = (kotlinx.coroutines.channels.g0) r9
                int r1 = r8.f35727i
                if (r1 != 0) goto L44
                kotlin.l2 r9 = kotlin.l2.f34958a
                return r9
            L44:
                if (r1 < 0) goto L48
                r4 = r3
                goto L49
            L48:
                r4 = 0
            L49:
                if (r4 == 0) goto L8c
                kotlinx.coroutines.channels.i0<java.lang.Object> r4 = r8.f35728j
                kotlinx.coroutines.channels.p r4 = r4.iterator()
                r5 = r8
            L52:
                r5.f35726h = r9
                r5.f35723e = r4
                r5.f35724f = r1
                r5.f35725g = r3
                java.lang.Object r6 = r4.a(r5)
                if (r6 != r0) goto L61
                return r0
            L61:
                r7 = r5
                r5 = r9
                r9 = r6
                r6 = r7
            L65:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L89
                java.lang.Object r9 = r4.next()
                r6.f35726h = r5
                r6.f35723e = r4
                r6.f35724f = r1
                r6.f35725g = r2
                java.lang.Object r9 = r5.R(r9, r6)
                if (r9 != r0) goto L80
                return r0
            L80:
                r9 = r5
                r5 = r6
            L82:
                int r1 = r1 + (-1)
                if (r1 != 0) goto L52
                kotlin.l2 r9 = kotlin.l2.f34958a
                return r9
            L89:
                kotlin.l2 r9 = kotlin.l2.f34958a
                return r9
            L8c:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "Requested element count "
                r9.append(r0)
                r9.append(r1)
                java.lang.String r0 = " is less than zero."
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r9 = r9.toString()
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.f0.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((f0) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {Constants.ACTION_NB_REMOVE_LOADER, com.alibaba.fastjson.asm.j.Q, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
    static final class g extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<Object>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35729e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35730f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35731g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f35732h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f35733i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35734j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i7, kotlinx.coroutines.channels.i0<Object> i0Var, kotlin.coroutines.d<? super g> dVar) {
            super(2, dVar);
            this.f35733i = i7;
            this.f35734j = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            g gVar = new g(this.f35733i, this.f35734j, dVar);
            gVar.f35732h = obj;
            return gVar;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0076 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x0077  */
        /* JADX WARN: Code duplicated, block: B:25:0x0086  */
        /* JADX WARN: Code duplicated, block: B:28:0x008e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0077 -> B:23:0x007e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c8 -> B:32:0x009f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.g.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((g) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class g0 extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<Object>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35737g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f35738h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35739i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i5.p<Object, kotlin.coroutines.d<? super Boolean>, Object> f35740j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g0(kotlinx.coroutines.channels.i0<Object> i0Var, i5.p<Object, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.d<? super g0> dVar) {
            super(2, dVar);
            this.f35739i = i0Var;
            this.f35740j = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            g0 g0Var = new g0(this.f35739i, this.f35740j, dVar);
            g0Var.f35738h = obj;
            return g0Var;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0063 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x0064  */
        /* JADX WARN: Code duplicated, block: B:20:0x0072  */
        /* JADX WARN: Code duplicated, block: B:22:0x0086 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0087  */
        /* JADX WARN: Code duplicated, block: B:26:0x0094  */
        /* JADX WARN: Code duplicated, block: B:28:0x0097  */
        /* JADX WARN: Code duplicated, block: B:30:0x00a6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a7 -> B:14:0x0057). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r9.f35737g
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L48
                if (r1 == r4) goto L38
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r9.f35735e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r5 = r9.f35738h
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r10)
                goto L56
            L1d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L25:
                java.lang.Object r1 = r9.f35736f
                java.lang.Object r5 = r9.f35735e
                kotlinx.coroutines.channels.p r5 = (kotlinx.coroutines.channels.p) r5
                java.lang.Object r6 = r9.f35738h
                kotlinx.coroutines.channels.g0 r6 = (kotlinx.coroutines.channels.g0) r6
                kotlin.e1.n(r10)
                r7 = r6
                r6 = r5
                r5 = r1
                r1 = r0
                r0 = r9
                goto L8c
            L38:
                java.lang.Object r1 = r9.f35735e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r5 = r9.f35738h
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r10)
                r6 = r5
                r5 = r1
                r1 = r0
                r0 = r9
                goto L6a
            L48:
                kotlin.e1.n(r10)
                java.lang.Object r10 = r9.f35738h
                kotlinx.coroutines.channels.g0 r10 = (kotlinx.coroutines.channels.g0) r10
                kotlinx.coroutines.channels.i0<java.lang.Object> r1 = r9.f35739i
                kotlinx.coroutines.channels.p r1 = r1.iterator()
                r5 = r10
            L56:
                r10 = r9
            L57:
                r10.f35738h = r5
                r10.f35735e = r1
                r10.f35737g = r4
                java.lang.Object r6 = r1.a(r10)
                if (r6 != r0) goto L64
                return r0
            L64:
                r8 = r0
                r0 = r10
                r10 = r6
                r6 = r5
                r5 = r1
                r1 = r8
            L6a:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto Lac
                java.lang.Object r10 = r5.next()
                i5.p<java.lang.Object, kotlin.coroutines.d<? super java.lang.Boolean>, java.lang.Object> r7 = r0.f35740j
                r0.f35738h = r6
                r0.f35735e = r5
                r0.f35736f = r10
                r0.f35737g = r3
                java.lang.Object r7 = r7.a0(r10, r0)
                if (r7 != r1) goto L87
                return r1
            L87:
                r8 = r5
                r5 = r10
                r10 = r7
                r7 = r6
                r6 = r8
            L8c:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 != 0) goto L97
                kotlin.l2 r10 = kotlin.l2.f34958a
                return r10
            L97:
                r0.f35738h = r7
                r0.f35735e = r6
                r10 = 0
                r0.f35736f = r10
                r0.f35737g = r2
                java.lang.Object r10 = r7.R(r5, r0)
                if (r10 != r1) goto La7
                return r1
            La7:
                r10 = r0
                r0 = r1
                r1 = r6
                r5 = r7
                goto L57
            Lac:
                kotlin.l2 r10 = kotlin.l2.f34958a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.g0.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((g0) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.asm.j.f12604b0}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
    static final class h extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<Object>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f35744h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35745i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i5.p<Object, kotlin.coroutines.d<? super Boolean>, Object> f35746j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(kotlinx.coroutines.channels.i0<Object> i0Var, i5.p<Object, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.d<? super h> dVar) {
            super(2, dVar);
            this.f35745i = i0Var;
            this.f35746j = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            h hVar = new h(this.f35745i, this.f35746j, dVar);
            hVar.f35744h = obj;
            return hVar;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x008d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x008e  */
        /* JADX WARN: Code duplicated, block: B:23:0x009c  */
        /* JADX WARN: Code duplicated, block: B:25:0x00b0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:29:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:31:0x00cb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x00ce  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b1 -> B:27:0x00b5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0102 -> B:35:0x00d9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.h.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((h) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 278}, m = "toChannel", n = {ShareConstants.DESTINATION, "$this$consume$iv$iv", ShareConstants.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class h0<E, C extends kotlinx.coroutines.channels.m0<? super E>> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35751h;

        h0(kotlin.coroutines.d<? super h0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35750g = obj;
            this.f35751h |= Integer.MIN_VALUE;
            return kotlinx.coroutines.channels.s.e0(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {38}, m = "elementAt", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    static final class i<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35753e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35755g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f35756h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35757i;

        i(kotlin.coroutines.d<? super i> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35756h = obj;
            this.f35757i |= Integer.MIN_VALUE;
            return v.l(null, 0, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toCollection", n = {ShareConstants.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class i0<E, C extends Collection<? super E>> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35759e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35760f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35761g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35762h;

        i0(kotlin.coroutines.d<? super i0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35761g = obj;
            this.f35762h |= Integer.MIN_VALUE;
            return kotlinx.coroutines.channels.s.f0(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {ConstraintLayout.LayoutParams.a.f4571b0}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    static final class j<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35766g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f35767h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35768i;

        j(kotlin.coroutines.d<? super j> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35767h = obj;
            this.f35768i |= Integer.MIN_VALUE;
            return v.m(null, 0, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {ShareConstants.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class j0<K, V, M extends Map<? super K, ? super V>> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35770e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35771f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35772g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35773h;

        j0(kotlin.coroutines.d<? super j0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35772g = obj;
            this.f35773h |= Integer.MIN_VALUE;
            return kotlinx.coroutines.channels.s.h0(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {com.alibaba.fastjson.asm.j.f12610e0, com.alibaba.fastjson.asm.j.f12612f0, com.alibaba.fastjson.asm.j.f12612f0}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class k<E> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super E>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35775f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35776g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f35777h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<E> f35778i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i5.p<E, kotlin.coroutines.d<? super Boolean>, Object> f35779j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        k(kotlinx.coroutines.channels.i0<? extends E> i0Var, i5.p<? super E, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.d<? super k> dVar) {
            super(2, dVar);
            this.f35778i = i0Var;
            this.f35779j = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            k kVar = new k(this.f35778i, this.f35779j, dVar);
            kVar.f35777h = obj;
            return kVar;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0065 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x0066  */
        /* JADX WARN: Code duplicated, block: B:20:0x0074  */
        /* JADX WARN: Code duplicated, block: B:22:0x0088 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0089  */
        /* JADX WARN: Code duplicated, block: B:26:0x0095  */
        /* JADX WARN: Code duplicated, block: B:28:0x00a3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x00a4  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.m0] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r9v0 */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r10.f35776g
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L48
                if (r1 == r5) goto L38
                if (r1 == r4) goto L26
                if (r1 != r3) goto L1e
                java.lang.Object r1 = r10.f35774e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r6 = r10.f35777h
                kotlinx.coroutines.channels.g0 r6 = (kotlinx.coroutines.channels.g0) r6
                kotlin.e1.n(r11)
                goto L56
            L1e:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L26:
                java.lang.Object r1 = r10.f35775f
                java.lang.Object r6 = r10.f35774e
                kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
                java.lang.Object r7 = r10.f35777h
                kotlinx.coroutines.channels.g0 r7 = (kotlinx.coroutines.channels.g0) r7
                kotlin.e1.n(r11)
                r8 = r7
                r7 = r1
                r1 = r0
                r0 = r10
                goto L8d
            L38:
                java.lang.Object r1 = r10.f35774e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r6 = r10.f35777h
                kotlinx.coroutines.channels.g0 r6 = (kotlinx.coroutines.channels.g0) r6
                kotlin.e1.n(r11)
                r7 = r6
                r6 = r1
                r1 = r0
                r0 = r10
                goto L6c
            L48:
                kotlin.e1.n(r11)
                java.lang.Object r11 = r10.f35777h
                kotlinx.coroutines.channels.g0 r11 = (kotlinx.coroutines.channels.g0) r11
                kotlinx.coroutines.channels.i0<E> r1 = r10.f35778i
                kotlinx.coroutines.channels.p r1 = r1.iterator()
                r6 = r11
            L56:
                r11 = r10
            L57:
                r11.f35777h = r6
                r11.f35774e = r1
                r11.f35775f = r2
                r11.f35776g = r5
                java.lang.Object r7 = r1.a(r11)
                if (r7 != r0) goto L66
                return r0
            L66:
                r9 = r0
                r0 = r11
                r11 = r7
                r7 = r6
                r6 = r1
                r1 = r9
            L6c:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto La9
                java.lang.Object r11 = r6.next()
                i5.p<E, kotlin.coroutines.d<? super java.lang.Boolean>, java.lang.Object> r8 = r0.f35779j
                r0.f35777h = r7
                r0.f35774e = r6
                r0.f35775f = r11
                r0.f35776g = r4
                java.lang.Object r8 = r8.a0(r11, r0)
                if (r8 != r1) goto L89
                return r1
            L89:
                r9 = r7
                r7 = r11
                r11 = r8
                r8 = r9
            L8d:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto La4
                r0.f35777h = r8
                r0.f35774e = r6
                r0.f35775f = r2
                r0.f35776g = r3
                java.lang.Object r11 = r8.R(r7, r0)
                if (r11 != r1) goto La4
                return r1
            La4:
                r11 = r0
                r0 = r1
                r1 = r6
                r6 = r8
                goto L57
            La9:
                kotlin.l2 r11 = kotlin.l2.f34958a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.k.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super E> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((k) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class k0 extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super r0<Object>>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f35783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35784i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k0(kotlinx.coroutines.channels.i0<Object> i0Var, kotlin.coroutines.d<? super k0> dVar) {
            super(2, dVar);
            this.f35784i = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            k0 k0Var = new k0(this.f35784i, dVar);
            k0Var.f35783h = obj;
            return k0Var;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0055 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0056  */
        /* JADX WARN: Code duplicated, block: B:17:0x0065  */
        /* JADX WARN: Code duplicated, block: B:19:0x007e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x007f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007f -> B:11:0x0047). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r11.f35782g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L38
                if (r1 == r3) goto L29
                if (r1 != r2) goto L21
                int r1 = r11.f35781f
                java.lang.Object r4 = r11.f35780e
                kotlinx.coroutines.channels.p r4 = (kotlinx.coroutines.channels.p) r4
                java.lang.Object r5 = r11.f35783h
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r12)
                r12 = r5
                r5 = r11
                r9 = r4
                r4 = r1
                r1 = r9
                goto L47
            L21:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L29:
                int r1 = r11.f35781f
                java.lang.Object r4 = r11.f35780e
                kotlinx.coroutines.channels.p r4 = (kotlinx.coroutines.channels.p) r4
                java.lang.Object r5 = r11.f35783h
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r12)
                r6 = r11
                goto L5d
            L38:
                kotlin.e1.n(r12)
                java.lang.Object r12 = r11.f35783h
                kotlinx.coroutines.channels.g0 r12 = (kotlinx.coroutines.channels.g0) r12
                kotlinx.coroutines.channels.i0<java.lang.Object> r1 = r11.f35784i
                kotlinx.coroutines.channels.p r1 = r1.iterator()
                r4 = 0
                r5 = r11
            L47:
                r5.f35783h = r12
                r5.f35780e = r1
                r5.f35781f = r4
                r5.f35782g = r3
                java.lang.Object r6 = r1.a(r5)
                if (r6 != r0) goto L56
                return r0
            L56:
                r9 = r5
                r5 = r12
                r12 = r6
                r6 = r9
                r10 = r4
                r4 = r1
                r1 = r10
            L5d:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto L84
                java.lang.Object r12 = r4.next()
                kotlin.collections.r0 r7 = new kotlin.collections.r0
                int r8 = r1 + 1
                r7.<init>(r1, r12)
                r6.f35783h = r5
                r6.f35780e = r4
                r6.f35781f = r8
                r6.f35782g = r2
                java.lang.Object r12 = r5.R(r7, r6)
                if (r12 != r0) goto L7f
                return r0
            L7f:
                r1 = r4
                r12 = r5
                r5 = r6
                r4 = r8
                goto L47
            L84:
                kotlin.l2 r12 = kotlin.l2.f34958a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.k0.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super r0<Object>> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((k0) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
    static final class l extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<Object>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35786f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35787g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35788h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private /* synthetic */ Object f35789i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35790j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i5.q<Integer, Object, kotlin.coroutines.d<? super Boolean>, Object> f35791k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(kotlinx.coroutines.channels.i0<Object> i0Var, i5.q<? super Integer, Object, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> qVar, kotlin.coroutines.d<? super l> dVar) {
            super(2, dVar);
            this.f35790j = i0Var;
            this.f35791k = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            l lVar = new l(this.f35790j, this.f35791k, dVar);
            lVar.f35789i = obj;
            return lVar;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0076 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x0077  */
        /* JADX WARN: Code duplicated, block: B:20:0x0086  */
        /* JADX WARN: Code duplicated, block: B:22:0x00a2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:26:0x00af  */
        /* JADX WARN: Code duplicated, block: B:28:0x00bf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x00c0  */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r12.f35788h
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L53
                if (r1 == r5) goto L40
                if (r1 == r4) goto L29
                if (r1 != r3) goto L21
                int r1 = r12.f35787g
                java.lang.Object r6 = r12.f35785e
                kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
                java.lang.Object r7 = r12.f35789i
                kotlinx.coroutines.channels.g0 r7 = (kotlinx.coroutines.channels.g0) r7
                kotlin.e1.n(r13)
                r13 = r12
                goto L66
            L21:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L29:
                int r1 = r12.f35787g
                java.lang.Object r6 = r12.f35786f
                java.lang.Object r7 = r12.f35785e
                kotlinx.coroutines.channels.p r7 = (kotlinx.coroutines.channels.p) r7
                java.lang.Object r8 = r12.f35789i
                kotlinx.coroutines.channels.g0 r8 = (kotlinx.coroutines.channels.g0) r8
                kotlin.e1.n(r13)
                r10 = r1
                r1 = r0
                r0 = r12
                r11 = r7
                r7 = r6
            L3d:
                r6 = r11
                goto La7
            L40:
                int r1 = r12.f35787g
                java.lang.Object r6 = r12.f35785e
                kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
                java.lang.Object r7 = r12.f35789i
                kotlinx.coroutines.channels.g0 r7 = (kotlinx.coroutines.channels.g0) r7
                kotlin.e1.n(r13)
                r8 = r7
                r7 = r6
                r6 = r1
                r1 = r0
                r0 = r12
                goto L7e
            L53:
                kotlin.e1.n(r13)
                java.lang.Object r13 = r12.f35789i
                kotlinx.coroutines.channels.g0 r13 = (kotlinx.coroutines.channels.g0) r13
                kotlinx.coroutines.channels.i0<java.lang.Object> r1 = r12.f35790j
                kotlinx.coroutines.channels.p r1 = r1.iterator()
                r6 = 0
                r7 = r13
                r13 = r12
                r11 = r6
                r6 = r1
                r1 = r11
            L66:
                r13.f35789i = r7
                r13.f35785e = r6
                r13.f35786f = r2
                r13.f35787g = r1
                r13.f35788h = r5
                java.lang.Object r8 = r6.a(r13)
                if (r8 != r0) goto L77
                return r0
            L77:
                r11 = r0
                r0 = r13
                r13 = r8
                r8 = r7
                r7 = r6
                r6 = r1
                r1 = r11
            L7e:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Lc5
                java.lang.Object r13 = r7.next()
                i5.q<java.lang.Integer, java.lang.Object, kotlin.coroutines.d<? super java.lang.Boolean>, java.lang.Object> r9 = r0.f35791k
                int r10 = r6 + 1
                java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.f(r6)
                r0.f35789i = r8
                r0.f35785e = r7
                r0.f35786f = r13
                r0.f35787g = r10
                r0.f35788h = r4
                java.lang.Object r6 = r9.v(r6, r13, r0)
                if (r6 != r1) goto La3
                return r1
            La3:
                r11 = r7
                r7 = r13
                r13 = r6
                goto L3d
            La7:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Lc0
                r0.f35789i = r8
                r0.f35785e = r6
                r0.f35786f = r2
                r0.f35787g = r10
                r0.f35788h = r3
                java.lang.Object r13 = r8.R(r7, r0)
                if (r13 != r1) goto Lc0
                return r1
            Lc0:
                r13 = r0
                r0 = r1
                r7 = r8
                r1 = r10
                goto L66
            Lc5:
                kotlin.l2 r13 = kotlin.l2.f34958a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.l.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((l) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    static final class l0 extends kotlin.jvm.internal.n0 implements i5.p<Object, Object, u0<Object, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l0 f35792a = new l0();

        l0() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final u0<Object, Object> a0(Object obj, Object obj2) {
            return p1.a(obj, obj2);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {Constants.EASY_PAY_MAXIMIZE_ASSIST}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends kotlin.coroutines.jvm.internal.o implements i5.p<Object, kotlin.coroutines.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35793e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35794f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i5.p<Object, kotlin.coroutines.d<? super Boolean>, Object> f35795g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        m(i5.p<Object, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.d<? super m> dVar) {
            super(2, dVar);
            this.f35795g = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            m mVar = new m(this.f35795g, dVar);
            mVar.f35794f = obj;
            return mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35793e;
            if (i7 == 0) {
                e1.n(obj);
                Object obj2 = this.f35794f;
                i5.p<Object, kotlin.coroutines.d<? super Boolean>, Object> pVar = this.f35795g;
                this.f35793e = 1;
                obj = pVar.a0(obj2, this);
                if (obj == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return kotlin.coroutines.jvm.internal.b.a(!((Boolean) obj).booleanValue());
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(Object obj, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
            return ((m) D(obj, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
    static final class m0<V> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super V>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f35799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f35800i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f35801j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f35802k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<R> f35803l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<E> f35804m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ i5.p<E, R, V> f35805n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        m0(kotlinx.coroutines.channels.i0<? extends R> i0Var, kotlinx.coroutines.channels.i0<? extends E> i0Var2, i5.p<? super E, ? super R, ? extends V> pVar, kotlin.coroutines.d<? super m0> dVar) {
            super(2, dVar);
            this.f35803l = i0Var;
            this.f35804m = i0Var2;
            this.f35805n = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            m0 m0Var = new m0(this.f35803l, this.f35804m, this.f35805n, dVar);
            m0Var.f35802k = obj;
            return m0Var;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:28:0x00b9 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #2 {all -> 0x0056, blocks: (B:26:0x00b1, B:28:0x00b9, B:40:0x0109, B:13:0x004a), top: B:52:0x004a }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00d1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:34:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:35:0x00e9 A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #1 {all -> 0x0106, blocks: (B:32:0x00d9, B:35:0x00e9), top: B:50:0x00d9 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0105 A[RETURN] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 278
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.m0.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super V> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((m0) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n<E> extends kotlin.coroutines.jvm.internal.o implements i5.p<E, kotlin.coroutines.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35806e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35807f;

        n(kotlin.coroutines.d<? super n> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            n nVar = new n(dVar);
            nVar.f35807f = obj;
            return nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.coroutines.intrinsics.d.h();
            if (this.f35806e != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(obj);
            return kotlin.coroutines.jvm.internal.b.a(this.f35807f != null);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.e E e8, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
            return ((n) D(e8, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "filterNotNullTo", n = {ShareConstants.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class o<E, C extends Collection<? super E>> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35808d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35809e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35810f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35811g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35812h;

        o(kotlin.coroutines.d<? super o> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35811g = obj;
            this.f35812h |= Integer.MIN_VALUE;
            return v.u(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 242}, m = "filterNotNullTo", n = {ShareConstants.DESTINATION, "$this$consume$iv$iv", ShareConstants.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class p<E, C extends kotlinx.coroutines.channels.m0<? super E>> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35816g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35817h;

        p(kotlin.coroutines.d<? super p> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35816g = obj;
            this.f35817h |= Integer.MIN_VALUE;
            return v.v(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {65}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class q<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35818d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35819e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35821g;

        q(kotlin.coroutines.d<? super q> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35820f = obj;
            this.f35821g |= Integer.MIN_VALUE;
            return v.w(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {75}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class r<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35823e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35824f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35825g;

        r(kotlin.coroutines.d<? super r> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35824f = obj;
            this.f35825g |= Integer.MIN_VALUE;
            return v.x(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class s extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<Object>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f35828g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<Object> f35829h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i5.p<Object, kotlin.coroutines.d<? super kotlinx.coroutines.channels.i0<Object>>, Object> f35830i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        s(kotlinx.coroutines.channels.i0<Object> i0Var, i5.p<Object, ? super kotlin.coroutines.d<? super kotlinx.coroutines.channels.i0<Object>>, ? extends Object> pVar, kotlin.coroutines.d<? super s> dVar) {
            super(2, dVar);
            this.f35829h = i0Var;
            this.f35830i = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            s sVar = new s(this.f35829h, this.f35830i, dVar);
            sVar.f35828g = obj;
            return sVar;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0060 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x0061  */
        /* JADX WARN: Code duplicated, block: B:20:0x006f  */
        /* JADX WARN: Code duplicated, block: B:22:0x0081 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0090 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x0091  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0091 -> B:14:0x0054). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r9.f35827f
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L45
                if (r1 == r4) goto L35
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r9.f35826e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r5 = r9.f35828g
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r10)
                goto L53
            L1d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L25:
                java.lang.Object r1 = r9.f35826e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r5 = r9.f35828g
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r10)
                r6 = r5
                r5 = r1
                r1 = r0
                r0 = r9
                goto L82
            L35:
                java.lang.Object r1 = r9.f35826e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r5 = r9.f35828g
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                kotlin.e1.n(r10)
                r6 = r5
                r5 = r1
                r1 = r0
                r0 = r9
                goto L67
            L45:
                kotlin.e1.n(r10)
                java.lang.Object r10 = r9.f35828g
                kotlinx.coroutines.channels.g0 r10 = (kotlinx.coroutines.channels.g0) r10
                kotlinx.coroutines.channels.i0<java.lang.Object> r1 = r9.f35829h
                kotlinx.coroutines.channels.p r1 = r1.iterator()
                r5 = r10
            L53:
                r10 = r9
            L54:
                r10.f35828g = r5
                r10.f35826e = r1
                r10.f35827f = r4
                java.lang.Object r6 = r1.a(r10)
                if (r6 != r0) goto L61
                return r0
            L61:
                r8 = r0
                r0 = r10
                r10 = r6
                r6 = r5
                r5 = r1
                r1 = r8
            L67:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L96
                java.lang.Object r10 = r5.next()
                i5.p<java.lang.Object, kotlin.coroutines.d<? super kotlinx.coroutines.channels.i0<java.lang.Object>>, java.lang.Object> r7 = r0.f35830i
                r0.f35828g = r6
                r0.f35826e = r5
                r0.f35827f = r3
                java.lang.Object r10 = r7.a0(r10, r0)
                if (r10 != r1) goto L82
                return r1
            L82:
                kotlinx.coroutines.channels.i0 r10 = (kotlinx.coroutines.channels.i0) r10
                r0.f35828g = r6
                r0.f35826e = r5
                r0.f35827f = r2
                java.lang.Object r10 = kotlinx.coroutines.channels.s.e0(r10, r6, r0)
                if (r10 != r1) goto L91
                return r1
            L91:
                r10 = r0
                r0 = r1
                r1 = r5
                r5 = r6
                goto L54
            L96:
                kotlin.l2 r10 = kotlin.l2.f34958a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.s.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((s) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {487}, m = "indexOf", n = {"element", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class t<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35832e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35833f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35834g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f35835h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35836i;

        t(kotlin.coroutines.d<? super t> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35835h = obj;
            this.f35836i |= Integer.MIN_VALUE;
            return v.A(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {97, 100}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class u<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35840g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35841h;

        u(kotlin.coroutines.d<? super u> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35840g = obj;
            this.f35841h |= Integer.MIN_VALUE;
            return v.B(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.v$v, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C0450v<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35845g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f35846h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f35847i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f35848j;

        C0450v(kotlin.coroutines.d<? super C0450v> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35847i = obj;
            this.f35848j |= Integer.MIN_VALUE;
            return v.C(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {123, 126}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class w<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35852g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35853h;

        w(kotlin.coroutines.d<? super w> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35852g = obj;
            this.f35853h |= Integer.MIN_VALUE;
            return v.D(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    static final class x<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35854e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35855f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35856g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f35857h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35858i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private /* synthetic */ Object f35859j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<E> f35860k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ i5.p<E, kotlin.coroutines.d<? super R>, Object> f35861l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        x(kotlinx.coroutines.channels.i0<? extends E> i0Var, i5.p<? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlin.coroutines.d<? super x> dVar) {
            super(2, dVar);
            this.f35860k = i0Var;
            this.f35861l = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            x xVar = new x(this.f35860k, this.f35861l, dVar);
            xVar.f35859j = obj;
            return xVar;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0086 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0087  */
        /* JADX WARN: Code duplicated, block: B:28:0x0093 A[Catch: all -> 0x00cf, TRY_LEAVE, TryCatch #2 {all -> 0x00cf, blocks: (B:8:0x0022, B:22:0x0076, B:26:0x008b, B:28:0x0093, B:36:0x00c9, B:18:0x005e, B:21:0x006e), top: B:48:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:34:0x00c2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x00c3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c3 -> B:22:0x0076). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.x.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super R> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((x) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    static final class y<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35862e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35863f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35864g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35865h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private /* synthetic */ Object f35866i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i0<E> f35867j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i5.q<Integer, E, kotlin.coroutines.d<? super R>, Object> f35868k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        y(kotlinx.coroutines.channels.i0<? extends E> i0Var, i5.q<? super Integer, ? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, kotlin.coroutines.d<? super y> dVar) {
            super(2, dVar);
            this.f35867j = i0Var;
            this.f35868k = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            y yVar = new y(this.f35867j, this.f35868k, dVar);
            yVar.f35866i = obj;
            return yVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x006c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x006d  */
        /* JADX WARN: Code duplicated, block: B:19:0x0079  */
        /* JADX WARN: Code duplicated, block: B:21:0x0095 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x0096  */
        /* JADX WARN: Code duplicated, block: B:25:0x00ac A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00ad  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ad -> B:13:0x005e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r11.f35865h
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L4c
                if (r1 == r4) goto L3d
                if (r1 == r3) goto L29
                if (r1 != r2) goto L21
                int r1 = r11.f35864g
                java.lang.Object r5 = r11.f35862e
                kotlinx.coroutines.channels.p r5 = (kotlinx.coroutines.channels.p) r5
                java.lang.Object r6 = r11.f35866i
                kotlinx.coroutines.channels.g0 r6 = (kotlinx.coroutines.channels.g0) r6
                kotlin.e1.n(r12)
                r12 = r6
                r6 = r11
                goto L5e
            L21:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L29:
                int r1 = r11.f35864g
                java.lang.Object r5 = r11.f35863f
                kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                java.lang.Object r6 = r11.f35862e
                kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
                java.lang.Object r7 = r11.f35866i
                kotlinx.coroutines.channels.g0 r7 = (kotlinx.coroutines.channels.g0) r7
                kotlin.e1.n(r12)
                r8 = r11
                goto L9b
            L3d:
                int r1 = r11.f35864g
                java.lang.Object r5 = r11.f35862e
                kotlinx.coroutines.channels.p r5 = (kotlinx.coroutines.channels.p) r5
                java.lang.Object r6 = r11.f35866i
                kotlinx.coroutines.channels.g0 r6 = (kotlinx.coroutines.channels.g0) r6
                kotlin.e1.n(r12)
                r7 = r11
                goto L71
            L4c:
                kotlin.e1.n(r12)
                java.lang.Object r12 = r11.f35866i
                kotlinx.coroutines.channels.g0 r12 = (kotlinx.coroutines.channels.g0) r12
                kotlinx.coroutines.channels.i0<E> r1 = r11.f35867j
                kotlinx.coroutines.channels.p r1 = r1.iterator()
                r5 = 0
                r6 = r11
                r10 = r5
                r5 = r1
                r1 = r10
            L5e:
                r6.f35866i = r12
                r6.f35862e = r5
                r6.f35864g = r1
                r6.f35865h = r4
                java.lang.Object r7 = r5.a(r6)
                if (r7 != r0) goto L6d
                return r0
            L6d:
                r10 = r6
                r6 = r12
                r12 = r7
                r7 = r10
            L71:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto Lb1
                java.lang.Object r12 = r5.next()
                i5.q<java.lang.Integer, E, kotlin.coroutines.d<? super R>, java.lang.Object> r8 = r7.f35868k
                int r9 = r1 + 1
                java.lang.Integer r1 = kotlin.coroutines.jvm.internal.b.f(r1)
                r7.f35866i = r6
                r7.f35862e = r5
                r7.f35863f = r6
                r7.f35864g = r9
                r7.f35865h = r3
                java.lang.Object r12 = r8.v(r1, r12, r7)
                if (r12 != r0) goto L96
                return r0
            L96:
                r8 = r7
                r1 = r9
                r7 = r6
                r6 = r5
                r5 = r7
            L9b:
                r8.f35866i = r7
                r8.f35862e = r6
                r9 = 0
                r8.f35863f = r9
                r8.f35864g = r1
                r8.f35865h = r2
                java.lang.Object r12 = r5.R(r12, r8)
                if (r12 != r0) goto Lad
                return r0
            Lad:
                r5 = r6
                r12 = r7
                r6 = r8
                goto L5e
            Lb1:
                kotlin.l2 r12 = kotlin.l2.f34958a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.y.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super R> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((y) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {androidx.constraintlayout.core.motion.utils.w.c.f3060r, androidx.constraintlayout.core.motion.utils.w.c.f3062t}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class z<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f35873h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35874i;

        z(kotlin.coroutines.d<? super z> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35873h = obj;
            this.f35874i |= Integer.MIN_VALUE;
            return v.M(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x0070 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0067, B:27:0x0070, B:29:0x007a, B:32:0x0084, B:21:0x0053, B:33:0x008b), top: B:44:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007a A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0067, B:27:0x0070, B:29:0x007a, B:32:0x0084, B:21:0x0053, B:33:0x008b), top: B:44:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0084 A[Catch: all -> 0x0037, TRY_ENTER, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0067, B:27:0x0070, B:29:0x007a, B:32:0x0084, B:21:0x0053, B:33:0x008b), top: B:44:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008b A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0067, B:27:0x0070, B:29:0x007a, B:32:0x0084, B:21:0x0053, B:33:0x008b), top: B:44:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object A(kotlinx.coroutines.channels.i0 r7, java.lang.Object r8, kotlin.coroutines.d r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.v.t
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.channels.v$t r0 = (kotlinx.coroutines.channels.v.t) r0
            int r1 = r0.f35836i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35836i = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$t r0 = new kotlinx.coroutines.channels.v$t
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f35835h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35836i
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r7 = r0.f35834g
            kotlinx.coroutines.channels.p r7 = (kotlinx.coroutines.channels.p) r7
            java.lang.Object r8 = r0.f35833f
            kotlinx.coroutines.channels.i0 r8 = (kotlinx.coroutines.channels.i0) r8
            java.lang.Object r2 = r0.f35832e
            kotlin.jvm.internal.k1$f r2 = (kotlin.jvm.internal.k1.f) r2
            java.lang.Object r4 = r0.f35831d
            kotlin.e1.n(r9)     // Catch: java.lang.Throwable -> L37
            goto L67
        L37:
            r7 = move-exception
            goto L9a
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            kotlin.e1.n(r9)
            kotlin.jvm.internal.k1$f r9 = new kotlin.jvm.internal.k1$f
            r9.<init>()
            kotlinx.coroutines.channels.p r2 = r7.iterator()     // Catch: java.lang.Throwable -> L96
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r6
        L53:
            r0.f35831d = r9     // Catch: java.lang.Throwable -> L37
            r0.f35832e = r2     // Catch: java.lang.Throwable -> L37
            r0.f35833f = r8     // Catch: java.lang.Throwable -> L37
            r0.f35834g = r7     // Catch: java.lang.Throwable -> L37
            r0.f35836i = r3     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = r7.a(r0)     // Catch: java.lang.Throwable -> L37
            if (r4 != r1) goto L64
            return r1
        L64:
            r6 = r4
            r4 = r9
            r9 = r6
        L67:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L37
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L37
            r5 = 0
            if (r9 == 0) goto L8b
            java.lang.Object r9 = r7.next()     // Catch: java.lang.Throwable -> L37
            boolean r9 = kotlin.jvm.internal.l0.g(r4, r9)     // Catch: java.lang.Throwable -> L37
            if (r9 == 0) goto L84
            int r7 = r2.f34870a     // Catch: java.lang.Throwable -> L37
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.f(r7)     // Catch: java.lang.Throwable -> L37
            kotlinx.coroutines.channels.s.b(r8, r5)
            return r7
        L84:
            int r9 = r2.f34870a     // Catch: java.lang.Throwable -> L37
            int r9 = r9 + r3
            r2.f34870a = r9     // Catch: java.lang.Throwable -> L37
            r9 = r4
            goto L53
        L8b:
            kotlin.l2 r7 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L37
            kotlinx.coroutines.channels.s.b(r8, r5)
            r7 = -1
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.f(r7)
            return r7
        L96:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L9a:
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r9 = move-exception
            kotlinx.coroutines.channels.s.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.A(kotlinx.coroutines.channels.i0, java.lang.Object, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x0092 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0032, B:37:0x008a, B:39:0x0092), top: B:53:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0086 -> B:37:0x008a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object B(kotlinx.coroutines.channels.i0 r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.v.u
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.v$u r0 = (kotlinx.coroutines.channels.v.u) r0
            int r1 = r0.f35841h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35841h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$u r0 = new kotlinx.coroutines.channels.v$u
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35840g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35841h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r6 = r0.f35839f
            java.lang.Object r2 = r0.f35838e
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            java.lang.Object r4 = r0.f35837d
            kotlinx.coroutines.channels.i0 r4 = (kotlinx.coroutines.channels.i0) r4
            kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> L36
            goto L8a
        L36:
            r6 = move-exception
            r2 = r4
            goto La8
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            java.lang.Object r6 = r0.f35838e
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r2 = r0.f35837d
            kotlinx.coroutines.channels.i0 r2 = (kotlinx.coroutines.channels.i0) r2
            kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> L4e
            goto L68
        L4e:
            r6 = move-exception
            goto La8
        L50:
            kotlin.e1.n(r7)
            kotlinx.coroutines.channels.p r7 = r6.iterator()     // Catch: java.lang.Throwable -> La5
            r0.f35837d = r6     // Catch: java.lang.Throwable -> La5
            r0.f35838e = r7     // Catch: java.lang.Throwable -> La5
            r0.f35841h = r4     // Catch: java.lang.Throwable -> La5
            java.lang.Object r2 = r7.a(r0)     // Catch: java.lang.Throwable -> La5
            if (r2 != r1) goto L64
            return r1
        L64:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L68:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L4e
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L4e
            if (r7 == 0) goto L9d
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4e
            r5 = r2
            r2 = r6
            r6 = r5
        L77:
            r0.f35837d = r6     // Catch: java.lang.Throwable -> La5
            r0.f35838e = r2     // Catch: java.lang.Throwable -> La5
            r0.f35839f = r7     // Catch: java.lang.Throwable -> La5
            r0.f35841h = r3     // Catch: java.lang.Throwable -> La5
            java.lang.Object r4 = r2.a(r0)     // Catch: java.lang.Throwable -> La5
            if (r4 != r1) goto L86
            return r1
        L86:
            r5 = r4
            r4 = r6
            r6 = r7
            r7 = r5
        L8a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L36
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r7 == 0) goto L98
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L36
            r6 = r4
            goto L77
        L98:
            r7 = 0
            kotlinx.coroutines.channels.s.b(r4, r7)
            return r6
        L9d:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L4e
            throw r6     // Catch: java.lang.Throwable -> L4e
        La5:
            r7 = move-exception
            r2 = r6
            r6 = r7
        La8:
            throw r6     // Catch: java.lang.Throwable -> La9
        La9:
            r7 = move-exception
            kotlinx.coroutines.channels.s.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.B(kotlinx.coroutines.channels.i0, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0072  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:12:0x0037, B:25:0x0075, B:27:0x007d, B:29:0x0087, B:30:0x008b, B:21:0x005f, B:31:0x0092), top: B:42:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0087 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:12:0x0037, B:25:0x0075, B:27:0x007d, B:29:0x0087, B:30:0x008b, B:21:0x005f, B:31:0x0092), top: B:42:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0092 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:12:0x0037, B:25:0x0075, B:27:0x007d, B:29:0x0087, B:30:0x008b, B:21:0x005f, B:31:0x0092), top: B:42:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0072 -> B:25:0x0075). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object C(kotlinx.coroutines.channels.i0 r7, java.lang.Object r8, kotlin.coroutines.d r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.v.C0450v
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.channels.v$v r0 = (kotlinx.coroutines.channels.v.C0450v) r0
            int r1 = r0.f35848j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35848j = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$v r0 = new kotlinx.coroutines.channels.v$v
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f35847i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35848j
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r7 = r0.f35846h
            kotlinx.coroutines.channels.p r7 = (kotlinx.coroutines.channels.p) r7
            java.lang.Object r8 = r0.f35845g
            kotlinx.coroutines.channels.i0 r8 = (kotlinx.coroutines.channels.i0) r8
            java.lang.Object r2 = r0.f35844f
            kotlin.jvm.internal.k1$f r2 = (kotlin.jvm.internal.k1.f) r2
            java.lang.Object r4 = r0.f35843e
            kotlin.jvm.internal.k1$f r4 = (kotlin.jvm.internal.k1.f) r4
            java.lang.Object r5 = r0.f35842d
            kotlin.e1.n(r9)     // Catch: java.lang.Throwable -> L3b
            goto L75
        L3b:
            r7 = move-exception
            goto La3
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            kotlin.e1.n(r9)
            kotlin.jvm.internal.k1$f r9 = new kotlin.jvm.internal.k1$f
            r9.<init>()
            r2 = -1
            r9.f34870a = r2
            kotlin.jvm.internal.k1$f r2 = new kotlin.jvm.internal.k1$f
            r2.<init>()
            kotlinx.coroutines.channels.p r4 = r7.iterator()     // Catch: java.lang.Throwable -> L9f
            r6 = r8
            r8 = r7
            r7 = r4
            r4 = r9
            r9 = r6
        L5f:
            r0.f35842d = r9     // Catch: java.lang.Throwable -> L3b
            r0.f35843e = r4     // Catch: java.lang.Throwable -> L3b
            r0.f35844f = r2     // Catch: java.lang.Throwable -> L3b
            r0.f35845g = r8     // Catch: java.lang.Throwable -> L3b
            r0.f35846h = r7     // Catch: java.lang.Throwable -> L3b
            r0.f35848j = r3     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r5 = r7.a(r0)     // Catch: java.lang.Throwable -> L3b
            if (r5 != r1) goto L72
            return r1
        L72:
            r6 = r5
            r5 = r9
            r9 = r6
        L75:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L92
            java.lang.Object r9 = r7.next()     // Catch: java.lang.Throwable -> L3b
            boolean r9 = kotlin.jvm.internal.l0.g(r5, r9)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L8b
            int r9 = r2.f34870a     // Catch: java.lang.Throwable -> L3b
            r4.f34870a = r9     // Catch: java.lang.Throwable -> L3b
        L8b:
            int r9 = r2.f34870a     // Catch: java.lang.Throwable -> L3b
            int r9 = r9 + r3
            r2.f34870a = r9     // Catch: java.lang.Throwable -> L3b
            r9 = r5
            goto L5f
        L92:
            kotlin.l2 r7 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L3b
            r7 = 0
            kotlinx.coroutines.channels.s.b(r8, r7)
            int r7 = r4.f34870a
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.f(r7)
            return r7
        L9f:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La3:
            throw r7     // Catch: java.lang.Throwable -> La4
        La4:
            r9 = move-exception
            kotlinx.coroutines.channels.s.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.C(kotlinx.coroutines.channels.i0, java.lang.Object, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x008b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0097 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #2 {all -> 0x0037, blocks: (B:13:0x0033, B:39:0x008f, B:41:0x0097), top: B:55:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008b -> B:39:0x008f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object D(kotlinx.coroutines.channels.i0 r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.v.w
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.v$w r0 = (kotlinx.coroutines.channels.v.w) r0
            int r1 = r0.f35853h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35853h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$w r0 = new kotlinx.coroutines.channels.v$w
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35852g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35853h
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L51
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r7 = r0.f35851f
            java.lang.Object r2 = r0.f35850e
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            java.lang.Object r4 = r0.f35849d
            kotlinx.coroutines.channels.i0 r4 = (kotlinx.coroutines.channels.i0) r4
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L37
            goto L8f
        L37:
            r7 = move-exception
            r2 = r4
            goto La4
        L3b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L43:
            java.lang.Object r7 = r0.f35850e
            kotlinx.coroutines.channels.p r7 = (kotlinx.coroutines.channels.p) r7
            java.lang.Object r2 = r0.f35849d
            kotlinx.coroutines.channels.i0 r2 = (kotlinx.coroutines.channels.i0) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L4f
            goto L69
        L4f:
            r7 = move-exception
            goto La4
        L51:
            kotlin.e1.n(r8)
            kotlinx.coroutines.channels.p r8 = r7.iterator()     // Catch: java.lang.Throwable -> La1
            r0.f35849d = r7     // Catch: java.lang.Throwable -> La1
            r0.f35850e = r8     // Catch: java.lang.Throwable -> La1
            r0.f35853h = r4     // Catch: java.lang.Throwable -> La1
            java.lang.Object r2 = r8.a(r0)     // Catch: java.lang.Throwable -> La1
            if (r2 != r1) goto L65
            return r1
        L65:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L69:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L4f
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L4f
            if (r8 != 0) goto L75
            kotlinx.coroutines.channels.s.b(r2, r5)
            return r5
        L75:
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L4f
            r6 = r2
            r2 = r7
            r7 = r6
        L7c:
            r0.f35849d = r7     // Catch: java.lang.Throwable -> La1
            r0.f35850e = r2     // Catch: java.lang.Throwable -> La1
            r0.f35851f = r8     // Catch: java.lang.Throwable -> La1
            r0.f35853h = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r4 = r2.a(r0)     // Catch: java.lang.Throwable -> La1
            if (r4 != r1) goto L8b
            return r1
        L8b:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L8f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L37
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L37
            if (r8 == 0) goto L9d
            java.lang.Object r8 = r2.next()     // Catch: java.lang.Throwable -> L37
            r7 = r4
            goto L7c
        L9d:
            kotlinx.coroutines.channels.s.b(r4, r5)
            return r7
        La1:
            r8 = move-exception
            r2 = r7
            r7 = r8
        La4:
            throw r7     // Catch: java.lang.Throwable -> La5
        La5:
            r8 = move-exception
            kotlinx.coroutines.channels.s.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.D(kotlinx.coroutines.channels.i0, kotlin.coroutines.d):java.lang.Object");
    }

    @a7.d
    @a1
    public static final <E, R> kotlinx.coroutines.channels.i0<R> E(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new x(i0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 F(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return kotlinx.coroutines.channels.s.J(i0Var, gVar, pVar);
    }

    @a7.d
    @a1
    public static final <E, R> kotlinx.coroutines.channels.i0<R> G(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.q<? super Integer, ? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new y(i0Var, qVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 H(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.q qVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return kotlinx.coroutines.channels.s.L(i0Var, gVar, qVar);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 I(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.q qVar) {
        return kotlinx.coroutines.channels.s.y(kotlinx.coroutines.channels.s.L(i0Var, gVar, qVar));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 J(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.q qVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return I(i0Var, gVar, qVar);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 K(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar) {
        return kotlinx.coroutines.channels.s.y(kotlinx.coroutines.channels.s.J(i0Var, gVar, pVar));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 L(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return K(i0Var, gVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #3 {all -> 0x00bf, blocks: (B:40:0x00a4, B:42:0x00ac, B:36:0x008f, B:26:0x0063), top: B:61:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:15:0x003d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object M(kotlinx.coroutines.channels.i0 r8, java.util.Comparator r9, kotlin.coroutines.d r10) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.M(kotlinx.coroutines.channels.i0, java.util.Comparator, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #3 {all -> 0x00bf, blocks: (B:40:0x00a4, B:42:0x00ac, B:36:0x008f, B:26:0x0063), top: B:61:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:15:0x003d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object N(kotlinx.coroutines.channels.i0 r8, java.util.Comparator r9, kotlin.coroutines.d r10) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.N(kotlinx.coroutines.channels.i0, java.util.Comparator, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object O(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.d dVar) {
        b0 b0Var;
        if (dVar instanceof b0) {
            b0Var = (b0) dVar;
            int i7 = b0Var.f35696f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                b0Var.f35696f = i7 - Integer.MIN_VALUE;
            } else {
                b0Var = new b0(dVar);
            }
        } else {
            b0Var = new b0(dVar);
        }
        Object objA = b0Var.f35695e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = b0Var.f35696f;
        boolean z7 = true;
        try {
            if (i8 == 0) {
                e1.n(objA);
                kotlinx.coroutines.channels.p it = i0Var.iterator();
                b0Var.f35694d = i0Var;
                b0Var.f35696f = 1;
                objA = it.a(b0Var);
                if (objA == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i0Var = (kotlinx.coroutines.channels.i0) b0Var.f35694d;
                e1.n(objA);
            }
            if (((Boolean) objA).booleanValue()) {
                z7 = false;
            }
            Boolean boolA = kotlin.coroutines.jvm.internal.b.a(z7);
            kotlinx.coroutines.channels.s.b(i0Var, null);
            return boolA;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlinx.coroutines.channels.s.b(i0Var, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006c A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:20:0x0046, B:29:0x0064, B:31:0x006c, B:41:0x0096, B:42:0x009d), top: B:53:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0096 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #2 {all -> 0x004a, blocks: (B:20:0x0046, B:29:0x0064, B:31:0x006c, B:41:0x0096, B:42:0x009d), top: B:53:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object Q(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.d dVar) {
        d0 d0Var;
        kotlinx.coroutines.channels.i0 i0Var2;
        Throwable th;
        kotlinx.coroutines.channels.p pVar;
        Object next;
        Object objA;
        kotlinx.coroutines.channels.i0 i0Var3;
        Object obj;
        if (dVar instanceof d0) {
            d0Var = (d0) dVar;
            int i7 = d0Var.f35709g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                d0Var.f35709g = i7 - Integer.MIN_VALUE;
            } else {
                d0Var = new d0(dVar);
            }
        } else {
            d0Var = new d0(dVar);
        }
        Object obj2 = d0Var.f35708f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = d0Var.f35709g;
        if (i8 == 0) {
            e1.n(obj2);
            try {
                kotlinx.coroutines.channels.p it = i0Var.iterator();
                d0Var.f35706d = i0Var;
                d0Var.f35707e = it;
                d0Var.f35709g = 1;
                Object objA2 = it.a(d0Var);
                if (objA2 == objH) {
                    return objH;
                }
                i0Var2 = i0Var;
                pVar = it;
                obj2 = objA2;
                if (((Boolean) obj2).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                next = pVar.next();
                d0Var.f35706d = i0Var2;
                d0Var.f35707e = next;
                d0Var.f35709g = 2;
                objA = pVar.a(d0Var);
                if (objA == objH) {
                    return objH;
                }
                i0Var3 = i0Var2;
                obj2 = objA;
                obj = next;
            } catch (Throwable th2) {
                i0Var2 = i0Var;
                th = th2;
                throw th;
            }
        } else if (i8 == 1) {
            pVar = (kotlinx.coroutines.channels.p) d0Var.f35707e;
            i0Var2 = (kotlinx.coroutines.channels.i0) d0Var.f35706d;
            try {
                e1.n(obj2);
                if (((Boolean) obj2).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                next = pVar.next();
                d0Var.f35706d = i0Var2;
                d0Var.f35707e = next;
                d0Var.f35709g = 2;
                objA = pVar.a(d0Var);
                if (objA == objH) {
                    return objH;
                }
                i0Var3 = i0Var2;
                obj2 = objA;
                obj = next;
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } else {
            if (i8 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = d0Var.f35707e;
            i0Var3 = (kotlinx.coroutines.channels.i0) d0Var.f35706d;
            try {
                e1.n(obj2);
            } catch (Throwable th4) {
                th = th4;
                i0Var2 = i0Var3;
                try {
                    throw th;
                } catch (Throwable th5) {
                    kotlinx.coroutines.channels.s.b(i0Var2, th);
                    throw th5;
                }
            }
        }
        if (((Boolean) obj2).booleanValue()) {
            throw new IllegalArgumentException("ReceiveChannel has more than one element.");
        }
        kotlinx.coroutines.channels.s.b(i0Var3, null);
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object R(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.d dVar) {
        e0 e0Var;
        kotlinx.coroutines.channels.i0 i0Var2;
        Throwable th;
        kotlinx.coroutines.channels.p pVar;
        kotlinx.coroutines.channels.i0 i0Var3;
        Object obj;
        if (dVar instanceof e0) {
            e0Var = (e0) dVar;
            int i7 = e0Var.f35715g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                e0Var.f35715g = i7 - Integer.MIN_VALUE;
            } else {
                e0Var = new e0(dVar);
            }
        } else {
            e0Var = new e0(dVar);
        }
        Object obj2 = e0Var.f35714f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = e0Var.f35715g;
        if (i8 == 0) {
            e1.n(obj2);
            try {
                kotlinx.coroutines.channels.p it = i0Var.iterator();
                e0Var.f35712d = i0Var;
                e0Var.f35713e = it;
                e0Var.f35715g = 1;
                Object objA = it.a(e0Var);
                if (objA == objH) {
                    return objH;
                }
                i0Var2 = i0Var;
                pVar = it;
                obj2 = objA;
            } catch (Throwable th2) {
                i0Var2 = i0Var;
                th = th2;
                throw th;
            }
        } else {
            if (i8 != 1) {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = e0Var.f35713e;
                i0Var3 = (kotlinx.coroutines.channels.i0) e0Var.f35712d;
                try {
                    e1.n(obj2);
                    if (((Boolean) obj2).booleanValue()) {
                        kotlinx.coroutines.channels.s.b(i0Var3, null);
                        return null;
                    }
                    kotlinx.coroutines.channels.s.b(i0Var3, null);
                    return obj;
                } catch (Throwable th3) {
                    th = th3;
                    i0Var2 = i0Var3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        kotlinx.coroutines.channels.s.b(i0Var2, th);
                        throw th4;
                    }
                }
            }
            pVar = (kotlinx.coroutines.channels.p) e0Var.f35713e;
            i0Var2 = (kotlinx.coroutines.channels.i0) e0Var.f35712d;
            try {
                e1.n(obj2);
            } catch (Throwable th5) {
                th = th5;
                throw th;
            }
        }
        if (!((Boolean) obj2).booleanValue()) {
            kotlinx.coroutines.channels.s.b(i0Var2, null);
            return null;
        }
        Object next = pVar.next();
        e0Var.f35712d = i0Var2;
        e0Var.f35713e = next;
        e0Var.f35715g = 2;
        Object objA2 = pVar.a(e0Var);
        if (objA2 == objH) {
            return objH;
        }
        i0Var3 = i0Var2;
        obj2 = objA2;
        obj = next;
        if (((Boolean) obj2).booleanValue()) {
            kotlinx.coroutines.channels.s.b(i0Var3, null);
            return null;
        }
        kotlinx.coroutines.channels.s.b(i0Var3, null);
        return obj;
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 S(kotlinx.coroutines.channels.i0 i0Var, int i7, kotlin.coroutines.g gVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new f0(i7, i0Var, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 T(kotlinx.coroutines.channels.i0 i0Var, int i7, kotlin.coroutines.g gVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            gVar = n1.g();
        }
        return S(i0Var, i7, gVar);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 U(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new g0(i0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 V(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return U(i0Var, gVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0078 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:13:0x0034, B:28:0x0070, B:30:0x0078, B:33:0x008b, B:18:0x004f), top: B:44:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.m0] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends kotlinx.coroutines.channels.m0<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.i0] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.i0] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0088 -> B:14:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @a7.e
    @kotlin.a1
    public static final <E, C extends kotlinx.coroutines.channels.m0<? super E>> java.lang.Object W(@a7.d kotlinx.coroutines.channels.i0<? extends E> r6, @a7.d C r7, @a7.d kotlin.coroutines.d<? super C> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.v.h0
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.v$h0 r0 = (kotlinx.coroutines.channels.v.h0) r0
            int r1 = r0.f35751h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35751h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$h0 r0 = new kotlinx.coroutines.channels.v$h0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35750g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35751h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L55
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.f35749f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r7 = r0.f35748e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r2 = r0.f35747d
            kotlinx.coroutines.channels.m0 r2 = (kotlinx.coroutines.channels.m0) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L53
        L37:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L5c
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            java.lang.Object r6 = r0.f35749f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r7 = r0.f35748e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r2 = r0.f35747d
            kotlinx.coroutines.channels.m0 r2 = (kotlinx.coroutines.channels.m0) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L53
            goto L70
        L53:
            r6 = move-exception
            goto L96
        L55:
            kotlin.e1.n(r8)
            kotlinx.coroutines.channels.p r8 = r6.iterator()     // Catch: java.lang.Throwable -> L92
        L5c:
            r0.f35747d = r7     // Catch: java.lang.Throwable -> L92
            r0.f35748e = r6     // Catch: java.lang.Throwable -> L92
            r0.f35749f = r8     // Catch: java.lang.Throwable -> L92
            r0.f35751h = r4     // Catch: java.lang.Throwable -> L92
            java.lang.Object r2 = r8.a(r0)     // Catch: java.lang.Throwable -> L92
            if (r2 != r1) goto L6b
            return r1
        L6b:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L70:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L53
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L53
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L53
            r0.f35747d = r2     // Catch: java.lang.Throwable -> L53
            r0.f35748e = r7     // Catch: java.lang.Throwable -> L53
            r0.f35749f = r6     // Catch: java.lang.Throwable -> L53
            r0.f35751h = r3     // Catch: java.lang.Throwable -> L53
            java.lang.Object r8 = r2.R(r8, r0)     // Catch: java.lang.Throwable -> L53
            if (r8 != r1) goto L37
            return r1
        L8b:
            kotlin.l2 r6 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L53
            r6 = 0
            kotlinx.coroutines.channels.s.b(r7, r6)
            return r2
        L92:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L96:
            throw r6     // Catch: java.lang.Throwable -> L97
        L97:
            r8 = move-exception
            kotlinx.coroutines.channels.s.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.W(kotlinx.coroutines.channels.i0, kotlinx.coroutines.channels.m0, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0064, B:21:0x004a, B:28:0x006d), top: B:39:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @a7.e
    @kotlin.a1
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object X(@a7.d kotlinx.coroutines.channels.i0<? extends E> r5, @a7.d C r6, @a7.d kotlin.coroutines.d<? super C> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.v.i0
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.v$i0 r0 = (kotlinx.coroutines.channels.v.i0) r0
            int r1 = r0.f35762h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35762h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$i0 r0 = new kotlinx.coroutines.channels.v$i0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35761g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35762h
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f35760f
            kotlinx.coroutines.channels.p r5 = (kotlinx.coroutines.channels.p) r5
            java.lang.Object r6 = r0.f35759e
            kotlinx.coroutines.channels.i0 r6 = (kotlinx.coroutines.channels.i0) r6
            java.lang.Object r2 = r0.f35758d
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r5 = move-exception
            goto L78
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.e1.n(r7)
            kotlinx.coroutines.channels.p r7 = r5.iterator()     // Catch: java.lang.Throwable -> L74
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L4a:
            r0.f35758d = r7     // Catch: java.lang.Throwable -> L35
            r0.f35759e = r6     // Catch: java.lang.Throwable -> L35
            r0.f35760f = r5     // Catch: java.lang.Throwable -> L35
            r0.f35762h = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r5.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L35
            r2.add(r7)     // Catch: java.lang.Throwable -> L35
            r7 = r2
            goto L4a
        L6d:
            kotlin.l2 r5 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L35
            r5 = 0
            kotlinx.coroutines.channels.s.b(r6, r5)
            return r2
        L74:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L78:
            throw r5     // Catch: java.lang.Throwable -> L79
        L79:
            r7 = move-exception
            kotlinx.coroutines.channels.s.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.X(kotlinx.coroutines.channels.i0, java.util.Collection, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0064, B:21:0x004a, B:28:0x0077), top: B:39:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @a7.e
    @kotlin.a1
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object Y(@a7.d kotlinx.coroutines.channels.i0<? extends kotlin.u0<? extends K, ? extends V>> r6, @a7.d M r7, @a7.d kotlin.coroutines.d<? super M> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.v.j0
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.v$j0 r0 = (kotlinx.coroutines.channels.v.j0) r0
            int r1 = r0.f35773h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35773h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$j0 r0 = new kotlinx.coroutines.channels.v$j0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35772g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35773h
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f35771f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r7 = r0.f35770e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r2 = r0.f35769d
            java.util.Map r2 = (java.util.Map) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r6 = move-exception
            goto L82
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.e1.n(r8)
            kotlinx.coroutines.channels.p r8 = r6.iterator()     // Catch: java.lang.Throwable -> L7e
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L4a:
            r0.f35769d = r8     // Catch: java.lang.Throwable -> L35
            r0.f35770e = r7     // Catch: java.lang.Throwable -> L35
            r0.f35771f = r6     // Catch: java.lang.Throwable -> L35
            r0.f35773h = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r6.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r5 = r2
            r2 = r8
            r8 = r5
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L77
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L35
            kotlin.u0 r8 = (kotlin.u0) r8     // Catch: java.lang.Throwable -> L35
            java.lang.Object r4 = r8.e()     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r8.f()     // Catch: java.lang.Throwable -> L35
            r2.put(r4, r8)     // Catch: java.lang.Throwable -> L35
            r8 = r2
            goto L4a
        L77:
            kotlin.l2 r6 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L35
            r6 = 0
            kotlinx.coroutines.channels.s.b(r7, r6)
            return r2
        L7e:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L82:
            throw r6     // Catch: java.lang.Throwable -> L83
        L83:
            r8 = move-exception
            kotlinx.coroutines.channels.s.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.Y(kotlinx.coroutines.channels.i0, java.util.Map, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.d dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f35686f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f35686f = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objA = aVar.f35685e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f35686f;
        try {
            if (i8 == 0) {
                e1.n(objA);
                kotlinx.coroutines.channels.p it = i0Var.iterator();
                aVar.f35684d = i0Var;
                aVar.f35686f = 1;
                objA = it.a(aVar);
                if (objA == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i0Var = (kotlinx.coroutines.channels.i0) aVar.f35684d;
                e1.n(objA);
            }
            kotlinx.coroutines.channels.s.b(i0Var, null);
            return objA;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlinx.coroutines.channels.s.b(i0Var, th);
                throw th2;
            }
        }
    }

    @a7.d
    @a1
    public static final i5.l<Throwable, l2> b(@a7.d kotlinx.coroutines.channels.i0<?> i0Var) {
        return new b(i0Var);
    }

    @a7.e
    @a1
    public static final <E> Object b0(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var, @a7.d kotlin.coroutines.d<? super Set<E>> dVar) {
        return kotlinx.coroutines.channels.s.f0(i0Var, new LinkedHashSet(), dVar);
    }

    @a7.d
    @a1
    public static final i5.l<Throwable, l2> c(@a7.d kotlinx.coroutines.channels.i0<?>... i0VarArr) {
        return new c(i0VarArr);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0068 A[Catch: all -> 0x0035, TryCatch #1 {, blocks: (B:12:0x0031, B:25:0x0060, B:27:0x0068, B:28:0x0072), top: B:41:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0060). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object d(kotlinx.coroutines.channels.i0 r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.v.d
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.v$d r0 = (kotlinx.coroutines.channels.v.d) r0
            int r1 = r0.f35705h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35705h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$d r0 = new kotlinx.coroutines.channels.v$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35704g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35705h
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f35703f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r2 = r0.f35702e
            kotlinx.coroutines.channels.i0 r2 = (kotlinx.coroutines.channels.i0) r2
            java.lang.Object r4 = r0.f35701d
            kotlin.jvm.internal.k1$f r4 = (kotlin.jvm.internal.k1.f) r4
            kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L60
        L35:
            r6 = move-exception
            goto L85
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.e1.n(r7)
            kotlin.jvm.internal.k1$f r7 = new kotlin.jvm.internal.k1$f
            r7.<init>()
            kotlinx.coroutines.channels.p r2 = r6.iterator()     // Catch: java.lang.Throwable -> L82
            r4 = r7
            r7 = r6
            r6 = r2
        L4e:
            r0.f35701d = r4     // Catch: java.lang.Throwable -> L7f
            r0.f35702e = r7     // Catch: java.lang.Throwable -> L7f
            r0.f35703f = r6     // Catch: java.lang.Throwable -> L7f
            r0.f35705h = r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r2 = r6.a(r0)     // Catch: java.lang.Throwable -> L7f
            if (r2 != r1) goto L5d
            return r1
        L5d:
            r5 = r2
            r2 = r7
            r7 = r5
        L60:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L72
            r6.next()     // Catch: java.lang.Throwable -> L35
            int r7 = r4.f34870a     // Catch: java.lang.Throwable -> L35
            int r7 = r7 + r3
            r4.f34870a = r7     // Catch: java.lang.Throwable -> L35
            r7 = r2
            goto L4e
        L72:
            kotlin.l2 r6 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L35
            r6 = 0
            kotlinx.coroutines.channels.s.b(r2, r6)
            int r6 = r4.f34870a
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.f(r6)
            return r6
        L7f:
            r6 = move-exception
            r2 = r7
            goto L85
        L82:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L85:
            throw r6     // Catch: java.lang.Throwable -> L86
        L86:
            r7 = move-exception
            kotlinx.coroutines.channels.s.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.d(kotlinx.coroutines.channels.i0, kotlin.coroutines.d):java.lang.Object");
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 d0(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new k0(i0Var, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 e0(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return d0(i0Var, gVar);
    }

    @a7.d
    @a1
    public static final <E, K> kotlinx.coroutines.channels.i0<E> f(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super K>, ? extends Object> pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new f(i0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 g(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return kotlinx.coroutines.channels.s.k(i0Var, gVar, pVar);
    }

    @a7.d
    @a1
    public static final <E, R, V> kotlinx.coroutines.channels.i0<V> g0(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var, @a7.d kotlinx.coroutines.channels.i0<? extends R> i0Var2, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super R, ? extends V> pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.h(i0Var, i0Var2), new m0(i0Var2, i0Var, pVar, null), 6, null);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 h(kotlinx.coroutines.channels.i0 i0Var, int i7, kotlin.coroutines.g gVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new g(i7, i0Var, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 h0(kotlinx.coroutines.channels.i0 i0Var, kotlinx.coroutines.channels.i0 i0Var2, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            gVar = n1.g();
        }
        return kotlinx.coroutines.channels.s.q0(i0Var, i0Var2, gVar, pVar);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 i(kotlinx.coroutines.channels.i0 i0Var, int i7, kotlin.coroutines.g gVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            gVar = n1.g();
        }
        return h(i0Var, i7, gVar);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 j(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new h(i0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 k(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return j(i0Var, gVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:27:0x006c A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0064, B:27:0x006c, B:33:0x007d, B:34:0x0094), top: B:46:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:32:0x0079  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005f -> B:25:0x0064). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object l(kotlinx.coroutines.channels.i0 r9, int r10, kotlin.coroutines.d r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.v.i
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.channels.v$i r0 = (kotlinx.coroutines.channels.v.i) r0
            int r1 = r0.f35757i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35757i = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$i r0 = new kotlinx.coroutines.channels.v$i
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f35756h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35757i
            r3 = 46
            java.lang.String r4 = "ReceiveChannel doesn't contain element at index "
            r5 = 1
            if (r2 == 0) goto L44
            if (r2 != r5) goto L3c
            int r9 = r0.f35753e
            int r10 = r0.f35752d
            java.lang.Object r2 = r0.f35755g
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            java.lang.Object r6 = r0.f35754f
            kotlinx.coroutines.channels.i0 r6 = (kotlinx.coroutines.channels.i0) r6
            kotlin.e1.n(r11)     // Catch: java.lang.Throwable -> L39
            goto L64
        L39:
            r9 = move-exception
            goto Lb1
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L44:
            kotlin.e1.n(r11)
            if (r10 < 0) goto L99
            kotlinx.coroutines.channels.p r11 = r9.iterator()     // Catch: java.lang.Throwable -> L95
            r2 = 0
        L4e:
            r0.f35754f = r9     // Catch: java.lang.Throwable -> L95
            r0.f35755g = r11     // Catch: java.lang.Throwable -> L95
            r0.f35752d = r10     // Catch: java.lang.Throwable -> L95
            r0.f35753e = r2     // Catch: java.lang.Throwable -> L95
            r0.f35757i = r5     // Catch: java.lang.Throwable -> L95
            java.lang.Object r6 = r11.a(r0)     // Catch: java.lang.Throwable -> L95
            if (r6 != r1) goto L5f
            return r1
        L5f:
            r8 = r6
            r6 = r9
            r9 = r2
            r2 = r11
            r11 = r8
        L64:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L39
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L7d
            java.lang.Object r11 = r2.next()     // Catch: java.lang.Throwable -> L39
            int r7 = r9 + 1
            if (r10 != r9) goto L79
            r9 = 0
            kotlinx.coroutines.channels.s.b(r6, r9)
            return r11
        L79:
            r11 = r2
            r9 = r6
            r2 = r7
            goto L4e
        L7d:
            java.lang.IndexOutOfBoundsException r9 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r11.<init>()     // Catch: java.lang.Throwable -> L39
            r11.append(r4)     // Catch: java.lang.Throwable -> L39
            r11.append(r10)     // Catch: java.lang.Throwable -> L39
            r11.append(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L39
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L39
            throw r9     // Catch: java.lang.Throwable -> L39
        L95:
            r10 = move-exception
            r6 = r9
            r9 = r10
            goto Lb1
        L99:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L95
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r0.<init>()     // Catch: java.lang.Throwable -> L95
            r0.append(r4)     // Catch: java.lang.Throwable -> L95
            r0.append(r10)     // Catch: java.lang.Throwable -> L95
            r0.append(r3)     // Catch: java.lang.Throwable -> L95
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L95
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L95
            throw r11     // Catch: java.lang.Throwable -> L95
        Lb1:
            throw r9     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            r10 = move-exception
            kotlinx.coroutines.channels.s.b(r6, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.l(kotlinx.coroutines.channels.i0, int, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #0 {all -> 0x0087, blocks: (B:27:0x006a, B:29:0x0072, B:23:0x0054, B:22:0x004f), top: B:43:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x007e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0065 -> B:27:0x006a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object m(kotlinx.coroutines.channels.i0 r8, int r9, kotlin.coroutines.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.v.j
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.channels.v$j r0 = (kotlinx.coroutines.channels.v.j) r0
            int r1 = r0.f35768i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35768i = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$j r0 = new kotlinx.coroutines.channels.v$j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f35767h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35768i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            int r8 = r0.f35764e
            int r9 = r0.f35763d
            java.lang.Object r2 = r0.f35766g
            kotlinx.coroutines.channels.p r2 = (kotlinx.coroutines.channels.p) r2
            java.lang.Object r5 = r0.f35765f
            kotlinx.coroutines.channels.i0 r5 = (kotlinx.coroutines.channels.i0) r5
            kotlin.e1.n(r10)     // Catch: java.lang.Throwable -> L3c
            r7 = r2
            r2 = r8
            r8 = r5
            r5 = r1
            r1 = r0
            r0 = r7
            goto L6a
        L3c:
            r8 = move-exception
            goto L8a
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            kotlin.e1.n(r10)
            if (r9 >= 0) goto L4f
            kotlinx.coroutines.channels.s.b(r8, r4)
            return r4
        L4f:
            kotlinx.coroutines.channels.p r10 = r8.iterator()     // Catch: java.lang.Throwable -> L87
            r2 = 0
        L54:
            r0.f35765f = r8     // Catch: java.lang.Throwable -> L87
            r0.f35766g = r10     // Catch: java.lang.Throwable -> L87
            r0.f35763d = r9     // Catch: java.lang.Throwable -> L87
            r0.f35764e = r2     // Catch: java.lang.Throwable -> L87
            r0.f35768i = r3     // Catch: java.lang.Throwable -> L87
            java.lang.Object r5 = r10.a(r0)     // Catch: java.lang.Throwable -> L87
            if (r5 != r1) goto L65
            return r1
        L65:
            r7 = r0
            r0 = r10
            r10 = r5
            r5 = r1
            r1 = r7
        L6a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L87
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L87
            if (r10 == 0) goto L83
            java.lang.Object r10 = r0.next()     // Catch: java.lang.Throwable -> L87
            int r6 = r2 + 1
            if (r9 != r2) goto L7e
            kotlinx.coroutines.channels.s.b(r8, r4)
            return r10
        L7e:
            r10 = r0
            r0 = r1
            r1 = r5
            r2 = r6
            goto L54
        L83:
            kotlinx.coroutines.channels.s.b(r8, r4)
            return r4
        L87:
            r9 = move-exception
            r5 = r8
            r8 = r9
        L8a:
            throw r8     // Catch: java.lang.Throwable -> L8b
        L8b:
            r9 = move-exception
            kotlinx.coroutines.channels.s.b(r5, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.m(kotlinx.coroutines.channels.i0, int, kotlin.coroutines.d):java.lang.Object");
    }

    @a7.d
    @a1
    public static final <E> kotlinx.coroutines.channels.i0<E> n(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new k(i0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 o(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return kotlinx.coroutines.channels.s.s(i0Var, gVar, pVar);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 p(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.q qVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new l(i0Var, qVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 q(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.q qVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return p(i0Var, gVar, qVar);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 r(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar) {
        return kotlinx.coroutines.channels.s.s(i0Var, gVar, new m(pVar, null));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 s(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return r(i0Var, gVar, pVar);
    }

    @a7.d
    @a1
    public static final <E> kotlinx.coroutines.channels.i0<E> t(@a7.d kotlinx.coroutines.channels.i0<? extends E> i0Var) {
        return o(i0Var, null, new n(null), 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0064, B:29:0x006a, B:21:0x004a, B:31:0x006f), top: B:40:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x006a A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0064, B:29:0x006a, B:21:0x004a, B:31:0x006f), top: B:40:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x006f A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0064, B:29:0x006a, B:21:0x004a, B:31:0x006f), top: B:40:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object u(kotlinx.coroutines.channels.i0 r5, java.util.Collection r6, kotlin.coroutines.d r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.v.o
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.v$o r0 = (kotlinx.coroutines.channels.v.o) r0
            int r1 = r0.f35812h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35812h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$o r0 = new kotlinx.coroutines.channels.v$o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35811g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35812h
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f35810f
            kotlinx.coroutines.channels.p r5 = (kotlinx.coroutines.channels.p) r5
            java.lang.Object r6 = r0.f35809e
            kotlinx.coroutines.channels.i0 r6 = (kotlinx.coroutines.channels.i0) r6
            java.lang.Object r2 = r0.f35808d
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r5 = move-exception
            goto L7a
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.e1.n(r7)
            kotlinx.coroutines.channels.p r7 = r5.iterator()     // Catch: java.lang.Throwable -> L76
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L4a:
            r0.f35808d = r7     // Catch: java.lang.Throwable -> L35
            r0.f35809e = r6     // Catch: java.lang.Throwable -> L35
            r0.f35810f = r5     // Catch: java.lang.Throwable -> L35
            r0.f35812h = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r5.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6f
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6d
            r2.add(r7)     // Catch: java.lang.Throwable -> L35
        L6d:
            r7 = r2
            goto L4a
        L6f:
            kotlin.l2 r5 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L35
            r5 = 0
            kotlinx.coroutines.channels.s.b(r6, r5)
            return r2
        L76:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L7a:
            throw r5     // Catch: java.lang.Throwable -> L7b
        L7b:
            r7 = move-exception
            kotlinx.coroutines.channels.s.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.u(kotlinx.coroutines.channels.i0, java.util.Collection, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x007d A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:25:0x0062, B:29:0x0075, B:31:0x007d, B:33:0x0083, B:37:0x0096, B:24:0x005e), top: B:49:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[Catch: all -> 0x009d, TryCatch #2 {all -> 0x009d, blocks: (B:25:0x0062, B:29:0x0075, B:31:0x007d, B:33:0x0083, B:37:0x0096, B:24:0x005e), top: B:49:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:37:0x0096 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #2 {all -> 0x009d, blocks: (B:25:0x0062, B:29:0x0075, B:31:0x007d, B:33:0x0083, B:37:0x0096, B:24:0x005e), top: B:49:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.m0] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object, kotlinx.coroutines.channels.m0] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.i0] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object v(kotlinx.coroutines.channels.i0 r6, kotlinx.coroutines.channels.m0 r7, kotlin.coroutines.d r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.v.p
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.v$p r0 = (kotlinx.coroutines.channels.v.p) r0
            int r1 = r0.f35817h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35817h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.v$p r0 = new kotlinx.coroutines.channels.v$p
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35816g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35817h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5b
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.f35815f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r7 = r0.f35814e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r2 = r0.f35813d
            kotlinx.coroutines.channels.m0 r2 = (kotlinx.coroutines.channels.m0) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L59
            r8 = r6
            r6 = r7
            r7 = r2
            goto L62
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            java.lang.Object r6 = r0.f35815f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r7 = r0.f35814e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r2 = r0.f35813d
            kotlinx.coroutines.channels.m0 r2 = (kotlinx.coroutines.channels.m0) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L59
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r2
        L56:
            r2 = r1
            r1 = r5
            goto L75
        L59:
            r6 = move-exception
            goto La1
        L5b:
            kotlin.e1.n(r8)
            kotlinx.coroutines.channels.p r8 = r6.iterator()     // Catch: java.lang.Throwable -> L9d
        L62:
            r0.f35813d = r7     // Catch: java.lang.Throwable -> L9d
            r0.f35814e = r6     // Catch: java.lang.Throwable -> L9d
            r0.f35815f = r8     // Catch: java.lang.Throwable -> L9d
            r0.f35817h = r4     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r2 = r8.a(r0)     // Catch: java.lang.Throwable -> L9d
            if (r2 != r1) goto L71
            return r1
        L71:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L56
        L75:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L9d
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L9d
            if (r8 == 0) goto L96
            java.lang.Object r8 = r0.next()     // Catch: java.lang.Throwable -> L9d
            if (r8 == 0) goto L92
            r1.f35813d = r7     // Catch: java.lang.Throwable -> L9d
            r1.f35814e = r6     // Catch: java.lang.Throwable -> L9d
            r1.f35815f = r0     // Catch: java.lang.Throwable -> L9d
            r1.f35817h = r3     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r8 = r7.R(r8, r1)     // Catch: java.lang.Throwable -> L9d
            if (r8 != r2) goto L92
            return r2
        L92:
            r8 = r0
            r0 = r1
            r1 = r2
            goto L62
        L96:
            kotlin.l2 r8 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L9d
            r8 = 0
            kotlinx.coroutines.channels.s.b(r6, r8)
            return r7
        L9d:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        La1:
            throw r6     // Catch: java.lang.Throwable -> La2
        La2:
            r8 = move-exception
            kotlinx.coroutines.channels.s.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.v.v(kotlinx.coroutines.channels.i0, kotlinx.coroutines.channels.m0, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005b A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:12:0x002d, B:23:0x0053, B:25:0x005b, B:28:0x0064, B:29:0x006b), top: B:38:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0064 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #1 {all -> 0x0031, blocks: (B:12:0x002d, B:23:0x0053, B:25:0x005b, B:28:0x0064, B:29:0x006b), top: B:38:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object w(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.d dVar) {
        q qVar;
        kotlinx.coroutines.channels.i0 i0Var2;
        Throwable th;
        kotlinx.coroutines.channels.p pVar;
        if (dVar instanceof q) {
            qVar = (q) dVar;
            int i7 = qVar.f35821g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                qVar.f35821g = i7 - Integer.MIN_VALUE;
            } else {
                qVar = new q(dVar);
            }
        } else {
            qVar = new q(dVar);
        }
        Object obj = qVar.f35820f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = qVar.f35821g;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pVar = (kotlinx.coroutines.channels.p) qVar.f35819e;
            i0Var2 = (kotlinx.coroutines.channels.i0) qVar.f35818d;
            try {
                e1.n(obj);
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object next = pVar.next();
                kotlinx.coroutines.channels.s.b(i0Var2, null);
                return next;
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    kotlinx.coroutines.channels.s.b(i0Var2, th);
                    throw th3;
                }
            }
        }
        e1.n(obj);
        try {
            kotlinx.coroutines.channels.p it = i0Var.iterator();
            qVar.f35818d = i0Var;
            qVar.f35819e = it;
            qVar.f35821g = 1;
            Object objA = it.a(qVar);
            if (objA == objH) {
                return objH;
            }
            i0Var2 = i0Var;
            pVar = it;
            obj = objA;
            if (((Boolean) obj).booleanValue()) {
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
            Object next2 = pVar.next();
            kotlinx.coroutines.channels.s.b(i0Var2, null);
            return next2;
        } catch (Throwable th4) {
            i0Var2 = i0Var;
            th = th4;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object x(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.d dVar) {
        r rVar;
        kotlinx.coroutines.channels.i0 i0Var2;
        Throwable th;
        kotlinx.coroutines.channels.p pVar;
        if (dVar instanceof r) {
            rVar = (r) dVar;
            int i7 = rVar.f35825g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                rVar.f35825g = i7 - Integer.MIN_VALUE;
            } else {
                rVar = new r(dVar);
            }
        } else {
            rVar = new r(dVar);
        }
        Object obj = rVar.f35824f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = rVar.f35825g;
        if (i8 == 0) {
            e1.n(obj);
            try {
                kotlinx.coroutines.channels.p it = i0Var.iterator();
                rVar.f35822d = i0Var;
                rVar.f35823e = it;
                rVar.f35825g = 1;
                Object objA = it.a(rVar);
                if (objA == objH) {
                    return objH;
                }
                i0Var2 = i0Var;
                pVar = it;
                obj = objA;
            } catch (Throwable th2) {
                i0Var2 = i0Var;
                th = th2;
                throw th;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pVar = (kotlinx.coroutines.channels.p) rVar.f35823e;
            i0Var2 = (kotlinx.coroutines.channels.i0) rVar.f35822d;
            try {
                e1.n(obj);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    kotlinx.coroutines.channels.s.b(i0Var2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            kotlinx.coroutines.channels.s.b(i0Var2, null);
            return null;
        }
        Object next = pVar.next();
        kotlinx.coroutines.channels.s.b(i0Var2, null);
        return next;
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.i0 y(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar) {
        return kotlinx.coroutines.channels.e0.g(f2.f36000a, gVar, 0, null, kotlinx.coroutines.channels.s.g(i0Var), new s(i0Var, pVar, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 z(kotlinx.coroutines.channels.i0 i0Var, kotlin.coroutines.g gVar, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = n1.g();
        }
        return y(i0Var, gVar, pVar);
    }
}

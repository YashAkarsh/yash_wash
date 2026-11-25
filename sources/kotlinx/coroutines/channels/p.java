package kotlinx.coroutines.channels;

import kotlin.e1;

/* JADX INFO: loaded from: classes2.dex */
public interface p<E> {

    public static final class a {

        /* JADX INFO: renamed from: kotlinx.coroutines.channels.p$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {584}, m = "next", n = {"this"}, s = {"L$0"})
        static final class C0449a<E> extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f35635d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f35636e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f35637f;

            C0449a(kotlin.coroutines.d<? super C0449a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f35636e = obj;
                this.f35637f |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @h5.h(name = "next")
        public static /* synthetic */ Object a(p pVar, kotlin.coroutines.d dVar) {
            C0449a c0449a;
            if (dVar instanceof C0449a) {
                c0449a = (C0449a) dVar;
                int i7 = c0449a.f35637f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    c0449a.f35637f = i7 - Integer.MIN_VALUE;
                } else {
                    c0449a = new C0449a(dVar);
                }
            } else {
                c0449a = new C0449a(dVar);
            }
            Object objA = c0449a.f35636e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = c0449a.f35637f;
            if (i8 == 0) {
                e1.n(objA);
                c0449a.f35635d = pVar;
                c0449a.f35637f = 1;
                objA = pVar.a(c0449a);
                if (objA == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pVar = (p) c0449a.f35635d;
                e1.n(objA);
            }
            if (((Boolean) objA).booleanValue()) {
                return pVar.next();
            }
            throw new x(s.f35660a);
        }
    }

    @a7.e
    Object a(@a7.d kotlin.coroutines.d<? super Boolean> dVar);

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @h5.h(name = "next")
    /* synthetic */ Object b(kotlin.coroutines.d dVar);

    E next();
}

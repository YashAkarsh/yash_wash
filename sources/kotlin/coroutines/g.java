package kotlin.coroutines;

import i5.p;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: kotlin.coroutines.g$a$a, reason: collision with other inner class name */
        static final class C0431a extends n0 implements p<g, b, g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0431a f34681a = new C0431a();

            C0431a() {
                super(2);
            }

            @Override // i5.p
            @a7.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final g a0(@a7.d g acc, @a7.d b element) {
                kotlin.coroutines.c cVar;
                l0.p(acc, "acc");
                l0.p(element, "element");
                g gVarMinusKey = acc.minusKey(element.getKey());
                i iVar = i.f34682a;
                if (gVarMinusKey == iVar) {
                    return element;
                }
                e.b bVar = e.f34677q0;
                e eVar = (e) gVarMinusKey.get(bVar);
                if (eVar == null) {
                    cVar = new kotlin.coroutines.c(gVarMinusKey, element);
                } else {
                    g gVarMinusKey2 = gVarMinusKey.minusKey(bVar);
                    if (gVarMinusKey2 == iVar) {
                        return new kotlin.coroutines.c(element, eVar);
                    }
                    cVar = new kotlin.coroutines.c(new kotlin.coroutines.c(gVarMinusKey2, element), eVar);
                }
                return cVar;
            }
        }

        @a7.d
        public static g a(@a7.d g gVar, @a7.d g context) {
            l0.p(context, "context");
            return context == i.f34682a ? gVar : (g) context.fold(gVar, C0431a.f34681a);
        }
    }

    public interface b extends g {

        public static final class a {
            public static <R> R a(@a7.d b bVar, R r7, @a7.d p<? super R, ? super b, ? extends R> operation) {
                l0.p(operation, "operation");
                return operation.a0(r7, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @a7.e
            public static <E extends b> E b(@a7.d b bVar, @a7.d c<E> key) {
                l0.p(key, "key");
                if (!l0.g(bVar.getKey(), key)) {
                    return null;
                }
                l0.n(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            @a7.d
            public static g c(@a7.d b bVar, @a7.d c<?> key) {
                l0.p(key, "key");
                return l0.g(bVar.getKey(), key) ? i.f34682a : bVar;
            }

            @a7.d
            public static g d(@a7.d b bVar, @a7.d g context) {
                l0.p(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // kotlin.coroutines.g
        <R> R fold(R r7, @a7.d p<? super R, ? super b, ? extends R> pVar);

        @Override // kotlin.coroutines.g
        @a7.e
        <E extends b> E get(@a7.d c<E> cVar);

        @a7.d
        c<?> getKey();

        @Override // kotlin.coroutines.g
        @a7.d
        g minusKey(@a7.d c<?> cVar);
    }

    public interface c<E extends b> {
    }

    <R> R fold(R r7, @a7.d p<? super R, ? super b, ? extends R> pVar);

    @a7.e
    <E extends b> E get(@a7.d c<E> cVar);

    @a7.d
    g minusKey(@a7.d c<?> cVar);

    @a7.d
    g plus(@a7.d g gVar);
}

package a5;

import kotlin.g1;
import kotlin.v;

/* JADX INFO: loaded from: classes2.dex */
@f
@g1(version = "1.3")
@kotlin.internal.b
public interface c {

    public static final class a {
        public static /* synthetic */ a5.a a(c cVar, v vVar, g gVar, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i7 & 2) != 0) {
                gVar = g.UNKNOWN;
            }
            return cVar.c(vVar, gVar);
        }
    }

    @a7.d
    @kotlin.internal.b
    h a();

    @a7.d
    @kotlin.internal.b
    h b(@a7.e Object obj);

    @a7.d
    @kotlin.internal.b
    <R> a5.a c(@a7.d v<? extends R> vVar, @a7.d g gVar);

    @a7.d
    @kotlin.internal.b
    i d();
}

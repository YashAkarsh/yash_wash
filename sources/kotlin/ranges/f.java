package kotlin.ranges;

import java.lang.Comparable;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.1")
public interface f<T extends Comparable<? super T>> extends g<T> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@a7.d f<T> fVar, @a7.d T value) {
            l0.p(value, "value");
            return fVar.b(fVar.d(), value) && fVar.b(value, fVar.f());
        }

        public static <T extends Comparable<? super T>> boolean b(@a7.d f<T> fVar) {
            return !fVar.b(fVar.d(), fVar.f());
        }
    }

    @Override // kotlin.ranges.g
    boolean a(@a7.d T t7);

    boolean b(@a7.d T t7, @a7.d T t8);

    @Override // kotlin.ranges.g
    boolean isEmpty();
}

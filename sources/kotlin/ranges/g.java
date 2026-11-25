package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public interface g<T extends Comparable<? super T>> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@a7.d g<T> gVar, @a7.d T value) {
            l0.p(value, "value");
            return value.compareTo(gVar.d()) >= 0 && value.compareTo(gVar.f()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@a7.d g<T> gVar) {
            return gVar.d().compareTo(gVar.f()) > 0;
        }
    }

    boolean a(@a7.d T t7);

    @a7.d
    T d();

    @a7.d
    T f();

    boolean isEmpty();
}

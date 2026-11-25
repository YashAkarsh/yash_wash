package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public interface d0 {

    public static final class a {
        @a7.e
        public static String a(@a7.d d0 d0Var) {
            return null;
        }
    }

    @a7.d
    a3 createDispatcher(@a7.d List<? extends d0> list);

    int getLoadPriority();

    @a7.e
    String hintOnError();
}

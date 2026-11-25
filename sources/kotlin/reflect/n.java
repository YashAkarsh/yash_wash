package kotlin.reflect;

import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends kotlin.reflect.b {

    public static final class a {
        @g1(version = "1.1")
        public static /* synthetic */ void a() {
        }
    }

    public enum b {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    boolean J();

    @a7.d
    b Z();

    int g();

    @a7.e
    String getName();

    @a7.d
    s getType();

    boolean m0();
}

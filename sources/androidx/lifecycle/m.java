package androidx.lifecycle;

import c.x0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    @c.m0
    AtomicReference<Object> f8318a = new AtomicReference<>();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8320b;

        static {
            int[] iArr = new int[b.values().length];
            f8320b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8320b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8320b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8320b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8320b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8320b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8320b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            f8319a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8319a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8319a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8319a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8319a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @c.o0
        public static b a(@c.m0 c cVar) {
            int i7 = a.f8319a[cVar.ordinal()];
            if (i7 == 1) {
                return ON_DESTROY;
            }
            if (i7 == 2) {
                return ON_STOP;
            }
            if (i7 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        @c.o0
        public static b b(@c.m0 c cVar) {
            int i7 = a.f8319a[cVar.ordinal()];
            if (i7 == 1) {
                return ON_STOP;
            }
            if (i7 == 2) {
                return ON_PAUSE;
            }
            if (i7 != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        @c.o0
        public static b d(@c.m0 c cVar) {
            int i7 = a.f8319a[cVar.ordinal()];
            if (i7 == 1) {
                return ON_START;
            }
            if (i7 == 2) {
                return ON_RESUME;
            }
            if (i7 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        @c.o0
        public static b e(@c.m0 c cVar) {
            int i7 = a.f8319a[cVar.ordinal()];
            if (i7 == 1) {
                return ON_CREATE;
            }
            if (i7 == 2) {
                return ON_START;
            }
            if (i7 != 3) {
                return null;
            }
            return ON_RESUME;
        }

        @c.m0
        public c c() {
            switch (a.f8320b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(@c.m0 c cVar) {
            return compareTo(cVar) >= 0;
        }
    }

    @c.j0
    public abstract void a(@c.m0 p pVar);

    @c.m0
    @c.j0
    public abstract c b();

    @c.j0
    public abstract void c(@c.m0 p pVar);
}

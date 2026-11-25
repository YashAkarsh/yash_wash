package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.b1;
import kotlin.jvm.internal.n0;

/* JADX INFO: loaded from: classes2.dex */
public enum b {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final C0441b f35308b = new C0441b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final kotlin.d0<Map<Integer, b>> f35309c = kotlin.f0.a(a.f35332a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35331a;

    static final class a extends n0 implements i5.a<Map<Integer, ? extends b>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35332a = new a();

        a() {
            super(0);
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<Integer, b> invoke() {
            b[] bVarArrValues = b.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(bVarArrValues.length), 16));
            for (b bVar : bVarArrValues) {
                linkedHashMap.put(Integer.valueOf(bVar.c()), bVar);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: kotlin.text.b$b, reason: collision with other inner class name */
    public static final class C0441b {
        public /* synthetic */ C0441b(kotlin.jvm.internal.w wVar) {
            this();
        }

        private final Map<Integer, b> a() {
            return (Map) b.f35309c.getValue();
        }

        @a7.d
        public final b b(int i7) {
            b bVar = a().get(Integer.valueOf(i7));
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalArgumentException("Directionality #" + i7 + " is not defined.");
        }

        private C0441b() {
        }
    }

    b(int i7) {
        this.f35331a = i7;
    }

    public final int c() {
        return this.f35331a;
    }
}

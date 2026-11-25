package kotlin.text;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f35431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f35432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f35433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f35434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f35435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q f35436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q f35437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ q[] f35438j = b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35440b;

    static {
        int i7 = 2;
        f35431c = new q("IGNORE_CASE", 0, i7, 0, 2, null);
        int i8 = 0;
        int i9 = 2;
        kotlin.jvm.internal.w wVar = null;
        f35432d = new q("MULTILINE", 1, 8, i8, i9, wVar);
        int i10 = 0;
        int i11 = 2;
        kotlin.jvm.internal.w wVar2 = null;
        f35433e = new q("LITERAL", i7, 16, i10, i11, wVar2);
        f35434f = new q("UNIX_LINES", 3, 1, i8, i9, wVar);
        f35435g = new q("COMMENTS", 4, 4, i10, i11, wVar2);
        f35436h = new q("DOT_MATCHES_ALL", 5, 32, i8, i9, wVar);
        f35437i = new q("CANON_EQ", 6, 128, i10, i11, wVar2);
    }

    private q(String str, int i7, int i8, int i9) {
        super(str, i7);
        this.f35439a = i8;
        this.f35440b = i9;
    }

    private static final /* synthetic */ q[] b() {
        return new q[]{f35431c, f35432d, f35433e, f35434f, f35435g, f35436h, f35437i};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f35438j.clone();
    }

    @Override // kotlin.text.i
    public int a() {
        return this.f35440b;
    }

    @Override // kotlin.text.i
    public int getValue() {
        return this.f35439a;
    }

    /* synthetic */ q(String str, int i7, int i8, int i9, int i10, kotlin.jvm.internal.w wVar) {
        this(str, i7, i8, (i10 & 2) != 0 ? i8 : i9);
    }
}

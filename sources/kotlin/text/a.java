package kotlin.text;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final C0440a f35282c = new C0440a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final String f35307b;

    /* JADX INFO: renamed from: kotlin.text.a$a, reason: collision with other inner class name */
    public static final class C0440a {
        public /* synthetic */ C0440a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final a a(int i7) {
            if (new kotlin.ranges.k(0, 16).m(i7)) {
                return a.values()[i7];
            }
            if (new kotlin.ranges.k(18, 30).m(i7)) {
                return a.values()[i7 - 1];
            }
            throw new IllegalArgumentException("Category #" + i7 + " is not defined.");
        }

        private C0440a() {
        }
    }

    a(int i7, String str) {
        this.f35306a = i7;
        this.f35307b = str;
    }

    public final boolean b(char c8) {
        return Character.getType(c8) == this.f35306a;
    }

    @a7.d
    public final String c() {
        return this.f35307b;
    }

    public final int d() {
        return this.f35306a;
    }
}

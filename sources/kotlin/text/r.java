package kotlin.text;

/* JADX INFO: loaded from: classes2.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final r f35441a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final o f35442b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f35442b = new o("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private r() {
    }
}

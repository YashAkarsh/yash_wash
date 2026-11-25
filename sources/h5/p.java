package h5;

/* JADX INFO: loaded from: classes2.dex */
public class p extends Error {
    public p() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public p(@a7.e String str) {
        super(str);
    }

    public p(@a7.e String str, @a7.e Throwable th) {
        super(str, th);
    }

    public p(@a7.e Throwable th) {
        super(th);
    }
}

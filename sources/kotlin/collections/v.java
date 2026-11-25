package kotlin.collections;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final v f34630a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public static final boolean f34631b;

    static {
        String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        f34631b = property != null ? Boolean.parseBoolean(property) : false;
    }

    private v() {
    }
}

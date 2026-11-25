package o2;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    SUCCESS("00000", "SUCCESSFUL"),
    SHARE_CANCLE("10002", "SHARE IS CANCELLED"),
    SHARE_ERROR("10003", "SHARE IS FAILED"),
    LOGIN_CANCEL("20002", "LOGIN CANCELLED"),
    MISS_PARAMETER("30001", "MISS PARAMETER"),
    UNKNOWN("999999", "error");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37573b;

    a(String str, String str2) {
        this.f37572a = str;
        this.f37573b = str2;
    }

    public String b() {
        return this.f37572a;
    }

    public String c() {
        return this.f37573b;
    }
}

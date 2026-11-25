package w3;

/* JADX INFO: loaded from: classes2.dex */
public class a implements v3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f40495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f40496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f40497c;

    public a(String str, String str2, String str3) {
        this.f40495a = str;
        this.f40496b = str2;
        this.f40497c = str3;
    }

    public String a() {
        return this.f40495a;
    }

    @Override // v3.b
    public int bluetoothType() {
        return 2;
    }

    @Override // v3.b
    public String getBluetoothMac() {
        return this.f40496b;
    }

    @Override // v3.b
    public String getStartCommand() {
        return this.f40497c;
    }
}

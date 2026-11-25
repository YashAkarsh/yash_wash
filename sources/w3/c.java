package w3;

import com.jiao.project.bluetoothofabroadwasherapp.enums.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements t3.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f40518e;

    public c(byte[] bArr) {
        this.f40518e = "无效命令，未获取到具体信息";
        if (bArr == null || bArr.length <= 12) {
            return;
        }
        this.f40518e = f.b(bArr[11]);
    }

    @Override // t3.c
    public boolean a() {
        return false;
    }

    @Override // t3.c
    public String b() {
        return "3";
    }

    @Override // t3.c
    public String c() {
        return this.f40518e;
    }
}

package com.haier.uhome.usdk.base.utils;

import android.os.Environment;
import com.haier.uhome.nfc.service.HttpHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigInfo {

    @g3.b(name = HttpHelper.a.f29520d)
    String clientId;

    @g3.b(name = "passLevelBle")
    int passLevelBle;

    @g3.b(name = "passLevelGateway")
    int passLevelGateway;

    @g3.b(name = "passLevelLocal")
    int passLevelLocal;

    @g3.b(name = "passLevelMesh")
    int passLevelMesh;

    @g3.b(name = "passLevelNoumenon")
    int passLevelNoumenon;

    @g3.b(name = "passLevelRemote")
    int passLevelRemote;

    @g3.b(name = com.paytm.pgsdk.d.R)
    String token;

    @g3.b(name = "userId")
    String userId;

    /* JADX WARN: Code duplicated, block: B:40:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static ConfigInfo loadConfigInfo() throws Throwable {
        BufferedReader bufferedReader;
        String str = Environment.getExternalStorageDirectory().getPath() + "/usdk_usdk_debug_config_file.cf";
        if (!new File(str).exists()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (IOException e8) {
                            e = e8;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e9) {
                                    e = e9;
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                }
            } catch (IOException e12) {
                e = e12;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            ConfigInfo configInfo = (ConfigInfo) com.haier.library.json.a.z(sb.toString(), ConfigInfo.class);
            e3.a.o("configInfo get:" + configInfo.toString(), new Object[0]);
            return configInfo;
        } catch (Exception e13) {
            e13.printStackTrace();
            return null;
        }
    }

    public String getClientId() {
        return this.clientId;
    }

    public int getPassLevelBle() {
        return this.passLevelBle;
    }

    public int getPassLevelGateway() {
        return this.passLevelGateway;
    }

    public int getPassLevelLocal() {
        return this.passLevelLocal;
    }

    public int getPassLevelMesh() {
        return this.passLevelMesh;
    }

    public int getPassLevelNoumenon() {
        return this.passLevelNoumenon;
    }

    public int getPassLevelRemote() {
        return this.passLevelRemote;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setPassLevelBle(int i7) {
        this.passLevelBle = i7;
    }

    public void setPassLevelGateway(int i7) {
        this.passLevelGateway = i7;
    }

    public void setPassLevelLocal(int i7) {
        this.passLevelLocal = i7;
    }

    public void setPassLevelMesh(int i7) {
        this.passLevelMesh = i7;
    }

    public void setPassLevelNoumenon(int i7) {
        this.passLevelNoumenon = i7;
    }

    public void setPassLevelRemote(int i7) {
        this.passLevelRemote = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "ConfigInfo{clientId='" + this.clientId + "', token='" + this.token + "', userId='" + this.userId + "', passLevelNoumenon=" + this.passLevelNoumenon + ", passLevelLocal=" + this.passLevelLocal + ", passLevelRemote=" + this.passLevelRemote + ", passLevelGateway=" + this.passLevelGateway + ", passLevelBle=" + this.passLevelBle + ", passLevelMesh=" + this.passLevelMesh + '}';
    }
}

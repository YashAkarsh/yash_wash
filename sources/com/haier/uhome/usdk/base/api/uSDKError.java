package com.haier.uhome.usdk.base.api;

import com.haier.uhome.usdk.base.annotation.Keep;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKError {

    @Keep
    public static final uSDKError RET_USDK_OK = ErrorConst.RET_USDK_OK.toError();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f31229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f31230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f31233e = new HashMap<>();

    public uSDKError() {
    }

    public static uSDKError a(int i7, String str) {
        return new uSDKError(i7, str);
    }

    public String b(String str) {
        HashMap<String, String> map = this.f31233e;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof uSDKError) {
            return ((uSDKError) obj).getCode() == getCode();
        }
        return super.equals(obj);
    }

    @Keep
    public int getCode() {
        return this.f31229a;
    }

    @Keep
    public String getDescription() {
        return this.f31231c;
    }

    @Keep
    public HashMap<String, String> getExtendedInfo() {
        return this.f31233e;
    }

    @Keep
    public String getFailureReason() {
        return this.f31232d;
    }

    @Keep
    public int getReasonCode() {
        return this.f31230b;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f31229a));
    }

    @Keep
    public void setCode(int i7) {
        this.f31229a = i7;
    }

    @Keep
    public void setDescription(String str) {
        this.f31231c = str;
    }

    public String toString() {
        return "uSDKError{code=" + this.f31229a + ", description=" + this.f31231c + ", failureReason=" + this.f31232d + ", extendedInfo=" + this.f31233e + '}';
    }

    public void a(int i7) {
        this.f31230b = i7;
    }

    public uSDKError(int i7) {
        this.f31229a = i7;
    }

    public void a(String str) {
        this.f31232d = str;
    }

    public void a(HashMap<String, String> map) {
        this.f31233e = map;
    }

    public void a(String str, String str2) {
        HashMap<String, String> map = this.f31233e;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public uSDKError(int i7, String str) {
        this.f31229a = i7;
        this.f31231c = str;
    }

    public boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ErrorConst) {
            return ((ErrorConst) obj).getErrorId() == getCode();
        }
        if (obj instanceof uSDKError) {
            return ((uSDKError) obj).getCode() == getCode();
        }
        return equals(obj);
    }
}

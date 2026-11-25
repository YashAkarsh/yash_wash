package com.haier.globalwasher.mvp_api.moudle;

import com.google.gson.f;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class BaseData<C> implements Serializable {
    private String retCode;
    private C retData;
    private String retInfo;
    private String retSign;
    private long sysTime;

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f24790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f24791b;

        a(Class cls, Type[] typeArr) {
            this.f24790a = cls;
            this.f24791b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f24791b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f24790a;
        }
    }

    public BaseData() {
    }

    private ParameterizedType type(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

    public BaseData fromJson(String str, Class<C> cls) {
        f fVar = new f();
        return cls == null ? (BaseData) fVar.n(str, BaseData.class) : (BaseData) fVar.o(str, type(BaseData.class, cls));
    }

    public C getData() {
        return this.retData;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public String getRetSign() {
        return this.retSign;
    }

    public long getSysTime() {
        return this.sysTime;
    }

    public void setData(C c8) {
        this.retData = c8;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetData(C c8) {
        this.retData = c8;
    }

    public void setRetInfo(String str) {
        this.retInfo = str;
    }

    public void setRetSign(String str) {
        this.retSign = str;
    }

    public void setSysTime(long j7) {
        this.sysTime = j7;
    }

    public String toJson(Class<C> cls) {
        return new f().A(this, type(BaseData.class, cls));
    }

    public String toString() {
        return "{retData=" + this.retData + ", sysTime=" + this.sysTime + ", retCode='" + this.retCode + "', retInfo='" + this.retInfo + "', retSign='" + this.retSign + "'}";
    }

    public BaseData(BaseBeen baseBeen) {
        this.retCode = baseBeen.getRetCode();
        this.retInfo = baseBeen.getRetInfo();
        this.retSign = baseBeen.getRetSign();
        this.sysTime = baseBeen.getSysTime();
    }

    public BaseData(C c8, long j7, String str, String str2, String str3) {
        this.retData = c8;
        this.sysTime = j7;
        this.retCode = str;
        this.retInfo = str2;
        this.retSign = str3;
    }
}

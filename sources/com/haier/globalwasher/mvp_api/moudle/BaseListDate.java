package com.haier.globalwasher.mvp_api.moudle;

import com.google.gson.f;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BaseListDate<C> implements Serializable {
    private String retCode;
    private ArrayList<C> retData;
    private String retInfo;
    private long sysTime;

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f24793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f24794b;

        a(Class cls, Type[] typeArr) {
            this.f24793a = cls;
            this.f24794b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f24794b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f24793a;
        }
    }

    private ParameterizedType type(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

    public BaseListDate<C> fromJson(String str, Class<C> cls) {
        return (BaseListDate) new f().o(str, type(BaseListDate.class, cls));
    }

    public ArrayList<C> getData() {
        return this.retData;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public long getSysTime() {
        return this.sysTime;
    }

    public void setData(ArrayList<C> arrayList) {
        this.retData = arrayList;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetInfo(String str) {
        this.retInfo = str;
    }

    public void setSysTime(long j7) {
        this.sysTime = j7;
    }

    public String toJson(String str, Class<C> cls) {
        return new f().A(this, type(BaseData.class, cls));
    }

    public String toString() {
        return "BaseListDate{retCode='" + this.retCode + "', retInfo='" + this.retInfo + "', retData=" + this.retData + '}';
    }
}

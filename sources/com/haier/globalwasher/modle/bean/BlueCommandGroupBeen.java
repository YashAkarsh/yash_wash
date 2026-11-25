package com.haier.globalwasher.modle.bean;

import com.google.gson.f;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BlueCommandGroupBeen {
    private String operationName;
    private List<OperationValueBean> operationValue;

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f24354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f24355b;

        a(Class cls, Type[] typeArr) {
            this.f24354a = cls;
            this.f24355b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f24355b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f24354a;
        }
    }

    public static BlueCommandGroupBeen getCommand(String str) {
        return (BlueCommandGroupBeen) new f().o(str, type(BlueCommandGroupBeen.class, OperationValueBean.class));
    }

    public static BlueCommandGroupBeen objectFromData(String str) {
        return (BlueCommandGroupBeen) new f().n(str, BlueCommandGroupBeen.class);
    }

    private static ParameterizedType type(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

    public String getOperationName() {
        return this.operationName;
    }

    public List<OperationValueBean> getOperationValue() {
        return this.operationValue;
    }

    public void setOperationName(String str) {
        this.operationName = str;
    }

    public void setOperationValue(List<OperationValueBean> list) {
        this.operationValue = list;
    }
}

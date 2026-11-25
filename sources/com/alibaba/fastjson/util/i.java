package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type[] f13357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f13358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f13359c;

    public i(Type[] typeArr, Type type, Type type2) {
        this.f13357a = typeArr;
        this.f13358b = type;
        this.f13359c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (!Arrays.equals(this.f13357a, iVar.f13357a)) {
            return false;
        }
        Type type = this.f13358b;
        if (type == null ? iVar.f13358b != null : !type.equals(iVar.f13358b)) {
            return false;
        }
        Type type2 = this.f13359c;
        Type type3 = iVar.f13359c;
        if (type2 != null) {
            return type2.equals(type3);
        }
        return type3 == null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f13357a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f13358b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f13359c;
    }

    public int hashCode() {
        Type[] typeArr = this.f13357a;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f13358b;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f13359c;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}

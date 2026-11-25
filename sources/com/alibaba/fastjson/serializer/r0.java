package com.alibaba.fastjson.serializer;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class r0 {

    private static class a implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f13167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f13168b;

        public a(String[] strArr, String[] strArr2) {
            if (strArr != null) {
                String[] strArr3 = new String[strArr.length];
                this.f13167a = strArr3;
                System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
                Arrays.sort(this.f13167a);
            }
            if (strArr2 != null) {
                String[] strArr4 = new String[strArr2.length];
                this.f13168b = strArr4;
                System.arraycopy(strArr2, 0, strArr4, 0, strArr2.length);
                Arrays.sort(this.f13168b);
            }
        }

        @Override // com.alibaba.fastjson.serializer.q0
        public boolean c(String str) {
            String[] strArr = this.f13168b;
            if (strArr != null) {
                return Arrays.binarySearch(strArr, str) == -1;
            }
            String[] strArr2 = this.f13167a;
            return strArr2 != null && Arrays.binarySearch(strArr2, str) >= 0;
        }
    }

    public static q0 a(String... strArr) {
        return new a(null, strArr);
    }

    public static q0 b(String... strArr) {
        return new a(strArr, null);
    }
}

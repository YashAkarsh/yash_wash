package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class z0 implements w0 {
    @Override // com.alibaba.fastjson.serializer.w0
    public String a(Object obj, String str, Object obj2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }
}

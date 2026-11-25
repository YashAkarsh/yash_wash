package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class x implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f13182a = new x();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        try {
            if (obj == null) {
                n0Var.V();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb = new StringBuilder();
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int i8 = characterStream.read(cArr, 0, 2048);
                    if (i8 < 0) {
                        String string = sb.toString();
                        characterStream.close();
                        n0Var.T(string);
                        return;
                    }
                    sb.append(cArr, 0, i8);
                }
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.d("read string from reader error", e8);
            }
        } catch (SQLException e9) {
            throw new IOException("write clob error", e9);
        }
    }
}

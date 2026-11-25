package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.j1;
import com.alibaba.fastjson.serializer.n0;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

/* JADX INFO: loaded from: classes.dex */
public class i extends AbstractSockJsMessageCodec {
    protected char[] a(String str) {
        j1 j1Var = new j1();
        try {
            new n0(j1Var).T(str);
            return j1Var.p0();
        } finally {
            j1Var.close();
        }
    }

    public String[] b(String str) throws IOException {
        return (String[]) com.alibaba.fastjson.a.N(str, String[].class);
    }

    public String[] c(InputStream inputStream) throws IOException {
        return (String[]) com.alibaba.fastjson.a.J(inputStream, String[].class, new com.alibaba.fastjson.parser.c[0]);
    }
}

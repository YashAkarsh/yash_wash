package com.haier.uhome.control.noumenon.b;

import com.haier.uhome.control.noumenon.b.b.c;
import com.haier.uhome.control.noumenon.b.b.d;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a() {
        ProtocolProcessor.registerProtocol(b.f29471g, d.class);
        ProtocolProcessor.registerProtocol(b.f29472h, com.haier.uhome.control.noumenon.b.b.a.class);
        ProtocolProcessor.registerProtocol(b.f29473i, com.haier.uhome.control.noumenon.b.b.b.class);
        ProtocolProcessor.registerProtocol(b.f29474j, c.class);
        ProtocolProcessor.registerProtocolChecker(com.haier.uhome.control.noumenon.b.a.d.class, d.class);
        ProtocolProcessor.registerProtocolChecker(com.haier.uhome.control.noumenon.b.a.a.class, com.haier.uhome.control.noumenon.b.b.a.class);
        ProtocolProcessor.registerProtocolChecker(com.haier.uhome.control.noumenon.b.a.b.class, com.haier.uhome.control.noumenon.b.b.b.class);
        ProtocolProcessor.registerProtocolChecker(com.haier.uhome.control.noumenon.b.a.c.class, c.class);
    }
}

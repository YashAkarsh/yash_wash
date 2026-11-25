package g0;

import com.alibaba.fastjson.serializer.n0;
import com.alibaba.fastjson.serializer.y0;
import java.io.IOException;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

/* JADX INFO: loaded from: classes.dex */
public class a implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33977a = new a();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        n0Var.C().write(((Json) obj).value());
    }
}

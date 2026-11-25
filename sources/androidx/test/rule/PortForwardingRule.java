package androidx.test.rule;

import android.util.Log;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import c.g1;
import c.m0;
import java.util.Properties;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class PortForwardingRule implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10349e = "PortForwardingRule";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10350f = 1024;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10351g = 65535;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g1
    static final int f10352h = 8080;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g1
    static final String f10353i = "127.0.0.1";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g1
    static final String f10354j = "http.proxyHost";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g1
    static final String f10355k = "https.proxyHost";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g1
    static final String f10356l = "http.proxyPort";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g1
    static final String f10357m = "https.proxyPort";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g1
    final String f10358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g1
    final int f10359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g1
    Properties f10360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Properties f10361d;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10362a = PortForwardingRule.f10353i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10363b = PortForwardingRule.f10352h;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Properties f10364c = System.getProperties();

        public PortForwardingRule d() {
            return new PortForwardingRule(this);
        }

        public Builder e(@m0 Properties properties) {
            this.f10364c = (Properties) Checks.f(properties);
            return this;
        }

        public Builder f(@m0 String proxyHost) {
            this.f10362a = (String) Checks.f(proxyHost);
            return this;
        }

        public Builder g(int proxyPort) {
            Checks.c(proxyPort >= 1024 && proxyPort <= 65535, "%d is used as a proxy port, must in range [%d, %d]", Integer.valueOf(proxyPort), 1024, 65535);
            this.f10363b = proxyPort;
            return this;
        }
    }

    private class PortForwardingStatement extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f10365a;

        public PortForwardingStatement(j base) {
            this.f10365a = base;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            try {
                PortForwardingRule.this.l();
                PortForwardingRule portForwardingRule = PortForwardingRule.this;
                Log.i(PortForwardingRule.f10349e, String.format("The current process traffic is forwarded to %s:%d", portForwardingRule.f10358a, Integer.valueOf(portForwardingRule.f10359b)));
                this.f10365a.a();
            } finally {
                PortForwardingRule.this.k();
                Log.i(PortForwardingRule.f10349e, "Current process traffic forwarding is cancelled");
            }
        }
    }

    private void f() {
        if (this.f10360c.getProperty(f10354j) != null) {
            this.f10361d.setProperty(f10354j, this.f10360c.getProperty(f10354j));
        }
        if (this.f10360c.getProperty(f10355k) != null) {
            this.f10361d.setProperty(f10355k, this.f10360c.getProperty(f10355k));
        }
        if (this.f10360c.getProperty(f10356l) != null) {
            this.f10361d.setProperty(f10356l, this.f10360c.getProperty(f10356l));
        }
        if (this.f10360c.getProperty(f10357m) != null) {
            this.f10361d.setProperty(f10357m, this.f10360c.getProperty(f10357m));
        }
    }

    protected static int i() {
        return f10352h;
    }

    private void j(Properties prop, Properties backUpProp, String key) {
        if (backUpProp.getProperty(key) != null) {
            prop.setProperty(key, backUpProp.getProperty(key));
        } else {
            prop.remove(key);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            h();
        } finally {
            j(this.f10360c, this.f10361d, f10354j);
            j(this.f10360c, this.f10361d, f10355k);
            j(this.f10360c, this.f10361d, f10356l);
            j(this.f10360c, this.f10361d, f10357m);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        g();
        this.f10360c.setProperty(f10354j, this.f10358a);
        this.f10360c.setProperty(f10355k, this.f10358a);
        this.f10360c.setProperty(f10356l, String.valueOf(this.f10359b));
        this.f10360c.setProperty(f10357m, String.valueOf(this.f10359b));
        d();
    }

    @Override // org.junit.rules.l
    public j a(final j base, c description) {
        return new PortForwardingStatement(base);
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void g() {
    }

    protected void h() {
    }

    private PortForwardingRule(Builder builder) {
        this(builder.f10362a, builder.f10363b, builder.f10364c);
    }

    protected PortForwardingRule(int proxyPort) {
        this(f10353i, proxyPort, System.getProperties());
    }

    @g1
    PortForwardingRule(String proxyHost, int proxyPort, @m0 Properties properties) {
        this.f10358a = proxyHost;
        this.f10359b = proxyPort;
        this.f10360c = (Properties) Checks.f(properties);
        this.f10361d = new Properties();
        f();
    }
}

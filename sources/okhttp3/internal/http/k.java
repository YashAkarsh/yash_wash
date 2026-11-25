package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.b0;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37896d = 307;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37897e = 308;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37898f = 421;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f37899g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f37900h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final Protocol f37901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public final int f37902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final String f37903c;

    public static final class a {
        private a() {
        }

        @a7.d
        public final k a(@a7.d Response response) {
            l0.p(response, "response");
            return new k(response.protocol(), response.code(), response.message());
        }

        @a7.d
        public final k b(@a7.d String statusLine) throws IOException {
            Protocol protocol;
            int i7;
            String strSubstring;
            l0.p(statusLine, "statusLine");
            if (b0.u2(statusLine, "HTTP/1.", false, 2, null)) {
                i7 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!b0.u2(statusLine, "ICY ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                protocol = Protocol.HTTP_1_0;
                i7 = 4;
            }
            int i8 = i7 + 3;
            if (statusLine.length() < i8) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            try {
                String strSubstring2 = statusLine.substring(i7, i8);
                l0.o(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i9 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i8) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i8) != ' ') {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    strSubstring = statusLine.substring(i7 + 4);
                    l0.o(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                return new k(protocol, i9, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public k(@a7.d Protocol protocol, int i7, @a7.d String message) {
        l0.p(protocol, "protocol");
        l0.p(message, "message");
        this.f37901a = protocol;
        this.f37902b = i7;
        this.f37903c = message;
    }

    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f37901a == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f37902b);
        sb.append(' ');
        sb.append(this.f37903c);
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

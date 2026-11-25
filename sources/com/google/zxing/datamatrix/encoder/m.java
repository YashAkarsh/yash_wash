package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class m extends c {
    m() {
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 2;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int d(char c8, StringBuilder sb) {
        if (c8 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c8 >= '0' && c8 <= '9') {
            sb.append((char) ((c8 - '0') + 4));
            return 1;
        }
        if (c8 >= 'a' && c8 <= 'z') {
            sb.append((char) ((c8 - 'a') + 14));
            return 1;
        }
        if (c8 < ' ') {
            sb.append((char) 0);
            sb.append(c8);
            return 2;
        }
        if (c8 >= '!' && c8 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c8 - '!'));
            return 2;
        }
        if (c8 >= ':' && c8 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c8 - ':') + 15));
            return 2;
        }
        if (c8 >= '[' && c8 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c8 - '[') + 22));
            return 2;
        }
        if (c8 == '`') {
            sb.append((char) 2);
            sb.append((char) (c8 - '`'));
            return 2;
        }
        if (c8 >= 'A' && c8 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c8 - 'A') + 1));
            return 2;
        }
        if (c8 < '{' || c8 > 127) {
            sb.append("\u0001\u001e");
            return d((char) (c8 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) ((c8 - '{') + 27));
        return 2;
    }
}

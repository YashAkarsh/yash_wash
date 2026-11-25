package m4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static String a(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
        } catch (UnsupportedEncodingException e9) {
            e9.printStackTrace();
            inputStreamReader = null;
        }
        bufferedReader = new BufferedReader(inputStreamReader);
        sb = new StringBuilder("");
        return sb.toString();
    }
}

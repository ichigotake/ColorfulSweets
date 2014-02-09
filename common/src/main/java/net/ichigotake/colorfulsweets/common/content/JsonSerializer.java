package net.ichigotake.colorfulsweets.common.content;

import android.content.Context;

import net.ichigotake.colorfulsweets.common.os.Key;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JsonSerializer {

    final private Context mContext;
    final private Key mKey;

    public JsonSerializer(Context context, Key key) {
        mContext = context;
        mKey = key;
    }

    public void serialize(JSONObject json) throws IllegalStateException {
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(mContext.getFileStreamPath(mKey.getKey()));
            stream.write(json.toString().getBytes());
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } finally {
            if (stream != null) {
                try { stream.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    public JSONObject deserialize() throws IllegalStateException {
        JSONObject json = null;

        InputStream stream = null;
        try {
            stream = new FileInputStream(mContext.getFileStreamPath(mKey.getKey()));
            byte[] buffer = new byte[1024];
            final StringBuffer fileContent = new StringBuffer("");
            while (stream.read(buffer) != -1) {
                fileContent.append(new String(buffer));
            }
            stream.close();
            json = new JSONObject(fileContent.toString());
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } finally {
            if (stream != null) {
                try { stream.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }

        if (json == null) {
            throw new IllegalStateException("");
        }

        return json;
    }
}

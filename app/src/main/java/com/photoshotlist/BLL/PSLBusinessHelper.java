package com.photoshotlist.BLL;

import com.photoshotlist.DAL.PSLDatabaseHelper;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;


/**
 * Created by PhpDev on 2016/07/30.
 */
public class PSLBusinessHelper {

    public PSLBusinessHelper() {}

    public SQLiteOpenHelper GetDataLayerObject(Context context)
    {
        return PSLDatabaseHelper.getInstance(context);
    }
}

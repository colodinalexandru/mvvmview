package com.colodin.mvvmviewcustom.assay

import android.content.Context
import com.colodin.mvvmviewcustom.BuildConfig
import com.colodin.mvvmviewcustom.assay.data.ASProduct
import com.parse.Parse
import com.parse.ParseObject

fun initParser(context: Context,applicationId:String) {
    if (BuildConfig.DEBUG) {
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG)
    }

    ParseObject.registerSubclass(ASProduct::class.java)
    Parse.initialize(
        Parse.Configuration.Builder(context)
            .applicationId(applicationId)
            .server(BuildConfig.PARSE_URL)
            .build()
    )
}

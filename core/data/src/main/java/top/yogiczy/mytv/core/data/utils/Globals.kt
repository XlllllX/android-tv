package top.yogiczy.mytv.core.data.utils

import android.content.res.Resources
import kotlinx.serialization.json.Json
import java.io.File

/**
 * 全局变量
 */
object Globals {
    lateinit var cacheDir: File

    lateinit var fileDir: File
    lateinit var nativeLibraryDir: File

    lateinit var resources: Resources

    lateinit var deviceName: String

    val json = Json {
        encodeDefaults = true
        explicitNulls = true
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}
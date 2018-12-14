package android.robnetwork.org.fofi.ui

import com.airbnb.mvrx.Async

object Utils {
    fun <T : Any> Async<T>.safeAccess(callback: (T) -> Unit) {
        takeIf { it.complete }?.invoke()?.let { callback(it) }
    }
}
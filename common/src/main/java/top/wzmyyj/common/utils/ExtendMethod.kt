package top.wzmyyj.common.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created on 2019/11/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

fun <T> MutableLiveData<T>.noMutable(): LiveData<T> {
    return this
}
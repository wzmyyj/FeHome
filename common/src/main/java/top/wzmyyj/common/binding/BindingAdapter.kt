package top.wzmyyj.common.binding

import android.graphics.Outline
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter

/**
 * Created on 2019/08/28.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@BindingAdapter("binding_marginTop")
fun View.setMarginTop(marginTop: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.topMargin = marginTop.toInt()
        this.requestLayout()
    }
}


@BindingAdapter(value = ["binding_radius"], requireAll = true)
fun View.setCornerRadius(radius: Int) {
    val p = object : ViewOutlineProvider() {
        override fun getOutline(v: View?, outline: Outline?) {
            if (v == null || outline == null) return
            outline.setRoundRect(0, 0, v.width, v.height, radius.toFloat())
        }
    }
    this.outlineProvider = p
    this.clipToOutline = true
}


package top.wzmyyj.kit.helper;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
public class FragmentTabWrapper {

    private List<FT> fts = new ArrayList<>();

    List<FT> getFTs() {
        return fts;
    }

    void clear() {
        fts.clear();
    }


    public void add(
            @NonNull Fragment fragment,
            @NonNull String title,
            @NonNull Drawable icon_unselected,
            @NonNull Drawable icon_selected
    ) {
        FT ft = new FT();
        ft.fragment = fragment;
        ft.title = title;
        ft.icon_unselected = icon_unselected;
        ft.icon_selected = icon_selected;
        fts.add(ft);
        ft.isFtUseRes = false;
    }

    public void add(
            @NonNull Fragment fragment,
            @StringRes int titleRes,
            @DrawableRes int iconRes_unselected,
            @DrawableRes int iconRes_selected
    ) {
        FT ft = new FT();
        ft.fragment = fragment;
        ft.titleRes = titleRes;
        ft.iconRes_unselected = iconRes_unselected;
        ft.iconRes_selected = iconRes_selected;
        fts.add(ft);
        ft.isFtUseRes = true;
    }


    class FT {
        boolean isFtUseRes = false;
        Fragment fragment;
        String title;
        Drawable icon_selected;// 选中的。
        Drawable icon_unselected;// 未选中的。
        @StringRes
        int titleRes;
        @DrawableRes
        int iconRes_selected;// 选中的。
        @DrawableRes
        int iconRes_unselected;// 未选中的。
    }


    @ColorInt
    int color_selected = 0xff666666;
    @ColorInt
    int color_unselected = 0xffbbbbbb;
    @ColorRes
    int colorRes_selected = 0;
    @ColorRes
    int colorRes_unselected = 0;

    boolean isColorUseRes = false;


    public void setColor(
            @ColorInt int color_unselected,
            @ColorInt int color_selected
    ) {
        this.color_unselected = color_unselected;
        this.color_selected = color_selected;
        this.isColorUseRes = false;

    }

    public void setColorRes(
            @ColorRes int colorRes_unselected,
            @ColorRes int colorRes_selected
    ) {
        this.colorRes_unselected = colorRes_unselected;
        this.colorRes_selected = colorRes_selected;
        this.isColorUseRes = true;

    }


    int firstWhich = 0;

    public void setFirstWhich(int firstWhich) {
        this.firstWhich = firstWhich;
    }

}

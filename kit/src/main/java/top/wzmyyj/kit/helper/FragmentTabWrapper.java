package top.wzmyyj.kit.helper;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.kit.R;

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
public class FragmentTabWrapper {

    private List<FT> fts = new ArrayList<>();

    public List<FT> getFTs() {
        return fts;
    }

    public void clear() {
        fts.clear();
    }


    public void add(Fragment fragment, String title, int icon_selected, int icon_unselected) {
        fts.add(new FT(fragment, title, icon_selected, icon_unselected));
    }


    class FT {
        Fragment fragment;
        String title;
        int icon_selected;// 选中的。
        int icon_unselected;// 未选中的。

        FT(Fragment fragment, String str, int icon_selected, int icon_unselected) {
            this.fragment = fragment;
            this.title = str;
            this.icon_selected = icon_selected;
            this.icon_unselected = icon_unselected;
        }
    }


    int text_color_selected = R.color.colorGray_6;
    int text_color_unselected = R.color.colorGray_b;


    public void setColorRes(int color_selected, int color_unselected) {
        text_color_selected = color_selected;
        text_color_unselected = color_unselected;

    }

    int firstWhich = 0;

    public void setFirstWhich(int firstWhich) {
        this.firstWhich = firstWhich;
    }

}

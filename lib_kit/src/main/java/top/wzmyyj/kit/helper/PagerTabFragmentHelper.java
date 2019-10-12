package top.wzmyyj.kit.helper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.kit.R;
import top.wzmyyj.kit.weight.SlideViewPager;

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
public abstract class PagerTabFragmentHelper {

    private static final int MAX_SIZE = 6;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private TabLayout mTabLayout;
    private SlideViewPager mViewPager;

    private FragmentTabWrapper wrapper = new FragmentTabWrapper();


    @NonNull
    public View getView(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_pager_fragment, null);
        mViewPager = v.findViewById(R.id.viewPager);
        mTabLayout = v.findViewById(R.id.tabLayout);
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(fragmentManager) {

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @NotNull
            @Override
            public Fragment getItem(int a) {
                return mFragmentList.get(a);
            }

            @Override
            public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
                super.destroyItem(container, position, object);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        initFTs(wrapper);
        fixFTs(v.getResources());

        if (wrapper.getFTs().size() == 0) {
            return v;
        }
        int i = 0;
        mFragmentList.clear();
        for (FragmentTabWrapper.FT ft : wrapper.getFTs()) {
            mFragmentList.add(ft.fragment);
            if (++i >= MAX_SIZE) break;
        }
        mAdapter.notifyDataSetChanged();
        setTabStyle();
        int which = wrapper.firstWhich;
        if (which < mFragmentList.size()) {
            mViewPager.setCurrentItem(which, false);
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return v;
    }


    private void fixFTs(@NonNull Resources resources) {
        for (FragmentTabWrapper.FT ft : wrapper.getFTs()) {
            if (ft.isFtUseRes) {
                ft.title = resources.getString(ft.titleRes);
                ft.icon_selected = resources.getDrawable(ft.iconRes_selected, getTheme());
                ft.icon_unselected = resources.getDrawable(ft.iconRes_unselected, getTheme());
            }
        }

        if (wrapper.isColorUseRes) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                wrapper.color_selected = resources.getColor(wrapper.colorRes_selected, getTheme());
                wrapper.color_unselected = resources.getColor(wrapper.colorRes_unselected, getTheme());
            } else {
                wrapper.color_selected = resources.getColor(wrapper.colorRes_selected);
                wrapper.color_unselected = resources.getColor(wrapper.colorRes_unselected);
            }
        }

    }

    @Nullable
    protected Resources.Theme getTheme() {
        return null;
    }

    /**
     * @param wrapper wrapper of FT.
     */
    protected abstract void initFTs(@NonNull FragmentTabWrapper wrapper);

    @Nullable
    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    @Nullable
    public SlideViewPager getViewPager() {
        return mViewPager;
    }

    public void clear() {
        mFragmentList.clear();
        wrapper.clear();
        mTabLayout = null;
        mViewPager = null;
    }


    private void setTabStyle() {
        final TabStyle tabStyle = getTabStyle();
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab == null) continue;
            tabStyle.setCustomView(tab);
            if (tab.isSelected()) {
                tabStyle.setTabSelected(tab);
            } else {
                tabStyle.setTabUnselected(tab);
            }
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == null) return;
                tabStyle.setTabSelected(tab);
                mViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == null) return;
                tabStyle.setTabUnselected(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab == null) return;
                tabStyle.setTabReselected(tab);
            }
        });
    }

    @NonNull
    protected TabStyle getTabStyle() {
        return new DefaultTabStyle();
    }


    public interface TabStyle {
        void setCustomView(@NonNull TabLayout.Tab tab);

        void setTabSelected(@NonNull TabLayout.Tab tab);

        void setTabUnselected(@NonNull TabLayout.Tab tab);

        void setTabReselected(@NonNull TabLayout.Tab tab);
    }

    public class DefaultTabStyle implements TabStyle {

        private final SparseArray<ImageView> imgs = new SparseArray<>();
        private final SparseArray<TextView> txts = new SparseArray<>();

        @Override
        public void setCustomView(@NonNull TabLayout.Tab tab) {
            int p = tab.getPosition();
            View customView = tab.setCustomView(R.layout.layout_tab).getCustomView();
            if (customView == null) return;
            TextView tv_tab = customView.findViewById(R.id.tv_tab);
            tv_tab.setText(wrapper.getFTs().get(p).title);
            ImageView img_tab = customView.findViewById(R.id.img_tab);
            imgs.put(p, img_tab);
            txts.put(p, tv_tab);
        }

        @Override
        public void setTabSelected(@NonNull TabLayout.Tab tab) {
            int p = tab.getPosition();
            imgs.get(p).setImageDrawable(wrapper.getFTs().get(p).icon_selected);
            txts.get(p).setTextColor(wrapper.color_selected);
        }

        @Override
        public void setTabUnselected(@NonNull TabLayout.Tab tab) {
            int p = tab.getPosition();
            imgs.get(p).setImageDrawable(wrapper.getFTs().get(p).icon_unselected);
            txts.get(p).setTextColor(wrapper.color_unselected);
        }

        @Override
        public void setTabReselected(@NonNull TabLayout.Tab tab) {

        }
    }
}

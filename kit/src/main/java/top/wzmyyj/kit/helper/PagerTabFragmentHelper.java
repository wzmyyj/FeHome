package top.wzmyyj.kit.helper;

import android.annotation.SuppressLint;
import android.content.Context;
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
        View v = LayoutInflater.from(context).inflate(R.layout.activity_pager_fragment, null);
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

    /**
     * @param wrapper wrapper of FT.
     */
    protected abstract void initFTs(FragmentTabWrapper wrapper);

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
        return new TabStyle();
    }

    public class TabStyle {

        protected final SparseArray<ImageView> imgs = new SparseArray<>();
        protected final SparseArray<TextView> txts = new SparseArray<>();

        protected void setCustomView(@NonNull TabLayout.Tab tab) {
            int p = tab.getPosition();
            View customView = tab.setCustomView(R.layout.layout_tab).getCustomView();
            if (customView == null) return;
            TextView tv_tab = customView.findViewById(R.id.tv_tab);
            tv_tab.setText(wrapper.getFTs().get(p).title);
            ImageView img_tab = customView.findViewById(R.id.img_tab);
            imgs.put(p, img_tab);
            txts.put(p, tv_tab);
        }

        protected void setTabSelected(@NonNull TabLayout.Tab tab) {
            int p = tab.getPosition();
            setImageResource(imgs.get(p), wrapper.getFTs().get(p).icon_selected);
            setTextColor(txts.get(p), wrapper.text_color_selected);
        }

        protected void setTabUnselected(@NonNull TabLayout.Tab tab) {
            int p = tab.getPosition();
            setImageResource(imgs.get(p), wrapper.getFTs().get(p).icon_unselected);
            setTextColor(txts.get(p), wrapper.text_color_unselected);
        }

        protected void setTabReselected(@NonNull TabLayout.Tab tab) {

        }

        @SuppressLint("NewApi")
        private void setTextColor(@NonNull TextView textView, int colorRes) {
            int color = textView.getContext().getResources().getColor(colorRes, null);
            textView.setTextColor(color);
        }

        private void setImageResource(@NonNull ImageView imageView, int imageRes) {
            imageView.setImageResource(imageRes);

        }
    }
}

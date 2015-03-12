package net.fengg.app.tabsliding.sample;

import net.fengg.app.tabsliding.sample.R;
import net.fengg.app.tabsliding.sample.fragment.FragmentFirst;
import net.fengg.app.tabsliding.sample.fragment.FragmentFour;
import net.fengg.app.tabsliding.sample.fragment.FragmentSecond;
import net.fengg.app.tabsliding.sample.fragment.FragmentThird;
import net.fengg.lib.tabsliding.TabSlidingView;
import net.fengg.lib.tabsliding.ContentItem;
import net.fengg.lib.tabsliding.TabSlidingView.TabContentProvider;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity {

	private FragmentFirst fragmentFirst;
	private FragmentSecond fragmentSecond;
	private FragmentThird fragmentThird;
	private FragmentFour fragmentFour;
	
	private TabSlidingView tabs;

	private DisplayMetrics dm;
	
	private MyPagerAdapter adapter;
	
	private ViewPager pager;
	
	private final int mImageViewArray[] = { R.drawable.tab_home,R.drawable.tab_convenience, R.drawable.tab_rentalhouse, R.drawable.tab_my};
	
	private final String[] titles = { "主页","省钱", "便民", "圈子"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.activity_main);
		dm = getResources().getDisplayMetrics();
		tabs = (TabSlidingView) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter=new MyPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		setTabsValue();
	}

	private void setTabsValue() {
		// 设置Tab是自动填充满屏幕的
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的
//		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 2, dm));
		// 设置Tab标题文字的大小
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 15, dm));
		// 设置Tab Indicator的颜色
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		tabs.setUnderlineColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
//		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		tabs.setTabBackground(0);
		tabs.setTitileIconDirection(LinearLayout.VERTICAL);
		tabs.setIconAbove(true);
		//设置指示在上部
		tabs.setIndicatorBelow(true);

	}

	public class MyPagerAdapter extends FragmentPagerAdapter implements TabContentProvider{

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if (fragmentFirst == null) {
					fragmentFirst = new FragmentFirst();
				}
				return fragmentFirst;
			case 1:
				if (fragmentSecond == null) {
					fragmentSecond = new FragmentSecond();
				}
				return fragmentSecond;
			case 2:
				if (fragmentThird == null) {
					fragmentThird = new FragmentThird();
				}
				return fragmentThird;
			case 3:
				if (fragmentFour == null) {
					fragmentFour = new FragmentFour();
				}
				return fragmentFour;
			default:
				return null;
			}
		}

		@Override
		public ContentItem getTabContent(int position) {
			ContentItem item = new ContentItem();
			item.setTitle(titles[position]);
			item.setIconRes(mImageViewArray[position]);
			return item;
			/*switch (position) {
			case 0:
				return titles[0];
			case 1:
				return titles[1];
			case 2:
				return mImageViewArray[0];
			case 3:
				return mImageViewArray[1];
			default:
				return null;
			}*/
		}
	}
}
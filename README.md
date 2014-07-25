TabSliding
==========


基于 https://github.com/astuetz/PagerSlidingTabStrip <br>
  1、修改了添加tab标题，可以更方便添加图标tab；<br>
  
  
    public class MyPagerAdapter extends FragmentPagerAdapter implements TabContentProvider{
      ......
    @Override
		public Object getTabContent(int position) {
			return mImageViewArray[position];
			/*switch (position) {
			case 0:
				return mImageViewArray[position];
			case 1:
				return titles[position];
			case 2:
				return titles[position];
			case 3:
				return titles[position];
			default:
				return null;
			}*/
		}
		
		}
  
  2、可以设置indicator在tab标题上或者下。

    tabs.setIndicatorBelow(false);

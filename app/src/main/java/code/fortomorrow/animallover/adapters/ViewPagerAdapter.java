package code.fortomorrow.animallover.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import code.fortomorrow.animallover.fragments.ChildFragment2;
import code.fortomorrow.animallover.fragments.ChildFragment3;
import code.fortomorrow.animallover.fragments.WelcomeFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] childFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[]{
                new WelcomeFragment(), //0
                new ChildFragment2(), //1
                new ChildFragment3() //2
        };

    }

    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length; //3 items
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }
}

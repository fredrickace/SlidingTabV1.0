package com.crossappfactory.slidingtab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

/**
 * Created by Fredrick on 20-Jul-16.
 */

public class MyViewAdapter extends FragmentPagerAdapter {


    Context context;
    String[] tabs;
    int[] icons = {R.drawable.ic_account_balance_wallet_black_24dp,R.drawable.ic_date_range_white_24dp,R.drawable.ic_shopping_basket_black_24dp};
    public MyViewAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabs = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentC();
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable drawable = context.getResources().getDrawable(icons[position]);
        drawable.setBounds(0,0,36,36);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
//        return tabs[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}

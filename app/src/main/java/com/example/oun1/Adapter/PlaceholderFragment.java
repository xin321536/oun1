package com.example.oun1.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.oun1.R;

public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION = "section";
    public PlaceholderFragment() {
    }
    public static PlaceholderFragment newInstance(String section) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION, section);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getArguments().getString(ARG_SECTION));
        return rootView;
    }
}
class SectionsPagerAdapter extends FragmentPagerAdapter {
    String[] tabs = {"首页","资讯","直播","我"};
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(tabs[position]);
    }
    @Override
    public int getCount() {
        return tabs.length;
    }
    @Override

    public CharSequence getPageTitle(int position) {

        return tabs[position];

    }


}

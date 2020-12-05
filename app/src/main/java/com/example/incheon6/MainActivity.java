package com.example.incheon6;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Drawable> temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent1 = new Intent(this, SplashActivity.class);
        startActivity(intent1);
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        ImageView imv2 = (ImageView) findViewById(R.id.btn2);
        imv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity2.class);
                startActivity(intent);
            }
        });



        //////////////////////뷰페이저////////////////////////////


        temp = new ArrayList<>();
        temp.add(ContextCompat.getDrawable(this, R.drawable.default_dot));
        temp.add(ContextCompat.getDrawable(this, R.drawable.selected_dot));
        temp.add(ContextCompat.getDrawable(this, R.drawable.tab_selector));

        MainActivity.Adapter a = new MainActivity.Adapter(temp, this);

        ViewPager pager = findViewById(R.id.viewpager1);
        pager.setAdapter(a);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager, true);


        /*
        int dpValue = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        */


        ArrayList<Integer> listImage1 = new ArrayList<>();
        listImage1.add(R.drawable.kidsad6);
        listImage1.add(R.drawable.kidsad4);
        listImage1.add(R.drawable.kidsad5);




        ViewPager viewPager1 = findViewById(R.id.viewpager1);
        MainActivity.FragmentAdapter fragmentAdapter1 = new MainActivity.FragmentAdapter(getSupportFragmentManager());
        viewPager1.setAdapter(fragmentAdapter1);

        /*
        viewPager1.setClipToPadding(false);
        viewPager1.setPadding(margin, 0, margin, 0);
        viewPager1.setPageMargin(margin / 2);
        */
        for (int i = 0; i < listImage1.size(); i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage1.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter1.addItem(imageFragment);
        }
        fragmentAdapter1.notifyDataSetChanged();



    }

    class FragmentAdapter extends FragmentPagerAdapter {

        // ViewPager에 들어갈 Fragment들을 담을 리스트
        private ArrayList<Fragment> fragments = new ArrayList<>();

        // 필수 생성자
        FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        // List에 Fragment를 담을 함수
        void addItem(Fragment fragment) {
            fragments.add(fragment);
        }
    }


    class Adapter extends PagerAdapter {

        Context context;
        List<Drawable> obj;

        Adapter(List<Drawable> res, Context context) {
            obj = res;
            this.context = context;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            View view = null;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.pager_adapter, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageDrawable(obj.get(position));
            container.addView(view);

            return view;

        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return false;
        }


        public int getCount() {
            return obj.size();
        }

    }

}

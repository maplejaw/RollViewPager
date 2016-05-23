package com.jude.rollviewpagerdome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.IconHintView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RollPagerView mRollViewPager;
    private List<String> mList;
    private TestLoopAdapter mTestLoopAdapter;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) this.findViewById(R.id.btn);
        mRollViewPager= (RollPagerView) this.findViewById(R.id.roll_view_pager);



        mList=new ArrayList<>();
        mList.add("http://a.hiphotos.baidu.com/zhidao/pic/item/024f78f0f736afc33199a401b119ebc4b7451238.jpg");
        mList.add("http://dl.bizhi.sogou.com/images/2013/11/26/421428.jpg");
        mList.add("http://c.hiphotos.baidu.com/zhidao/pic/item/5bafa40f4bfbfbedd9cd7d587bf0f736afc31f04.jpg");
        mList.add("http://pic51.nipic.com/file/20141016/18941053_114235006000_2.jpg");


        mRollViewPager.setPlayDelay(1000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(mTestLoopAdapter=new TestLoopAdapter(mRollViewPager));

        mRollViewPager.setHintView(new IconHintView(this,R.drawable.point_focus,R.drawable.point_normal));

        mButton.setOnClickListener(this);
    }



    private class TestLoopAdapter extends LoopPagerAdapter{


        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(container.getContext()).load(mList.get(position)).into(view);
            return view;
        }

        @Override
        public int getRealCount() {
            return mList.size();
        }

    }


    @Override
    public void onClick(View v) {
        mList.clear();
        mList.add("http://img4.imgtn.bdimg.com/it/u=2920262631,1375942661&fm=21&gp=0.jpg");
        mTestLoopAdapter.notifyDataSetChanged();
    }







}

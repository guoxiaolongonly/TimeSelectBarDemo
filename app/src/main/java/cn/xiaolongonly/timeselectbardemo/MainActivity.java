package cn.xiaolongonly.timeselectbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.xiaolongonly.timebarselect.ScalableTimebarView;

public class MainActivity extends AppCompatActivity {
    private ScalableTimebarView mScalableTimebarView;
    private ScalableTimebarView mScalableTimebarView2;
    private TextView tvIndicator;
    private Animation mHideAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScalableTimebarView2 = findViewById(R.id.my_timebar_view2);
        mScalableTimebarView = findViewById(R.id.my_timebar_view);
        tvIndicator = findViewById(R.id.tvIndicator);

        long timebarRightEndPointTime = System.currentTimeMillis();
        long timebarLeftEndPointTime = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            timebarLeftEndPointTime = simpleDateFormat.parse("2018-06-14 00:00:00").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mScalableTimebarView2.initTimebarLengthAndPosition(timebarLeftEndPointTime,
                timebarRightEndPointTime, (timebarLeftEndPointTime + timebarRightEndPointTime) / 2);

        ScalableTimebarView.OnBarMoveListener onBarMoveListener = new ScalableTimebarView.OnBarMoveListener() {
            @Override
            public void onBarMove(long screenLeftTime, long screenRightTime, long currentTime) {
                tvIndicator.setText(simpleDateFormat.format(new Date(currentTime)));
                setHideAnimation(tvIndicator, 1000);
            }

            @Override
            public void OnBarMoveFinish(long screenLeftTime, long screenRightTime, long currentTime) {

            }
        };
        ScalableTimebarView.OnBarScaledListener onBarScaledListener = new ScalableTimebarView.OnBarScaledListener() {
            @Override
            public void onBarScaled(long screenLeftTime, long screenRightTime, long currentTime) {
                tvIndicator.setText(simpleDateFormat.format(new Date(currentTime)));
                setHideAnimation(tvIndicator, 1000);
            }

            @Override
            public void onBarScaleFinish(long screenLeftTime, long screenRightTime, long currentTime) {
            }
        };
        mScalableTimebarView.setOnBarMoveListener(onBarMoveListener);
        mScalableTimebarView.setOnBarScaledListener(onBarScaledListener);
        mScalableTimebarView2.setOnBarMoveListener(onBarMoveListener);
        mScalableTimebarView2.setOnBarScaledListener(onBarScaledListener);
    }

    /**
     * View渐隐动画效果
     */
    public void setHideAnimation(View view, int duration) {
        if (null == view || duration < 0) {
            return;
        }

        if (null != mHideAnimation) {
            mHideAnimation.cancel();
        }
        // 监听动画结束的操作
        mHideAnimation = new AlphaAnimation(1.0f, 0.0f);
        mHideAnimation.setDuration(duration);
        mHideAnimation.setFillAfter(true);
        view.startAnimation(mHideAnimation);
    }
}

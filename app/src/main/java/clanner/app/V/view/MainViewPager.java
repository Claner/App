package clanner.app.V.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Clanner on 2016/7/16.
 */
public class MainViewPager extends ViewPager{
    private boolean isPagingEnable = true;

    public MainViewPager(Context context){
        super(context);
    }

    public MainViewPager(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.isPagingEnable && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return this.isPagingEnable && super.onInterceptHoverEvent(event);
    }

    public void setPagingEnable(boolean pagingEnable) {
        this.isPagingEnable = pagingEnable;
    }
}

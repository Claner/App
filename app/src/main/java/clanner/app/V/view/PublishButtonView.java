package clanner.app.V.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageButton;

import clanner.app.V.R;

/**
 * Created by Clanner on 2016/7/17.
 */
public class PublishButtonView extends ImageButton{
    //要显示的文字
    private String text = "App";
    //文字的颜色
    private int color;

    public PublishButtonView(Context context) {
        this(context,null);
    }

    public PublishButtonView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PublishButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PublishButtonView);
        text = array.getString(0);
        array.recycle();
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 有时间来接着写，不行就粗暴解决...
         * 先粗暴解决...
         * 之后再想办法换自定义view
         */
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

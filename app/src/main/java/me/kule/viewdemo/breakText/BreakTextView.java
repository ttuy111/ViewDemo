package me.kule.viewdemo.breakText;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import me.kule.viewdemo.Utils;

/**
 * Created by KuLe on 2018/7/17.
 * Email: 783051@qq.com
 */

public class BreakTextView extends View {


    private static final float PADDING = Utils.dp2Px(40);
    private static final float TEXT_SIZE = Utils.dp2Px(16);
    private static final int IMAGE_WIDTH = (int) Utils.dp2Px(150);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    TextPaint textPaint = new TextPaint(paint);
    StaticLayout staticLayout;
    public BreakTextView(Context context) {
        super(context);
    }

    public BreakTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BreakTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    {
        paint.setTextSize(TEXT_SIZE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

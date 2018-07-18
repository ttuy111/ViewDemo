package me.kule.viewdemo.speed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import me.kule.viewdemo.Utils;

/**
 * Created by KuLe on 2018/7/17.
 * Email: 783051@qq.com
 */

public class SpeedView extends View {

    private static final float PADDING = Utils.dp2Px(40);

    private static final float ANGLE = 120;
    private static final float DASH_WIDTH = Utils.dp2Px(1);
    private static final float DASH_HEIGH = Utils.dp2Px(5);
    private static final String TAG = "qq";
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path dash = new Path();
    PathEffect pathEffect;
    PathMeasure pathMeasure = new PathMeasure();
    Path path = new Path();
    private int num = 20;
    private double pointX, pointY;

    public SpeedView(Context context) {
        super(context);
    }

    public SpeedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SpeedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2Px(2));
        dash.addRect(0, 0, DASH_WIDTH, DASH_HEIGH, Path.Direction.CW);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2Px(2));
        dash.reset();
        dash.addRect(0, 0, DASH_WIDTH, DASH_HEIGH, Path.Direction.CW);
        float radius = Math.min(getWidth(), getHeight()) / 2 - PADDING;
        canvas.drawArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius,
                getHeight() / 2 + radius, 90 + ANGLE / 2, 360 - ANGLE, false, paint);
        path.addArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius,
                getHeight() / 2 + radius, 90 + ANGLE / 2, 360 - ANGLE);
        pathMeasure.setPath(path, false);

        pathEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - DASH_WIDTH) / num, 0, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(pathEffect);
        canvas.drawArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius,
                getHeight() / 2 + radius, 90 + ANGLE / 2, 360 - ANGLE, false, paint);

        dash.addRect(0, 0, DASH_WIDTH * 2, DASH_HEIGH * 2, Path.Direction.CW);
        pathEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - (DASH_WIDTH * 2)) / 4, 0, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(pathEffect);
        canvas.drawArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius,
                getHeight() / 2 + radius, 90 + ANGLE / 2, 360 - ANGLE, false, paint);
        paint.setPathEffect(null);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Utils.dp2Px(8), paint);
        paint.setColor(Color.BLACK);
        float angle = getAngle();
        if (angle > 180 && angle < 270) {
            float v = angle - 180;
            double v3 = Math.toRadians(v);
            double v1 = radius / 2 * Math.sin(v3);
            double v2 = radius / 2 * Math.cos(v3);
            pointY = (getHeight() / 2) - v1;
            pointX = (getWidth() / 2) - v2;
        } else if (angle > 270 && angle < 360) {
            float v = angle - 270;
            double v3 = Math.toRadians(v);
            double v1 = radius / 2 * Math.sin(v3);
            double v2 = radius / 2 * Math.cos(v3);
            pointY = (getHeight() / 2) - v2;
            pointX = (getWidth() / 2) +v1;
        } else if (angle > 360) {
            float v = angle - 360;
            double v3 = Math.toRadians(v);
            double v1 = radius / 2 * Math.sin(v3);
            double v2 = radius / 2 * Math.cos(v3);
            pointY = (getHeight() / 2) +v1;
            pointX = (getWidth() / 2) +v2;
        } else {
            float v =  180-angle;
            double v3 = Math.toRadians(v);
            double v1 = radius / 2 * Math.sin(v3);
            double v2 = radius / 2 * Math.cos(v3);
            pointY = (getHeight() / 2) + v1;
            pointX = (getWidth() / 2) - v2;
        }

        canvas.drawLine(getWidth() / 2, getHeight() / 2, (int) pointX, (int) pointY, paint);
    }

    private float getAngle() {

        return 90 + ANGLE / 2 + (360 - ANGLE) * value / num;
    }

    float value = 1;

    public void setValue(float value) {
        this.value = value;
        invalidate();
    }
}

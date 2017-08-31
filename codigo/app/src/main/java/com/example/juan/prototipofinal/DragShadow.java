package com.example.juan.prototipofinal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

/**
 * Created by Juan on 28/04/2016.
 */
public class DragShadow extends View.DragShadowBuilder {

    ColorDrawable greybox;

    public DragShadow(View view) {
        super(view);
        greybox= new ColorDrawable(Color.parseColor("#FFCA28"));

    }

    public void onDrawShadow(Canvas canvas)
    {
        greybox.draw(canvas);

    }

    public void onProvideShadowMetrics(Point shadowSize,Point shadowTouchPoint)
    {
        View v = getView();

        int altura= v.getHeight();
        int ancho= v.getWidth();

        greybox.setBounds(0, 0, ancho, altura);
        shadowSize.set(ancho*5,altura*5);
        // con la mitad queda justo en el centro "bajo el dedo"
        shadowTouchPoint.set((int)(ancho/2),(int)(altura/2));
    }

}

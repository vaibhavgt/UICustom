package org.annet.meier.uicustom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

	private Paint marginPaint;
	private Paint linePaint;
	private int papercolor;
	private float margin;
	private float gap;

	public MyTextView(Context context) {
		super(context);
		init();
	}

	public MyTextView(Context context, AttributeSet ats, int ds) {
		super(context, ats, ds);
		init();
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		Resources myRes = getResources();

		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setStrokeWidth(20);
		marginPaint.setColor(myRes.getColor(R.color.notepad_margin));

		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(myRes.getColor(R.color.notepad_line));

		papercolor = myRes.getColor(R.color.notepad_paper);

		margin = myRes.getDimension(R.dimen.n_margin);
		gap = myRes.getDimension(R.dimen.gap);

	}

	public void onDraw(Canvas canvas) {

		canvas.drawColor(papercolor);

		canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
		canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(),
				getMeasuredHeight(), linePaint);
		
			canvas.drawLine(margin, 0,
					margin , getMeasuredHeight(), marginPaint);
		
		canvas.save();
		canvas.translate(margin, 0);

		super.onDraw(canvas);
		canvas.restore();
	}

}

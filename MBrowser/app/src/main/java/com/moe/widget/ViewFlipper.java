package com.moe.widget;
import android.widget.ViewFlipper;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import com.moe.Mbrowser.R;
import de.greenrobot.event.EventBus;
import com.moe.bean.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import com.moe.fragment.WindowFragment;
import com.moe.webkit.WebViewManagerView;


public class ViewFlipper extends ViewFlipper
{
    
    private ArrayList<OnChangeListener> ocl=new ArrayList<>();
    public ViewFlipper(Context context)
	{
        super(context);
    }

    public ViewFlipper(Context context, AttributeSet attrs)
	{
        super(context, attrs);
    }
	public void registerOnChangeListener(OnChangeListener o)
	{
		ocl.add(o);
	}
	public void unRegisterOnChangeListener(OnChangeListener o){
		ocl.remove(o);
	}
    @Override
    public void addView(View child, int index)
    {
		super.addView(child, index);
          Iterator<OnChangeListener> i=ocl.iterator();
		  while(i.hasNext())
            i.next().onAdd((WebViewManagerView)child, index);
    }

    @Override
    public void removeViewAt(int index)
    {
		((WebViewManagerView)getChildAt(index)).destroy();
		super.removeViewAt(index);
		System.gc();
		Iterator<OnChangeListener> i=ocl.iterator();
		while(i.hasNext())
            i.next().onRemove(index);
        if (getChildCount() == 0){
            EventBus.getDefault().post(new WindowEvent(WindowEvent.WHAT_NEW_WINDOW));
			EventBus.getDefault().post(WindowFragment.CLOSE);}
    }

	

    @Override
    public void setDisplayedChild(int whichChild)
    {
        Iterator<OnChangeListener> i=ocl.iterator();
		while(i.hasNext())
            i.next().onToggle(whichChild);
        super.setDisplayedChild(whichChild);
    }
    public abstract interface OnChangeListener
	{
        void onAdd(WebViewManagerView vf, int index);
        void onRemove(int index);
        void onToggle(int index);
    }
}

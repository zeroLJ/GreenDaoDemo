package zero.com.utillib.Activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import zero.com.utillib.R;

/**
 * 只可控制toolbar
 */
public class BaseToolbarActivity extends BaseActivity {
    private Toolbar mToolbar;
    private ToolBarHelper mToolBarHelper;
    protected TextView top_left_tv, top_center_tv, top_right_tv;
    @Override
    protected void initView() {
        super.initView();
        setToolBar(layoutResID);
    }

    protected void setToolBar(int mLayoutResID) {
        mToolBarHelper = new ToolBarHelper(this, mLayoutResID);
        mToolbar = mToolBarHelper.getToolBar();
        setContentView(mToolBarHelper.getContentView());
        /*把 toolbar 设置到Activity 中*/
        setSupportActionBar(mToolbar);
         /*自定义的一些操作*/
        onCreateCustomToolBar(mToolbar);
    }

    protected void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(0, 0);
        getLayoutInflater().inflate(R.layout.toobar_default_style, toolbar);
        toolbar.setNavigationIcon(null);
        top_left_tv = (TextView) toolbar.findViewById(R.id.left_tv);
        top_right_tv = (TextView) toolbar.findViewById(R.id.right_tv);
        top_center_tv = (TextView) toolbar.findViewById(R.id.center_tv);
        top_center_tv.setText(getString(R.string.app_name));
    }

    protected void setReturnEnable(boolean enable){
        if (enable){
            top_left_tv.setText("返回");
            top_left_tv.setVisibility(View.VISIBLE);
            top_left_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            top_left_tv.setVisibility(View.GONE);
        }
    }
}

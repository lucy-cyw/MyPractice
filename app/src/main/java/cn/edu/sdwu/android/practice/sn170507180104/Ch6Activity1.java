package cn.edu.sdwu.android.practice.sn170507180104;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Ch6Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch6_1);

//在Java中获取字符串资源
        String content=getString(R.string.ok);
        Log.i(Ch6Activity1.this.toString(),content);

        String sms=getString(R.string.sms);
        sms=String.format(sms,100,"张三");
        Log.i(Ch6Activity1.this.toString(),sms);

        //获取数组资源
        Resources resources=getResources();
        //整形数组
        int[] intArr=resources.getIntArray(R.array.intArr);
        for(int i=0;i<intArr.length;i++){
            Log.i(Ch6Activity1.this.toString(),intArr[i]+"");
        }
        //字符串数组
        String[] strArr=resources.getStringArray(R.array.strArr);
        for(int i=0;i<strArr.length;i++){
            Log.i(Ch6Activity1.this.toString(),strArr[i]);
        }

        //普通类型数组
        TypedArray typedArray=resources.obtainTypedArray(R.array.commanArr);
        ImageView imageView= (ImageView) findViewById(R.id.ch6_1_iv);
        int resId=typedArray.getResourceId(0,0);
        imageView.setImageResource(resId);
        String str=typedArray.getString(1);
        Log.i(Ch6Activity1.this.toString(),str);

        //注册上下文菜单
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.ch6_1_ll);
        registerForContextMenu(linearLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //加载自定义的菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mymenu_iteml:
                Toast.makeText(this,"itm1",Toast.LENGTH_LONG).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this,"itm2",Toast.LENGTH_LONG).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this,"itm3",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //基于回调的事件处理
        //根据菜单项的ID进行区分
        switch (item.getItemId()){
            case R.id.mymenu_iteml:
                Toast.makeText(this,"itm1",Toast.LENGTH_LONG).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this,"itm2",Toast.LENGTH_LONG).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this,"itm3",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载自定义的菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
        return true;
    }
}
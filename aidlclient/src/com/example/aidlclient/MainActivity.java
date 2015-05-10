package com.example.aidlclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 客户端调用AIDL服务
 * @author miaowei
 *
 */
public class MainActivity extends Activity implements OnClickListener{

	private  IMyService myService = null ;  
	private Button btn;
//  创建ServiceConnection对象   
    private  ServiceConnection serviceConnection = new  ServiceConnection()  
    {  
        @Override   
        public  void  onServiceConnected(ComponentName name, IBinder service)  
        {  
            // 获得AIDL服务对象   
            myService = IMyService.Stub.asInterface(service);  
            try   
            {  
                //  调用AIDL服务对象中的getValue方法，并以对话框中显示该方法的返回值   
                new  AlertDialog.Builder(MainActivity.this ).setMessage(  
                        myService.getValue()).setPositiveButton("确定" , null )  
                        .show();  
            }  
            catch  (Exception e)  
            {  
            }  
        }  
        @Override   
        public  void  onServiceDisconnected(ComponentName name)  
        {  
        	serviceConnection = null;
        }  
    };  
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.btnAidl);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
	//  绑定AIDL服务   
        bindService(new  Intent("com.example.aidlservice.IMyService" ),  
                serviceConnection, Context.BIND_AUTO_CREATE);  
	}

}

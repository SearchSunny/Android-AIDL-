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
 * �ͻ��˵���AIDL����
 * @author miaowei
 *
 */
public class MainActivity extends Activity implements OnClickListener{

	private  IMyService myService = null ;  
	private Button btn;
//  ����ServiceConnection����   
    private  ServiceConnection serviceConnection = new  ServiceConnection()  
    {  
        @Override   
        public  void  onServiceConnected(ComponentName name, IBinder service)  
        {  
            // ���AIDL�������   
            myService = IMyService.Stub.asInterface(service);  
            try   
            {  
                //  ����AIDL��������е�getValue���������ԶԻ�������ʾ�÷����ķ���ֵ   
                new  AlertDialog.Builder(MainActivity.this ).setMessage(  
                        myService.getValue()).setPositiveButton("ȷ��" , null )  
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
		
	//  ��AIDL����   
        bindService(new  Intent("com.example.aidlservice.IMyService" ),  
                serviceConnection, Context.BIND_AUTO_CREATE);  
	}

}

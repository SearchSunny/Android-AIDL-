package com.example.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service{

	
	 //  IMyService.Stub���Ǹ���IMyService.aidl�ļ����ɵ��࣬�����а����˽ӿڷ�����getValue�� 
	private class MyServiceImpl extends IMyService.Stub{

		@Override
		public String getValue() throws RemoteException {
			
			return  "��AIDL�����õ�ֵ." ; 
		}
		
		
		
	}
	@Override
	public IBinder onBind(Intent intent) {
		
	//  �÷������뷵��MyServiceImpl��Ķ���ʵ��   
        return  new  MyServiceImpl();  
	}

}

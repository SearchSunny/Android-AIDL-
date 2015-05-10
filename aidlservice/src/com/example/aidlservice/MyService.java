package com.example.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service{

	
	 //  IMyService.Stub类是根据IMyService.aidl文件生成的类，该类中包含了接口方法（getValue） 
	private class MyServiceImpl extends IMyService.Stub{

		@Override
		public String getValue() throws RemoteException {
			
			return  "从AIDL服务获得的值." ; 
		}
		
		
		
	}
	@Override
	public IBinder onBind(Intent intent) {
		
	//  该方法必须返回MyServiceImpl类的对象实例   
        return  new  MyServiceImpl();  
	}

}

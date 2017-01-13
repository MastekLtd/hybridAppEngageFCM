package com.plugin.appengage;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mastek.appengage.MA;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class AppEngageAnalytics extends CordovaPlugin  {

	private static final String TAG =AppEngageAnalytics.class.getSimpleName() ;
	private final String LINE_SEPARATOR = "\n";
	private Context context;
	private String currentUrl;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		// TODO Auto-generated method stub
		context=this.cordova.getActivity().getApplicationContext();

		Log.e("", "action :- " + action + "args :- " + args);
		if (action.equalsIgnoreCase("send")) {

			Log.e("action", "send action");
			MA.sendApi(context);
//			Application.class.t
			return true;
		} else if (action.equalsIgnoreCase("event")) {
			Log.e("action", "event action");
			String key = args.getString(0);

			JSONObject prop = new JSONObject();

			if(!(args.length()%2==0)){
				try {
					for(int i=1; i<args.length(); i=i+2){
						prop.put(args.getString(i),args.getString(i+1));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Log.e(TAG, "key: "+key );
			Log.e(TAG, "prop: "+prop );
			MA.eventApi(key, prop);
			return true;
		} else if (action.equalsIgnoreCase("end")) {
			Log.e("action", "end action");
			Log.e("action",args.getString(0));
			MA.endApi(context);

			return true;
		} else if (action.equalsIgnoreCase("backbutton")) {



		} else if (action.equalsIgnoreCase("crash")) {
			Log.e("action", "crash action");
			Toast.makeText(context,"CRASH",Toast.LENGTH_SHORT).show();
			int j=1/0;

			return true;
		}
		else if(action.equalsIgnoreCase("my")){
			Log.e("action", "my");
			Log.e(TAG, "execute: "+args.length());
			Log.e("Args ",args.getString(1));
			return true;
		} else if(action.equalsIgnoreCase("startScreen")){

			Log.e("Start Screen","Start Screen");
			MA.startFragmentScreen("Start Screen name");


			return true;
		}else if(action.equalsIgnoreCase("endScreen")){
			Log.e("end Screen","end Screen");
			Log.e(TAG, "execute: "+args.length());
			String s=args.getString(0);
			Log.e(TAG, "execute:End "+s );
			MA.endFragmentScreen(s);
			return true;
		}

		return super.execute(action, args, callbackContext);
	}

	@Override
	public void onPause(boolean multitasking) {
		super.onPause(multitasking);
		MA.activityTimeTrackingApi(context);
		MA.endApi(context);
	}

	@Override
	public void onResume(boolean multitasking) {
		super.onResume(multitasking);
		MA.beginApi(context);
	}



}

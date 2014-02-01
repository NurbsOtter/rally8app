package com.rally8.rally8droid;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.*;
import java.util.List;
import java.util.ArrayList;
import org.apache.http.message.*;
import org.apache.http.client.entity.*;
import org.apache.http.util.*;
public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	public void gotoLogin(View view)
	{
		setContentView(R.layout.login);
	}
	public void doLogin(View view)
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost("www.rally8.com/login");
		EditText userName=(EditText)findViewById(R.id.userName);
		EditText password = (EditText)findViewById(R.id.password);
		try
		{
			List<NameValuePair> data = new ArrayList<NameValuePair>();
			String userNameText = userName.getText().toString();
			data.add(new BasicNameValuePair("username",userNameText));
			data.add(new BasicNameValuePair("password",password.getText().toString()));
			post.setEntity(new UrlEncodedFormEntity(data));
			HttpResponse res = httpClient.execute(post);
			userName.setText(EntityUtils.toString(res.getEntity()));
			
		}
		catch(Exception e)
		{
			
		}
	}
}

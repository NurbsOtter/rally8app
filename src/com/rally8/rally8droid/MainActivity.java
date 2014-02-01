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
		EditText userName=(EditText)findViewById(R.id.userName);
		EditText password=(EditText)findViewById(R.id.password);
		LoginHandlerAsync loginTask = new LoginHandlerAsync();
		loginTask.execute(new String[] {userName.getText().toString(),password.getText().toString()});
	}
	private class LoginHandlerAsync extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... p1)
		{
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://www.rally8.com/login");
			
			try
			{
				List<NameValuePair> data = new ArrayList<NameValuePair>();
				data.add(new BasicNameValuePair("username",p1[0]));
				data.add(new BasicNameValuePair("password",p1[1]));
				post.setEntity(new UrlEncodedFormEntity(data));
				HttpResponse res = httpClient.execute(post);
				return EntityUtils.toString(res.getEntity());
			}
			catch(Exception e)
			{
				return "Oh god!";
			}
		}

	}
	@Override
	protected void onPostExecute(String result)
	{
		EditText userName=(EditText)findViewById(R.id.userName);
		userName.setText(result);
	}
	
}


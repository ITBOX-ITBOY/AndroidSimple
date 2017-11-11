package com.example.app08;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NetworkActivity extends Activity {

	private EditText et_network_url;
	private EditText et_network_result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);

		et_network_url = (EditText) findViewById(R.id.et_network_url);
		et_network_result = (EditText) findViewById(R.id.et_network_result);
	}

	public void testConnectionGet(View v) {
		final ProgressDialog progressDialog = ProgressDialog.show(this, null, "�����С�������");

		new Thread() {
			public void run() {
				String path = et_network_url.getText().toString() + "?name=Tom&age=34";

				try {
					URL url = new URL(path);
					HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
					openConnection.setRequestMethod("GET");
					openConnection.setConnectTimeout(5000);
					openConnection.setReadTimeout(6000);
					openConnection.connect();

					int resultCode = openConnection.getResponseCode();

					if (resultCode == 200) {
						InputStream inputStream = openConnection.getInputStream();

						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = -1;
						while ((len = inputStream.read(buffer)) != -1) {
							byteArrayOutputStream.write(buffer, 0, len);
						}
						final String result = byteArrayOutputStream.toString();

						byteArrayOutputStream.close();
						inputStream.close();

						runOnUiThread(new Runnable() {
							public void run() {
								et_network_result.setText(result);
								progressDialog.dismiss();
							}
						});
					}
					// �������ӶϿ�
					openConnection.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();

	}

	/*
	 * ʹ��httpUrlConnection�ύpost����
	 */
	/*
	 * 1. ��ʾProgressDialog 2. �������߳� 3. �ڷ��߳�, ��������, �õ���Ӧ���� 1). �õ�path 2). ����URL����
	 * 3). ������, �õ�HttpURLConnection���� 4). ��������ʽ,���ӳ�ʱ, ��ȡ���ݳ�ʱ 5). ���ӷ����� 6).
	 * ������, �õ���Ӧ���� �õ������, д������:name=Tom1&age=11 �õ���Ӧ��, ������200�Ŷ�ȡ �õ�InputStream,
	 * ����ȡ��String 7). �Ͽ����� 4. �����߳�, ��ʾ�õ��Ľ��, �Ƴ�dialog
	 */
	public void testConnectionPost(View v) {
		final ProgressDialog progressDialog = ProgressDialog.show(this, null, "���ڼ����С�������");

		new Thread() {
			public void run() {
				String path = et_network_url.getText().toString();
				try {
					URL url = new URL(path);
					HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
					openConnection.setRequestMethod("POST");
					openConnection.setConnectTimeout(5000);
					openConnection.setReadTimeout(6000);
					openConnection.connect();

					OutputStream outputStream = openConnection.getOutputStream();
					String data = "name=Tom&age=34";
					outputStream.write(data.getBytes("utf-8"));
					int resultCode = openConnection.getResponseCode();

					if (resultCode == 200) {
						InputStream inputStream = openConnection.getInputStream();

						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = -1;
						while ((len = inputStream.read(buffer)) != -1) {
							byteArrayOutputStream.write(buffer, 0, len);
						}
						final String result = byteArrayOutputStream.toString();

						byteArrayOutputStream.close();
						inputStream.close();

						runOnUiThread(new Runnable() {
							public void run() {
								et_network_result.setText(result);
								progressDialog.dismiss();
							}
						});
					}
					// �������ӶϿ�
					openConnection.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
					progressDialog.dismiss();
				}
			}
		}.start();

	}

	/*
	 * ʹ��httpClient�ύget����
	 */
	public void testClientGet(View v) {
		final ProgressDialog progressDialog = ProgressDialog.show(this, null, "�����С�������");

		new Thread() {
			public void run() {
				String path = et_network_url.getText().toString() + "?name=Tom&age=34";

				try {
					//��ȡhttpClient����
					HttpClient httpClient=new DefaultHttpClient();
					//��������
					HttpParams params = httpClient.getParams();
					HttpConnectionParams.setConnectionTimeout(params, 5000);
					HttpConnectionParams.setSoTimeout(params, 5000);
					//���з�������
					HttpGet httpGet=new HttpGet(path);
					HttpResponse execute = httpClient.execute(httpGet);
					
					int statusCode = execute.getStatusLine().getStatusCode();

					if (statusCode == 200) {
						//��ȡ��Ӧ��ʵ��
						HttpEntity entity=execute.getEntity();
						final String result = EntityUtils.toString(entity);
						
						runOnUiThread(new Runnable() {
							public void run() {
								et_network_result.setText(result);
								progressDialog.dismiss();
							}
						});
					}
					// �������ӶϿ�
					httpClient.getConnectionManager().shutdown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	/*
	 * ʹ��httpClient�ύpost����
	 */
	public void testClientPost(View v) {
		//1. ��ʾProgressDialog
		final ProgressDialog dialog = ProgressDialog.show(this, null, "����������...");
		//2. �������߳�
		new Thread(){
			//3. �ڷ��߳�, ��������, �õ���Ӧ����
			public void run() {
				try {
					//1). �õ�path
					String path = et_network_url.getText().toString();
					
					//2). ����HttpClient����
					HttpClient httpClient = new DefaultHttpClient();
					//3). ���ó�ʱ
					HttpParams params = httpClient.getParams();
					HttpConnectionParams.setConnectionTimeout(params, 5000);
					HttpConnectionParams.setSoTimeout(params, 5000);
					//4). �����������
					HttpPost request = new HttpPost(path);
					//����������
					List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
					parameters.add(new BasicNameValuePair("name", "Tom4"));
					parameters.add(new BasicNameValuePair("age", "14"));
					HttpEntity entity = new UrlEncodedFormEntity(parameters);
					request.setEntity(entity);
					
					//5). ִ���������, �õ���Ӧ����
					HttpResponse response = httpClient.execute(request);
					
					int statusCode = response.getStatusLine().getStatusCode();
					if(statusCode==200) {
						//6). �õ���Ӧ���ı�
						entity = response.getEntity();
						final String result = EntityUtils.toString(entity);
						//4. Ҫ���߳�, ��ʾ����, �Ƴ�dialog
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								et_network_result.setText(result);
								dialog.dismiss();
							}
						});
					}
					//7). �Ͽ�����
					httpClient.getConnectionManager().shutdown();
				} catch (Exception e) {
					e.printStackTrace();
					//��������쳣Ҫ�Ƴ�dialog
					dialog.dismiss();
				}
			}
		}.start();
	}

}

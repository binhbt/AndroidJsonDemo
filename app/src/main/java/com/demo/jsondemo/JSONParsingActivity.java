package com.demo.jsondemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.technotalkative.jsonparsing.R;

import java.io.IOException;
import java.io.InputStream;

public class JSONParsingActivity extends Activity {

    TextView txtJsonObject;
    TextView txtJsonArray;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtJsonObject = (TextView) findViewById(R.id.textView1);
        txtJsonArray = (TextView) findViewById(R.id.textView2);
        parseJSON();

    }

    public void parseJSON() {
        try {
            String objectValue = readDataFromAsset("data_obj.json", this);
            JSONObject jsonObject = new JSONObject(objectValue);
            String strObj = "Ten :"+ jsonObject.getString("name") +"\n Tuoi: "+ jsonObject.getInt("old");
            txtJsonObject.setText(strObj);

            String arrValue = readDataFromAsset("data_array.json", this);
            JSONArray jsonArr = new JSONArray(arrValue);
            String strArr = "Tong so phan tu: "+jsonArr.length();
            for(int i=0; i<jsonArr.length(); i++){
                JSONObject object = jsonArr.getJSONObject(i);
                strArr = strArr+"\n Ten: "+object.getString("name")+"\n Tuoi: "+object.getInt("old");
            }
            txtJsonArray.setText(strArr);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private String readDataFromAsset(String filename, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}


// Actual JSON Value

/*
//JSON Object
	{
        "id": 1,
        "name": "Nguyen van A",
        "old": 30,
      }


//JSON ARRAY
	[
	  {
        "id": 1,
        "name": "Nguyen van A",
        "old": 30,
      }	,
	  {
        "id": 2,
        "name": "Nguyen van B",
        "old": 20,
      },
      {
        "id": 1,
        "name": "Nguyen van C",
        "old": 18,
      }
      ]
 */
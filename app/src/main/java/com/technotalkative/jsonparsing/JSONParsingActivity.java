package com.technotalkative.jsonparsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JSONParsingActivity extends Activity {
    /** Called when the activity is first created. */
	
	TextView txtViewParsedValue;
	private JSONObject jsonObject;
	
	String strParsedValue = null;
	
	private String strJSONValue = "{\"FirstObject\":{\"attr1\":\"one value\" ,\"attr2\":\"two value\","
			+"\"sub\": { \"sub1\":[ {\"sub1_attr\":\"sub1_attr_value\" },{\"sub1_attr\":\"sub2_attr_value\" }]}}}";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtViewParsedValue = (TextView) findViewById(R.id.textView1);
        
        try {
			parseJSON();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void parseJSON() throws JSONException
    {
    	jsonObject = new JSONObject(strJSONValue);
    	
    	JSONObject object = jsonObject.getJSONObject("FirstObject");
    	String attr1 = object.getString("attr1");
    	String attr2 = object.getString("attr2");
    	
    	strParsedValue="Attribute 1 value => "+attr1;
    	strParsedValue+="\n Attribute 2 value => "+attr2;
    	
    	JSONObject subObject = object.getJSONObject("sub");
    	JSONArray subArray = subObject.getJSONArray("sub1");

    	strParsedValue+="\n Array Length => "+subArray.length();
    	
    	for(int i=0; i<subArray.length(); i++)
    	{
    		strParsedValue+="\n"+subArray.getJSONObject(i).getString("sub1_attr").toString();
    	}
    	
    	txtViewParsedValue.setText(strParsedValue);
    }
}


// Actual JSON Value
/*
{"FirstObject": { "attr1":"one value" ,"attr2":"two value",
	
   "sub": { "sub1":[ {"sub1_attr":"sub1_attr_value" },{"sub1_attr":"sub2_attr_value" }]}
  }
"}; */

// Same JSON value in XML
/*
<FirstObject obj1="Object 1 value" obj2="Object 2 value">
	<sub>
	    <sub1 sub1_attr="sub1_attr_value" />
	    <sub1 sub1_attr="sub2_attr_value" />
	</sub>
</FirstObject> */

/*
	[
	  {
        "id": 1,
        "type": "apk",
        "title": "NhacTv ",
        "pakage": "vn.nhac.tv",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/6.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Nhac.png",
		"versionName": "0.6.66",
		"versionCode": "6"
      }	,
	  {
        "id": 1,
        "type": "apk",
        "title": "Karaoke",
        "pakage": "tv.vega.com.vn.karaoketv1",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/2017_04_13__KaraokeTV.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_karaoke1.png",
		"versionName": "1.0",
		"versionCode": "4"
      },
      {
        "id": 0,
        "type": "apk",
        "title": "Zing mp3",
        "pakage": "vng.zing.mp3",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Zing_Mp3AndroidTV_v1.1.3_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_zingpm3.png",
		"versionName": "1.8",
		"versionCode": "11300"
      },
      {
        "id": 1,
        "type": "apk",
        "title": "Nhaccuatui",
        "pakage": "vn.nhaccuatui.tv",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/NhacCuaTui_V_v1.2.6_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_nhaccuatui.png",
		"versionName": "1.0",
		"versionCode": "31"
      },
	  {
        "id": 3,
        "type": "apk",
        "title": "VnExpress",
        "pakage": "com.fo.vnetv",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/VnExpress_Android_TV_v2.7_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_vnexpress.png",
		"versionName": "1.0",
		"versionCode": "29"
      },
	  {
        "id": 1,
        "type": "apk",
        "title": "Zing TV",
        "pakage": "com.zing.tv.androidtv2",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Zing_TV_forAndroid_TV_v2.1.3_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_zingtv.png",
		"versionName": "1.0",
		"versionCode": "21300"
      },
	  {
        "id": 1,
        "type": "apk",
        "title": "Netflix",
        "pakage": "com.netflix.mediaclient",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Netflix_v4.10.7build11183_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Netflix.png",
		"versionName": "1.0",
		"versionCode": "11183"
      },
	  {
        "id": 1,
        "type": "apk",
        "title": "Youtube",
        "pakage": "com.google.android.youtube.tv",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/YouTube_for_Android_TV_v1.3.11_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_youtube.png",
		"versionName": "1.0",
		"versionCode": "10311100"
      },

	  {
        "id": 1,
        "type": "apk",
        "title": "USB",
        "pakage": "com.szpnd.lee.mediacenter",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/mediacenter5_signed.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_usb.png",
		"versionName": "1.0",
		"versionCode": "5"
      },
	  {
        "id": 1,
        "type": "apk",
        "title": "Kiểm tra mạng",
        "pakage": "vn.com.vega.speedtest",
        "url": "http://v2.cdn.clip.vn/tvbox/file/SpeedTest_1.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_speedtest.png",
		"versionName": "1.0",
		"versionCode": "1"
      }
	  ,
	  {
        "id": 1,
        "type": "apk",
        "title": "Google Chrome",
        "pakage": "com.android.chrome",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/com.android.chrome_56.0.2924.87-292408700_minAPI16(armeabi-v7a)(nodpi)_apkmirror.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Chrome_m.png",
		"versionName": "1.0",
		"versionCode": "292408700"
      }
	  ,
	  {
        "id": 1,
        "type": "apk",
        "title": "VTV Go",
        "pakage": "vn.vtv.vtvgotv",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/VTVgo_TV_1.1.16_androidtv_apk-dl.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/VTV-go.png",
		"versionName": "1.0",
		"versionCode": "75"
      }
	  ,
	  {
        "id": 1,
        "type": "apk",
        "title": "HPlus",
        "pakage": "com.hplus",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/hplus-2.3.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Hplus.png",
		"versionName": "1.0",
		"versionCode": "21"
      }
	  ,
	  {
        "id": 1,
        "type": "apk",
        "title": "iFlix",
        "pakage": "iflix.play",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/iflix_v2.18.0-2982_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/iflix_m.png",
		"versionName": "1.0",
		"versionCode": "302182982"
      }

		  ,
	  {
        "id": 1,
        "type": "apk",
        "title": "HDViet",
        "pakage": "com.vnhd.app.phonegap",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/HDVIET-Android-box_4.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/HD-Viet.png",
		"versionName": "1.0",
		"versionCode": "4"
      },
	  {
        "id": 1,
        "type": "apk",
        "title": "Kodi",
        "pakage": "org.xbmc.kodi",
        "url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Kodi-16-1-HieuHien-VN-version-5.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Kodi_m.png",
		"versionName": "1.0",
		"versionCode": "161000"
      } ,
	  {
        "id": 1,
        "type": "apk",
        "title": "Youtube TV",
        "pakage": "com.firsthash.smartyoutubetv2.beta",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/SmartYouTubeTVBeta_v6.5.9_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/YoutubeTV.png",
		"versionName": "1.0",
		"versionCode": "73"
      },
	  {
        "id": 1,
        "type": "apk",
        "title": "Twitch",
        "pakage": "tv.twitch.android.app",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/tv.twitch.android.app_4.2.3_77.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Twitch.png",
		"versionName": "1.0",
		"versionCode": "77"
      }
,
	  {
        "id": 1,
        "type": "apk",
        "title": "TalkTv",
        "pakage": "vn.com.vng.talktv",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/TalkTV_v3.1.6_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/TalkTV.png",
		"versionName": "1.0",
		"versionCode": "329"
      }

	  ,


	  {
        "id": 1,
        "type": "apk",
        "title": "Facebook",
        "pakage": "com.facebook.katana",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Facebook_v122.0.0.17.71_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Facebook.png",
		"versionName": "122.0.0.17.71",
		"versionCode": "56891644"
      }
  ,

	  {
        "id": 1,
        "type": "apk",
        "title": "Skype",
        "pakage": "com.skype.raider",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/SkypefreeIMvideocalls_v7.44.0.223_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Skype.png",
		"versionName": "7.44.0.223",
		"versionCode": "120324319"
      }
 ,
	  {
        "id": 1,
        "type": "apk",
        "title": "FTP Play",
        "pakage": "net.fptplay.ottbox",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/fpt-play-for-android-tv-2-2-8-apkplz.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/fpt-play-androidbox.png",
		"versionName": "2.2.8",
		"versionCode": "1031"
      }
,
	  {
        "id": 1,
        "type": "apk",
        "title": "OpenVPN for Android",
        "pakage": "de.blinkt.openvpn",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/OpenVPNforAndroid_v0.6.66_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/openvpn-for-android_icon.png",
		"versionName": "0.6.66",
		"versionCode": "147"
      }
,
	  {
        "id": 1,
        "type": "apk",
        "title": "AirPin",
        "pakage": "com.waxrain.airplaydmr",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/AirPin_MINIX_v3.3.3.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/Airpin-pro.png",
		"versionName": "0.6.66",
		"versionCode": "333"
      }
 ,

	  {
        "id": 1,
        "type": "apk",
        "title": "CCleaner ",
        "pakage": "com.cleanmaster.mguard",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/com.cleanmaster.mguard_v5.17.9-51795722_Android-5.0.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/CleanMaster.png",
		"versionName": "0.6.66",
		"versionCode": "51795722"
      }
 ,

	  {
        "id": 1,
        "type": "apk",
        "title": "THVL ",
        "pakage": "vn.thvl.app",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/THVL_v2.3.0_apkpure.com.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/THVLi.png",
		"versionName": "0.6.66",
		"versionCode": "100100"
      }
 ,

	  {
        "id": 1,
        "type": "apk",
        "title": "Chalk Fighter",
        "pakage": "com.game.plane",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Chalk Fighter.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_Chalk_Fighter.png",
		"versionName": "0.6.66",
		"versionCode": "1"
      }
    ]

 */
/*
	  {
        "id": 1,
        "type": "apk",
        "title": "Chalk Fighter",
        "pakage": "com.game.plane",
		"url": "http://v2.cdn.clip.vn/tvbox/file/other_apk/Chalk Fighter.apk",
		"thumb": "http://v2.cdn.clip.vn/tvbox/file/img/ic_Chalk_Fighter.png",
		"versionName": "0.6.66",
		"versionCode": "1"
      }
 */
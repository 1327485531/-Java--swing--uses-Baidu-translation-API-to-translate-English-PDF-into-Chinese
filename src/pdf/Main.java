package pdf;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import fan.TransApi;
import fan.fanbean;

public class Main {

    // 鍦ㄥ钩鍙扮敵璇风殑APP_ID 璇﹁ http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        fanbean data=null;
        String query = "apple";
        //  System.out.println(api.getTransResult(query, "auto", "en"));
          
for(int i=0;i<=1;i++){
        
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //1000 姣鏉冿紝涔熷氨鏄�1绉�.
	String json = api.getTransResult(query, "auto", "zh");
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(json);
        com.alibaba.fastjson.JSONArray array =  jsonObject.getJSONArray("trans_result"); 

        System.out.println(array);
//鈥斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺��
//鐗堟潈澹版槑锛氭湰鏂囦负CSDN鍗氫富銆孒iCodd銆嶇殑鍘熷垱鏂囩珷锛岄伒寰狢C 4.0 BY-SA鐗堟潈鍗忚锛岃浆杞借闄勪笂鍘熸枃鍑哄閾炬帴鍙婃湰澹版槑銆�
//鍘熸枃閾炬帴锛歨ttps://blog.csdn.net/HookJony/article/details/77720719
        //System.out.println(re.getTrans_result());
}
    }

}

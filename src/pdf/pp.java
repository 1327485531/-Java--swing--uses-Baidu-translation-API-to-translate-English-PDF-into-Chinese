package pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;

import fan.TransApi;
import fan.fanbean;

public class pp{
	private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";
	 public static  void readPDF(String fileName) {
	        File file = new File(fileName);
	        FileInputStream in = null;
	        try {
	            in = new FileInputStream(fileName);
	            // 鏂板缓涓�涓狿DF瑙ｆ瀽鍣ㄥ璞�
	            PDFParser parser = new PDFParser(new RandomAccessFile(file,"rw"));
	            // 瀵筆DF鏂囦欢杩涜瑙ｆ瀽
	            parser.parse();
	            // 鑾峰彇瑙ｆ瀽鍚庡緱鍒扮殑PDF鏂囨。瀵硅薄
	            PDDocument pdfdocument = parser.getPDDocument();
	            // 鏂板缓涓�涓狿DF鏂囨湰鍓ョ鍣�
	            PDFTextStripper stripper = new PDFTextStripper();
	             
	              int pagenumber=pdfdocument.getNumberOfPages();
	              fanbean data=null;
	              for(int ii=1;ii<=pagenumber;ii++){
	            	  stripper.setSortByPosition(true);//WsetSortByPosition(sort); //sort璁剧疆涓簍rue 鍒欐寜鐓ц杩涜璇诲彇锛岄粯璁ゆ槸false
	  	            // 浠嶱DF鏂囨。瀵硅薄涓墺绂绘枃鏈�
	              stripper.setStartPage(ii);
	              stripper.setEndPage(ii);
	            String result = stripper.getText(pdfdocument);
	            
	            //FileWriter fileWriter = new FileWriter(new File("pdf.txt"));
	            //fileWriter.write(result);
	            //fileWriter.flush();
	            //fileWriter.close();
	            System.out.println("PDF鏂囦欢鐨勬枃鏈唴瀹瑰涓嬶細"+result.length()+"椤垫暟"+pagenumber+"dangqian"+ii+"鏈〉瀛楁暟"+result.length());
	            System.out.println(result);
	            try {
	        		Thread.sleep(1000);
	        	} catch (InterruptedException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	} //1000 姣鏉冿紝涔熷氨鏄�1绉�.
	        //    if(result.length()<6400){
	            TransApi api = new TransApi(APP_ID, SECURITY_KEY);

	            String query = "apple";
	          //  System.out.println(api.getTransResult(query, "auto", "en"));
	            String json = api.getTransResult(result, "auto", "zh");

	            //閫氳繃gson瑙ｆ瀽
	            Gson gson = new Gson();
	             data = gson.fromJson(json,fanbean.class);
	          //  String dst = data.getFrom();//getDst();
                for(int i=0;i<data.getTrans_result().size();i++){
	            System.out.println(data.getTrans_result().get(i).getDst());
                } //鐢�70 71澶у皬
	        //    }
	         //   else{
	            //	System.out.println("瀛楁暟澶"+result.length());
	           // }
	            
	              }
	              
	              
	        } catch (Exception e) {
	            System.out.println("璇诲彇PDF鏂囦欢" + file.getAbsolutePath() + "鐢熷け璐ワ紒" + e);
	            e.printStackTrace();
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	    }

	//鈥斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺��
//	鐗堟潈澹版槑锛氭湰鏂囦负CSDN鍗氫富銆屼綘绗戠殑鍍忎竴鏉＄嫍銆嶇殑鍘熷垱鏂囩珷锛岄伒寰狢C 4.0 BY-SA鐗堟潈鍗忚锛岃浆杞借闄勪笂鍘熸枃鍑哄閾炬帴鍙婃湰澹版槑銆�
	//鍘熸枃閾炬帴锛歨ttps://blog.csdn.net/weixin_38361347/article/details/89643568
    /** *//**
     * @param args
     */
	 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	 String fileName = "C:/Users/cc/Desktop/5755-15223-1-PB.pdf";  //杩欓噷鍏堟墜鍔ㄦ妸缁濆璺緞鐨勬枃浠跺す缁欒ˉ涓娿��
         pp pdfUtil = new pp();
         pdfUtil.readPDF(fileName);//(fileName);
         //pdfUtil.closeDocument();
 //鈥斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺�斺��
 //鐗堟潈澹版槑锛氭湰鏂囦负CSDN鍗氫富銆屼綘绗戠殑鍍忎竴鏉＄嫍銆嶇殑鍘熷垱鏂囩珷锛岄伒寰狢C 4.0 BY-SA鐗堟潈鍗忚锛岃浆杞借闄勪笂鍘熸枃鍑哄閾炬帴鍙婃湰澹版槑銆�
 //鍘熸枃閾炬帴锛歨ttps://blog.csdn.net/weixin_38361347/article/details/89643568
    }
}
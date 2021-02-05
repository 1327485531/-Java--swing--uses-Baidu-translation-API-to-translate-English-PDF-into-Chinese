package pdf;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;

import fan.TransApi;
import fan.fanbean;


public class p extends JFrame {
	private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					p frame = new p();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public p() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		JScrollPane js=new JScrollPane(textArea);
		textArea.setLineWrap(true);
		js.setBounds(5, 45, 350, 300);
	//	JScrollPane jsp = new JScrollPane(textArea);
  	 // jsp.setVerticalScrollBarPolicy( 
  			 //JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		textArea.setBounds(89, 37, 268, 215);
		File file = new File("C:/Users/cc/Desktop/25902126.pdf");
        FileInputStream in = null;
        try {
            in = new FileInputStream("C:/Users/cc/Desktop/25902126.pdf");
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
            System.out.println("PDF文件如下"+result.length()+"共几页"+pagenumber+"dangqian"+ii+"当前页共多少字"+result.length());
            System.out.println(result);
            TransApi api = new TransApi(APP_ID, SECURITY_KEY);

            String query = "apple";
          //  System.out.println(api.getTransResult(query, "auto", "en"));
            String json = api.getTransResult(result, "auto", "zh");

            //閫氳繃gson瑙ｆ瀽
            Gson gson = new Gson();
             data = gson.fromJson(json,fanbean.class);
          //  String dst = data.getFrom();//getDst();
             textArea.setBounds(28, 221, 454, 36);
            for(int i=0;i<data.getTrans_result().size();i++){
            System.out.println("0");
            
           // textArea.setText(data.getTrans_result().get(i).getDst());
            textArea.append(data.getTrans_result().get(i).getDst());
          	 
          	 textArea.append("\r\n");
           // jf.getContentPane().add(textArea);
            } //鐢�70 71澶у皬
          
            try {
            	 
        		Thread.sleep(1000);
        	} catch (InterruptedException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} //1000 姣鏉冿紝涔熷氨鏄�1绉�.
              }
              
        } catch (Exception e) {
            System.out.println("报错了" + file.getAbsolutePath() + "错误代码" + e);
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
		contentPane.add(js);
	}

}

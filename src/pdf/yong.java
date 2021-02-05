package pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;

//import shitu.zhuan;








import fan.TransApi;
import fan.fanbean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.Image;
import java.awt.TextField;
import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;



public class yong {
	JFileChooser jfc=new JFileChooser("C:/Users/cc/Desktop");//默认打开桌面
    static JTextArea textArea = new JTextArea();
    
    private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";
    final static javax.swing.JFrame jf = new javax.swing.JFrame();
    public static  void readPDF(String fileName) {
        
    }

	public void showUI(String apii,String keyy){
		//窗体类
		final String id=apii;
		final String key=keyy;
		
		//窗体名称
		jf.setTitle("看图说话");
		//窗体大小（具体值跟电脑显示器的像素有关，可调整到合适大小）
		jf.setSize(536, 405);
		//设置退出进程的方法
		jf.setDefaultCloseOperation(3);
		//设置居中显示用3
		jf.setLocationRelativeTo(null);
		
		//图片，冒号里是你存图片的地址
		String src="img/2.jpg";
		
		javax.swing.ImageIcon icon = new javax.swing.ImageIcon(src);			
		icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));//更改图片大小
		//标签
		final javax.swing.JLabel jla = new javax.swing.JLabel(icon);
		jla.setBounds(360, 10, 150, 200);
		java.awt.Dimension dm0=new java.awt.Dimension(280,200);
		jf.getContentPane().setLayout(null);
		//设置大小
		jla.setPreferredSize(dm0);//应用大小到相应组件
		jf.getContentPane().add(jla);
		java.awt.Dimension dm = new java.awt.Dimension(280, 30);
		
		//按钮
		javax.swing.JButton jbu = new javax.swing.JButton("\u8BC6\u522B\u8FD9\u5F20\u56FE\u7247");
		jbu.setBounds(377, 268, 122, 23);
jf.getContentPane().add(jbu);   //给窗体添加一个按钮对象
		
JScrollPane js=new JScrollPane(textArea);
textArea.setLineWrap(true);
js.setBounds(5, 45, 350, 300);
		textArea.setBounds(28, 221, 454, 43);
		textArea.setText("我是个好人啊。。。"+"您的id为"+id+"您的key为"+key);
		jf.getContentPane().add(js);
		
		final JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(360, 220, 139, 34);
		lblNewLabel.setText("还没选择文件呢");
		jf.getContentPane().add(lblNewLabel);
		
		
		
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 textArea.setText("");
				 lblNewLabel.setText("稍等，我正在转换");
				  jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  //可以选择文件和文件夹

		            int val=jfc.showOpenDialog(null);    //文件打开对话框

//		          int val=fc.showSaveDialog(null); //弹出保存文件对话框。

		            if(val==jfc.APPROVE_OPTION){//判断是否选择文件

		                //正常选择文件

		                ImageIcon im=new ImageIcon(jfc.getSelectedFile().toString());
		             
		                im.setImage(im.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
		              
		                System.out.print(im+"路径");
		                //http();
		                File file = new File(im.toString());
		                FileInputStream in = null;
		                try {
		                    in = new FileInputStream(im.toString());
		                    ////需要绝对路径                                             鏂板缓涓�涓狿DF瑙ｆ瀽鍣ㄥ璞�
		                    PDFParser parser = new PDFParser(new RandomAccessFile(file,"rw"));
		                    //对PDF文件进行解析                                        瀵筆DF鏂囦欢杩涜瑙ｆ瀽
		                    parser.parse();
		                    //获取解析后得到的PDF文档对象                      鑾峰彇瑙ｆ瀽鍚庡緱鍒扮殑PDF鏂囨。瀵硅薄
		                    PDDocument pdfdocument = parser.getPDDocument();
		                    //新建一个PDF文本剥离器                                   鏂板缓涓�涓狿DF鏂囨湰鍓ョ鍣�
		                    PDFTextStripper stripper = new PDFTextStripper();
		                     
		                      int pagenumber=pdfdocument.getNumberOfPages();//获取pdf页数
		                      fanbean data=null;
		                      for(int ii=1;ii<=pagenumber;ii++){
		                    	  stripper.setSortByPosition(true);//WsetSortByPosition(sort); //sort璁剧疆涓簍rue 鍒欐寜鐓ц杩涜璇诲彇锛岄粯璁ゆ槸false
		          	            //从PDF文档对象中剥离文本                          浠嶱DF鏂囨。瀵硅薄涓墺绂绘枃鏈�
		                      stripper.setStartPage(ii);
		                      stripper.setEndPage(ii);
		                    String result = stripper.getText(pdfdocument);
		                    
		                    //FileWriter fileWriter = new FileWriter(new File("pdf.txt"));
		                    //fileWriter.write(result);
		                    //fileWriter.flush();
		                    //fileWriter.close();
		                    System.out.println("PDF文件如下"+result.length()+"共几页"+pagenumber+"dangqian"+ii+"当前页共多少字"+result.length());
		                    System.out.println(result);
		                    textArea.append("\r\n");
		                    textArea.append("PDF文件如下"+result.length()+"，共"+pagenumber+"页，"+"当前是第"+ii+"页，"+"当前页共"+result.length()+"字");
		                    textArea.append("\r\n");
		                    textArea.append(result);
		                    try {
		                		Thread.sleep(3000);
		                	} catch (InterruptedException e) {
		                		// TODO Auto-generated catch block
		                		e.printStackTrace();
		                	} //等一秒，不然翻译api报错，免费版不能太快
		                //    if(result.length()<6400){
		                    TransApi api = new TransApi(id, key);
                              System.out.print(id+"."+key);
		                    String query = "apple";
		                  //  System.out.println(api.getTransResult(query, "auto", "en"));
		                    String json = api.getTransResult(result, "auto", "zh");

		                    //获取翻译
		                    Gson gson = new Gson();
		                     data = gson.fromJson(json,fanbean.class);
		                  
		                    for(int i=0;i<data.getTrans_result().size();i++){
		                    System.out.println("0");
		                    
		                  //  textArea.append(data.getTrans_result().get(i).getDst());
		                    textArea.append(data.getTrans_result().get(i).getDst());
		                    textArea.append("\r\n");
		                    lblNewLabel.setText("转换好啦"+"，共"+ii+"页");
		                   // jf.getContentPane().add(textArea);
		                    } 
		                    
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
		            }else{

		                //未正常选择文件，如选择取消按钮
		            	JOptionPane.showMessageDialog(null, "no choose");
		                textArea.setText("未选择文件");
		                lblNewLabel.setText("你没有选择文件哦");
		                System.out.print(textArea.getText());
		            }
				  
				System.out.print("ccc");
			}
		});
		
		
		jf.setVisible(true);   //设置可见，放在代码最后一句
		
	}

   
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		yong y=new yong();
	//	y.showUI();
		
	}
}

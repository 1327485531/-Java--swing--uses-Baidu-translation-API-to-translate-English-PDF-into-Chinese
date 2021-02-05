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
import java.awt.BorderLayout;
import javax.swing.JButton;



public class o {
	
    final static javax.swing.JFrame jf = new javax.swing.JFrame();
    private static JTextField textField;
    private static JTextField textField_1;
   
        
    

	public void O(){
		//窗体类
		
		//窗体名称
		jf.setTitle("填入您的百度翻译API中提供的id与key");
		//窗体大小（具体值跟电脑显示器的像素有关，可调整到合适大小）
		jf.setSize(460,300);
		//设置居中显示用
		//jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);   //设置可见，放在代码最后一句
		
	}

   
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		jf.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(121, 54, 178, 21);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 105, 178, 21);
		jf.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("APP_ID");
		lblNewLabel.setBounds(28, 57, 70, 15);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SECURITY_KEY");
		lblNewLabel_1.setBounds(28, 108, 83, 15);
		jf.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("确认进入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String id=textField.getText();
			String key=textField_1.getText();
			if(id.trim().length()==0||key.trim().length()==0){
				//trim为去掉空格后的文本
				JOptionPane.showMessageDialog(null, "api或key为空", "错误", JOptionPane.ERROR_MESSAGE);
			}else{
				jf.dispose();
				yong y=new yong();
				y.showUI(id, key);
			}
			}
		});
		btnNewButton.setBounds(158, 192, 93, 23);
		jf.getContentPane().add(btnNewButton);
		
		String st="<html>填入对应的百度翻译api中提供的APP_ID与SECURITY_KEY";
		JLabel lblNewLabel_2 = new JLabel(st);
		lblNewLabel_2.setBounds(309, 10, 115, 141);
		jf.getContentPane().add(lblNewLabel_2);
		// TODO Auto-generated method stub
		o oo=new o();
		oo.O();
	//	y.showUI();
		
	}
}

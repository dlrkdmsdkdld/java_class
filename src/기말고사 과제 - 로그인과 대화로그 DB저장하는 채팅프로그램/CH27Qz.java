import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class User{
	public String uid;
	public String Pwd;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
}

class MessengerA {
	protected JTextField textField;
	protected JTextArea textArea;
	
	ArrayList<User> list = new ArrayList<User>();

	DatagramSocket socket;
	DatagramPacket packet;
	
	InetAddress address =null;
	final int myPort=5000;
	final int yourPort = 6000;
	static int next ;
	static String id="�̰���";
	static String dbName = "msg_db";
	
	Connection con =null;
	
	public MessengerA() throws IOException, SQLException{
		new GUI();
		address = InetAddress.getByName("127.0.0.1");
		socket = new DatagramSocket(myPort);

	}
	
	//begin of DB interface
	public Connection makeConnection() {
		String url = "jdbc:mariadb://localhost:3308/" + dbName;
		String id = "root";
		String password ="1234";
		Connection con = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println(dbName+"�����ͺ��̽� ���� ����");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹�ã��������");
		}catch(SQLException e) {
			System.out.println("�������");
		}
		return con;
	}
	public void saveLog(String log) {
		Connection con = makeConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "INSERT INTO msg_log (msg) VALUES ";
			s += "('"+ log + "')";
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if(i==1)
				System.out.println("���ڵ� �߰� ����");
			else
				System.out.println("���ڵ� �߰� ����");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void listenMessage() {
		while(true) {
			try {
			     byte[] buf = new byte[256];
			     packet = new DatagramPacket(buf,buf.length);
			     socket.receive(packet);//��Ŷ�ޱ�
			     //���� ��Ŷ�� �ؽ�Ʈ ������ ǥ��
			     String yourMsg = new String(buf);
			     textArea.append(yourMsg+"\n");
			     //�޽����� ���̺� ����
			     saveLog(yourMsg);
			}catch(IOException ioException) {
				ioException.printStackTrace();
			}finally {}
		}
	}
	
	public Connection makeLoginConnection() {
		String dbNam="user_db";
		String url = "jdbc:mariadb://localhost:3308/" + dbNam;//�� ���� ��� ��Ʈ�� 3306
		String id = "root";
		String password ="1234";//�� ���� ����� a1s2d3f4
		Connection con = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println(dbName+"�����ͺ��̽� ���� ����");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹�ã��������");
		}catch(SQLException e) {
			System.out.println("�������");
		}
		return con;
	}
	public void savenewIDLog(String log,String password) {
		Connection con = makeLoginConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "INSERT INTO user_table (uid, pwd) VALUES ";
			s += "('"+ log + "', '"+ password+ "')";
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if(i==1)
				System.out.println("���ڵ� �߰� ����");
			else
				System.out.println("���ڵ� �߰� ����");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<User> GetAllUidAndPassword() {
		ArrayList<User> list = new ArrayList<User>();
		Connection con = makeLoginConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "SELECT uid, pwd FROM user_table";
			System.out.println(s);
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()) {
				User buffer=new User();
				buffer.uid=rs.getString("uid");
				buffer.Pwd=rs.getString("pwd");
				list.add(buffer);

			}
			for(int i =0; i<list.size();i++) {
				System.out.println("ȸ�����̵�:"+list.get(i).getUid());
				System.out.println("ȸ���н�����:"+list.get(i).getPwd());
			}
			
					
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	class GUI extends JFrame{
		JButton LoginButton,newIDButton;
		JTextField LoginField ,PasswordFiel;
		public GUI() {
			setSize(500,200);
			setTitle("�α���");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel1=new JPanel();
			panel1.add(new JLabel("-----------------������ �Ϸ��� �̸��ϰ� ����� ġ�� ���Թ�ư�� ��������-----------------"));
			panel1.add(new JLabel("�̸���"));
			LoginField = new JTextField(20);
			panel1.add(LoginField);
			
			panel1.add(new JLabel("��й�ȣ"));
			PasswordFiel = new JTextField(20);
			panel1.add(PasswordFiel);
			
			LoginButton=new JButton("�α���");
			////////////�α��κκ�
			LoginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	                list=GetAllUidAndPassword();//�����ͺ��̽��� �����͵��� �迭�� �� �޾ƿ� 
	                String lBuffer=LoginField.getText();
	                String pBuffer=PasswordFiel.getText();

	                int next=0;
	                for(int i=0; i<list.size();i++) {
	                	//�������� �޾ƿ� ��絥���͸� �ϳ��ϳ� �� ��
	                	if(list.get(i).getUid().equals(lBuffer)&&list.get(i).getPwd().equals(pBuffer)) {
	                		setVisible(false); // â �Ⱥ��̰� �ϱ� 
	                		new MyFrame();
	                		next=1;
	                	}
	                }
	                if(next==0) {//�α��ξȵ�����
	                	JOptionPane.showMessageDialog(null,"���̵�� ����� �ٽ� �Է����ּ���","���",JOptionPane.WARNING_MESSAGE);
	                }
	                
					
	            }
	        });
			panel1.add(LoginButton);
			
			newIDButton=new JButton("�����ϱ�");
			/////////���� �κ�
			newIDButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                setVisible(false); // â �Ⱥ��̰� �ϱ� 
	                ///���ο���� ��� ����
					savenewIDLog(LoginField.getText(),PasswordFiel.getText());

					new MyFrame();
	            }
	        });
			panel1.add(newIDButton);
			
			
			setVisible(true);
			add(panel1);
	}
			
	}
	
	class MyFrame extends JFrame implements ActionListener{
		public MyFrame() {
			super(id);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			textField = new JTextField(30);
			textField.addActionListener(this);
			
			textArea = new JTextArea(10,30);
			textArea.setEditable(false);
			
			add(textField,BorderLayout.PAGE_END);
			add(textArea,BorderLayout.CENTER);
			pack();
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			String myMsg = "[" + id + "] " + textField.getText();
			byte[] buffer = myMsg.getBytes();
			DatagramPacket packet;
			
			//��Ŷ�� ����
			packet = new DatagramPacket(buffer,buffer.length,address,yourPort);
			try {
				socket.send(packet);
			}catch (IOException e) {
				e.printStackTrace();
			}
			textArea.append(myMsg + "\n");
			textField.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
			textField.setText("");
			
			//���̸޽����� ���̺� ����
			saveLog(myMsg);
			myMsg = "";
			
		}
	}
	
	
}


public class CH27Qz {

	public static void main(String[] args) throws IOException,SQLException {
		// TODO Auto-generated method stub
		MessengerA m = new MessengerA();
		m.listenMessage();

	}

}

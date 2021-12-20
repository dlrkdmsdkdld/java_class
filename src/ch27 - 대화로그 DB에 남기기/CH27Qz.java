import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class MessengerA {
	protected JTextField textField;
	protected JTextArea textArea;
	
	DatagramSocket socket;
	DatagramPacket packet;
	
	InetAddress address =null;
	final int myPort=5000;
	final int yourPort = 6000;
	
	static String id="�̰���";
	static String dbName = "msg_db";
	
	Connection con =null;
	
	public MessengerA() throws IOException, SQLException{
		new MyFrame();
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

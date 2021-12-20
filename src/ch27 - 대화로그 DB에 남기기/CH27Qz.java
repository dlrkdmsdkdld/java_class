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
	
	static String id="이가형";
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
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println(dbName+"데이터베이스 연결 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버찾을수없음");
		}catch(SQLException e) {
			System.out.println("연결실패");
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
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void listenMessage() {
		while(true) {
			try {
			     byte[] buf = new byte[256];
			     packet = new DatagramPacket(buf,buf.length);
			     socket.receive(packet);//패킷받기
			     //받은 패킷을 텍스트 영역에 표시
			     String yourMsg = new String(buf);
			     textArea.append(yourMsg+"\n");
			     //메시지를 테이블에 저장
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
			
			//패킷을 생성
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
			
			//마이메시지를 테이블에 저장
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

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
	static String id="이가형";
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
	
	public Connection makeLoginConnection() {
		String dbNam="user_db";
		String url = "jdbc:mariadb://localhost:3308/" + dbNam;//내 실제 디비 포트는 3306
		String id = "root";
		String password ="1234";//내 실제 비번은 a1s2d3f4
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
	public void savenewIDLog(String log,String password) {
		Connection con = makeLoginConnection();
		try {
			Statement stmt = con.createStatement();
			String s = "INSERT INTO user_table (uid, pwd) VALUES ";
			s += "('"+ log + "', '"+ password+ "')";
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
				System.out.println("회원아이디:"+list.get(i).getUid());
				System.out.println("회원패스워드:"+list.get(i).getPwd());
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
			setTitle("로그인");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel1=new JPanel();
			panel1.add(new JLabel("-----------------가입을 하려면 이메일과 비번을 치고 가입버튼을 누르세요-----------------"));
			panel1.add(new JLabel("이메일"));
			LoginField = new JTextField(20);
			panel1.add(LoginField);
			
			panel1.add(new JLabel("비밀번호"));
			PasswordFiel = new JTextField(20);
			panel1.add(PasswordFiel);
			
			LoginButton=new JButton("로그인");
			////////////로그인부분
			LoginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	                list=GetAllUidAndPassword();//데이터베이스안 데이터들을 배열로 다 받아옴 
	                String lBuffer=LoginField.getText();
	                String pBuffer=PasswordFiel.getText();

	                int next=0;
	                for(int i=0; i<list.size();i++) {
	                	//데베에서 받아온 모든데이터를 하나하나 다 비교
	                	if(list.get(i).getUid().equals(lBuffer)&&list.get(i).getPwd().equals(pBuffer)) {
	                		setVisible(false); // 창 안보이게 하기 
	                		new MyFrame();
	                		next=1;
	                	}
	                }
	                if(next==0) {//로그인안됐을때
	                	JOptionPane.showMessageDialog(null,"아이디와 비번을 다시 입력해주세요","경고",JOptionPane.WARNING_MESSAGE);
	                }
	                
					
	            }
	        });
			panel1.add(LoginButton);
			
			newIDButton=new JButton("가입하기");
			/////////가입 부분
			newIDButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                setVisible(false); // 창 안보이게 하기 
	                ///새로운계쩡 디비 남김
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

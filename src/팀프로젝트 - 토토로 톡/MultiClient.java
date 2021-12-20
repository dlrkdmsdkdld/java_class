package totoroChat;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JProgressBar;

public class MultiClient implements ActionListener {
   private Socket socket;
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   private JFrame jframe, login1; // 창 
   private JTextField jtf, pass;//전송,아이디,비번창 
   private JTextArea jta, jlo;//토토로배경창,로그인창     타자
   private JLabel jlb1, jlb2, jID, jPW;//토토로창에서 유저아이디랑 아이피주소를나타내는 라벨
   private JPanel jp1, jp2, jp3, jp4;//버튼등등 담아서 프레임에 붙이는 바구니
   private String ip;
   private String id;//로그인할수있는 아이디
   private JButton jbtn, jbtn1 , jexit;//전송버튼이랑 로그인 종료 버튼
   public boolean changepower = false;
   public boolean saypower = false;
   private boolean login = false;
   String dbName = "msg_db";

   Image img = new ImageIcon("C:\\Users\\dlrkd\\eclipse-workspace\\totoroChat\\src\\totoroChat\\totoro.PNG").getImage();

   
   public MultiClient() {
       jframe = new JFrame("Multi Chatting");
      login1 = new JFrame("Login");
      JProgressBar progressBar = new JProgressBar();
      progressBar.setStringPainted(true);
      progressBar.setIndeterminate(true);
      progressBar.setBounds(32, 303, 195, 14);
      
      
      jtf = new JTextField(10);
      pass = new JTextField(10);
      

      jta = new JTextArea(43, 43) {
         {
            setOpaque(false);
         }

         public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
            super.paintComponent(g);
         }
      };
      jlo = new JTextArea(30,30); 
      jlb1 = new JLabel("토토로 채팅방   댓글전체지우기: clear +ENTER ") {
         {
            setOpaque(false);
         }
      };
      jPW = new JLabel("name"); //패스워드 라벨
      jbtn = new JButton("Enter"); // 채팅전송 버튼
      jbtn1 = new JButton("Login"); //로그인 버튼
      jexit = new JButton("exit"); //종료 버튼
      jp1 = new JPanel(); // 바구니
      jp2 = new JPanel();
      jp3 = new JPanel();  //로그인 화면
      jp4 = new JPanel();
      jbtn.setFont(new Font("HY엽서L", Font.PLAIN, (int) 20));
      jlb1.setFont(new Font("HY엽서L", Font.PLAIN, (int) 15));
      jlb1.setBackground(Color.LIGHT_GRAY);
       
       jPW.setFont(new Font("HY엽서L", Font.PLAIN, (int) 30));
      jPW.setHorizontalAlignment(jPW.CENTER);
      
    //  idc.setFont(new Font("HY엽서L", Font.PLAIN, (int) 30));
    //  idc.setBackground(Color.WHITE);
      pass.setFont(new Font("HY엽서L", Font.PLAIN, (int) 30));
      pass.setBackground(Color.WHITE);
      jbtn1.setBackground(Color.LIGHT_GRAY);
      jbtn1.setFont(new Font("HY엽서L", Font.PLAIN, (int) 30));
      jexit.setBackground(Color.LIGHT_GRAY);
      jexit.setFont(new Font("HY엽서L", Font.PLAIN, (int) 30));
      jbtn.setBackground(Color.LIGHT_GRAY);
      jlo.setBackground(Color.LIGHT_GRAY);
      
      jp1.setLayout(new BorderLayout());
      jp2.setLayout(new BorderLayout());
      jp3.setLayout(new GridLayout(3,2,10,10));

      jp1.add(jbtn, BorderLayout.EAST); 
      jp1.add(jtf, BorderLayout.CENTER);
      jp2.add(jlb1, BorderLayout.CENTER);
      
      jp1.setBackground(Color.LIGHT_GRAY);
      jp2.setBackground(Color.LIGHT_GRAY);
      jp3.setBackground(Color.LIGHT_GRAY);
       jp3.add(jPW);
      jp3.add(pass);
      jp3.add(jbtn1);
      jp3.add(jexit);
      jframe.add(jp1, BorderLayout.SOUTH);
      jframe.add(jp2, BorderLayout.NORTH);
      login1.add(jp3, BorderLayout.EAST);
      login1.add(jp4, BorderLayout.EAST);
      
      //채팅방부분
      JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      jframe.add(jsp, BorderLayout.CENTER);
      JScrollPane jsp1 = new JScrollPane(jlo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      login1.add(jp3, BorderLayout.CENTER);

      jtf.addActionListener(this); // 노건들
      jbtn.addActionListener(this);
      jexit.addActionListener(this);
      
      jframe.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            try {
               oos.writeObject(id + "#exit");
            } catch (IOException ee) {
               ee.printStackTrace();
            }
            System.exit(0);
         }

         public void windowOpened(WindowEvent e) {
            jtf.requestFocus();
         }
      });

      jbtn1.addActionListener(this);

      jta.setEditable(false);
       
      
      
      jframe.pack();
      jframe.setSize(500, 520);
      jframe.setResizable(true);
      jframe.setVisible(false);

      login1.pack();
      login1.setSize(700, 400);
      login1.setResizable(true);
      login1.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      String msg = jtf.getText();

      String str = e.getActionCommand();

      if (str.equals("Login")) {
         jframe.setVisible(true);
         login1.setVisible(false);

         id = pass.getText();
      }
      
      if (str.equals("exit")){
         System.exit(0);
      }
     
      if (obj == jtf || obj == jbtn) {
         if (msg == null || msg.length() == 0) {//메시지가 비어있을때
            JOptionPane.showMessageDialog(jframe, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
         }
         else if (str.equals("ㅗ")) {//욕할때 경고하는 기능
             JOptionPane.showMessageDialog(jframe, "욕설 경고합니다", "경고", JOptionPane.WARNING_MESSAGE);
            
         }
         
         else {
            try {
               saveLog(msg,id);
               oos.writeObject(id + "#" + msg);
               
            } catch (IOException ee) {
               ee.printStackTrace();
            }
            jtf.setText("");
         }
      }
   }

   public void exit() {
      System.exit(0);
   }
   
   public void init() throws IOException {
      socket = new Socket("192.168.219.102", 5000);
      System.out.println("connected...");
      oos = new ObjectOutputStream(socket.getOutputStream());
      ois = new ObjectInputStream(socket.getInputStream());
      MultiClientThread ct = new MultiClientThread(this);
      Thread t = new Thread(ct);
      t.start();
   }

   public static void main(String args[]) throws IOException {
      JFrame.setDefaultLookAndFeelDecorated(true);
      MultiClient cc = new MultiClient();
      cc.init();
   }

   public ObjectInputStream getOis() {
      return ois;
   }

   public JTextArea getJta() {
      return jta;
   }

   public String getId() {
      return id;
   }

   public void SetName(String a) {
      id = a;
   }

   public void Clear() {
	   jta.setText(""); //초기화되고
	   jtf.requestFocus();
	}
 //begin of DB interface
 	public Connection makeConnection() {
 		String url = "jdbc:mariadb://localhost:3306/" + dbName;
 		String id = "root";
 		String password ="a1s2d3f4";
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
 	public void saveLog(String log,String id) {
 		Connection con = makeConnection();
 		try {
 			Statement stmt = con.createStatement();
 			String s = "INSERT INTO msg_log (msg) VALUES ";
 			s += "('"+ id +" | "+ log + "')";
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
   
   
}
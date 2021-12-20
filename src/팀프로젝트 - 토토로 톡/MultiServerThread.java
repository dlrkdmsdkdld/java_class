package totoroChat;

import java.net.*;
import java.io.*;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private MultiServer ms;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public MultiServerThread(MultiServer ms) {
		this.ms = ms;
	}

	public synchronized void run() {
		boolean isStop = false;
		try {
			socket = ms.getSocket();
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			String message = null;
			while (!isStop) {
				message = (String) ois.readObject();
				String[] str = message.split("#");
				
				String name = "list"+"#";
				
				for(int i=0; i<ms.getList().size(); i++){
					name += ms.getList().get(i)+"#";
				}
				
				if (str[1].equals("exit")) {
					broadCasting(message);
					isStop = true;
				}else if(str[1].equals("list")){
					broadCasting(name);
				}else if(str[1].equals("")){
					broadCasting(name);
				}
				else {
					broadCasting(message);
				}
			}		
			ms.getList().remove(this);
		//	System.out.println(socket.getInetAddress() + "정상적으로 종료하셨습니다");
			//System.out.println("list size : " + ms.getList().size());
		}catch (Exception e) {
			ms.getList().remove(this);
			//System.out.println(socket.getInetAddress() + "비정상적으로 종료하셨습니다");
			//System.out.println("list size : " + ms.getList().size());
		}
	}

	public void broadCasting(String message) throws IOException {
		for (MultiServerThread ct : ms.getList()) {
			ct.send(message);
		}
	}

	public void send(String message) throws IOException {//메시지를 클라이언트에게 출력하는 함수
		oos.writeObject(message);
	}
}


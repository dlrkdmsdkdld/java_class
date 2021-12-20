package totoroChat;


import java.awt.Font;
import java.io.IOException;
import java.util.Scanner;

public class MultiClientThread extends Thread{
    private MultiClient mc;
    
    public MultiClientThread(MultiClient mc){
        this.mc = mc;
    }
    
    
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        
        boolean isStop = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject();
                receivedMsg = message.split("#");

            }catch(Exception e){
                e.printStackTrace();
                isStop = true;
            }
            System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            if(receivedMsg[1].equals("exit")){
                if(receivedMsg[0].equals(mc.getId())){
                    mc.exit();
                }else{
                    mc.getJta().append(
                    receivedMsg[0] +"님이 종료 하셨습니다."+
                    System.getProperty("line.separator"));
                    mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                }
            }else if(receivedMsg[1].equals("change")){   //메시지를 change로 보내면 이름 변경 이벤트발생            
                mc.changepower=true;
                mc.getJta().append("바꿀 아이디를 입력하세요"+ System.getProperty("line.separator"));
                try {
					message = (String)mc.getOis().readObject();//바꾼아이디를 받아오기위해 한번더 데이터를 읽음
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                receivedMsg = message.split("#");
                String name = receivedMsg[1];
                mc.SetName(name);
                
            }else if(receivedMsg[1].equals("clear")){     //메시지를 clear로 보내면 채팅방이깨끗해짐
            	mc.Clear();
            }else if(receivedMsg[0].equals(mc.getId())){
            	mc.getJta().append(
            			receivedMsg[0] +" : "+receivedMsg[1]+
                        System.getProperty("line.separator"));
                        mc.getJta().setCaretPosition(
                            mc.getJta().getDocument().getLength());  
            	
            }
            
            else if(receivedMsg[0].equals("list")){            	
            	int len =receivedMsg.length-1;
            	String numStr2 = String.valueOf(len);
            	mc.getJta().append("현재접속인원 :"+numStr2+System.getProperty("line.separator"));
            	/*for(int i=0;i<receivedMsg.length;i++){
            		mc.getJta().append(receivedMsg[i]+System.getProperty("line.separator"));
            	} */      
            }else{               
                mc.getJta().append(
                receivedMsg[0] +" : "+receivedMsg[1]+
                System.getProperty("line.separator"));
                mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());     
            }
        }
    }
}
package com.song.netty.fakeSync;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TimeServer
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-09-29 11:37
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            TImeServerHasnlerExecutePool executePool = new TImeServerHasnlerExecutePool(50,1000);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                executePool.execute(new Runnable() {
                    @Override
                    public void run() {
                        //todo 处理逻辑
                    }
                });
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (serverSocket != null){
                serverSocket.close();
                serverSocket=null;
            }
        }
    }
}

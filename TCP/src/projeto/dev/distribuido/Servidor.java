package projeto.dev.distribuido;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;


public class Servidor{
    int porta = 2137;
    String mensagem = "";
    public Servidor() throws IOException{
        System.out.println("Servidor Rodando");
        
        ServerSocket servidorSocket = new ServerSocket(porta);
        Socket socket = servidorSocket.accept();
        
        OutputStream outputstream = socket.getOutputStream();
        outputstream.write("Servidor ta funcionando".getBytes());

        while(true){
        	System.out.println("teste");
            InputStream inStream = socket.getInputStream();
            byte[] bytte = new byte[1000];
            inStream.read(bytte);
            
            String resposta = new String(bytte);
            
            System.out.println(resposta);
            
            BufferedImage carta = ImageIO.read(new File("/home/elvis/"+ resposta.trim().toLowerCase()+".jpg"));
            System.out.println(carta);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(carta, "jpg", baos);
            
            byte[] size = ByteBuffer.allocate(4).putInt(baos.size()).array();
            outputstream.write(size);
            outputstream.write(baos.toByteArray());
            outputstream.flush();
        }
    }
    
    public static void main(String args[]) throws IOException{
        Servidor servidor = new Servidor();
    }
}

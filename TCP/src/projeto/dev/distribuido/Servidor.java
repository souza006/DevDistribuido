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
    int porta = 1234;
    String mensagem = "";
    public Servidor() throws IOException{
        System.out.println("Servidor Rodando");
        
        ServerSocket servidorSocket = new ServerSocket(porta);
        Socket socket = servidorSocket.accept();
        
        OutputStream outputstream = socket.getOutputStream();
        outputstream.write("Servidor ta funcionando".getBytes());

        while(true){
            InputStream inStream = socket.getInputStream();
            byte[] bytte = new byte[1000];
            inStream.read(bytte);
            
            String resposta = new String(bytte);
            
            System.out.println(resposta);
            
            BufferedImage escudo = ImageIO.read(new File("C:/Users/Administrador/Desktop/projeto-dev-distribuido/src/Servidor/"+ resposta.trim().toLowerCase()+".jpg"));
       
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(escudo, "jpg", baos);
            
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

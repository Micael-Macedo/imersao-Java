import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class GeradoraDeFigurinhas {
     public void cria() throws IOException{
        BufferedImage ImagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null); 

        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }
    public static void main(String[] args) throws IOException {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}

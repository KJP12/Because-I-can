package net.kjp12.doot;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length < 3){
            System.out.println(ProcessHandle.current().info().commandLine().orElse("unknown") + " <x> <y> <count>");
            return;
        }

        var clr = new Color[256];
        for(int i = 0; i < clr.length; i++) clr[i] = Color.getHSBColor((float) i / (float) clr.length, 1F, 1F);

        int x = Integer.parseInt(args[0]), y = Integer.parseInt(args[1]);

        var iw = ImageIO.getImageWritersByFormatName("gif").next();

        var p = FileSystems.getDefault().getPath("/home/kjp12/Downloads/doot3.gif");

        if(Files.notExists(p)) Files.createFile(p);

        var os = Files.newOutputStream(p);
        var ios = ImageIO.createImageOutputStream(os);
        iw.setOutput(ios);
        iw.prepareWriteSequence(null);
        var iwp = iw.getDefaultWriteParam();

        int i = 0;
        for(int d = Math.max(x, y); d > 0; d /= 2){
            //for(int ya = 0; ya < y / d; ya++){*/
                for(int xb = 0; xb <= x / d; xb++){
                    for(int yb = 0; yb <= y / d; yb++) {
                        var src = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
                        var graph = src.createGraphics();
                        graph.setStroke(new BasicStroke(d));
                        graph.setColor(clr[i++ % clr.length]);
                        graph.drawLine(x / 2, y / 2, xb * d, yb *d);
                        IIOMetadata meta = iw.getDefaultImageMetadata(new ImageTypeSpecifier(src), iwp);
                        IIOImage ii = new IIOImage(src, null, meta);
                        iw.writeToSequence(ii, null);
                    }
                }
            //}
        }
        iw.endWriteSequence();
        ios.close();
    }
}

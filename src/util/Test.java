/**
 * 
 */
package util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.channels.FileChannel;

/**
 * 
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-3
 */
public class Test {

	/**
<<<<<<< HEAD
	 * @param args
	 */
	public static void main(String[] args) {
//		 test();
        TimeCounter tc = new TimeCounter();
        tc.start();
        String filePath = "E://flv";
        batchRename(filePath,".flv");
        tc.stop();
        System.out.println(tc.consumeBySecond() + " s");
    }

    public static void batchRename(String dirPath,String suffix){
        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    rename(file, suffix);
                }
            }
        }
    }

    public static void rename(File file, String suffix) {
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        int i = absolutePath.indexOf("-Chinese");
        if (i > 0) {
            String newFilePath = absolutePath.substring(0, i).trim() + suffix;
            File newFile = new File(newFilePath);
            file.renameTo(newFile);
            System.out.println(newFilePath);
        } else {
            int j = absolutePath.indexOf(".vdat");
            if (j > 0) {
                String newFilePath = absolutePath.substring(0, j).trim() + suffix;
                File newFile = new File(newFilePath);
                file.renameTo(newFile);
                System.out.println(newFilePath);
            } else {
                System.out.println(absolutePath);
            }
        }
    }

	public static void test(){
		// 得到当前方法的名字
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		System.out.println(methodName);
		// 得到当前文件的名字
		String fileName = Thread.currentThread().getStackTrace()[2].getFileName();
		System.out.println(fileName);
		// 得到行号
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		System.out.println(lineNumber);
	}
	
	/**
=======
>>>>>>> edffa3c33c870ddf48a37e2216b69fa2212e976a
	 * 使用NIO进行快速的文件拷贝
	 */
	public static void fileCopy( File in, File out )  
            throws IOException  
    {  
        FileChannel inChannel = new FileInputStream( in ).getChannel();  
        FileChannel outChannel = new FileOutputStream( out ).getChannel();  
        try 
        {  
            // magic number for Windows, 64Mb - 32Kb)  
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);  
            long size = inChannel.size();  
            long position = 0;  
            while ( position < size )  
            {  
               position += inChannel.transferTo( position, maxCount, outChannel );  
            }  
        }  
        finally 
        {  
            if ( inChannel != null )  
            {  
               inChannel.close();  
            }  
            if ( outChannel != null )  
            {  
                outChannel.close();  
            }  
        }  
    } 
	
	
	/**
	 * 抓屏程序
	 */
	public static void captureScreen(File file) throws Exception {  
		   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
		   Rectangle screenRectangle = new Rectangle(screenSize);  
		   Robot robot = new Robot();  
		   BufferedImage image = robot.createScreenCapture(screenRectangle);  
		   ImageIO.write(image, "png", file);  
		  
		}  
	
	/**
	 * 创建图片的缩略图
	 */
	public static void createThumbnail(String filename, int thumbWidth, int thumbHeight, int quality, String outFilename)  
	        throws InterruptedException, FileNotFoundException, IOException  
	    {  
	        // load image from filename  
	        Image image = Toolkit.getDefaultToolkit().getImage(filename);  
	        MediaTracker mediaTracker = new MediaTracker(new Container());  
	        mediaTracker.addImage(image, 0);  
	        mediaTracker.waitForID(0);  
	        // use this to test for errors at this point: System.out.println(mediaTracker.isErrorAny());  
	  
	        // determine thumbnail size from WIDTH and HEIGHT  
	        double thumbRatio = (double)thumbWidth / (double)thumbHeight;  
	        int imageWidth = image.getWidth(null);  
	        int imageHeight = image.getHeight(null);  
	        double imageRatio = (double)imageWidth / (double)imageHeight;  
	        if (thumbRatio < imageRatio) {  
	            thumbHeight = (int)(thumbWidth / imageRatio);  
	        } else {  
	            thumbWidth = (int)(thumbHeight * imageRatio);  
	        }  
	  
	        // draw original image to thumbnail image object and  
	        // scale it to the new size on-the-fly  
	        BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);  
	        Graphics2D graphics2D = thumbImage.createGraphics();  
	        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
	        graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);  
	  
	        // save thumbnail image to outFilename  
	        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilename));  
	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
	        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);  
	        quality = Math.max(0, Math.min(quality, 100));  
	        param.setQuality((float)quality / 100.0f, false);  
	        encoder.setJPEGEncodeParam(param);  
	        encoder.encode(thumbImage);  
	        out.close();  
	    } 
}

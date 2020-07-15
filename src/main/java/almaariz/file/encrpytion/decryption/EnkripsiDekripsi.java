/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almaariz.file.encrpytion.decryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author 1817101458
 */
public class EnkripsiDekripsi {
    public static void enkripsidekripsi(File src, File dest)
            throws IOException {

            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            
            int length;
            //8 byte key, you can change it
            byte key[] = {1,0,0,1,1,0,1,0};
            //copy the file content in bytes 
            while ((length = in.read(buffer)) > 0) {
                for (int i=0; i< length; i++){
                    buffer[i] = (byte) (buffer[i] ^ key[i%8]);
                }
                    out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File " + src + " encrypted/decrypted to " + dest);
    }
}
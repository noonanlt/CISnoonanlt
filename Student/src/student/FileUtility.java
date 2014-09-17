/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.util.logging.Level;
import java.util.logging.Logger;
import static student.Student.*;

/**
 *
 * @author lnoonan31918
 */
public class FileUtility {

    public static void addRecord(String s, String fileName) {

        Path file = Paths.get(fileName);
        final int REC_SIZE = s.length();
        byte[] data = s.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        try {
            FileChannel fc = null;
            int id = Integer.parseInt(s.substring(0, 3));
            System.out.println(id);
            fc = (FileChannel) Files.newByteChannel(file, WRITE);
            fc.position(id * RECORD_LAYOUT.length()+1); //Should REC_SIZE be defined? seem to be running into issues here how can we account for variance in record lengths
            fc.write(buffer);
            fc.close();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error message: " + e);
        }
    }

    public static void initializeFile(String fileName) {
        Path file = Paths.get(fileName);
        byte[] data = Student.RECORD_LAYOUT.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(data);

        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            for (int i = 0; i < Student.NUMBER_OF_RECORDS; ++i) {
                writer.write(Student.RECORD_LAYOUT, 0, RECORD_LAYOUT.length());
            }
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

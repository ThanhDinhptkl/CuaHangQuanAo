package gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

class FileUtil {
    public static void luuTamCTHD(String filePath, DefaultTableModel model) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(model.getDataVector());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DefaultTableModel loadTamCTHD(String filePath) {
        DefaultTableModel model = new DefaultTableModel();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof Vector) {
                Vector dataVector = (Vector) obj;
                for (Object row : dataVector) {
                    model.addRow((Vector) row);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return model;
    }
}
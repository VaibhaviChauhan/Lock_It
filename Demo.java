import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo
{
    public static void operate(int key)
    {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        try{
            FileInputStream fis = new FileInputStream(file);
            byte data[]=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for (byte b: data) {
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();

        }
        catch (Exception e){

        }



    }
    public static void main(String args[]) {

        JFrame f = new JFrame();
        f.setTitle("Img");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Roboto", Font.BOLD, 25);
        JButton btn = new JButton();
        btn.setText("Select Image");
        btn.setFont(font);


        JTextField text = new JTextField(10);
        text.setFont(font);

        btn.addActionListener(e -> {
            String t = text.getText();
            int temp = Integer.parseInt(t);
            operate(temp);
        });
        f.setLayout(new FlowLayout());
        f.add(btn);
        f.add(text);
        f.setVisible(true);


    }
}

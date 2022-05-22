import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.FlowLayout;


import java.awt.Font;

public class ImageEncryption {



    public static void operate(int key)
    {
        JFileChooser filec= new JFileChooser();
        filec.showOpenDialog(null);
        File file = filec.getSelectedFile();
        try {

            FileInputStream fis = new FileInputStream(file);
            byte [] data= new byte [fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        f.setTitle("Simple Encrypter");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font= new Font("Roboto",Font.BOLD,25);

        //Button
        JButton button = new JButton();
        button.setText("Select Image");
        button.setFont(font);

        JTextField textfield = new JTextField(10);
        textfield.setFont(font);

        f.setLayout(new FlowLayout() );
        f.add(button);
        f.add(textfield);
        f.setVisible(true);
        
        button.addActionListener(e->{
            String text=textfield.getText();
            int temp=Integer.parseInt(text);
            operate(temp);

        });

          
    }
    
}

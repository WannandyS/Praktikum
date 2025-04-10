import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Banner extends JFrame implements Runnable {
    private JLabel label;
    private int x = -250; //posisi awal horizontal untuk teksnya

    public Banner() {
        setTitle("Banner");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //untuk tutup jendela secara keseluruhan 
        setLocationRelativeTo(null);// posisi jendela ke layar

        JPanel panel = new JPanel();
        panel.setLayout(null); // pake ini untuk ngatur posisi secara manual jadi dinonaktifkan layout otomatisnya
        panel.setBackground(Color.CYAN); // untuk warna background

        label = new JLabel("Your name here!");
        label.setForeground(Color.RED); // untuk warna teksnya
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBounds(x, 40, 300, 30); // untuk atur posisi komponen (posisi awal teks)

        panel.add(label); //nambahkan label ke panel
        add(panel); //nambahkan panel ke jendela utama (frame)
        setVisible(true); // nampilkan jendela ke layar

        Thread t = new Thread(this); // untuk jalankan animasi di thread
        t.start();
    }
    
    @Override
    public void run() {
        while (true) { // pake true buat dia animasinya jalan terus tanpa berhenti
            x += 5; // kecepatan animasi teksnya

            if (x > getWidth()) { // untuk teksnya udah keluar layar ke sebelah kanan, nanti direset ke kiri
                x = -label.getWidth();
            }

            label.setBounds(x, 40, 300, 30); // buat gerakin teksnya bisa bergerak terus

            try {
                Thread.sleep(50); // delay untuk animasi dari kiri ke kanan
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Banner();
    }
}
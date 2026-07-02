package view;

import entity.Pegawai;
import service.PegawaiService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PegawaiForm extends JFrame {

    private PegawaiService service = new PegawaiService();
    private JTable table;
    private DefaultTableModel model;

    private JTextField txtNama, txtJabatan, txtDivisi, txtGaji;

    public PegawaiForm() {

        setTitle("CRUD Pegawai");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel(new String[]{"ID", "Nama", "Jabatan", "Divisi", "Gaji"}, 0);
        table = new JTable(model);

        loadData();

        JPanel form = new JPanel(new GridLayout(5, 2));

        txtNama = new JTextField();
        txtJabatan = new JTextField();
        txtDivisi = new JTextField();
        txtGaji = new JTextField();

        form.add(new JLabel("Nama"));
        form.add(txtNama);
        form.add(new JLabel("Jabatan"));
        form.add(txtJabatan);
        form.add(new JLabel("Divisi"));
        form.add(txtDivisi);
        form.add(new JLabel("Gaji"));
        form.add(txtGaji);

        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus");

        form.add(btnTambah);
        form.add(btnHapus);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> {
            Pegawai p = new Pegawai(
                    txtNama.getText(),
                    txtJabatan.getText(),
                    txtDivisi.getText(),
                    Double.parseDouble(txtGaji.getText())
            );

            service.tambah(p);
            loadData();
        });

        btnHapus.addActionListener(e -> {
            int row = table.getSelectedRow();
            int id = (int) table.getValueAt(row, 0);

            service.hapus(id);
            loadData();
        });
    }

    private void loadData() {
        model.setRowCount(0);

        List<Pegawai> list = service.getAll();

        for (Pegawai p : list) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getNama(),
                    p.getJabatan(),
                    p.getDivisi(),
                    p.getGaji()
            });
        }
    }

    public static void main(String[] args) {
        new PegawaiForm().setVisible(true);
    }
}
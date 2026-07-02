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

    private int selectedId = -1;

    public PegawaiForm() {

        setTitle("CRUD Pegawai");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================= TABLE =================
        model = new DefaultTableModel(
                new String[]{"ID", "Nama", "Jabatan", "Divisi", "Gaji"}, 0
        );

        table = new JTable(model);
        loadData();

        add(new JScrollPane(table), BorderLayout.CENTER);

        // ================= FORM =================
        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));

        txtNama = new JTextField();
        txtJabatan = new JTextField();
        txtDivisi = new JTextField();
        txtGaji = new JTextField();

        JButton btnTambah = new JButton("Tambah");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        form.add(new JLabel("Nama"));
        form.add(txtNama);

        form.add(new JLabel("Jabatan"));
        form.add(txtJabatan);

        form.add(new JLabel("Divisi"));
        form.add(txtDivisi);

        form.add(new JLabel("Gaji"));
        form.add(txtGaji);

        form.add(btnTambah);
        form.add(btnUpdate);
        form.add(btnDelete);

        add(form, BorderLayout.SOUTH);

        // ================= TABLE CLICK =================
        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {
                selectedId = (int) table.getValueAt(row, 0);

                txtNama.setText(table.getValueAt(row, 1).toString());
                txtJabatan.setText(table.getValueAt(row, 2).toString());
                txtDivisi.setText(table.getValueAt(row, 3).toString());
                txtGaji.setText(table.getValueAt(row, 4).toString());
            }
        });

        // ================= TAMBAH =================
        btnTambah.addActionListener(e -> {

            Pegawai p = new Pegawai(
                    txtNama.getText(),
                    txtJabatan.getText(),
                    txtDivisi.getText(),
                    Double.parseDouble(txtGaji.getText())
            );

            service.tambah(p);
            loadData();
            clearForm();
        });

        // ================= UPDATE =================
        btnUpdate.addActionListener(e -> {

            if (selectedId == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data dulu!");
                return;
            }

            Pegawai p = new Pegawai(
                    selectedId,
                    txtNama.getText(),
                    txtJabatan.getText(),
                    txtDivisi.getText(),
                    Double.parseDouble(txtGaji.getText())
            );

            service.ubah(p);
            loadData();
            clearForm();

            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
        });

        // ================= DELETE =================
        btnDelete.addActionListener(e -> {

            if (selectedId == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data dulu!");
                return;
            }

            service.hapus(selectedId);
            loadData();
            clearForm();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        });
    }

    // ================= LOAD DATA =================
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

    // ================= CLEAR FORM =================
    private void clearForm() {
        txtNama.setText("");
        txtJabatan.setText("");
        txtDivisi.setText("");
        txtGaji.setText("");
        selectedId = -1;
    }

    public static void main(String[] args) {
        new PegawaiForm().setVisible(true);
    }
}
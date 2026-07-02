package entity;

public class Pegawai {

    private int id;
    private String nama;
    private String jabatan;
    private String divisi;
    private double gaji;

    public Pegawai() {
    }

    public Pegawai(int id, String nama, String jabatan, String divisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.divisi = divisi;
        this.gaji = gaji;
    }

    public Pegawai(String nama, String jabatan, String divisi, double gaji) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.divisi = divisi;
        this.gaji = gaji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
}
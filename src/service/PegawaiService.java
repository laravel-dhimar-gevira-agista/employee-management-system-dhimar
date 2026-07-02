package service;

import entity.Pegawai;
import repository.PegawaiRepository;

import java.util.List;

public class PegawaiService {

    private PegawaiRepository repo = new PegawaiRepository();

    public List<Pegawai> getAll() {
        return repo.getAll();
    }

    public void tambah(Pegawai p) {
        repo.insert(p);
    }

    public void ubah(Pegawai p) {
        repo.update(p);
    }

    public void hapus(int id) {
        repo.delete(id);
    }
}
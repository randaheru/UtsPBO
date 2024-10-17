// Kelas dasar untuk semua kendaraan
class Kendaraan {
    protected String merk;
    protected String model;

    public Kendaraan(String merk, String model) {
        this.merk = merk;
        this.model = model;
    }

    public String getDetails() {
        return "Merk: " + merk + ", Model: " + model;
    }
}

// Kelas Mobil yang diwarisi dari Kendaraan
class Mobil extends Kendaraan {
    protected int kursi;

    public Mobil(String merk, String model, int kursi) {
        super(merk, model);
        this.kursi = kursi;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Kursi: " + kursi;
    }
}

// Kelas MobilListrik yang diwarisi dari Mobil
class MobilListrik extends Mobil {
    private int dayaBaterai;

    public MobilListrik(String merk, String model, int kursi, int dayaBaterai) {
        super(merk, model, kursi);
        this.dayaBaterai = dayaBaterai;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Daya Baterai: " + dayaBaterai + " jam";
    }
}

// Kelas Motor yang diwarisi dari Kendaraan
class Motor extends Kendaraan {
    private boolean adaBagasi;

    public Motor(String merk, String model, boolean adaBagasi) {
        super(merk, model);
        this.adaBagasi = adaBagasi;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Ada Bagasi: " + (adaBagasi ? "Ya" : "Tidak");
    }
}

// Kelas MotorListrik yang diwarisi dari Motor
class MotorListrik extends Motor {
    private int dayaBaterai;

    public MotorListrik(String merk, String model, boolean adaBagasi, int dayaBaterai) {
        super(merk, model, adaBagasi);
        this.dayaBaterai = dayaBaterai;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Daya Baterai: " + dayaBaterai + " jam";
    }
}

// Kelas utama untuk pengujian
public class Main {
    public static void main(String[] args) {
        MobilListrik mobilListrik = new MobilListrik("Tesla", "Model S", 5, 10);
        MotorListrik motorListrik = new MotorListrik("Zero", "FX", true, 6);

        System.out.println(mobilListrik.getDetails());
        System.out.println(motorListrik.getDetails());
    }
}

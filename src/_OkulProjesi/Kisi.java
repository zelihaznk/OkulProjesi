package _OkulProjesi;

public class Kisi {

    private String adSoyad;
    private String kimlikNo;
    private String yas; // herkesin ortak ozelligi

    public Kisi(String adSoyad, String kimlikNo, String yas) {
        this.adSoyad = adSoyad;
        this.kimlikNo = kimlikNo;
        this.yas = yas;
    }

    public Kisi() {
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    @Override
    public String toString() {
        return
                "kimlikNo = " + kimlikNo+ " " +
                        "adSoyad = " + adSoyad+ " " +
                        "yas = " + yas+ " ";
    }
}

package _OkulProjesi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {
    static List<Kisi> ogretmenList = new ArrayList<>();
    static List<Kisi> ogrenciList = new ArrayList<>();
    static String kisiTuru;
    static Scanner scan = new Scanner(System.in);
    //static yazmamizin sebebi tum methodlardan ulasmak

    public static void girisPaneli() {
        System.out.println("====================================");
        System.out.println("ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ");
        System.out.println("====================================");
        System.out.println("1- ÖĞRENCİ İŞLEMLERİ");
        System.out.println("2- ÖĞRETMEN İŞLEMLERİ");
        System.out.println("Q- ÇIKIŞ");

        String secim = scan.nextLine().toUpperCase();

        switch (secim) {
            case "1":
                kisiTuru = "OGRENCI";
                islemMenusu();
                break;
            case "2":
                kisiTuru = "OGRETMEN";
                islemMenusu();
                break;
            case "Q":
                break;
            default:
                System.out.println("Hatali giris :(");
                girisPaneli();
                break;
        }


    }

    private static void islemMenusu() {
        System.out.println(kisiTuru + " icin asagidaki menuden isleminizi seciniz.");

        System.out.println("============= İŞLEMLER =============\n" +
                "         1-EKLEME\n" +
                "         2-ARAMA\n" +
                "         3-LİSTELEME\n" +
                "         4-SİLME\n" +
                "         5-ANA MENÜ\n" +
                "         0-ÇIKIŞ");
        System.out.println("Islem tercihinizi giriniz: ");
        int secilenIslem = scan.nextInt();

        switch (secilenIslem) {
            case 1:
                ekle(); // yapildi
                islemMenusu(); // method call ile islem menusune tekrar gidiyor.
                break;
            case 2:
                arama();
                islemMenusu();
                break;
            case 3:
                listele();
                islemMenusu();
                break;
            case 4:
                sil();
                islemMenusu();
                break;
            case 5:
                girisPaneli();
                break;
            case 0:
                cikis();
                break;
            default:
                System.out.println("Hatali giris yaptiniz ");
                islemMenusu();
                break;
        }
    }

    private static void cikis() {
        System.out.println("Iyi gunler dileriz.");
    }

    private static void sil() {
        System.out.println("**** " + kisiTuru + " silme sayfasina hosgeldin");
        boolean flag = true;//bayrak havada aksiyon basla

        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {
            System.out.println("Silmek istedigin kimlik no gir");

            String silinecekKimlikNo = scan.next().replaceAll(" ", "");

            for (Kisi each : ogrenciList) {
                if (each.getKimlikNo().equals(silinecekKimlikNo)) {
                    System.out.println("Silinen ogrenci " + each.getAdSoyad());
                    ogrenciList.remove(each);//o ogrenciyi siler
                    flag = false;
                    break;
                }
            }
            if (flag) {//eger girilen tc list te yok ise bu if calisir
                System.out.println("bu tc ile ogrenci yok silinemedi");
            }
        }else {
            System.out.println("Silmek istedigin kimlik no gir");

            String silinecekKimlikNo = scan.next().replaceAll(" ", "");

            for (Kisi each : ogretmenList) {
                if (each.getKimlikNo().equals(silinecekKimlikNo)) {
                    System.out.println("Silinen ogretmen " + each.getAdSoyad());
                    ogretmenList.remove(each);//o ogretmeni siler
                    flag = false;
                    break;
                }
            }
            if (flag) {//eger girilen tc list te yok ise bu if calisir
                System.out.println("Bu tc ile ogretmen yok silinemedi");
            }
        }
    }


    private static void listele() {
        System.out.println("**** " + kisiTuru + " listeleme sayfasina hosgeldin");
        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {
            System.out.println("Ogrenciler = " + ogrenciList);
        } else {
            for (Kisi each : ogretmenList) {
                System.out.println("Ogretmenler = " + each.toString());
            }
        }
    }

    private static void arama() {
        System.out.println("**** " + kisiTuru + " arama sayfasina hosgeldiniz. ****");
        boolean flag = true; // bayrak yukarida true olan her sart devam eder

        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {
            System.out.println("Aramak istediginiz kisinin kimlik numarasini giriniz.");
            String arananKimlikNo = scan.next().replaceAll(" ", "");

            for (Kisi each : ogrenciList
            ) {
                if (each.getKimlikNo().equals(arananKimlikNo)) {
                    System.out.println("Aradiginiz Ogrenci : " + each.getAdSoyad());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Aradiginiz TC ile ogrenci bulunmamaktadir.");
            }
        } else {
            System.out.println("**** " + kisiTuru + " arama sayfasina hosgeldiniz. ****");
            System.out.println("Aramak istediginiz kisinin kimlik numarasini giriniz.");
            String arananKimlikNo = scan.next().replaceAll(" ", "");

            for (Kisi each : ogretmenList
            ) {
                if (each.getKimlikNo().equals(arananKimlikNo)) {
                    System.out.println("Aradiginiz Ogretmen : " + each.getAdSoyad());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Aradiginiz TC ile Ogretmen bulunmamaktadir.");
            }
        }
    }

    private static void ekle() {//bu menu hem ogrencı hem de ogretmen eklemek icin tasarlandi
        System.out.println("**** " + kisiTuru + " ekleme sayfasina hosgeldiniz. ****");
        System.out.println("Isım soyisim giriniz.");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        System.out.println("Kimlik no giriniz.");
        String kimlikNo = scan.next();

        System.out.println("Yasi giriniz.");
        String yas = scan.next();

        if (kisiTuru.equals("OGRENCI")) {
            System.out.println("Ogrenci no giriniz.");
            String ogrenciNo = scan.next().replaceAll(" ", "");
            System.out.println("Lutfen sinifini giriniz.");
            String sinif = scan.next().replaceAll(" ", "");

            Ogrenci ogrenci = new Ogrenci(adSoyad, kimlikNo, yas, ogrenciNo, sinif);
            ogrenciList.add(ogrenci);
            System.out.print(ogrenciList);
        } else {
            scan.nextLine();
            System.out.println("Bolum giriniz.");
            String bolum = scan.nextLine();
            System.out.println("Sicil no giriniz.");
            String sicilNo = scan.nextLine();

            Ogretmen ogretmen = new Ogretmen(adSoyad, kimlikNo, yas, bolum, sicilNo);
            ogretmenList.add(ogretmen);
            System.out.print(ogretmenList);
        }
    }
}

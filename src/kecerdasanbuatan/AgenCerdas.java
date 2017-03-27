/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kecerdasanbuatan;

public class AgenCerdas {

    private String lingkungan[][];
    public String Jenissampah[] = {"debu", "bulu", "kapas", "tisu", "sterofom", "kertas"};

    AgenCerdas(int location) {
        lingkungan = new String[location][4];
    }

    public void setKondisi(int i, String Nama, String location,String status, String sampah) {
        lingkungan[i - 1][0] = Nama;
        lingkungan[i - 1][1] = location;
        lingkungan[i - 1][2] = status;
        lingkungan[i - 1][3] = sampah;
    }

    public void vacumm(int i, String location, String status,String sampah) {
  
        String datasampah[]= pisah(sampah);
        if ("kotor".equals(status.toLowerCase())) {
              for(int j=0;j<datasampah.length;j++){
                   boolean ifkotor = false;
                for(int k=0;k<Jenissampah.length;k++){
                    if(datasampah[j].equals(Jenissampah[k])){
                    ifkotor=true;
                    }else{
                       ifkotor = false; 
                    }
                }
               if(ifkotor==true){
                   System.out.println("\tBersih-bersih "+datasampah[j]);
               }else{
                   System.out.println("\t"+datasampah[j]+" Bukan sampah");
               }
            }
                      
            status = "bersih";
            lingkungan[i][2] = status;
            vacumm(i, location, status,sampah);
        } else if ("kiri".equals(location.toLowerCase())) {
            System.out.println("geser kanan-->");
        } else if ("kanan".equals(location.toLowerCase())) {
            System.out.println("<--geser kiri");
        }
    }

    public void bersihkan() {
        for (int i = 0; i < lingkungan.length; i++) {
            System.out.println("Lokasi" + lingkungan[i][0]);
            vacumm(i, lingkungan[i][1], lingkungan[i][2],lingkungan[i][3]);
        }
        cek();
    }

    public void cek() {
        for (int i = 0; i < lingkungan.length; i++) {
            if (!"bersih".equals(lingkungan[i][2])) {
                bersihkan();
                break;
            }
        }
        System.out.println("SEMUA SUDAH BERSIH");
    }

    public String[] pisah(String awal) {
        String x[] = awal.split(",");
        return x;
    }

    public static void main(String[] args) {
        AgenCerdas a = new AgenCerdas(2);
        a.setKondisi(1, "Lokasi 1", "kanan","kotor","Debu,Dompet,Gorengan,Kapas,tisu");
        a.setKondisi(2, "Lokasi 2", "kiri","kotor","Mie,Debu,Tisu,Sterofom,Kertas");
        a.bersihkan();
//
//        String pis[] = a.pisah("Firmanda Mulyawan Nugroho");
//       for(int i=0;i<pis.length;i++)
//            System.out.println(i+"."+pis[i]+"\n");
            
    }
}

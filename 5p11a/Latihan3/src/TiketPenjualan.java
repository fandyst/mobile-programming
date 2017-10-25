import javax.microedition.lcdui.*;

public class TiketPenjualan extends Form implements CommandListener {

	TextField tBeli;
	StringItem tBayar;
	ChoiceGroup cgJurusan;
	ChoiceGroup cgKelas;
	Command btnBayar;
	Command btnKeluar;
	Main m;

	public TiketPenjualan(Main m) {
		super("Aplikasi Tiket Penjualan");
		this.m = m;
		tBeli = new TextField("Jumlah Beli","",2,TextField.NUMERIC);
		append(tBeli);

		cgJurusan = new ChoiceGroup("Jurusan", Choice.EXCLUSIVE);
		cgJurusan.append("Pekalongan - Jakarta",null);
		cgJurusan.append("Semarang - Jakarta",null);
		append(cgJurusan);

		cgKelas = new ChoiceGroup("Kelas", ChoiceGroup.EXCLUSIVE);
		cgKelas.append("Ekonomi",null);
		cgKelas.append("Bisnis",null);
		append(cgKelas);

		tBayar = new StringItem("Bayar : ","Rp");
		append(tBayar);

		btnBayar = new Command("Bayar",Command.OK,0);
		btnKeluar = new Command("Keluar",Command.EXIT,0);
		addCommand(btnBayar);
		addCommand(btnKeluar);

		setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable d) {
		int beli = Integer.parseInt(tBeli.getString());
		int hasil = 0;

		if(cmd == btnBayar) {
			if(beli <= 4) {
				if(cgJurusan.isSelected(0)) {
					if(cgKelas.isSelected(0)) {
						hasil = 40000*beli;
					}else {
						hasil = 100000*beli;
					}
				}else {
					if(cgKelas.isSelected(0)){
						hasil = 80000*beli;
					}else {
						hasil = 140000*beli;
					}
				}
			}else {

			}

		}

		tBayar.setText("Rp "+hasil);
	}

}

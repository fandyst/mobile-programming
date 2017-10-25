import javax.microedition.lcdui.*;

public class Tiket extends Form implements CommandListener {
	Main m;
	TextField tBeli;
	StringItem tBayar;
	ChoiceGroup cgTujuan;
	ChoiceGroup cgKelas;
	Command btnHitung;
	Command btnKeluar;

	public Tiket(Main m) {
		super("Aplikasi Tiket");
		this.m = m;

		tBeli = new TextField("Jumlah Beli","",2,TextField.NUMERIC);
		append(tBeli);

		cgTujuan = new ChoiceGroup("Tujuan", Choice.EXCLUSIVE);
		cgTujuan.append("Pekalongan - Jakarta",null);
		cgTujuan.append("Pekalongan - Bandung",null);
		append(cgTujuan);

		cgKelas = new ChoiceGroup("Kelas", Choice.EXCLUSIVE);
		cgKelas.append("Ekonomi",null);
		cgKelas.append("Bisnis",null);
		append(cgKelas);

		tBayar = new StringItem("Total Bayar","");
		append(tBayar);

		btnHitung = new Command("Hitung",Command.OK,0);
		addCommand(btnHitung);

		btnKeluar = new Command("Keluar", Command.EXIT,0);
		addCommand(btnKeluar);

		setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable d) {
		int beli = Integer.parseInt(tBeli.getString());
		int hasil = 0;

		if(cgTujuan.isSelected(0)) {
			if(cgKelas.isSelected(0)) {
				hasil = 60000*beli;
			}
			else if(cgKelas.isSelected(1)) {
					hasil = 160000*beli;
			}
		}

		else if(cgTujuan.isSelected(1)) {
			if(cgKelas.isSelected(0)) {
				hasil = 80000*beli;
			}
			else if(cgKelas.isSelected(1)){
				hasil = 200000*beli;
			}
		}
		
		if(beli >= 5) {
			hasil = 0;
		}


		tBayar.setText("Rp "+hasil);
	}
}
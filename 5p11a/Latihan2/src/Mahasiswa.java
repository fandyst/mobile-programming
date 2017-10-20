import javax.microedition.lcdui.*;

public class Mahasiswa extends Form implements CommandListener {
	Main m;
	TextField txtNim;
	TextField txtNama;
	TextField txtAlamat;
	Command btnCek;
	Command btnKeluar;
	Alert alert;

	public Mahasiswa(Main m) {
		super("Mahasiswa");
		this.m = m;

		txtNim = new TextField("NIM","",11,TextField.ANY);
		append(txtNim);

		txtNama = new TextField("Nama","",25,TextField.ANY);
		append(txtNama);

		txtAlamat = new TextField("Alamat","",50,TextField.ANY);
		append(txtAlamat);

		btnCek = new Command("Cek", Command.OK,0);
		btnKeluar = new Command("Keluar", Command.EXIT,0);
		addCommand(btnCek);
		addCommand(btnKeluar);

		setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable d) {

		if (cmd == btnCek) {
			// tombol btnCek untuk menampilkan alert
			String nim = txtNim.getString();
			String nama = txtNama.getString();
			String alamat = txtAlamat.getString();

			if("".equals(nim) || "".equals(nama) || "".equals(alamat)) {
				append("Kolom Wajib Diisi");
			}else {
				alert = new Alert("Informasi Mahasiswa","NIM : "+nim+"\nNama : "+nama+"\nAlamat : "+alamat,null,AlertType.INFO);
				alert.setTimeout(Alert.FOREVER);
				m.display.setCurrent(alert);
			}

			
			
		}else {
			m.destroyApp(true);
		}
	}
}
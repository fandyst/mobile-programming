import javax.microedition.lcdui.*;

public class Mahasiswa extends Form implements CommandListener {
	Main m;
	TextField tNim;
	TextField tNama;
	TextField tAlamat;
	Command btnTampil;
	Command btnKeluar;
	Alert alert;

	public Mahasiswa(Main m) {
		super("Data Mahasiswa");
		this.m = m;

		tNim = new TextField("NIM ","",11,TextField.ANY);
		tNama = new TextField("Nama ","",25,TextField.ANY);
		tAlamat = new TextField("Alamat ","",50,TextField.ANY);

		btnTampil = new Command("Tampil",Command.OK,0);
		btnKeluar = new Command("Keluar",Command.EXIT,0);

		append(tNim);
		append(tNama);
		append(tAlamat);
		addCommand(btnTampil);
		addCommand(btnKeluar);

		setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable d) {

		if(cmd == btnTampil) {
			String nim = tNim.getString();
			String nama = tNama.getString();
			String alamat = tAlamat.getString();

			alert = new Alert("Info Mahasiswa","NIM anda "+nim+" dengan nama "+nama+" yang beralamat di "+alamat+" adalah mahasiswa STMIK Widya Pratama",null,AlertType.INFO);
			alert.setTimeout(Alert.FOREVER);
			m.display.setCurrent(alert);
		}else {
			m.destroyApp(true);
		}		
	}
}
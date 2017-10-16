import javax.microedition.lcdui.*;

public class HitungLuas extends Form implements CommandListener {
	TextField txtPanjang;
	TextField txtLebar;
	TextField txtHasil;
	Command btnHitung;

	public HitungLuas() {
		super("Hitung Luas");
		txtPanjang = new TextField("Panjang","",10,TextField.NUMERIC);
		append(txtPanjang);

		txtLebar = new TextField("Lebar    ","",10,TextField.NUMERIC);
		append(txtLebar);

		txtHasil = new TextField("Hasil      ","",10,TextField.NUMERIC);
		append(txtHasil);

		btnHitung = new Command("Hitung",Command.OK,0);
		addCommand(btnHitung);

		setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable d) {

		if(cmd == btnHitung) {
			int p = Integer.parseInt(txtPanjang.getString());
			int l = Integer.parseInt(txtLebar.getString());
			int hasil = p * l;

			txtHasil.setString(hasil+"");
		}

	}
}
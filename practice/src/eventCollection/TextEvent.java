package eventCollection;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextEvent extends Frame implements ActionListener, TextListener {

	TextField text;
	TextArea area;
	Label lbl_info;
	int rand, count;

	public TextEvent(String title) {

		super(title);

		setSize(500, 500);

		text = new TextField("", 20);
		text.selectAll();
		text.setFocusable(true);
		text.addActionListener(this);
		text.addTextListener(this);

		area = new TextArea();
		area.setEnabled(false);

		lbl_info = new Label("1 ~ 100 까지의 숫자 중 하나를 입력하여 맞춰주세요.");

		add("North", lbl_info);
		add("South", text);
		add("Center", area);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {
		new TextEvent("숫자퀴즈");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		text.setText("");
		area.append("\n");

	}

	@Override
	public void textValueChanged(java.awt.event.TextEvent e) {

		rand = (int) (Math.random() * 101);

		int num;
		try {
			num = Integer.parseInt(text.getText());
			while (true) {

				if (num < rand) {

					area.setText(num + "이상 입니다.");
//					area.append("" + num + "이상입니다.");

				}
				if (num > rand) {

					area.setText(num + "이하 입니다. ");
//					area.append("" + num + "이하입니다.");

				}
				if (num == rand) {

					area.setText("딩동댕" + num + " 입니다.");
//					area.append("딩동댕" + num + " 입니다.");
					break;

				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}

	}

}

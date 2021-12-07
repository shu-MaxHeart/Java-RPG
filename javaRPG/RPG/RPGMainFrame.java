import java.awt.*;
import java.awt.event.*;


public class RPGMainFrame extends Frame implements ActionListener,WindowListener,KeyListener {

	//ReservationStudentControl rControl;

	TextField tfStudentID,tfFirstName,tfSecondName;	// 学生IDと施設のテキストフィールド
	TextField tfYear,tfMonth,tfDay;			// 年月日のテキストフィールド

	Button buttonInsert;		// 新規予約ボタン
	Button buttonSelect;		// レコードの検ボタン

	TextArea textMessage;					// 検索結果・メッセージ欄


	public RPGMainFrame( RPGControl rc){
		rControl = rc;

		// 各フィールドの生成
		tfStudentID = new TextField("",6);
		tfFirstName = new TextField("",20);
		tfSecondName = new TextField("",20);
		tfYear = new TextField("",4);
		tfMonth = new TextField("",2);
		tfDay = new TextField("",2);

		// ボタンの生成
		buttonInsert = new Button("学生登録");
		buttonSelect = new Button("学生登録簿");

		// テキストエリアの生成と編集不可の設定
		textMessage = new TextArea( 20, 80);
		textMessage.setEditable(false);

		// ウィンドウへの登録
		setLayout( new FlowLayout());
		add( new Label("学生ID"));
		add( tfStudentID);
		add( new Label(" 苗字"));
		add( tfFirstName);
		add( new Label(" 名前"));
		add( tfSecondName);
		add( new Label(" \n"));
		add( new Label(" 予約日"));
		add( tfYear);
		add( new Label("年"));
		add( tfMonth);
		add( new Label("月"));
		add( tfDay);
		add( new Label("日"));

		add( buttonInsert);
		add( buttonSelect);

		add(textMessage);

		buttonInsert.addActionListener(this);
		buttonSelect.addActionListener(this);

		addWindowListener(this);
		addKeyListener(this);

	}

	
	public void actionPerformed(ActionEvent e) {

		//結果を受け取る変数とメッセージエリアの初期化
		String result = "";
		textMessage.setText("");

		// ボタンごとの処理
		if ( e.getSource()==buttonInsert){///予約追加ボタンが押された時の処理
			result = rControl.insertReservation( tfStudentID.getText(), tfFirstName.getText(), tfSecondName.getText(), tfYear.getText(), tfMonth.getText(), tfDay.getText());
		} else if ( e.getSource() == buttonSelect){///予約表示ボタンが押された時の処理
			result = rControl.selectReservation();
		}

		//結果をメッセージエリアに設定
		textMessage.setText(result);

	}

	
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		System.exit(0);
	}

	
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
import java.awt.*;
import java.awt.event.*;


public class RPGMainFrame extends Frame implements ActionListener,WindowListener,KeyListener {

	//ReservationStudentControl rControl;

	TextField tfStudentID,tfFirstName,tfSecondName;	// �w��ID�Ǝ{�݂̃e�L�X�g�t�B�[���h
	TextField tfYear,tfMonth,tfDay;			// �N�����̃e�L�X�g�t�B�[���h

	Button buttonInsert;		// �V�K�\��{�^��
	Button buttonSelect;		// ���R�[�h�̌��{�^��

	TextArea textMessage;					// �������ʁE���b�Z�[�W��


	public RPGMainFrame( RPGControl rc){
		rControl = rc;

		// �e�t�B�[���h�̐���
		tfStudentID = new TextField("",6);
		tfFirstName = new TextField("",20);
		tfSecondName = new TextField("",20);
		tfYear = new TextField("",4);
		tfMonth = new TextField("",2);
		tfDay = new TextField("",2);

		// �{�^���̐���
		buttonInsert = new Button("�w���o�^");
		buttonSelect = new Button("�w���o�^��");

		// �e�L�X�g�G���A�̐����ƕҏW�s�̐ݒ�
		textMessage = new TextArea( 20, 80);
		textMessage.setEditable(false);

		// �E�B���h�E�ւ̓o�^
		setLayout( new FlowLayout());
		add( new Label("�w��ID"));
		add( tfStudentID);
		add( new Label(" �c��"));
		add( tfFirstName);
		add( new Label(" ���O"));
		add( tfSecondName);
		add( new Label(" \n"));
		add( new Label(" �\���"));
		add( tfYear);
		add( new Label("�N"));
		add( tfMonth);
		add( new Label("��"));
		add( tfDay);
		add( new Label("��"));

		add( buttonInsert);
		add( buttonSelect);

		add(textMessage);

		buttonInsert.addActionListener(this);
		buttonSelect.addActionListener(this);

		addWindowListener(this);
		addKeyListener(this);

	}

	
	public void actionPerformed(ActionEvent e) {

		//���ʂ��󂯎��ϐ��ƃ��b�Z�[�W�G���A�̏�����
		String result = "";
		textMessage.setText("");

		// �{�^�����Ƃ̏���
		if ( e.getSource()==buttonInsert){///�\��ǉ��{�^���������ꂽ���̏���
			result = rControl.insertReservation( tfStudentID.getText(), tfFirstName.getText(), tfSecondName.getText(), tfYear.getText(), tfMonth.getText(), tfDay.getText());
		} else if ( e.getSource() == buttonSelect){///�\��\���{�^���������ꂽ���̏���
			result = rControl.selectReservation();
		}

		//���ʂ����b�Z�[�W�G���A�ɐݒ�
		textMessage.setText(result);

	}

	
	public void windowActivated(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void windowClosed(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void windowClosing(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		System.exit(0);
	}

	
	public void windowDeactivated(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void windowDeiconified(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void windowIconified(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void windowOpened(WindowEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void keyPressed(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void keyReleased(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	
	public void keyTyped(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
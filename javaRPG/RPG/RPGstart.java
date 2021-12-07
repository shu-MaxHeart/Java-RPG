public class RPGstart {

	public static void main ( String argv[]){
		ReservationStudentControl reservationControl = new ReservationStudentControl();
		ReservationStudentMainFrame mainFrame = new ReservationStudentMainFrame(reservationControl);
		mainFrame.setBounds( 5,5,655,455);
		mainFrame.setVisible(true);
	}
}
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

// 문제 1. 풀이
class MyFrame extends JFrame implements ActionListener {
	public MyFrame(){
		this.setTitle("Title");
		this.setBounds(100, 100, 300, 200);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("event test");
	}
}
// 문제 4. 풀이
class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "[ x=" + x + " , y=" + y + " ]";
	}
}
// 문제 5. 풀이
abstract class Shape {
	private Point p1;
	private Point p2;
	abstract double area(double width, double height);
}
class Rectangle extends Shape {
	@Override
	public double area(double width, double height) {
		return width * height;
	}
}

public class TermExam {

	public static void main(String[] args) {
		// 1. JFrame class, ActionListener interface를 상속(extends, implements)받아 window의 title, location, size를 
		//    정해서 보여주는(visible) MyFrame class를 만드세요. ActionListener의 추상 메서드 void actionPerformed(ActionEvent e)도
		//    오버라이딩 하세요. (해당 title, location, size 값은 임의로 정하고, actionPerformed 메서드 동작도 임의로 정하면 됩니다.) 
		   MyFrame myFrame = new MyFrame();
		   JButton btn = new JButton("test");
		   btn.addActionListener(myFrame);
		   myFrame.add(btn);
		// 2. 한글이 포함된 text file "test.txt"를 읽어서 문자 'x'를 모두 제외하고 콘솔 화면에 출력하는 프로그램 작성 하세요. 
		try {
			FileReader fr = new FileReader("test.txt");
			int data;
			while( (data=fr.read()) != -1 ) {
				if( data != 'x') {
					System.out.print( (char)data );
				}
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 3. 정수값을 원소로 가지는 ArrayList를 생성하고 이 List에 10개의 랜덤 정수값을 넣으세요.
		ArrayList<Integer> ial = new ArrayList<>();
		Random rnd = new Random();
		for(int i=0;i<10;i++) {
			ial.add( rnd.nextInt() );
		}		
		System.out.println( ial );
		// 4. x좌표와 y좌표를 정수값으로 가지는 Point class를 정의하고, 매개변수로 전달받은 두 값으로 x, y 를 정하는 생성자를 만드세요. 
		//    그리고, 인스턴스명으로 해당 좌표를 [ x=2 , y=3 ]형태로 출력하도록 toString 메서드를 오버라이딩 하세요.  
		Point p = new Point(2, 3);
		System.out.println( p );
		// 5. 4번 문제에서 만든 Point class 두 개를 field(= 멤버 변수) 값으로 가지고 
		//    정수값으로 밑변(w)과 높이(h)를 매개변수로 받고 정수값을 반환하는 추상 메소드 int area(int w, int h)를 가지는 Shape class를 만드세요.
		//    Shape class를 상속 받은 Rectangle class를 만들고 면적을 구하는 area()를 구현(오버라이딩) 하세요.
		Point p1 = new Point(2,3);
		Point p2 = new Point(5,7);
		Shape s = new Rectangle();
		System.out.println( "면적 = " + s.area(5-2, 7-3) );
	}
}

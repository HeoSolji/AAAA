import java.util.*;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;

public class Home {
	public static List<Classs> listClasses= new ArrayList<Classs>();
	public static List<ClassObj> classObjs= new ArrayList<ClassObj>();
	private static Point random(){
        Point p= new Point();
        Random ran= new Random();
        p.x=ran.nextInt(600);
        p.y=ran.nextInt(500);
        return p;
    }
	
	public static void main(String[] args) throws IOException {
		ReadFile a= new ReadFile();
		listClasses= a.getListClass();
		a.getNameClass();
		a.Show();
		Home home= new Home();
		Layer layer= new Layer();
		JFrame frame = new JFrame("FileVisual");
		
		for(Classs e: listClasses) {
			ClassObj co= new ClassObj(e.getName(), e.getStringFields(), e.getStringMethods());
			classObjs.add(co);
			for (String string :e.getStringFields()) {
				System.out.println(string);
			}
		}
		for(ClassObj c: classObjs) {
			ClassTable table1= new ClassTable(random(), c);
			layer.addTable(table1);
		}
		String _ClassName="Class Name";
		List<String> _Feild= new ArrayList<String>();
		List<String> _Method= new ArrayList<String>();
		for(Classs m: listClasses) {
		}
		_Feild.add("AAAA");
		_Feild.add("CCC");
		_Feild.add("girl's generaton");
		_Feild.add("it's bad day, not a bad life");
		_Method.add("BBBB");
		ClassObj classObj= new ClassObj(_ClassName, _Feild, _Method);
		ClassTable table= new ClassTable(random(),classObj);
		layer.addTable(table);
		
        frame.add(layer);
        frame.addMouseListener(layer);
        frame.addMouseMotionListener(layer);

        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

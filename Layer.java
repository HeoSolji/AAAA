import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Layer extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	private int posX=0,posY=0,myX=0,myY=0;
    private List<ClassTable> tables = new ArrayList<>();
    Timer t = new Timer(1, this);
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.PINK);
        //g.drawRect(x, y, width, height);

        tables.forEach(table -> table.drawRect(g));
        t.start();
    }

    public void addTable(ClassTable table) {
        tables.add(table);
    }
    public void actionPerformed (ActionEvent e) {}
    public void mouseClicked (MouseEvent e) {}
    public void mousePressed (MouseEvent e) {
    	
    }
    public void mouseReleased (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseDragged (MouseEvent e) {}
    public void mouseMoved (MouseEvent e) {}
}

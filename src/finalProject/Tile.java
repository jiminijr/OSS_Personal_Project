package finalProject;
import java.awt.Color;

import javax.swing.ImageIcon;


public class Tile {
	private Color color; 
		public int value;
		 public int getValue() {
		        return this.value;
		    }
		    public void setValue(int value) {
		        this.value = value;
		    }
		public Tile(){
			this(0);
		}
		public Tile(int num){
			value = num;
		}
		public boolean isEmpty(){
			return value == 0;
		}
		public Color getForeground(){
			return value<16? new Color(61, 40, 99) : new Color(61, 40, 99);
		}
		
		public ImageIcon getImageIcon() {
		    String path;
		    switch (value) {
		        case 2: path = "/finalProject/images/2.gif"; break;
		        case 4: path = "/finalProject/images/4.gif"; break;
		        case 8: path = "/finalProject/images/8.gif"; break;
		        case 16: path = "/finalProject/images/16.gif"; break;
		        case 32: path = "/finalProject/images/32.gif"; break;
		        case 64: path = "/finalProject/images/64.gif"; break;
		        case 128: path = "/finalProject/images/128.gif"; break;
		        case 256: path = "/finalProject/images/256.gif"; break;
		        case 512: path = "/finalProject/images/512.gif"; break;
		        case 1024: path = "/finalProject/images/1024.gif"; break;
		        default: path = "/finalProject/images/default.png"; break;
		    }
		    return new ImageIcon(Tile.class.getResource(path));
		}
}


